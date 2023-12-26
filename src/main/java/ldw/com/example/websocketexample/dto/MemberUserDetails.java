package ldw.com.example.websocketexample.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MemberUserDetails implements UserDetails {
    private final String username;
    private final String password;
    Collection<? extends GrantedAuthority> authorities;

    public MemberUserDetails(String username, String password, String role) {
        this.username = username;
        this.password = password;
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(authority);
;       this.authorities = authorityList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
