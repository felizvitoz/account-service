package id.bikushoppu.controller;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import id.bikushoppu.constant.AccessType;
import id.bikushoppu.entity.Accessibility;
import id.bikushoppu.entity.Role;
import id.bikushoppu.entity.RoleAccessibilitiy;
import id.bikushoppu.entity.User;
import id.bikushoppu.service.AccessibilityService;
import id.bikushoppu.service.RoleService;
import id.bikushoppu.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccessibilityService accessibilityService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/greeting")
    public String greeting() throws Exception {
        Accessibility accessibility =
            this.accessibilityService.create(Accessibility.builder().code("ACS-USERS").accessName("UserApiAccess").url("/users").build());
        Role role =
            Role.builder().code("RL-ADMIN").roleName("ADMIN").build();
        role.setRoleAccesibilities(new HashSet<>());
        RoleAccessibilitiy rc = RoleAccessibilitiy.builder().role(role).accessibility(accessibility).accessType(AccessType.WRITE).build();
        role.getRoleAccesibilities().add(rc);
        this.roleService.create(role);
        User user = User.builder().username("feliz").password("password").build();
        return userService.create(user).toString();
    }
}
