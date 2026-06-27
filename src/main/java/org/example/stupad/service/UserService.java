package org.example.stupad.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.example.stupad.dao.entity.User;
import org.example.stupad.dao.repository.UserRepository;
import org.example.stupad.exception.ResourceNotFoundException;
import org.example.stupad.mapper.UserMapper;
import org.example.stupad.model.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return userMapper.toUserDtoList(users);
    }

    public UserDto getById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return userMapper.toUserDto(user);
    }

    public UserDto create(UserDto userDto) {
        User user = userMapper.toUser(userDto);
        log.info("Saving user to database: {}", user);
        User savedUser = userRepository.save(user);
        return userMapper.toUserDto(savedUser);
    }
}
