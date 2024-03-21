package com.marcelino.examdevops.marcelino;

import com.marcelino.examdevops.marcelino.controller.VoitureController;
import com.marcelino.examdevops.marcelino.model.VoitureEntity;
import com.marcelino.examdevops.marcelino.service.VoitureService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VoitureControllerTest {

    @Mock
    private VoitureService voitureService;

    @InjectMocks
    private VoitureController voitureController;

    public VoitureControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllVoitures() {
        // Données de test
        VoitureEntity voiture1 = new VoitureEntity();
        voiture1.setId(1L);
        voiture1.setMarque("Marque1");
        voiture1.setModele("Modele1");

        VoitureEntity voiture2 = new VoitureEntity();
        voiture2.setId(2L);
        voiture2.setMarque("Marque2");
        voiture2.setModele("Modele2");

        List<VoitureEntity> voitures = Arrays.asList(voiture1, voiture2);

        // Définition du comportement du service mock
        when(voitureService.getAllVoitures()).thenReturn(voitures);

        // Appel de la méthode à tester
        List<VoitureEntity> result = voitureController.getAllVoitures();

        // Vérification du résultat
        assertEquals(voitures.size(), result.size());
        assertEquals(voiture1.getMarque(), result.get(0).getMarque());
        assertEquals(voiture2.getModele(), result.get(1).getModele());
    }

    @Test
    public void testAddVoiture() {
        // Données de test
        VoitureEntity voiture = new VoitureEntity();
        voiture.setId(1L);
        voiture.setMarque("Marque");
        voiture.setModele("Modele");

        // Définition du comportement du service mock
        when(voitureService.addVoiture(any(VoitureEntity.class))).thenReturn(voiture);

        // Appel de la méthode à tester
        VoitureEntity result = voitureController.addVoiture(voiture);

        // Vérification du résultat
        assertEquals(voiture.getId(), result.getId());
        assertEquals(voiture.getMarque(), result.getMarque());
        assertEquals(voiture.getModele(), result.getModele());
    }

    @Test
    public void testUpdateVoiture() {
        // Données de test
        Long id = 1L;
        VoitureEntity voiture = new VoitureEntity();
        voiture.setId(id);
        voiture.setMarque("Marque");
        voiture.setModele("Modele");

        // Définition du comportement du service mock
        when(voitureService.updateVoiture(eq(id), any(VoitureEntity.class))).thenReturn(voiture);

        // Appel de la méthode à tester
        VoitureEntity result = voitureController.updateVoiture(id, voiture);

        // Vérification du résultat
        assertEquals(voiture.getId(), result.getId());
        assertEquals(voiture.getMarque(), result.getMarque());
        assertEquals(voiture.getModele(), result.getModele());
    }

    @Test
    public void testDeleteVoiture() {
        // Données de test
        Long id = 1L;

        // Appel de la méthode à tester
        voitureController.deleteVoiture(id);

        // Vérification que la méthode du service a été appelée
        verify(voitureService, times(1)).deleteVoiture(eq(id));
    }

}
