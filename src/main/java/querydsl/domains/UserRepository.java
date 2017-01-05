package querydsl.domains;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface UserRepository extends JpaRepository<User, Integer>, QueryDslPredicateExecutor<User> {
}
