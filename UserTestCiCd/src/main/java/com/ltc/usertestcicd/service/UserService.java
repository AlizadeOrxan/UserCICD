package com.ltc.usertestcicd.service;

import com.ltc.usertestcicd.dtos.UserRequestDto;
import com.ltc.usertestcicd.dtos.UserResponseDto;
import com.ltc.usertestcicd.mapper.UserMapper;
import com.ltc.usertestcicd.model.UserEntity;
import com.ltc.usertestcicd.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }



    public UserResponseDto createUser(UserRequestDto userRequestDto) {

        UserEntity userEntity = userMapper.toEnity(userRequestDto);

        return userMapper.toDto(userRepository.save(userEntity));
    }


    public UserResponseDto getById(Long id){
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDto(userEntity);
    }

    public List<UserResponseDto> getAll(){
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserResponseDto updateUser(Long id ,UserRequestDto userRequestDto) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userMapper.updateUser(userRequestDto, userEntity);

        return userMapper.toDto(userRepository.save(userEntity));
    }


    void deleteUser(Long id){
        userRepository.deleteById(id);
    }


}
