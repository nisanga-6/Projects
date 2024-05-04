package com.example.regLoginDemo.appUser;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
@Data
@NoArgsConstructor
@Document("app_user")
public class AppUser implements UserDetails {

    @Id
    @Field("id")
    private Long id;

    @Field("name")
    private String name;

    @Field("username")
    private String username;

    @Field("email")
    private String email;

    @Field("password")
    private String password;

    @Field("appUserRole")
    private AppUserRole appUserRole;

    @Field("locked")
    private Boolean locked;

    @Field("enabled")
    private Boolean enabled;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public AppUser( String name, String username, String email, String password, AppUserRole appUserRole, Boolean locked, Boolean enabled) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        this.locked = locked;
        this.enabled = enabled;
    }
}
