package shop.mtcoding.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter//프라이베이트라서 겟터세터해줘야됨
@Table(name = "user_tb")
@Entity// ddl-auto가 create일때 자동으로 만들어줌 
public class User {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;



    @Column(nullable = false, length = 20, unique = true)
    private String username;
    @Column(nullable = false, length = 70)
    private String password;
    @Column(nullable = false, length = 20)
    private String email;
}
    

