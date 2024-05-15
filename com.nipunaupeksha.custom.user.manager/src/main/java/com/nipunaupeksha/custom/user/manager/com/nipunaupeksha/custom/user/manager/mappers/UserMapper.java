package com.nipunaupeksha.custom.user.manager.com.nipunaupeksha.custom.user.manager.mappers;

import com.nipunaupeksha.custom.user.manager.com.nipunaupeksha.custom.user.manager.entities.User;
import com.nipunaupeksha.custom.user.manager.com.nipunaupeksha.custom.user.manager.models.UserDTO;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User userDtoToUser(UserDTO userDTO);

    UserDTO userToUserDto(User user);
}
