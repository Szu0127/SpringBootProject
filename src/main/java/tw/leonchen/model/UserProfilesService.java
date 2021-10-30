package tw.leonchen.model;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.leonchen.exception.UserNotFoundException;

@Service
@Transactional
public class UserProfilesService {

	@Autowired
	private UserProfilesRepository uRepo;

	public UserProfiles getByName(String name) {
		Optional<UserProfiles> op1 = uRepo.findByName(name);

		if (op1.isEmpty()) {
			throw new UserNotFoundException("Can't Find User");
		}

		return op1.get();
	}

	public UserProfiles createUserProfiles(UserProfiles userProfiles) {
		return uRepo.save(userProfiles);
	}
}
