package ma.enset.immatriculationservice.queryside.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Owner {
    @Id
    private String id;
    private String name;
    private Date dat_naissance;
    private String email;
}
