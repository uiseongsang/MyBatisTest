CREATE TABLE member (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        username VARCHAR(255) NOT NULL,
                        email VARCHAR(255) NOT NULL,
                        createdAt TIMESTAMP
);

CREATE TABLE board (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        title VARCHAR(255) NOT NULL,
                        content VARCHAR(255) NOT NULL,
                        createdAt TIMESTAMP
);
