package id.bikushoppu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.bikushoppu.authentication.AuthenticationRequest;
import id.bikushoppu.entity.User;
import id.bikushoppu.repository.UserRepository;
import id.bikushoppu.util.JwtTokenUtil;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String authenticate(final AuthenticationRequest authentication) throws Exception {
        User user = this.userRepository.findFirstByUsername(authentication.getUsername());
        if (user.getPassword().equals(authentication.getPassword())) {
            return this.jwtTokenUtil.generateToken(user);
        } else {
            throw new Exception("Unathorized");
        }
    }
}
