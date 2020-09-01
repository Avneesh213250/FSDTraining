package com.group2.FSD.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group2.FSD.domain.Officer;
import com.group2.FSD.domain.User;
import com.group2.FSD.repository.OfficerRepository;
import com.group2.FSD.repository.UserJPARepo;

@Service
@Transactional
public class LoginService {

	@Autowired
	UserJPARepo userJPARepo;
	
	@Autowired
	OfficerRepository offRepository;
	
	public User findByUseridAndPassword(int userid,String password) {
		Optional<User> user=userJPARepo.findById(userid);
	
		User user1=null;
		if(user.isPresent()) {
			if(password.equals(user.get().getPassword())) {
				user1= user.get();
				System.out.println("   =======    "+user1);
			}
			
		}
		return user1;
	}
	
	public User updateById(int userid, User user) {
	
				Optional<User> saOptional = userJPARepo.findById(userid);
		User salesT = null;
		if (saOptional.isPresent()) {
			user.setuserid(userid);
			user.setUsertype(saOptional.get().getUsertype());
			salesT = userJPARepo.save(user);
		}
		System.out.println(salesT);
		return salesT;
	}
	public Officer findById(int userid) {
		Optional<Officer> user=offRepository.findById(userid);
		
		
		return user.get();
	}
	public List<User> findAll() {
		List<User> list = userJPARepo.findAll();
		return list;
}
}
