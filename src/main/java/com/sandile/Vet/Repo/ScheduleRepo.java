package com.sandile.Vet.Repo;

import com.sandile.Vet.Model.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepo extends CrudRepository<Schedule, Long> {


}
