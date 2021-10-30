package tw.leonchen.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	@Query(value = "from Users Where name like concat('%',?1,'%')")
	public List<Users> findUsers(String name);
	
	
	public List<Users> findByNameLike(String name);
	
	@Query(value = "Select * From Users", nativeQuery = true)
	public List<Users> findAll();
	
}
