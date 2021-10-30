package tw.leonchen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.leonchen.model.Users;
import tw.leonchen.model.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UsersService uService;
	
	@GetMapping("/findusers.controller")
	public List<Users> processFindUsersAction1(){
		return uService.findUsers("ma");
	}
	
	@GetMapping("/findusersbynamelike.controller")
	public List<Users> processFindUsersByNameAction(@RequestParam("name") String name){
		return uService.findByNameLike("%" + name + "%");
	}
	
}
