package com.abc.CabBookingApplication.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.CabBookingApplication.entity.TripBooking;

public interface TripBookingRepository extends JpaRepository<TripBooking, Integer> {

	List<TripBooking> findAllByCustomerId(int customer_id);

	@Query("select t.bill from TripBooking t where t.customerId = :tId") public
	List<Float> getBillOfCustomer(@Param("tId") int tripId);
	
	List<TripBooking> findByOrderByCustomerIdAsc();

	List<TripBooking> findByOrderByFromDateTimeAsc();

	List<TripBooking> findByOrderByDriverAsc();

	@Query("select t from TripBooking t where t.customerId = :cid and t.fromDateTime >= :fd and t.toDateTime <= :td")
    List<TripBooking> findAllWithFromDateTimeBefore(@Param("cid") int custid,@Param("fd") LocalDateTime fromdate,@Param("td") LocalDateTime todate);
}
