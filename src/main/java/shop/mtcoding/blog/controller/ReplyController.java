package shop.mtcoding.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog.dto.ReplyWriteDTO;
import shop.mtcoding.blog.model.User;
import shop.mtcoding.blog.repository.ReplyRepository;

@Controller
public class ReplyController {

    @Autowired
    private HttpSession session;

    @Autowired
    private ReplyRepository replyRepository;

    @PostMapping("/reply/save")
    public String save(ReplyWriteDTO replywriteDTO){
        //comment 유효성 검사
        if (replywriteDTO.getBoardId() == null  ) {
            return "redirect:/40x";
        }
        if (replywriteDTO.getComment() == null || replywriteDTO.getComment().isEmpty()) {
            return "redirect:/40x";
        }



        //인증검사

       User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            return "redirect:/loginForm";
        }


        //댓글쓰기
        replyRepository.save(replywriteDTO, sessionUser.getId());
        
        return "redirect:/board/"+replywriteDTO.getBoardId();
    }
    
}
