package com.sandile.Vet.Model;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long petId;
    private String petName;
    private String species;
    private String dob;

    public Pet( String petName,String species, String dob){
        this.petName = petName;
        this.species = species;
        this.dob = dob;
    }
    public Pet(){

    }

    public Long getPetId() {
        return petId;
    }



    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId='" + petId + '\'' +
                ", petName='" + petName + '\'' +
                ", species='" + species + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
