package cz.hamiweb.petclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    private LocalDate birthDate;
    @ManyToOne
    private Owner owner;
    @ManyToOne
    private PetType petType;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();


}
