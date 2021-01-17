package id.bikushoppu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.bikushoppu.entity.User;
import id.bikushoppu.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(final User user) throws Exception {
        return userRepository.save(user);
    }
}
