package com.digrazia.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "disponibilita")
public class DisponibilitaEntity {

    @Id
    private String id;
    private LocalDate giorno;
    private LocalTime orario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dottore_id", nullable = false)
    private DottoreEntity dottoreEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prestazione_id", nullable = false)
    private PrestazioneEntity prestazioneEntity;

    private boolean disponibile;


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public LocalDate getGiorno() { return giorno; }
    public void setGiorno(LocalDate giorno) { this.giorno = giorno; }

    public LocalTime getOrario() { return orario; }
    public void setOrario(LocalTime orario) { this.orario = orario; }

    public DottoreEntity getDottore() { return dottoreEntity; }
    public void setDottore(DottoreEntity dottoreEntity) { this.dottoreEntity = dottoreEntity; }

    public PrestazioneEntity getPrestazione() { return prestazioneEntity; }
    public void setPrestazione(PrestazioneEntity prestazioneEntity) { this.prestazioneEntity = prestazioneEntity; }

    public boolean isDisponibile() { return disponibile; }
    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }
}
