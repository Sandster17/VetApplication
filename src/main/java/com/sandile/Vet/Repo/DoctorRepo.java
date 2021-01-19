package com.sandile.Vet.Repo;


import com.sandile.Vet.Model.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepo extends CrudRepository<Doctor, Long> {


}