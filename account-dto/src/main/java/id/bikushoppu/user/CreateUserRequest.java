package id.bikushoppu.user;

import java.io.Serializable;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Builder
@Setter
public class CreateUserRequest implements Serializable {

    private String userName;
    private String password;
    private Set<String> roleCodes;
}
