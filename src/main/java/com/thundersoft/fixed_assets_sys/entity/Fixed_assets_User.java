package com.thundersoft.fixed_assets_sys.entity;
import com.thundersoft.fixed_assets_sys.vo.LoginUserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Fixed_assets_User {
    private int uid;
    private String u_username;
    private String u_password;

    LoginUserInfo to(){
        return LoginUserInfo.builder().
                username(this.u_username).password(this.u_password).build();
    }
}
