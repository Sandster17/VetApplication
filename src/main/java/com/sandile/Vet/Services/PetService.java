package com.sandile.Vet.Services;

import com.sandile.Vet.Model.Pet;
import com.sandile.Vet.Repo.PetRepo;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PetService {

    private List<Pet> petList;
    private PetRepo petRepo;

    public PetService(ConfigurableApplicationContext configurableApplicationContext){
        petRepo = configurableApplicationContext.getBean(PetRepo.class);
        petList = new ArrayList<>();
        petList = (List<Pet>) petRepo.findAll();
    }

    public void loadPets(){
        petList = (List<Pet>) petRepo.findAll();
    }

    public void addPet( String petName,String species, String dob){
        Pet pet = new Pet(petName,species,dob);
        petRepo.save(pet);
    }

    public void deletePet(Long id){
        petRepo.deleteById(id);
    }

    public void updatePet(@PathVariable("pet_id")Long id, String petName,String species, String dob){
        Pet pet = new Pet(petName, species,dob);
        petRepo.save(pet);
    }

    public boolean isPetListEmpty(){
        return petList.isEmpty();
    }

    public boolean searchPet(Long petId){
        boolean result;
        Optional<Pet> optionalPet = petRepo.findById(petId);
        result = optionalPet.isPresent();
        return result;
    }

    @Override
    public String toString(){
        String temp = "";
        for (Pet pet:petList) {
            temp+=pet.toString() + "\n";
        }
        return temp;
    }

    public Pet getPet(int petId){
        return petList.get(petId);
    }




}
