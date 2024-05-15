package com.nipunaupeksha.custom.user.manager.com.nipunaupeksha.custom.user.manager.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserDTO {

    private Long userId;
    private String userName;
}
