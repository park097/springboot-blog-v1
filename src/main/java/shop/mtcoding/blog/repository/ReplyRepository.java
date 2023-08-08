package shop.mtcoding.blog.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blog.dto.ReplyWriteDTO;
import shop.mtcoding.blog.dto.UpdateDTO;



@Repository
public class ReplyRepository {

    @Autowired
    private EntityManager em;

    @Transactional
    public void save(ReplyWriteDTO replyWriteDTO, Integer userId) {
        Query query = em
                .createNativeQuery(
                        "insert into reply_tb(comment, board_id, user_id) values(:comment,:boardId,:userId)");

        query.setParameter("boardId", replyWriteDTO.getBoardId());
        query.setParameter("userId", userId);
        query.setParameter("comment", replyWriteDTO.getComment());
        
      
        query.executeUpdate();
    }

      @Transactional
    public void deleteById(Integer id) {
        Query query = em.createNativeQuery("delete from board_tb where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional // 이게 끝나면 자동으로 커밋을 해주고 실패하면 롤백해줌
    public void update(ReplyWriteDTO replyWriteDTO, Integer id) {
        Query query = em.createNativeQuery("update replt_tb set comment = :comment where id = :id");
        query.setParameter("commnet", replyWriteDTO.getComment());
        query.setParameter("id", id);
    
        query.executeUpdate();
    }


    
}
