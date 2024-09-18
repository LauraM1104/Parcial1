package co.edu.uniandes.dse.parcialprueba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcialprueba.entities.CancionEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.CancionRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;


@Slf4j // Permite el uso de logs en la clase
@Service // Marca la clase como un servicio de Spring
public class CancionService {
    @Autowired
    CancionRepository cancionRepository;

    @Transactional
    public CancionEntity createCancion (CancionEntity cancionEntity) throws IllegalOperationException {
        log.info("Inicia proceso de registro de nueva cancion"); // Mensaje en el log
        if (cancionEntity.getSegundos()<=0){
            throw new IllegalOperationException("Duración no válida");
        }
        log.info("Termina proceso de registro de nueva cancion");
        return cancionRepository.save(cancionEntity); 
    }}
        

