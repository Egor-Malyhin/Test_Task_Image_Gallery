package org.mycorp.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
@Access(AccessType.PROPERTY)
public class User extends BaseEntity implements UserDetails {
    private String username;
    private String password;
    private String role;
    private List<Image> imageList;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.imageList = new ArrayList<>();
    }

    @Column(name = "login")
    public String getUsername() {
        return username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    public List<Image> getImageList() {
        return imageList;
    }

    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return true;
    }
}
