package com.example.course_app_graphql.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.course_app_graphql.entity.User;
import com.example.course_app_graphql.input.UserFilter;
import com.example.course_app_graphql.input.UserInput;
import com.example.course_app_graphql.repository.UserRepository;
import com.example.course_app_graphql.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers(UserFilter filter) {

        if (filter != null) {
            filter.print();
        }
        Sort sort = Sort.unsorted();
        if (!filter.getSortBy().equals("")) {
            Sort.Direction direction = filter.sortOrder == 1 ? Sort.Direction.ASC
                    : filter.sortOrder == -1 ? Sort.Direction.DESC : null;
            sort = direction == null ? Sort.unsorted() : Sort.by(direction, filter.sortBy);
        }

        Pageable pageable = PageRequest.of(filter.getPage() - 1, filter.getLimit(), sort);
        return userRepository.findAll(pageable).getContent();
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(UserInput userInput) {

        User user = User.builder()
                .name(userInput.getName())
                .dob(userInput.getDob())
                .phone(userInput.getPhone())
                .email(userInput.getEmail())
                .roleType(0)
                .username(userInput.getUsername())
                .password(userInput.getPassword()).build();
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String id, UserInput userInput) {

        User userFromDB = userRepository.findById(id).orElse(null);

        if (userFromDB != null) {

            if (userInput.getName() != null) {
                userFromDB.setName(userInput.getName());
            }

            if (userInput.getPhone() != 0) {
                userFromDB.setPhone(userInput.getPhone());
            }

            if (userInput.getEmail() != null) {
                userFromDB.setEmail(userInput.getEmail());
            }
            if (userInput.getUsername() != null) {
                userFromDB.setUsername(userInput.getUsername());
            }
        }
        User updatedUser = userRepository.save(userFromDB);
        return updatedUser;
    }

    @Override
    public String deleteUser(String id) {
        User userFromDB = userRepository.findById(id).orElse(null);
        if (userFromDB != null) {
            userRepository.deleteById(id);
            return "User deleted successfully.";
        }
        return "User not deleted.";
    }

}
