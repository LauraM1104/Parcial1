package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.InterpreteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.InterpreteRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j // Permite el uso de logs en la clase
@Service // Marca la clase como un servicio de Spring
public class InterpreteService {
    @Autowired
    InterpreteRepository interpreteRepository;

    @Transactional
    public InterpreteEntity createInterprete (InterpreteEntity interpreteEntity) throws IllegalOperationException {
        log.info("Inicia proceso de registro de nuevo interprete"); // Mensaje en el log
        if (interpreteEntity.getNombre()==null){
            throw new IllegalOperationException("Nombre no válido");
        }
        log.info("Termina proceso de registro de nuevo interprete");
        return interpreteRepository.save(interpreteEntity);
    }}
        




