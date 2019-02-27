package cz.hamiweb.petclinic.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Owner extends Person{

    private String address;
    private String city;
    private String telephone;

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String telephone, @Singular Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        this.pets = pets;
    }

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Pet> pets = new HashSet<>();


}
