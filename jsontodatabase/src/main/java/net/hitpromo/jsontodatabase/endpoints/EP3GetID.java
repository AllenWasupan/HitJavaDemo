package net.hitpromo.jsontodatabase.endpoints;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.veinhorn.spring.sqlfile.SqlFromResource;

@RestController
public class EP3GetID {

	@GetMapping("/find-id/{productId}")
	public String createProduct(@PathVariable int productId) {
		System.out.println(productId);
		return "wow3!";
	}
	@Repository
	public interface UserRepository extends JpaRepository<User, Integer> {
		@SqlFromResource(path = "select_user_by_id.sql")
		User findById(int userId);
	}
}