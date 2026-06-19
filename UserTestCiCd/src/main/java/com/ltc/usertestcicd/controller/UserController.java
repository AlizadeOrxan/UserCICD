package com.ltc.usertestcicd.controller;

import com.ltc.usertestcicd.dtos.UserRequestDto;
import com.ltc.usertestcicd.dtos.UserResponseDto;
import com.ltc.usertestcicd.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/create")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto){
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {
        UserResponseDto userResponseDto = userService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<UserResponseDto> userResponseDtos = userService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDtos);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id ,@RequestBody UserRequestDto userRequestDto){
        UserResponseDto userResponseDto = userService.updateUser(id, userRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }


}

