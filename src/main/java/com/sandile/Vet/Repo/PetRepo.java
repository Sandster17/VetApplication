package com.sandile.Vet.Repo;
import com.sandile.Vet.Model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepo extends CrudRepository<Pet, Long> {


}
