package cz.hamiweb.petclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.MappedSuperclass;

@Data
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class Person extends BaseEntity{

    private String firstName;
    private String lastName;

}
