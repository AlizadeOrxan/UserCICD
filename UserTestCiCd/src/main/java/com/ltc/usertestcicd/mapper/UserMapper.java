package com.ltc.usertestcicd.mapper;

import com.ltc.usertestcicd.dtos.UserRequestDto;
import com.ltc.usertestcicd.dtos.UserResponseDto;
import com.ltc.usertestcicd.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {


    @Mapping(target = "id" , ignore = true)
    UserEntity toEnity (UserRequestDto  userRequestDto);

    UserResponseDto  toDto (UserEntity userEntity);

    @Mapping(target = "id" , ignore = true)
    void updateUser(UserRequestDto userRequestDto,@MappingTarget UserEntity userEntity);
}
