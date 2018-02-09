package com.butchjgo.simplecas.serviceimpl;

import com.butchjgo.simplecas.entity.User;
import com.butchjgo.simplecas.entity.UserProfile;
import com.butchjgo.simplecas.repository.UserProfileRepository;
import com.butchjgo.simplecas.repository.UserRepository;
import com.butchjgo.simplecas.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Data
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProfileRepository userProfileRepository;

    @Override
    @Transactional
    public Optional<User> create(User user) {
        Optional<User> optionalUser;
        boolean existed = userRepository.findUserByEmail(user.getEmail()).isPresent();
        if (!existed) {
            user.setId(null);
            User userResult = userRepository.save(user);

            UserProfile profile = new UserProfile();
            profile.setUser(userResult);
            userProfileRepository.save(profile);

            optionalUser = Optional.of(userResult);
        } else {
            optionalUser = Optional.empty();
        }
        return optionalUser;
    }

    @Override
    @Transactional
    public void delete(User user) {
        userProfileRepository.removeByUserId(user.getId());
        userRepository.delete(user);
    }

    @Override
    @Transactional
    public void delete(long userId) {
        userProfileRepository.removeByUserId(userId);
        userRepository.deleteById(userId);
    }
}
