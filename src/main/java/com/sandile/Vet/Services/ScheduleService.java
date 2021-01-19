package com.sandile.Vet.Services;
import com.sandile.Vet.Model.Schedule;
import com.sandile.Vet.Repo.ScheduleRepo;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScheduleService {

    private List<Schedule> scheduleList;
    private ScheduleRepo scheduleRepo;

    public ScheduleService(ConfigurableApplicationContext configurableApplicationContext){
        scheduleRepo = configurableApplicationContext.getBean(ScheduleRepo.class);
        scheduleList = new ArrayList<>();
    }

    public void loadScheduleData(){
        scheduleList = (List<Schedule>) scheduleRepo.findAll();
    }

    public void addSchedule(Long petId,Long doctorId,String date, String time){
        Schedule schedule = new Schedule(petId,doctorId,date,time);
        scheduleRepo.save(schedule);
    }

    public void updateSchedule(@PathVariable("schedule_id")Long id,Long petId,Long doctorId,String date, String time){

        Schedule schedule = new Schedule(petId,doctorId,date,time);
        scheduleRepo.save(schedule);
    }

    public void deleteSchedule(Long id){
        scheduleRepo.deleteById(id);
    }

    public boolean searchSchedule(Long scheduleId){
        boolean result;
        Optional<Schedule> optionalSchedule = scheduleRepo.findById(scheduleId);
        result = optionalSchedule.isPresent();
        return result;
    }

    @Override
    public String toString(){
        String temp = "";
        for (Schedule schedule:scheduleList) {
            temp+=schedule.toString() + "\n";
        }
        return temp;
    }

    public Schedule getSchedule(int scheduleId){
        return scheduleList.get(scheduleId);
    }

}
