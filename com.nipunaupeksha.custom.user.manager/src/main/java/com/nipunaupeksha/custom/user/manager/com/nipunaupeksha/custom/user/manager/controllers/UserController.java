package com.nipunaupeksha.custom.user.manager.com.nipunaupeksha.custom.user.manager.controllers;

import com.nipunaupeksha.custom.user.manager.com.nipunaupeksha.custom.user.manager.models.UserDTO;
import com.nipunaupeksha.custom.user.manager.com.nipunaupeksha.custom.user.manager.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {
    public static final String USER_PATH = "/api/v1/users";

    private final UserService userService;

    @PostMapping(USER_PATH)
    public ResponseEntity<UserDTO> addUser(@RequestParam("username") String username) {

        UserDTO savedUserDTO = userService.createUser(UserDTO.builder().userName(username).build());
        return ResponseEntity.ok(savedUserDTO);
    }
}
