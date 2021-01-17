package id.bikushoppu.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ACS_ROLE")
@AllArgsConstructor
@Getter
@Builder
@Setter
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="code", nullable=false, unique=true)
    private String code;

    @Column(name="roleName")
    private String roleName;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    Set<RoleAccessibilitiy> roleAccesibilities;

}
