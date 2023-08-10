package com.yflash.tech.RESTAPIConsumer.controller;

import com.yflash.tech.RESTAPIConsumer.model.out.User;
import com.yflash.tech.RESTAPIConsumer.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class UserController {

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping(value = "/get-all-users", produces = "application/json")
    ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

}
