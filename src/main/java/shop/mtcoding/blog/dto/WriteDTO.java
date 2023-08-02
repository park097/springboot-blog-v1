package shop.mtcoding.blog.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *  회원가입 API
 * 1,URL :http://localhost:8080/board/save
 * 2,method :POST
 * 3,요청 body :title=값(string)content=값(string)
 * 4, MINE타입 : x-www-form-unlencoded
 * 5,응답: view(html)를 응답함. INDEX 페이지
 * 
 */




@Getter
@Setter
public class WriteDTO {
    private String title;
    private String content;
    
    
}
