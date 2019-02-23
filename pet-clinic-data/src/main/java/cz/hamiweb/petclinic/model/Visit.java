package cz.hamiweb.petclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    private LocalDateTime dateTime;
    @Lob
    private
    String description;

    @ManyToOne
    private
    Pet pet;


}
