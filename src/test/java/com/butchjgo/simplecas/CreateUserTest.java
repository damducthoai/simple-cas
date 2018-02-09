package com.butchjgo.simplecas;

import com.butchjgo.simplecas.entity.User;
import com.butchjgo.simplecas.repository.UserRepository;
import com.butchjgo.simplecas.service.UserService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateUserTest {
    @Autowired
    private UserService userService;

    @Test
    public void createUser1() {
        User user = new User("dxadasxddasdsd","adasd");
        Optional<User> rs = userService.create(user);
        assert (rs.isPresent());
        userService.delete(rs.get());
    }

    @Test
    public void createUser2() {
        User user = new User("dxadasxddasdsd","adasd");
        Optional<User> rs = userService.create(user);
        assert (rs.isPresent());
        userService.delete(rs.get().getId());
    }
}
