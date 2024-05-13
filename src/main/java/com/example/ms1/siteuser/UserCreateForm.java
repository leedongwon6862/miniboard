package com.example.ms1.siteuser;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserCreateForm {

    @NotEmpty(message = "아이디를 입력해주세요")
    private String loginId;

    @NotEmpty(message = "비밀번호를 입력해주세요")
    private String password;

    @Email(message = "이메일 형식을 지켜주세요")
    @NotEmpty(message = "이메일를 입력해주세요")
    private String email;

    @NotEmpty(message = "닉네임를 입력해주세요")
    private String nickname;
}
