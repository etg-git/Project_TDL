package com.taegyun.tdl.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import sun.plugin2.message.Message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class UserDTO implements Serializable {

    @NotBlank(message = "id를 입력하세요")
    private String uid;

    @NotBlank(message = "pwd를 입력하세요")
    @Size(min = 8)
    private String upassword;

    @NotBlank(message = "이메일을 입력하세요")
    @Email(message = "이메일의 형식을 입력하세요")
    private String uemail;


    public User dto() {
        User user = new User();
        user.setId(this.uid);
        user.setPassword(this.upassword);
        user.setEmail(this.uemail);

        return user;
    }
//    public String  getUid() {
//        return uid;
//    }

//    public String getUpassword() {
//        return upassword;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setUid(String uid) {
//        this.uid = uid;
//    }
//
//    public void setUpwd(String upassword) {
//        this.upassword = upassword;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
}
