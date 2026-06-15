package com.example.Etudiant.demo.Repository;

import com.example.Etudiant.demo.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    Optional<Etudiant> findByMatricule(String matricule);
}


