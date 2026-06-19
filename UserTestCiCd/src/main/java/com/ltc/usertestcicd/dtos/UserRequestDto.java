package com.ltc.usertestcicd.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter  @Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDto {

     String firstName;
     String lastName;
}
