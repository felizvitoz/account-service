package id.bikushoppu.user;

import java.util.Collections;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BaseListResponse <T extends Collections> extends BaseResponse {

    private T contents;
}
