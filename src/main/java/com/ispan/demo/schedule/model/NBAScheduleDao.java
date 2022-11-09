package com.ispan.demo.schedule.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NBAScheduleDao extends JpaRepository<NBASchedule, Integer> {
//	List<Schedule> findTop3ByOrderByNewsNumberDesc();
//	
//	List<Schedule> findTop5ByOrderByNewsClickCountDesc();
	
//	@Query(value ="select * from newstable where newsIndex like CONCAT('%',?1,'%') ORDER BY ?#{#pageable}",countQuery = "select count(*) from newstable where newsIndex like CONCAT('%',?1,'%')",nativeQuery = true)
//	Page<Schedule> search(String word, Pageable pageable);
	
//	List<Schedule> findByPoint(String point);
	List<NBASchedule> findByGameDate(Date date);
	@Query("From NBASchedule s Order by s.gameDate DESC")
	List<NBASchedule> findAllOrderByGameDate();
	
}
