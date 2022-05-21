package com.fintech.monopostspr.converters;

import com.fintech.monopostspr.dto.request.UserRequest;
import com.fintech.monopostspr.dto.response.UserResponse;
import com.fintech.monopostspr.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    public User convertToEntity(UserRequest userRequest) {
        return User.builder()
                .firstName(userRequest.getFirstName())
                .secondName(userRequest.getSecondName())
                .patronymicName(userRequest.getPatronymicName())
                .phoneNumber(userRequest.getPhoneNumber())
                .email(userRequest.getEmail())
                .build();
    }

    public UserResponse convertToUserResponse(User user) {
        return UserResponse.builder()
                .firstName(user.getFirstName())
                .secondName(user.getSecondName())
                .patronymicName(user.getPatronymicName())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .build();
    }

    public List<UserResponse> convertToListUserResponse(List<User> users){
        return users.stream().map(this::convertToUserResponse).collect(Collectors.toList());
    }
}
