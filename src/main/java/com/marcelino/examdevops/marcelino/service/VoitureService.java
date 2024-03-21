package com.marcelino.examdevops.marcelino.service;

import org.springframework.stereotype.Service;
import com.marcelino.examdevops.marcelino.model.VoitureEntity;
import com.marcelino.examdevops.marcelino.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureService {

    @Autowired
    private VoitureRepository voitureRepository;

    public List<VoitureEntity> getAllVoitures() {
        return voitureRepository.findAll();
    }

    public VoitureEntity getVoitureById(Long id) {
        return voitureRepository.findById(id).orElse(null);
    }

    public VoitureEntity addVoiture(VoitureEntity voiture) {
        return voitureRepository.save(voiture);
    }

    public VoitureEntity updateVoiture(Long id, VoitureEntity voiture) {
        if (voitureRepository.findById(id).isPresent()) {
            voiture.setId(id);
            return voitureRepository.save(voiture);
        } else {
            return null;
        }
    }

    public void deleteVoiture(Long id) {
        voitureRepository.deleteById(id);
    }
}
