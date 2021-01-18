package id.bikushoppu.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.bikushoppu.authentication.AuthenticationRequest;
import id.bikushoppu.authentication.AuthenticationResponse;
import id.bikushoppu.service.AuthenticationService;
import id.bikushoppu.user.BaseSingleResponse;
import id.bikushoppu.util.JwtTokenUtil;

@RestController
public class AuthenticationController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    @RequestMapping("/authenticate")
    public BaseSingleResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) throws Exception {
        String token = this.authenticationService.authenticate(request);
        AuthenticationResponse response = AuthenticationResponse.builder().token(token).build();
        return BaseSingleResponse.<AuthenticationResponse>builder().content(response).build();
    }

    @GetMapping
    @RequestMapping("/check-role")
    public String authenticatez(@RequestParam String token) throws Exception {
        String roles = this.jwtTokenUtil.getRoles(token).stream().collect(Collectors.joining(","));
        return roles;
    }
}
