package co.edu.uniandes.dse.parcialprueba.services;
import co.edu.uniandes.dse.parcialprueba.entities.InterpreteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import(InterpreteService.class)
public class InterpreteTest {
    @Autowired
    private InterpreteService interpreteService;
    @Autowired
    private TestEntityManager entityManager;
    private PodamFactory factory = new PodamFactoryImpl();
    private List<InterpreteEntity> canciones = new ArrayList<>(); 
}


    @BeforeEach
    void setUp() {
        clearData();
        insertData();
    }

    private void clearData() {
        entityManager.getEntityManager().createQuery("delete from InterpreteEntity").executeUpdate();
        entityManager.getEntityManager().createQuery("delete from CancionEntity").executeUpdate();
    }

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            InterpreteEntity interpreteEntity = factory.manufacturePojo(InterpreteEntity.class);
            entityManager.persist(interpreteEntity);
            interpretes.add(interpreteEntity);
        }
    }



@Test
void testCreateInterprete() throws EntityNotFoundException, IllegalOperationException {
    InterpreteEntity newEntity= factory.manufacturePojo (InterpreteEntity.class);
    newEntity.setBiografia("biografiaPrueba");
    newEntity.setInstrumento("instrumentoPrueba");
    newEntity.setNombre("nombrePrueba");

    InterpreteEntity result = interpreteService.createInterprete(newEntity);
   
    assertNotNull(result);

    InterpreteEntity entity = entityManager.find(InterpreteEntity.class, result.getId());
    
    assertEquals(newEntity.getBiografia(), entity.getBiografia());
    assertEquals(newEntity.getCanciones(), entity.getCanciones());
    assertEquals(newEntity.getInstrumento(), entity.getInstrumento());

@Test
void testCreateInterpreteNValido() throws IllegalOperationException {
    InterpreteEntity newEntity = factory.manufacturePojo(InterpreteEntity.class);
    newEntity.setNombre("Pepita");
    InterpreteEntity result =interpreteService.createInterprete(newEntity);
    assertNotNull(result);
    InterpreteEntity entity = entityManager.find(InterpreteEntity.class, result.getId());
    assertEquals(newEntity.getBiografia(), entity.getBiografia());
    assertEquals(newEntity.getCanciones(), entity.getCanciones());
    assertEquals(newEntity.getInstrumento(), entity.getInstrumento());

}
    

@Test 
void testCreateInterpreteNombreNull() {
    InterpreteEntity newEntity = factory.manufacturePojo(InterpreteEntity.class);
    newEntity.setNombre(null);
    try {
        interpreteService.createInterprete(newEntity);
    } catch (IllegalOperationException e) {
        assertEquals("Nombre no válido", e.getMessage());
    }

}}