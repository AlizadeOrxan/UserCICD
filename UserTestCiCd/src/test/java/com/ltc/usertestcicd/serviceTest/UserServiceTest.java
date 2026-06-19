package com.ltc.usertestcicd.serviceTest;

import com.ltc.usertestcicd.dtos.UserRequestDto;
import com.ltc.usertestcicd.dtos.UserResponseDto;
import com.ltc.usertestcicd.mapper.UserMapper;
import com.ltc.usertestcicd.model.UserEntity;
import com.ltc.usertestcicd.repos.UserRepository;
import com.ltc.usertestcicd.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;



    @Test
    void createUserTest(){

        UserRequestDto userRequestDto = new UserRequestDto("Nurlan","Alizade");

        UserEntity  userEntity = new UserEntity(1L,"Nurlan","Alizade");

        UserResponseDto  userResponseDto = new UserResponseDto(1L,"Nurlan","Alizade");


        when(userMapper.toEnity(userRequestDto)).thenReturn(userEntity);

        when(userRepository.save(userEntity)).thenReturn(userEntity);

        when(userMapper.toDto(userEntity)).thenReturn(userResponseDto);

        UserResponseDto result = userService.createUser(userRequestDto);


        assertNotNull(result);
        assertEquals(1L,result.getId());
        assertEquals("Nurlan",result.getFirstName());
        assertEquals("Alizade",result.getLastName());

        verify(userMapper).toEnity(userRequestDto);
        verify(userRepository).save(userEntity);
        verify(userMapper).toDto(userEntity);

    }

    @Test
    void getByIdTest(){



        Long id = 1L;

        UserEntity  userEntity = new UserEntity(id,"Nurlan","Alizade");

        UserResponseDto userResponseDto = new UserResponseDto(id,"Nurlan","Alizade");

        when(userRepository.findById(id)).thenReturn(Optional.of(userEntity));

        when(userMapper.toDto(userEntity)).thenReturn(userResponseDto);

        UserResponseDto result = userService.getById(id);

        assertNotNull(result);
        assertEquals(id,result.getId());
        assertEquals("Nurlan",result.getFirstName());
        assertEquals("Alizade",result.getLastName());

        verify(userRepository).findById(id);
        verify(userMapper).toDto(userEntity);

    }

    @Test
    void getAllUsersTest(){

        UserEntity user1 = new UserEntity(1L,"Nurlan","Alizade");
        UserEntity user2 = new UserEntity(2L,"Elnur","Huseynov");

        UserResponseDto userResponseDto1 = new UserResponseDto(1L,"Nurlan","Alizade");
        UserResponseDto userResponseDto2 = new UserResponseDto(2L,"Elnur","Huseynov");

        when(userRepository.findAll()).thenReturn(List.of(user1,user2));

        when(userMapper.toDto(user1)).thenReturn(userResponseDto1);
        when(userMapper.toDto(user2)).thenReturn(userResponseDto2);

        List<UserResponseDto> result = userService.getAll();

        assertNotNull(result);
        assertEquals("Nurlan",result.get(0).getFirstName());
        assertEquals("Alizade",result.get(0).getLastName());

        assertEquals("Elnur",result.get(1).getFirstName());
        assertEquals("Huseynov",result.get(1).getLastName());

        verify(userRepository).findAll();
        verify(userMapper).toDto(user1);
        verify(userMapper).toDto(user2);
    }

    @Test
    void updateUserTest(){
        Long id = 1L;

        UserRequestDto userRequestDto = new UserRequestDto("Cavid","Memmedov");
        UserEntity  userEntity = new UserEntity(id,"Nurlan","Alizade");
        UserResponseDto  userResponseDto = new UserResponseDto(id,"Cavid","Memmedov");

        when(userRepository.findById(id)).thenReturn(Optional.of(userEntity));
        doNothing().when(userMapper).updateUser(userRequestDto,userEntity);
        when(userRepository.save(userEntity)).thenReturn(userEntity);
        when(userMapper.toDto(userEntity)).thenReturn(userResponseDto);

        UserResponseDto result = userService.updateUser(id,userRequestDto);

        assertNotNull(result);

        assertEquals(id,result.getId());
        assertEquals("Cavid",result.getFirstName());
        assertEquals("Memmedov",result.getLastName());
        verify(userRepository).findById(id);
        verify(userMapper).updateUser(userRequestDto,userEntity);
        verify(userRepository).save(userEntity);
        verify(userMapper).toDto(userEntity);



    }








}
