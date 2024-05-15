package com.nipunaupeksha.custom.user.manager.com.nipunaupeksha.custom.user.manager.services;

import com.nipunaupeksha.custom.user.manager.com.nipunaupeksha.custom.user.manager.entities.User;
import com.nipunaupeksha.custom.user.manager.com.nipunaupeksha.custom.user.manager.mappers.UserMapper;
import com.nipunaupeksha.custom.user.manager.com.nipunaupeksha.custom.user.manager.models.UserDTO;
import com.nipunaupeksha.custom.user.manager.com.nipunaupeksha.custom.user.manager.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.userDtoToUser(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.userToUserDto(savedUser);
    }
}
