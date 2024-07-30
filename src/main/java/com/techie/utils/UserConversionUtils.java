package com.techie.utils;

import com.techie.domain.entities.*;
import com.techie.domain.enums.*;
import com.techie.domain.model.*;

import java.time.format.*;
import java.util.*;
import java.util.stream.*;

public class UserConversionUtils {

    public static UserDisplayView convertToView(UserEntity user) {
        String highestRole = getHighestRole(user);

        return UserDisplayView.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(highestRole)
                .createdAt(formatDateTime(user))
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .profileImage(user.getProfileImageUrl())
                .isSubscribed(user.isSubscribed())
                .build();
    }

    private static String formatDateTime(UserEntity user) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM yyyy HH:mm", Locale.ENGLISH);
        return user.getCreatedAt().format(formatter);
    }

    private static String getHighestRole(UserEntity user) {
        List<UserRoleEnum> roles = user.getRoles().stream()
                .map(RoleEntity::getRole)
                .collect(Collectors.toList());
        UserRoleEnum highestRole = RoleUtil.getHighestRole(roles);
        String highestRoleString = highestRole.name().toLowerCase();
        return highestRoleString.substring(0, 1).toUpperCase() + highestRoleString.substring(1).toLowerCase();
    }

}