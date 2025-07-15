package com.tien.ss05.controller;

import com.tien.ss05.model.dto.response.DataResponse;
import com.tien.ss05.model.entity.Student;
import com.tien.ss05.model.entity.User;
import com.tien.ss05.repository.StudentRepository;
import com.tien.ss05.service.StudentService;
import com.tien.ss05.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<DataResponse<List<User>>> getAllUsers(){
        return new ResponseEntity<>(new DataResponse<>(userService.getAllUsers(), HttpStatus.OK), HttpStatus.OK);
    }

//    @GetMapping("{id}")
//    public ResponseEntity<DataResponse<User>> getAllUsersById(@PathVariable("id") Long id) {
//        return new ResponseEntity<>(new DataResponse<>(userService.getUserById(id), HttpStatus.OK), HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<DataResponse<User>> addUser(@RequestBody User user) {
        return new ResponseEntity<>(new DataResponse<>(userService.createUser(user), HttpStatus.CREATED), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<DataResponse<User>> updateUser(@PathVariable Long id, @RequestBody User user) {
        return new ResponseEntity<>(new DataResponse<>(userService.updateUser(user, id), HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<DataResponse<String>> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(new DataResponse<>("Xoa thanh cong",HttpStatus.NO_CONTENT),HttpStatus.NO_CONTENT);
    }
}
