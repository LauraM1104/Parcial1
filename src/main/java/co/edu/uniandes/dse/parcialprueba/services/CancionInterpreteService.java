package co.edu.uniandes.dse.parcialprueba.services;

import org.modelmapper.spi.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.InterpreteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.*;
import co.edu.uniandes.dse.parcialprueba.repositories.CancionRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.InterpreteRepository;
import lombok.extern.slf4j.Slf4j;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import co.edu.uniandes.dse.parcialprueba.entities.CancionEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.exceptions.ErrorMessage;


@Slf4j // Permite el uso de logs en la clase
@Service // Marca la clase como un servicio de Spring
public class CancionInterpreteService {

    @Autowired 
    private CancionRepository cancionRepository;

    @Autowired 
    private InterpreteRepository interpreteRepository;

    @Transactional 
    public InterpreteEntity addCancion(Long interpreteId, Long cancionId) throws EntityNotFoundException {
        log.info("Inicia proceso de asociarle una cancion al interprete con id = {}", interpreteId);

       
        Optional<InterpreteEntity> interpreteEntity = interpreteRepository.findById(interpreteId);
        if (interpreteEntity.isEmpty())
            throw new EntityNotFoundException(ErrorMessage.INTERPRETE_NOT_FOUND);

        // Buscar la especialidad por id, lanzar excepción si no existe
        Optional<CancionEntity> cancionEntity = cancionRepository.findById(cancionId);
        if (cancionEntity.isEmpty())
            throw new EntityNotFoundException(ErrorMessage.CANCION_NOT_FOUND);

        // Asociar la especialidad al médico
        interpreteEntity.get().getCanciones().add(cancionEntity.get());

        log.info("Termina proceso de asociarle una especialidad al médico con id = {}", interpreteId);
        return interpreteEntity.get(); // Retorna el médico actualizado
    }
}
