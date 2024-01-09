package org.example.test.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@NoArgsConstructor
public class Board {
    /**
     * 컬럼 - 연관관계 컬럼을 제외한 컬럼을 정의합니다.
     */
    private Long board_id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Long user_id;

    /**
     * 생성자 - 약속된 형태로만 생성가능하도록 합니다.
     */
    @Builder
    public Board(String title, String content, Long user_id) {
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.createdAt = LocalDateTime.now();
    }

    /**
     * 연관관계 - Foreign Key 값을 따로 컬럼으로 정의하지 않고 연관 관계로 정의합니다.
     */
    private User user;

    /**
     * 연관관계 편의 메소드 - 반대쪽에는 연관관계 편의 메소드가 없도록 주의합니다.
     */
    // TODO
    // 다쪽에서 편의 메소드가 있어야 한다
    public void addBoardList(User user) {
        this.user = user;
        user.getBoardList().add(this);
    }

    /**
     * 서비스 메소드 - 외부에서 엔티티를 수정할 메소드를 정의합니다. (단일 책임을 가지도록 주의합니다.)
     */
}
