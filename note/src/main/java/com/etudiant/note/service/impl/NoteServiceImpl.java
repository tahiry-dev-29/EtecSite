package com.etudiant.note.service.impl;

import com.etudiant.note.entity.Note;
import com.etudiant.note.repository.NoteRepository;
import com.etudiant.note.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    @Override
    public Note save(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Page<Note> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Note findById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note introuvable"));
    }

    @Override
    public Note update(Long id, Note note) {
        Note existing = findById(id);

        existing.setValeur(note.getValeur());
        existing.setMention(note.getMention());
        return noteRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        Note existing = findById(id);
        noteRepository.delete(existing);
    }
}
