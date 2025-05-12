
package com.digrazia.service;


import com.digrazia.entity.DisponibilitaEntity;
import com.digrazia.entity.PrenotazioneEntity;
import com.digrazia.entity.PrestazioneEntity;
import com.digrazia.entity.UtenteEntity;
import com.digrazia.model.dto.PrenotazioneDTO;
import com.digrazia.repository.DisponibilitaRepository;
import com.digrazia.repository.PrenotazioneRepository;
import com.digrazia.repository.UtenteRepository;
import com.github.javafaker.Faker;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class PrenotazioneConsumer {

    private final PrenotazioneRepository repository;
    private final DisponibilitaRepository disponibilitaRepository;
    private final UtenteRepository utenteRepository;
    Faker faker = new Faker();

    public PrenotazioneConsumer(PrenotazioneRepository repository,
                                DisponibilitaRepository disponibilitaRepository, UtenteRepository utenteRepository) {
        this.repository = repository;
        this.disponibilitaRepository = disponibilitaRepository;
        this.utenteRepository = utenteRepository;
    }

    @KafkaListener(topics = "prenotazioni", groupId = "prenotazione-consumer")
    public void consuma(PrenotazioneDTO dto) {
        PrenotazioneEntity p = new PrenotazioneEntity();
        p.setId(dto.getId());
        p.setUtenteId(dto.getUtenteId());
        p.setDisponibilitaId(dto.getDisponibilitaId());
        LocalDate data = LocalDate.parse(dto.getData());
        p.setData(data);
        System.out.println("email: " + dto.getEmail());

        UtenteEntity utente =
                utenteRepository.findByEmail(dto.getEmail()).orElse(buildNewUtente(dto));
        System.out.println("email: " + utente.getEmail());

        p.setUtenteId(utente.getId());
        PrenotazioneEntity saved = repository.save(p);
        if (saved != null) {
            Optional<DisponibilitaEntity> toUpdate =
                    disponibilitaRepository.findById(dto.getDisponibilitaId());
            if (toUpdate.isPresent()) {
                DisponibilitaEntity disponibilita = toUpdate.get();
                disponibilita.setDisponibile(false);
                disponibilitaRepository.save(disponibilita);
            }
        }
    }

    UtenteEntity buildNewUtente(PrenotazioneDTO prenotazioneDTO) {
        UtenteEntity utente = new UtenteEntity();
        utente.setId(UUID.randomUUID().toString());
        utente.setEmail(prenotazioneDTO.getEmail());
        utente.setTelefono(prenotazioneDTO.getTelefono());
        utente.setNome(prenotazioneDTO.getNome());
        return utenteRepository.save(utente);
    }
}
