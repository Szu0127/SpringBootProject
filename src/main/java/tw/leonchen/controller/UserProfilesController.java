package tw.leonchen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tw.leonchen.model.UserProfiles;
import tw.leonchen.model.UserProfilesService;

@RestController
public class UserProfilesController {

	@Autowired
	private UserProfilesService uService;
	
	@PostMapping("/userprofilescreate.controller")
	public UserProfiles processCreateUserAction (@RequestBody UserProfiles uProfiles) {
		
		String encode1 = new BCryptPasswordEncoder().encode(uProfiles.getPassword());
		uProfiles.setPassword(encode1);
		
		return uService.createUserProfiles(uProfiles);
	}
	
	
}
