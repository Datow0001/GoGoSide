package com.ispan.demo.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ispan.demo.login.model.member.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    List<Member> findByUserIdAndPassword(String userId,String password);
    
    @Query(value = "from Member where userId = :userId")
    Member findByUserId(String userId);

    @Query(value = "from Member where userId = :userId")
    List<Member> findByAllUserId(@Param("userId") String userId);
        
}
