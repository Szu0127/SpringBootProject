package tw.leonchen.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfilesRepository extends JpaRepository<UserProfiles, Integer> {

	// 相當於JPQL: from UserProfiles where name = ?1
	public Optional<UserProfiles> findByName(String name);
}
