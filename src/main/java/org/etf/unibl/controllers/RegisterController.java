package org.etf.unibl.controllers;

import lombok.AllArgsConstructor;
import org.etf.unibl.models.entities.UserEntity;
import org.etf.unibl.models.enums.Status;
import org.etf.unibl.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegisterController {
    private final String NAME_QUERY = "name";
    private final String SURNAME_QUERY = "surname";
    private final String USERNAME_QUERY = "username";
    private final String PASSWORD_QUERY = "password";
    private final String EMAIL_QUERY = "email";

    private final UserService userService;

    @PostMapping("/register")
    void register(@RequestParam(value = NAME_QUERY) String name,
                    @RequestParam(value = SURNAME_QUERY) String surname,
                    @RequestParam(value = USERNAME_QUERY) String username,
                    @RequestParam(value = PASSWORD_QUERY) String password,
                    @RequestParam(value = EMAIL_QUERY) String email){

        UserEntity user = new UserEntity(name,surname,username,password,email);
        user.setStatus(Status.PENDING.toString());
        userService.saveUser(user);
    }
}