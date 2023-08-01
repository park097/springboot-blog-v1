package shop.mtcoding.blog.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *  회원가입 API
 * 1,URL :http://localhost:8080/join
 * 2,method :POST(로그인은 SELECT이지만 ,POST로 한다)
 * 3,요청 body :username=값(string)&password=값(string)
 * 4, MINE타입 : x-www-form-unlencoded
 * 5,응답: view(html)를 응답함. INDEX 페이지
 * 
 */


@Getter@Setter
public class LoginDTO {

    private String username;
    private String password;
    
}


