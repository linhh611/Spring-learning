package app;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByNameLike(String name, Pageable pageable);
}
