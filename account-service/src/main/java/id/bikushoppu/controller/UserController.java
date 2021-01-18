package id.bikushoppu.controller;

import java.util.HashSet;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.bikushoppu.constant.AccessType;
import id.bikushoppu.entity.Accessibility;
import id.bikushoppu.entity.Role;
import id.bikushoppu.entity.RoleAccessibilitiy;
import id.bikushoppu.entity.User;
import id.bikushoppu.service.AccessibilityService;
import id.bikushoppu.service.RoleService;
import id.bikushoppu.service.UserService;
import id.bikushoppu.user.BaseSingleResponse;
import id.bikushoppu.user.CreateUserRequest;
import id.bikushoppu.user.UserResponse;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccessibilityService accessibilityService;

    @Autowired
    private RoleService roleService;

    @PostMapping
    public BaseSingleResponse<UserResponse> create(@RequestParam(name = "requestId") String requestId,
        @RequestParam(name = "channelId") String channelId, @RequestParam(name = "username") String username,
        @RequestBody CreateUserRequest request) throws Exception {
        //validate here if posibble before calling service...
        User user = this.userService.create(request);
        UserResponse userResponse = UserResponse.builder().build();
        BeanUtils.copyProperties(user, userResponse);
        BaseSingleResponse<UserResponse> response = BaseSingleResponse.<UserResponse>builder().content(userResponse).build();
        response.setSucces(true);
        return response;
    }

    @GetMapping("/fill-dummy")
    public String greeting() throws Exception {
        Accessibility accessibility =
            this.accessibilityService.create(Accessibility.builder().code("ACS-USERS").accessName("UserApiAccess").url("/users").build());
        Role role =
            Role.builder().code("RL-ADMIN").roleName("ADMIN").build();
        role.setRoleAccesibilities(new HashSet<>());
        RoleAccessibilitiy rc = RoleAccessibilitiy.builder().role(role).accessibility(accessibility).accessType(AccessType.WRITE).build();
        role.getRoleAccesibilities().add(rc);
        this.roleService.create(role);
        return role.getCode();
    }
}
