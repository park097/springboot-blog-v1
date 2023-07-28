package shop.mtcoding.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
     

     //ip주소 부여 :10.5.9.200  ->mtcoding.com   //ip는 컴퓨터까지만 // ip만으론 주고받을 순 없음 (여러개가 돌아가니까 )-->mtcoding.com:8080 포트로 
     //80포트가 아닌 건 다 적어야됨 ,80은 없어도 됨 
     ///localhost (외부로 안빠져나가고 다시 돌아옴/루프백) ,127.0.0.1
     //a태그(하이퍼링크) (달라는 거) , method=get  ( 두개로만 요청할 수 있음)

     //웹은 겟맵핑과 주소와 포트만 있으면 호출 됨 (기존에 뉴하던거)
    @GetMapping({ "/", "/board" }) //얘를 때려야 함 
    public String index() {

        //templates/
        //.mustache
        //그래서 슬래시를 안 붙임 여기서는 
        return "index";   //뷰리조버가 호출 됨   //머스태치는 템플레이츠가 실행됨 //

    }

    
    @GetMapping({ "/board/saveForm" })
    public String saveForm() {
        return "board/saveForm";

    }
    @GetMapping({ "/board/1" })
    public String detail() {
        return "board/detail";

    }
}
