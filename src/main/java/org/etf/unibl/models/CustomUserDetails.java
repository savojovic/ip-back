package org.etf.unibl.models;

import org.etf.unibl.models.entities.UserEntity;
import org.etf.unibl.models.enums.Role;
import org.etf.unibl.models.enums.Status;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CustomUserDetails implements UserDetails {
    private final Byte IS_ADMIN = 1;

    private Status status;
    private UserEntity user;
    private Role role;


    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



    public CustomUserDetails(UserEntity user){
        this.user = user;
        if(user.getIsAdmin() == IS_ADMIN){
            role = Role.ADMIN;
        }else{
            role = Role.USER;
        }
        if(Status.PENDING.toString().equals(user.getStatus())){
            status=Status.PENDING;
        }else if(Status.ACTIVE.toString().equals(user.getStatus())){
            status=Status.ACTIVE;
        }else{
            status=Status.BLOCKED;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(status==Status.ACTIVE){
            return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
        }else{
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public String getPassword() {
        return user.getPassHash();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
