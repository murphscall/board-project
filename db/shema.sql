-- 1. users 테이블 생성
CREATE TABLE users
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    email       VARCHAR(255) NOT NULL,
    nickname    VARCHAR(50)  NOT NULL,
    picture_url VARCHAR(255),
    provider    VARCHAR(100) NOT NULL,
    provider_id VARCHAR(255) NOT NULL,
    created_at  DATETIME DEFAULT CURRENT_TIMESTAMP(),
    UNIQUE KEY uk_users_provider (provider, provider_id)
);

-- 2. posts 테이블 생성
CREATE TABLE posts
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    title      VARCHAR(255) NOT NULL,
    content    TEXT         NOT NULL,
    view_count bigint   DEFAULT 0,
    user_id    BIGINT       NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP(),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

-- 3. comments 테이블 생성
CREATE TABLE comments
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    post_id    BIGINT NOT NULL,
    user_id    BIGINT NOT NULL,
    content    TEXT   NOT NULL,
    parent_id  BIGINT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP(),
    FOREIGN KEY (post_id) REFERENCES posts (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (parent_id) REFERENCES comments (id) ON DELETE CASCADE
);

-- 4. post_likes 테이블 생성
CREATE TABLE post_likes
(
    id      BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    post_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (post_id) REFERENCES posts (id) ON DELETE CASCADE,
    UNIQUE KEY uk_post_likes (user_id, post_id)
);

-- 5. comment_likes 테이블 생성
CREATE TABLE comment_likes
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    comment_id BIGINT NOT NULL,
    user_id    BIGINT NOT NULL,
    FOREIGN KEY (comment_id) REFERENCES comments (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    UNIQUE KEY uk_comment_likes (user_id, comment_id)
);