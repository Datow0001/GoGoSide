package com.ispan.demo.memeber.registor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ispan.demo.memeber.registor.model.member.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    List<Member> findByUserIdAndPassword(String userId,String password);
    
    Optional<Member> findUserByMail(String mail);
    
    
//    @Query(value = "from Member where userId = :userId")
//    Member findByUserId(String userId);

//    @Query(value = "from Member where userId = :userId")
//    List<Member> findByAllUserId(@Param("userId") String userId);
        
}
