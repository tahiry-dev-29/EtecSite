package com.etudiant.note.Dto;

import com.etudiant.note.entity.Note;
import lombok.Data;

import java.util.List;

@Data
public class EtudiantNoteResponse {


    private EtudiantResponse etudiant;


    private List<Note> notes;


    private Double moyenne;

}
