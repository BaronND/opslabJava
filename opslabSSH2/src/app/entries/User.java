package app.entries;

import lombok.Getter;
import lombok.Setter;


public class User {

    @Getter @Setter private Integer id;

    @Getter @Setter private String username;

    @Getter @Setter private String nickname;

    @Getter @Setter private String email;

    @Getter @Setter private String password;

    @Getter @Setter private String sex;

    @Getter @Setter private String createTime;

    @Getter @Setter private String status;

}
