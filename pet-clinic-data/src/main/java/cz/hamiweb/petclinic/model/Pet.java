package cz.hamiweb.petclinic.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Singular;

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

    @Builder
    public Pet(Long id, LocalDate birthDate, Owner owner, PetType petType, String name, @Singular Set<Visit> visits) {
        super(id);
        this.birthDate = birthDate;
        this.owner = owner;
        this.petType = petType;
        this.name = name;
        this.visits = visits;
    }
}
