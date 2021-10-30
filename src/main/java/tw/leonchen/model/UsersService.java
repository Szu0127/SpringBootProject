package tw.leonchen.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersService {
	
	@Autowired
	private UsersRepository uResp;
	
    public List<Users> findUsers(String name){
    	return uResp.findUsers(name);
    }
    
    public List<Users> findByNameLike(String name){
    	return uResp.findByNameLike(name);
    }
    
}

