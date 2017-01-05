package querydsl.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import querydsl.domains.User;
import querydsl.infrastructure.Responses;
import querydsl.services.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<User> create(@RequestBody User user) {
        try {
            return Responses.ok(userService.createOrUpdate(user));
        } catch (Exception e){
            return Responses.internalServerError(e.getMessage());
        }

    }

}
