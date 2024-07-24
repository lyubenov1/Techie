package com.techie.utils;

import com.techie.domain.enums.*;

import java.util.*;

public class RoleUtil {
    private static final List<UserRoleEnum> roleHierarchy = Arrays.asList(
            UserRoleEnum.ADMIN,
            UserRoleEnum.MODERATOR,
            UserRoleEnum.USER
    );

    public static UserRoleEnum getHighestRole(List<UserRoleEnum> roles) {
        return roles.stream().min(Comparator.comparingInt(roleHierarchy::indexOf))
                .orElse(UserRoleEnum.USER); // Default to USER if no roles found
    }
}