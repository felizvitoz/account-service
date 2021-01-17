package id.bikushoppu.user;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Builder
@Setter
public class UserResponse implements Serializable {

    private String username;
    private Date createdOn;
    private String createdBy;
    private String updatedBy;
    private Date updatedOn;
}
