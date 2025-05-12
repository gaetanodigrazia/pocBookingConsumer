
package com.digrazia.repository;


import com.digrazia.entity.DisponibilitaEntity;
import com.digrazia.entity.PrenotazioneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisponibilitaRepository extends JpaRepository<DisponibilitaEntity, String> {
}
