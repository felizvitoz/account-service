package id.bikushoppu.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntity {

    private Date createdOn;
    private String createdBy;
    private String updatedBy;
    private Date updatedOn;
}
