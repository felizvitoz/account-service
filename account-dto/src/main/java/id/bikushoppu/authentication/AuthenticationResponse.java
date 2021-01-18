package id.bikushoppu.authentication;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse implements Serializable {

    private final String token;
}
