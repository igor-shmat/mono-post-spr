package com.fintech.monopostspr.service;

import com.fintech.monopostspr.converters.UserConverter;
import com.fintech.monopostspr.repository.UserRepository;
import com.fintech.monopostspr.dto.request.UserRequest;
import com.fintech.monopostspr.entity.User;
import com.fintech.monopostspr.exceptions.EntityNotFoundException;
import com.fintech.monopostspr.exceptions.СreateInDbException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public User create(UserRequest userRequest) {
        Optional<User> userFromDB = Optional.ofNullable(userRepository.findByEmailOrPhoneNumber(userRequest.getEmail(), userRequest.getPhoneNumber()));
        if (userFromDB.isEmpty()) {
            return userRepository.save(userConverter.convertToEntity(userRequest));
        }
        if (userFromDB.get().getEmail().equals(userRequest.getEmail()) && userFromDB.get().getPhoneNumber().equals(userRequest.getPhoneNumber())) {
            throw new СreateInDbException("User with email : " + userFromDB.get().getEmail() + " and phone number : " + userFromDB.get().getPhoneNumber() + " already exists");
        } else if (userFromDB.get().getEmail().equals(userRequest.getEmail())) {
            throw new СreateInDbException("User with email : " + userFromDB.get().getEmail() + " already exists");
        } else {
            throw new СreateInDbException("User with phone number : " + userFromDB.get().getPhoneNumber() + " already exists");
        }
    }

    public User update(UserRequest userRequest, Long id) {
        findById(id);
        User user = userConverter.convertToEntity(userRequest);
        user.setPkey(id);
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User was not found"));
    }

    public User findByPhoneNumber(String phone) {
        return userRepository.findByPhoneNumber(phone).orElseThrow(() -> new EntityNotFoundException("User with phone number : " + phone + " does not exists"));
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
