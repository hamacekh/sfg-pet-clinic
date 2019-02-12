package cz.hamiweb.petclinic.model;

import java.time.LocalDateTime;

public class Visit extends BaseEntity {

    LocalDateTime dateTime;
    String description;
    Pet pet;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }


}
