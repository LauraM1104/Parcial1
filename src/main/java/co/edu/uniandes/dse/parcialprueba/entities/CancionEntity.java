package co.edu.uniandes.dse.parcialprueba.entities;
import lombok.Data;
import jakarta.persistence.Entity;
import uk.co.jemos.podam.common.PodamExclude;
import jakarta.persistence.ManyToMany;
import java.util.List;
import java.util.ArrayList;

@Data
@Entity
public class CancionEntity extends BaseEntity{
    private String titulo;
    private Integer segundos;
    private String genero;

    @PodamExclude
    @ManyToMany(mappedBy = "canciones")
    private List<InterpreteEntity> interpretes = new ArrayList<>();
}


