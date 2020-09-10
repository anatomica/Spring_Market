package com.anatomica.market;


import com.anatomica.market.entities.User;
import com.anatomica.market.repositories.UsersRepository;
import com.anatomica.market.services.UsersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {
    @Autowired
    private UsersService usersService;

    @MockBean
    private UsersRepository usersRepository;

    @Test
    public void findOneUserTest() {
        User userFromDB = new User();
        userFromDB.setFirstName("John");
        userFromDB.setEmail("john@mail.ru");

        Mockito.doReturn(Optional.of(userFromDB))
                .when(usersRepository)
                .findOneByEmail("john@mail.ru");

        User userJohn = usersService.findByEmail("john@mail.ru").get();
        Assertions.assertNotNull(userJohn);
        Mockito.verify(usersRepository, Mockito.times(1)).findOneByEmail(ArgumentMatchers.eq("john@mail.ru"));
//        Mockito.verify(userRepository, Mockito.times(1)).findOneByPhone(ArgumentMatchers.any(String.class));
    }
}
