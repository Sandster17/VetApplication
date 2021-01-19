package com.sandile.Vet;

import com.sandile.Vet.Services.DoctorService;
import com.sandile.Vet.Services.PetService;
import com.sandile.Vet.Services.ScheduleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.Scanner;


@SpringBootApplication
public class VetApplication {

	public static void main(String[] args) {

       ConfigurableApplicationContext configurableApplicationContext =
                SpringApplication.run(VetApplication.class, args);

        PetService petService = new PetService(configurableApplicationContext);
        DoctorService doctorService = new DoctorService(configurableApplicationContext);
        ScheduleService scheduleService = new ScheduleService(configurableApplicationContext);

        boolean exit = false;
        while(!exit){
            Long petId, doctorId, scheduleId;
            System.out.println("Welcome to our Pet application");
            System.out.println("A. Create Entity?:");
            System.out.println("B. Update Entity?:");
            System.out.println("C. Delete Entity?:");
            System.out.println("X. Exit Application.");
            System.out.print("Select an option:");
            Scanner scan  = new Scanner(System.in);
            String input = scan.nextLine().toUpperCase();

            switch (input.charAt(0)){
                case 'A':
                    System.out.println();
                    System.out.println("a.Add a Pet?:");
                    System.out.println("b.Add a Doctor?:");
                    System.out.println("c.Create a schedule?:");
                    System.out.println("Select an option");
                    Scanner scanCreate  = new Scanner(System.in);
                    String option1 = scanCreate.nextLine().toLowerCase();
                    switch (option1.charAt(0)){
                        case 'a':
                            Scanner petScan  = new Scanner(System.in);
                            String petName, petSpecies, petDob;
                            System.out.println("Enter the pet's name:");
                            petName = petScan.next();
                            System.out.println("Enter the pet's species:");
                            petSpecies = petScan.next();
                            System.out.println("Enter the pet's dob:");
                            petDob = petScan.next();
                            petService.addPet(petName,petSpecies,petDob);
                            System.out.println(petName + " has been added successfully.");
                            break;
                        case 'b':
                            Scanner doctorScan  = new Scanner(System.in);
                            String firstname,lastname;
                            System.out.println("Enter the doctor's firstname:");
                            firstname = doctorScan.next();
                            System.out.println("Enter the doctor's lastname:");
                            lastname = doctorScan.next();
                            doctorService.addDoctor(firstname,lastname);
                            break;
                        case 'c':
                            Scanner scheduleScan  = new Scanner(System.in);
                            String date, time;

                            System.out.println("Enter the Pet's Id:");
                            petId = scheduleScan.nextLong();
                            System.out.println("Enter the Doctor's Id:");
                            doctorId = scheduleScan.nextLong();
                            petService.loadPets();
                            doctorService.loadDoctorData();
                            System.out.println();
                            //Checks whether or not the doctor and pet related data exists and creates data
                            if(petService.searchPet(petId)&&doctorService.searchDoctor(doctorId)) {
                                System.out.println("Enter the date of the schedule(dd/mm/yyyy):");
                                date = scheduleScan.next();
                                System.out.println("Enter the time of the schedule(tt:hh)");
                                time = scheduleScan.next();
                                scheduleService.addSchedule(petId,doctorId,date,time);
                            }else{
                                System.out.println("Pet id or doctor id does not exits.");
                            }
                            break;
                    }
                    break;
                case 'B':
                    System.out.println("a.Update a Pet?:");
                    System.out.println("b.Update a Doctor?:");
                    System.out.println("c.Update a schedule?:");
                    System.out.println("Select an option:");
                    Scanner scanUpdate  = new Scanner(System.in);
                    String option2 = scanUpdate.nextLine().toLowerCase();
                    switch (option2.charAt(0)) {
                        case 'a':
                            Scanner scanPetUpdate = new Scanner(System.in);
                            System.out.println();
                            System.out.println("Enter the pet Id you would like to update?:");
                            petId = scanPetUpdate.nextLong();
                            String petName, petSpecies, petDob;
                            if(petService.searchPet(petId)){
                                System.out.println("Enter the pet's name:");
                                petName = scanPetUpdate.next();
                                System.out.println("Enter the pet's species:");
                                petSpecies = scanPetUpdate.next();
                                System.out.println("Enter the pet's dob:");
                                petDob = scanPetUpdate.next();
                                petService.updatePet(petId,petName,petSpecies,petDob);
                                System.out.println(petName + " has been updated successfully.");
                            }else{
                                System.out.println("pet id " + petId + " does not exits");
                            }

                        break;
                        case 'b':
                            Scanner scanDoctorId = new Scanner(System.in);
                            System.out.println();
                            System.out.println("Enter the doctor Id you would like to delete?:");
                            doctorId = scanDoctorId.nextLong();
                            if(doctorService.searchDoctor(doctorId)){
                                Scanner doctorScan  = new Scanner(System.in);
                                String firstname,lastname;
                                System.out.println("Enter the doctor's firstname:");
                                firstname = doctorScan.next();
                                System.out.println("Enter the doctor's lastname:");
                                lastname = doctorScan.next();
                                doctorService.updateDoctor(doctorId,firstname,lastname);
                            }else{
                                System.out.println("doctor id " + doctorId + " does not exits");
                            }
                            break;
                        case 'c':
                            Scanner scanScheduleId = new Scanner(System.in);
                            System.out.println();
                            System.out.println("Enter the Schedule Id you would like to delete?:");
                            scheduleId = scanScheduleId.nextLong();
                            if(scheduleService.searchSchedule(scheduleId)){

                                Scanner scheduleScan  = new Scanner(System.in);

                                String date, time;
                                System.out.println("Enter the Pet's Id:");
                                petId = scheduleScan.nextLong();
                                System.out.println("Enter the Doctor's Id:");
                                doctorId = scheduleScan.nextLong();
                                petService.loadPets();
                                doctorService.loadDoctorData();
                                System.out.println();
                                //Checks whether or not the doctor and pet related data exists and creates data
                                if(petService.searchPet(petId)&&doctorService.searchDoctor(doctorId)) {
                                    System.out.println("Enter the date of the schedule(dd/mm/yyyy):");
                                    date = scheduleScan.next();
                                    System.out.println("Enter the time of the schedule(tt:hh)");
                                    time = scheduleScan.next();
                                    scheduleService.updateSchedule(scheduleId,petId,doctorId,date,time);
                                }else{
                                    System.out.println("Pet id or doctor id does not exits.");
                                }

                            }
                            else{
                                System.out.println("doctor id " + scheduleId + " does not exits");
                            }
                            break;
                    }

                    break;
                case 'C':
                    System.out.println("a.Delete a Pet?:");
                    System.out.println("b.Delete a Vet?:");
                    System.out.println("c.Delete a schedule?:");
                    System.out.println("Select an option:");
                    Scanner scanDelete  = new Scanner(System.in);
                    String option3 = scanDelete.nextLine().toLowerCase();
                    switch (option3.charAt(0)) {
                        case 'a':
                            Scanner scanPetId = new Scanner(System.in);
                            System.out.println();
                            System.out.println("Enter the pet Id you would like to delete?:");
                            petId = scanPetId.nextLong();
                            petService.deletePet(petId);
                            System.out.println(petId + " has been deleted from the database");

                            break;
                        case 'b':
                            Scanner scanDoctorId = new Scanner(System.in);
                            System.out.println();
                            System.out.println("Enter the doctor Id you would like to delete?:");
                            doctorId = scanDoctorId.nextLong();
                            doctorService.deleteDoctor(doctorId);
                            System.out.println(doctorId + " has been deleted from the database");

                            break;
                        case 'c':
                            Scanner scanScheduleId = new Scanner(System.in);
                            System.out.println();
                            System.out.println("Enter the Schedule Id you would like to delete?:");
                            scheduleId = scanScheduleId.nextLong();
                            scheduleService.deleteSchedule(scheduleId);
                            System.out.println(scheduleId + " has been deleted from the database");
                            break;
                    }
                    break;
                case 'X':
                    break;
            }
        }
     }

}