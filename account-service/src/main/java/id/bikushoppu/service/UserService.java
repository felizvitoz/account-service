package id.bikushoppu.service;

import id.bikushoppu.entity.User;
import id.bikushoppu.user.CreateUserRequest;

public interface UserService {

    public User create(CreateUserRequest createUserRequest) throws Exception;

    public User findByUsername(String username) throws Exception;
}
