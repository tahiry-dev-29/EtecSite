package com.etec.historique.repository;

import com.etec.historique.entity.Historique;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoireRepository extends JpaRepository<Historique, Long> {

}
