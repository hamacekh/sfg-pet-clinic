package cz.hamiweb.petclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "pet_types")
public class PetType extends BaseEntity {

    private String name;

}
