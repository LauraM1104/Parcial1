package co.edu.uniandes.dse.parcialprueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.uniandes.dse.parcialprueba.entities.InterpreteEntity;

@Repository
public interface InterpreteRepository extends JpaRepository <InterpreteEntity,Long> {




}
