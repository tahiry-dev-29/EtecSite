package com.example.Etudiant.demo.Controller;

import com.example.Etudiant.demo.Entity.Etudiant;
import com.example.Etudiant.demo.Service.EtudiantService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/etudiants")
@RequiredArgsConstructor
public class EtudiantController {

    private final EtudiantService etudiantService;

    @PostMapping
    public Etudiant create(@RequestBody Etudiant etudiant,
                           HttpServletRequest request) {

        return etudiantService.createEtudiant(etudiant, request);
    }

    @GetMapping
    public List<Etudiant> getAll() {
        return etudiantService.getAllEtudiants();
    }

    @GetMapping("/{id}")
    public Etudiant getById(@PathVariable Long id) {
        return etudiantService.getEtudiantById(id);
    }

    @GetMapping("/matricule/{matricule}")
    public Etudiant getByMatricule(@PathVariable String matricule) {
        return etudiantService.getByMatricule(matricule);
    }

    @PutMapping("/{id}")
    public Etudiant update(@PathVariable Long id,
                           @RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(id, etudiant);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
    }
}