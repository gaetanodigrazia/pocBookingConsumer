
package com.digrazia.repository;


import com.digrazia.entity.DisponibilitaEntity;
import com.digrazia.entity.UtenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtenteRepository extends JpaRepository<UtenteEntity, String> {
    Optional<UtenteEntity> findByEmail(String email);
}
