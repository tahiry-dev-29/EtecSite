package com.encadrement.demo.Service;

import com.common.common.dto.NotificationRequest;
import com.encadrement.demo.Entity.Encadrement;
import com.encadrement.demo.Entity.StatutEncadrement;
import com.encadrement.demo.Repository.EncadrementRepository;
import com.encadrement.demo.client.EnseignantClient;
import com.encadrement.demo.client.EtudiantClient;
import com.encadrement.demo.client.MemoireClient;
import com.encadrement.demo.client.NotificationClient;
import com.encadrement.demo.dto.EnseignantDto;
import com.encadrement.demo.dto.EtudiantDto;
import com.encadrement.demo.dto.MemoireDto;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EncadrementService {

    private final EncadrementRepository repository;
    private final MemoireClient memoireClient;
    private final EnseignantClient enseignantClient;
    private final EtudiantClient etudiantClient;
    private final NotificationClient notificationClient;

    public Encadrement save(Encadrement encadrement) {

        // Vérifier le mémoire
        try {
            MemoireDto memoire = memoireClient.getMemoire(encadrement.getMemoireId());

            if (memoire == null) {
                throw new RuntimeException("Mémoire introuvable");
            }

        } catch (FeignException e) {
            throw new RuntimeException("Mémoire introuvable");
        }

        // Vérifier l'enseignant
        try {
            EnseignantDto enseignant = enseignantClient.getEnseignant(encadrement.getEnseignantId());

            if (enseignant == null) {
                throw new RuntimeException("Enseignant introuvable");
            }

        } catch (FeignException e) {
            throw new RuntimeException("Enseignant introuvable");
        }

        try {
            EtudiantDto etudiant = etudiantClient.getEtudiant(encadrement.getEtudiantId());

            if (etudiant == null) {
                throw new RuntimeException("Etudiant introuvable");
            }

        } catch (FeignException e) {
            throw new RuntimeException("Etudiant introuvable");
        }


        if (encadrement.getStatut() == null) {
            encadrement.setStatut(StatutEncadrement.EN_COURS);
        }

        Encadrement saved =
                repository.save(encadrement);



        EtudiantDto etudiant =
                etudiantClient.getEtudiant(
                        saved.getEtudiantId()
                );



        NotificationRequest request =
                new NotificationRequest(
                        etudiant.getUserId(),
                        saved.getEtudiantId(),
                        "Nouvel encadrement",
                        "Vous avez été affecté à un encadreur"
                );


        notificationClient.envoyer(request);



        return saved;

    }

    public Encadrement update(Long id, Encadrement encadrement) {

        Encadrement existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Encadrement introuvable"));

        // Vérifier le mémoire
        try {
            MemoireDto memoire = memoireClient.getMemoire(encadrement.getMemoireId());

            if (memoire == null) {
                throw new RuntimeException("Mémoire introuvable");
            }

        } catch (FeignException e) {
            throw new RuntimeException("Mémoire introuvable");
        }

        // Vérifier l'enseignant
        try {
            EnseignantDto enseignant = enseignantClient.getEnseignant(encadrement.getEnseignantId());

            if (enseignant == null) {
                throw new RuntimeException("Enseignant introuvable");
            }

        } catch (FeignException e) {
            throw new RuntimeException("Enseignant introuvable");
        }

        existing.setMemoireId(encadrement.getMemoireId());
        existing.setEnseignantId(encadrement.getEnseignantId());
        existing.setDateDebut(encadrement.getDateDebut());
        existing.setDateFin(encadrement.getDateFin());
        existing.setStatut(encadrement.getStatut());
        existing.setObservation(encadrement.getObservation());

        return repository.save(existing);
    }

    public Encadrement findById(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Encadrement introuvable"));
    }

    public Page<Encadrement> findAll(Pageable pageable) {

        return repository.findAll(pageable);
    }

    public void delete(Long id) {

        Encadrement existing = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Encadrement introuvable"));

        repository.delete(existing);
    }
}