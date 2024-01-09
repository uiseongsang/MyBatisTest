CREATE TABLE member (
                        user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        username VARCHAR(255) NOT NULL,
                        email VARCHAR(255) NOT NULL,
                        createdAt TIMESTAMP
);

CREATE TABLE board (
                        board_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        title VARCHAR(255) NOT NULL,
                        content VARCHAR(255) NOT NULL,
                        createdAt TIMESTAMP,
                        user_id BIGINT,
                        FOREIGN KEY (user_id) REFERENCES member(user_id)
);
