//package com.ispan.demo.memeber.registor.security.config;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import com.ispan.demo.memeber.dto.MemberRequest;
//import com.ispan.demo.memeber.dto.MemberResponse;
//import com.ispan.demo.memeber.registor.model.member.Member;
//
//public class MemberConverter {
//
////	將請求資訊放入 new member()
//	public static Member toMember(MemberRequest request) {
//		Member member = new Member();
//		member.setUserId(request.getUserId());
//		member.setPassword(request.getPassword());
//		member.setMail(request.getMail());
//		member.setNickName(request.getNikeName());
//		member.setRoles(request.getRoles());
//		return member;
//	}
//	
//	//將資料庫member資訊放進new MemberResponse()
//	public static MemberResponse toMemberResponse(Member member) {
//		MemberResponse response = new MemberResponse();
//		response.setUserId(member.getUserId());
//		response.setPassword(member.getPassword());
//		response.setMail(member.getMail());
//		response.setNikeName(member.getNickName());
//		response.setRoles(member.getRoles());
//		return response;
//		
//		
//	}
//	public static List<MemberResponse> toMemberResponse(List<Member> members) {
//		return members.stream()
//					  .map(MemberConverter::toMemberResponse)
//					  .collect(Collectors.toList());
//	}
//	
//	
//}
