package com.example.GestionBibliotheque.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private LocalDate dateEmprunt;
    @NotBlank
    private LocalDate dateRetourPrevue;
    @NotBlank
    private LocalDate dateRetourRelle;
    @NotBlank
    private String statut;
}
