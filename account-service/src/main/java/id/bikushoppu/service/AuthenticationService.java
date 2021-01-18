package id.bikushoppu.service;

import id.bikushoppu.authentication.AuthenticationRequest;

public interface AuthenticationService {

    public String authenticate(AuthenticationRequest authentication) throws Exception;
}
