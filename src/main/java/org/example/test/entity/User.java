package org.example.test.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.test.common.Timestamped;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class User extends Timestamped {
    //컬럼 - 연관관계 컬럼을 제외한 컬럼을 정의합니다.
    private Long user_id;
    private String username;
    private String email;

    // 생성자 - 약속된 형태로만 생성가능하도록 합니다.
    @Builder
    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // 연관관계
    private List<Board> boardList = new ArrayList<>();

    // 연관관계 편의 메소드 - 반대쪽에는 연관관계 편의 메소드가 없도록 주의합니다.

    // 서비스 메소드 - 외부에서 엔티티를 수정할 메소드를 정의합니다. (단일 책임을 가지도록 주의합니다.)
}
