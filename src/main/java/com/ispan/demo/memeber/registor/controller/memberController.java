//package com.ispan.demo.memeber.registor.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Stream;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.ispan.demo.memeber.registor.model.member.Member;
//
//@RestController
//@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//public class memberController {
//
////	private final List<Member> memberDB=new ArrayList<>();
////	@PostConstruct
////private void initDB() {
////		memberDB.add(new Member("apple123","蕭蘋果","果果","Apple123","Apple123","S219162708", null, "apple123@apple.com", null, null, null, true, null, null, null, null));
////		memberDB.add(new Member("banana123","黃香蕉","蕉蕉","Banana123","Banana123","Y121643621", null, "banana123@banana123.com", null, null, null, false, null, null, null, null));
////		memberDB.add(new Member("cat123","毛凱蒂","蒂蒂","Ketty123","Ketty123","R259253330", null, "Ketty123@apple.com", null, null, null, false, null, null, null, null));
////		memberDB.add(new Member("dog123","史奴比","比比","Snoopy123","Snoopy123","M199671487", null, "Snoopy123@apple.com", null, null, null, false, null, null, null, null));
////		memberDB.add(new Member("eyes123","鳳大眼","眼眼","Bigeyes123","Bigeyes123","G268624072", null, "Bigeyes123@apple.com", null, null, null, false, null, null, null, null));
////	}
//	
//	@GetMapping("/member/{userId}")
//	public ResponseEntity<Member> getMember(@PathVariable("userId") String userId) {
//		Optional<Member> memberOp = memberDB.stream().filter(m->m.getUserId().equals(userId)).findFirst();
//		if (memberOp.isPresent()) {
//			Member member = memberOp.get();
//			return ResponseEntity.ok().body(member);
//		}
//		return ResponseEntity.notFound().build();
//	}
//	
//	
//	
//}
