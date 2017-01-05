package querydsl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import querydsl.domains.User;
import querydsl.domains.UserRepository;

/**
 * Created by Larissa on 04/01/2017.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createOrUpdate(User user) {
       return userRepository.save(user);
    }
}
