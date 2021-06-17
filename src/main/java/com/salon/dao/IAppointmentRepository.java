package com.salon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salon.bean.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment,Long>{
	
	@Query(value="select * from appointment where status=:status",nativeQuery=true)
	List<Appointment> getAppointmentstatus(@Param("status") String status);

}
