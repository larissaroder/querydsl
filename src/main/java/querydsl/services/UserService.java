package querydsl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import querydsl.domains.User;
import querydsl.domains.UserRepository;
import querydsl.infrastructure.filter.FilterService;
import querydsl.services.abstractservice.AbstractService;

@Service
public class UserService extends AbstractService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserService(FilterService filterService) {
        super(filterService);
    }

    @Transactional
    public User createOrUpdate(User user) {
       return userRepository.save(user);
    }

}
