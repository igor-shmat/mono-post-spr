package com.fintech.monopostspr.controller;

import com.fintech.monopostspr.converters.UserConverter;
import com.fintech.monopostspr.dto.request.UserRequest;
import com.fintech.monopostspr.dto.response.UserResponse;
import com.fintech.monopostspr.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final UserConverter userConverter;

    @PostMapping("/create")
    public UserResponse create(@RequestBody UserRequest userRequest) {
        return userConverter.convertToUserResponse(userService.create(userRequest));
    }

    @PutMapping("/update/{id}")
    public UserResponse update(@PathVariable Long id, @RequestBody UserRequest userRequest){
        return userConverter.convertToUserResponse(userService.update(userRequest,id));
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "User deleted successfully";
    }

    @GetMapping("readById/{id}")
    public UserResponse readById(@PathVariable Long id){
        return userConverter.convertToUserResponse(userService.findById(id));
    }
}
