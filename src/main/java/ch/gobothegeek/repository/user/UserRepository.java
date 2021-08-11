package ch.gobothegeek.repository.user;

import ch.gobothegeek.model.user.User;
import ch.gobothegeek.model.user.UserPK;
import org.apache.deltaspike.data.api.EntityManagerDelegate;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.criteria.CriteriaSupport;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.Optional;

// the repository for User class
@ApplicationScoped
@Transactional
@Repository(forEntity = User.class)
public interface UserRepository extends FullEntityRepository<User, UserPK>, EntityManagerDelegate<User>, CriteriaSupport<User> {

    @Transactional Optional<User> findByLogin(String login);

    @Transactional
    @Query("SELECT u FROM User u WHERE u.login = ?1 AND u.password = ?2 AND u.enabled = true")
    Optional<User> checkLogin(String username, String hashPwd);
}

