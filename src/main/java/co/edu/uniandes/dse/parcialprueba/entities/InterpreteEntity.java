package co.edu.uniandes.dse.parcialprueba.entities;
import lombok.Data;
import jakarta.persistence.Entity;
import uk.co.jemos.podam.common.PodamExclude;
import jakarta.persistence.ManyToMany;
import java.util.List;
import java.util.ArrayList;

@Data
@Entity
public class InterpreteEntity {
    private String nombre;
    private String instrumento;
    private String biografia;

    @PodamExclude
    @ManyToMany
    private List<CancionEntity> canciones = new ArrayList<>();


    

}
