package dev.przetrwaj.przetrwajapi.user;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

public enum Role {
    USER,
    MODERATOR,
    ADMIN
}
