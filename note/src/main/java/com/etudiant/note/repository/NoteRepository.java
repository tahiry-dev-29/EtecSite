package com.etudiant.note.repository;

import com.etudiant.note.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByEtudiantId(Long etudiantId);
    @Query("SELECT AVG(n.valeur) FROM Note n WHERE n.etudiantId = :etudiantId")
    Double calculerMoyenne(@Param("etudiantId") Long etudiantId);
}
