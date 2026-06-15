package com.example.Etudiant.demo.Service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EtudiantService {

    private final EtudiantRepository etudiantRepository;

    // 🔥 CREATE ETUDIANT
    public Etudiant createEtudiant(Etudiant etudiant, HttpServletRequest request) {

        // 🔵 récupérer userId depuis JwtFilter
        Long userId = (Long) request.getAttribute("userId");

        if (userId == null) {
            throw new RuntimeException("userId introuvable dans le token");
        }

        // 🔵 lien User ↔ Etudiant
        etudiant.setUserId(userId);

        return etudiantRepository.save(etudiant);
    }

    // 🔥 GET ALL ETUDIANTS
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    // 🔥 GET BY ID
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etudiant introuvable"));
    }

    // 🔥 GET BY MATRICULE
    public Etudiant getByMatricule(String matricule) {
        return etudiantRepository.findByMatricule(matricule)
                .orElseThrow(() -> new RuntimeException("Matricule introuvable"));
    }

    // 🔥 UPDATE ETUDIANT
    public Etudiant updateEtudiant(Long id, Etudiant newData) {

        Etudiant existing = getEtudiantById(id);

        existing.setMatricule(newData.getMatricule());
        existing.setCin(newData.getCin());
        existing.setAdresse(newData.getAdresse());
        existing.setPhone(newData.getPhone());
        existing.setPhoto(newData.getPhoto());

        return etudiantRepository.save(existing);
    }

    // 🔥 DELETE ETUDIANT
    public void deleteEtudiant(Long id) {
        etudiantRepository.deleteById(id);
    }
}