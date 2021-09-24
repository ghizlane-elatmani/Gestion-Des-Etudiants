package io.javacode.tpspringmvc.dao;

import io.javacode.tpspringmvc.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    // Using SpringData !

}
