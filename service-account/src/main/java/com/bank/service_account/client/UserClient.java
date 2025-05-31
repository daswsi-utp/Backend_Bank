package com.bank.service_account.client;

import com.bank.service_account.dto.UserDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class UserClient {

    private final RestTemplate restTemplate;
    private final String userServiceUrl;

    public UserClient(RestTemplate restTemplate,
                      @Value("${services.user.url}") String userServiceUrl) {
        this.restTemplate = restTemplate;
        this.userServiceUrl = userServiceUrl;
    }

    public Optional<UserDTO> getUserById(Long id) {
        try {
            String url = userServiceUrl + "/api/users/" + id;
            UserDTO user = restTemplate.getForObject(url, UserDTO.class);
            return Optional.ofNullable(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
