package com.marcelino.examdevops.marcelino.repository;

import com.marcelino.examdevops.marcelino.model.VoitureEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface VoitureRepository extends JpaRepository<VoitureEntity, Long> {

}
