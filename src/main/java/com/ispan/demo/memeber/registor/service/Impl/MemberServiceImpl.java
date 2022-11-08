package com.ispan.demo.memeber.registor.service.Impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.demo.memeber.registor.model.member.Member;
import com.ispan.demo.memeber.registor.repository.MemberRepository;
import com.ispan.demo.memeber.registor.service.MemberService;

import com.ispan.demo.memeber.login.model.Login;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    private MemberRepository mRepository;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public MemberServiceImpl(MemberRepository mRepository) {
		this.mRepository = mRepository;
//		this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
	}


	@Override
    public List<Member> findAll() {
//    	List<Member> memberList = new ArrayList<>();
//    	memberList.add(new Member("apple123","蕭蘋果","果果","Apple123","Apple123","S219162708", null, "apple123@apple.com", null, null, null, "admin", null, null, null, null));
//    	memberList.add(new Member("banana123","黃香蕉","蕉蕉","Banana123","Banana123","Y121643621", null, "banana123@banana123.com", null, null, null, "user", null, null, null, null));
//    	memberList.add(new Member("cat123","毛凱蒂","蒂蒂","Ketty123","Ketty123","R259253330", null, "Ketty123@apple.com", null, null, null, "user", null, null, null, null));
//    	memberList.add(new Member("dog123","史奴比","比比","Snoopy123","Snoopy123","M199671487", null, "Snoopy123@apple.com", null, null, null, "user", null, null, null, null));
//    	memberList.add(new Member("eyes123","鳳大眼","眼眼","Bigeyes123","Bigeyes123","G268624072", null, "Bigeyes123@apple.com", null, null, null, "user", null, null, null, null));
    	return mRepository.findAll();
    }


	@Override
	public Member save(Member member) {
		member.setRegisterTime(new Timestamp(System.currentTimeMillis()));
		return mRepository.save(member);
	}


	@Override
	public List<Member> findByUserIdAndPassword(String userId, String password) {
		return mRepository.findByUserIdAndPassword(userId, password);
		
	}


	@Override
	public boolean existsByUserId(String userId) {
		return mRepository.existsById(userId);
	}


	@Override
	public boolean existsByMail(String mail) {
		return mRepository.existsById(mail);
	}


	@Override
	public boolean existsByPhone(String phone) {
		return mRepository.existsById(phone);
	}


	@Override
	public Login cheakIdPassword(String userId, String password) {
//		Member member=null;
		Login login=new Login();
		List<Member> memberIdPassword = mRepository.findByUserIdAndPassword(userId, password);
		if (memberIdPassword.size()>0) {
//			member = memberIdPassword.get(0);
			login =new Login(userId,password,false);
		}else {
			login=null;
		}
			
		
		return login;
	}


	@Override
	public Member findByUserId(String userId) {
		Optional<Member> member=mRepository.findById(userId);
		if(member.isPresent()) {
			return member.get();
		}else {
			return null;
			
		}
	}


	@Override
	public void insert(Member member) {
		mRepository.save(member);
	}
	
	

	




//
//	@Override
//	public Member getMemberByMail(String mail) {
//		return mRepository.findUserByMail(mail).orElseThrow(()->new ResourceNotFoundException("can't find user"));
//	}

////將請求轉成回應給前端，將請求放到new Member()，將密碼加密
//	public MemberResponse createUser(MemberRequest request) {
//		Member member = MemberConverter.toMember(request);
//		member.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
//		member=mRepository.save(member);
//		return MemberConverter.toMemberResponse(member);
//	}

    

}
