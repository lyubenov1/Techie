package com.techie.utils;

import com.techie.domain.entities.*;
import com.techie.domain.model.*;

public class UserConversionUtils {

    public static UserDisplayView convertToView(UserEntity user) {
        return UserDisplayView.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .profileImage(user.getProfileImageUrl())
                .build();
    }

}