package com.sandile.Vet.Services;

import com.sandile.Vet.Model.Doctor;
import com.sandile.Vet.Repo.DoctorRepo;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DoctorService {

    private List<Doctor> doctorList;
    private DoctorRepo doctorRepo;

    public DoctorService(ConfigurableApplicationContext configurableApplicationContext){
        doctorRepo = configurableApplicationContext.getBean(DoctorRepo.class);
        doctorList = new ArrayList<>();
    }

    public void loadDoctorData(){
        doctorList = (List<Doctor>) doctorRepo.findAll();
    }

    public void addDoctor(String firstname, String lastname){
        Doctor doctor = new Doctor(firstname,lastname)  ;
        doctorRepo.save(doctor);
    }

    public void deleteDoctor(Long id){
        doctorRepo.deleteById(id);
    }

    public boolean isDoctorListEmpty(){
        return doctorList.isEmpty();
    }

    public void updateDoctor(@PathVariable("doctor_id")Long id, String firstname, String lastname){
        Doctor doctor = new Doctor(firstname,lastname);
        doctorRepo.save(doctor);
    }

    public boolean searchDoctor(Long id){
        Optional<Doctor> optionalDoctor = doctorRepo.findById(id);
        boolean result = optionalDoctor.isPresent();
        return result;
    }

    public Doctor getDoctor(int id){
        return doctorList.get(id);
    }

    @Override
    public String toString(){
        String temp = "";
        for (Doctor doctor :doctorList) {
            temp+=doctor.toString() + "\n";
        }
        return temp;
    }

}
