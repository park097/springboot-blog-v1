package shop.mtcoding.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {
      
    @GetMapping("/exLogin")
     public String exLogin(){
        return "error/exLogin";
     }
   
    
    @GetMapping("/40x")
     public String ex40x(){
      StringBuilder sb = new StringBuilder();
      sb.append("<script>");
      sb.append("alert('잘못된 요청을 하였습니다');");
      sb.append("history.back();");
      sb.append("</script>");

        return sb.toString();
     }
    @GetMapping("/50x")
     public String ex50x(){
        return "error/ex50x";
     }
}
