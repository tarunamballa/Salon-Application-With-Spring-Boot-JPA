package com.salon.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.salon.bean.SalonService;

public interface ISalonRepository extends JpaRepository<SalonService,Long>{
	
	@Query(value="select * from salon_service where service_name=:serviceName",nativeQuery=true)
	List<SalonService> findByServiceName(@Param("serviceName") String serviceName);
		
	@Query(value="select * from salon_service where service_price=:servicePrice",nativeQuery=true)
		List<SalonService> findByServicePrice(@Param("servicePrice") double servicePrice);

	@Query(value="select * from salon_service where service_duration=:serviceDuration",nativeQuery=true)
	List<SalonService> findByServiceDuration(@Param("serviceDuration") String serviceDuration);

}
