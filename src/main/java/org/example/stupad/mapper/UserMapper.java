package org.example.stupad.mapper;

import org.example.stupad.dao.entity.User;
import org.example.stupad.model.UserDto;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);
    User toUser(UserDto userDto);
}
