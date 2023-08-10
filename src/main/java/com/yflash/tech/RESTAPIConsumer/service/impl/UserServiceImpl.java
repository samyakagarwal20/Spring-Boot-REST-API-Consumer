package com.yflash.tech.RESTAPIConsumer.service.impl;

import com.yflash.tech.RESTAPIConsumer.model.out.User;
import com.yflash.tech.RESTAPIConsumer.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final Environment environment;
    private final RestTemplate restTemplate;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(Environment environment, RestTemplate restTemplate, ModelMapper modelMapper) {
        this.environment = environment;
        this.restTemplate = restTemplate;
        this.modelMapper = modelMapper;
    }

    private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

    @Override
    public List<User> getAllUsers() {
        List<User> result = null;
        try {
            String wsUrl = environment.getProperty("producer.api.url");
            /**
             * We can pass in the query parameters by creating a MultiValueMap<String,String>
             */
            MultiValueMap<String,String> queryParams = new LinkedMultiValueMap<>();
            queryParams.add("id","2");

            LOGGER.info("Fetching users data ...");
            ResponseEntity<List> response = restTemplate.getForEntity(wsUrl, List.class, queryParams);

            if (response.getStatusCode().is2xxSuccessful()) {
                result = response.getBody();
                LOGGER.info("Data fetched successfully !");
            }
        } catch (Exception e) {
            LOGGER.error("Error in getAllUsers() : {}", e.getMessage());
        }
        return result;
    }

}
