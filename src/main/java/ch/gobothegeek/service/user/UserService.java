package ch.gobothegeek.service.user;

import ch.gobothegeek.model.user.User;
import ch.gobothegeek.repository.user.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class UserService {
    private final Logger logger = LogManager.getLogger(UserService.class);

    @Inject private UserRepository userRepo;

    public UserService() { }

    public Boolean checkUser(String login, String pwd) {
        Optional<User> optUser;

        optUser = this.userRepo.checkLogin(login, pwd);
        return (optUser.isPresent());
    }
}
