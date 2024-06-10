package com.github.artsiomchekh.mapper;

import com.github.artsiomchekh.dto.UserView;
import com.github.artsiomchekh.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserViewMapper {

    public UserView toUserView(User user) {
        UserView userView = new UserView();
        userView.setId(user.getId());
        userView.setUsername(user.getUsername());
        userView.setEmail(user.getEmail());
        userView.setRoles(user.getRoles());
        return userView;
    }
}
