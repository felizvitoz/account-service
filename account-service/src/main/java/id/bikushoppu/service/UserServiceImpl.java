package id.bikushoppu.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.bikushoppu.entity.Role;
import id.bikushoppu.entity.User;
import id.bikushoppu.entity.UserRole;
import id.bikushoppu.repository.RoleRepository;
import id.bikushoppu.repository.UserRepository;
import id.bikushoppu.user.CreateUserRequest;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User create(CreateUserRequest createUser) throws Exception {
        User user = this.userRepository.findFirstByUsername(createUser.getUserName());
        if (user!=null) {
            throw new Exception("User Already Exists");
        }
        user = User.builder().username(createUser.getUserName()).password(createUser.getPassword()).build();
        Set<UserRole> userRoles = Optional.ofNullable(createUser.getRoleCodes()).orElse(new HashSet<>()).stream()
            .filter(code -> !"".equals(code.trim())).map(this::toUserRole)
            .filter(userRole -> userRole!=null).collect(Collectors.toSet());
        for (UserRole userRole : userRoles) {
            userRole.setUser(user);
        }
        user.setUserRoles(userRoles);
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(final String username) throws Exception {
        return userRepository.findFirstByUsername(username);
    }

    private UserRole toUserRole(String roleCode) {
        try {
            Role role = this.roleRepository.findFirstByCode(roleCode);
            return UserRole.builder().role(role).build();
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return null;
        }
    }
}
