package id.bikushoppu.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "account-service", path = "/users")
public interface UserClient {

    @PostMapping
    public BaseSingleResponse<UserResponse> create(@RequestParam(name = "requestId") String requestId,
            @RequestParam(name = "channelId") String channelId, @RequestParam(name = "username") String username,
            @RequestBody CreateUserRequest request);
}
