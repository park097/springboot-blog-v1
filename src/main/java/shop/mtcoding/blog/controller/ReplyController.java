package shop.mtcoding.blog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.blog.dto.ReplyWriteDTO;
import shop.mtcoding.blog.model.Board;
import shop.mtcoding.blog.model.Reply;
import shop.mtcoding.blog.model.User;
import shop.mtcoding.blog.repository.ReplyRepository;

@Controller
public class ReplyController {

    private static final Integer Id = null;

    @Autowired
    private HttpSession session;

    @Autowired
    private ReplyRepository replyRepository;

    @PostMapping("/reply/save")
    public String save(ReplyWriteDTO replywriteDTO) {
        // comment 유효성 검사
        if (replywriteDTO.getBoardId() == null) {
            return "redirect:/40x";
        }
        if (replywriteDTO.getComment() == null || replywriteDTO.getComment().isEmpty()) {
            return "redirect:/40x";
        }

        // 인증검사

        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            return "redirect:/loginForm";
        }

        // 댓글쓰기
        replyRepository.save(replywriteDTO, sessionUser.getId());

        return "redirect:/board/" + replywriteDTO.getBoardId();
    }

    @PostMapping("/reply/{id}/delete")
    public String delete1(@PathVariable Integer id, Integer boardId) { // 1. PathVariable 값 받기
        // 2.인증검사
        // session에 접근해서 sessionUser 키값을 가져오세요
        // null 이면, 로그인페이지로 보내고
        // null 아니면, 3번을 실행하세요.
        User sessionUser = (User) session.getAttribute("sessionUser");
        if (sessionUser == null) {
            return "redirect:/board"; // 401
            // }
            // //권한검사
            // List<Reply> reply = replyRepository.findByBoardId(id);
            // if ( reply.getId() != sessionUser.getId()) {
            // return "redirect:/40x"; // 403 권한없음
        }

        // 4. 모델에 접근해서 삭제
        // boardRepository.deleteById(id); 호출하세요 -> 리턴을 받지 마세요
        // delete from board_tb where id = :id
        replyRepository.deleteByboardId(id);
        System.out.println("테스트"+boardId);

        return "redirect:/board/" + boardId;

    }
}
