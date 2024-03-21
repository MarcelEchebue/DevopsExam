package com.marcelino.examdevops.marcelino.controller;

import com.marcelino.examdevops.marcelino.model.VoitureEntity;
import com.marcelino.examdevops.marcelino.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/voitures")
public class VoitureController {

    @Autowired
    private VoitureService voitureService;

    @GetMapping
    public List<VoitureEntity> getAllVoitures() {
        return voitureService.getAllVoitures();
    }

   // @GetMapping("/{id}")
  //  public VoitureEntity getVoitureById(@PathVariable Long id) {
     //   return voitureService.getVoitureById(id);
    //}

    @PostMapping
    public VoitureEntity addVoiture(@RequestBody VoitureEntity voiture) {
        return voitureService.addVoiture(voiture);
    }

    @PutMapping("/{id}")
    public VoitureEntity updateVoiture(@PathVariable Long id, @RequestBody VoitureEntity voiture) {
        return voitureService.updateVoiture(id, voiture);
    }

    @DeleteMapping("/{id}")
    public void deleteVoiture(@PathVariable Long id) {
        voitureService.deleteVoiture(id);
    }
}
