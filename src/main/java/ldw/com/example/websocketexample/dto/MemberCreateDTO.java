package ldw.com.example.websocketexample.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberCreateDTO {
    private String username;
    private String password;
    private String role;

    public MemberCreateDTO(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "MemberCreateDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
