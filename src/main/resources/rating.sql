DROP TABLE IF EXISTS RATING;

CREATE TABLE IF NOT EXISTS RATING
(
    rating_id   int      NOT NULL AUTO_INCREMENT COMMENT '별점 id',
    lecture_id  int      NOT NULL COMMENT '강의 id',
    user_id     int      NOT NULL COMMENT '작성자(학생) id',
    rating      float    DEFAULT '0' COMMENT '별점',
    comment     varchar(200)      NOT NULL COMMENT '코멘트',
    created_at  datetime  DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
    updated_at  datetime  DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일',
    PRIMARY KEY (rating_id)
);

INSERT INTO rating (rating_id, lecture_id, user_id, rating, comment, created_at, updated_at)
VALUES (1, 1, 1, 5, 'lecture1-1', now(), now());

INSERT INTO rating (rating_id, lecture_id, user_id, rating, comment, created_at, updated_at)
VALUES (2, 1, 2, 4, 'lecture1-2', now(), now());

INSERT INTO rating (rating_id, lecture_id, user_id, rating, comment, created_at, updated_at)
VALUES (3, 1, 3, 1, 'lecture1-3', now(), now());

INSERT INTO rating (rating_id, lecture_id, user_id, rating, comment, created_at, updated_at)
VALUES (4, 2, 1, 5, 'lecture2-1', now(), now());

INSERT INTO rating (rating_id, lecture_id, user_id, rating, comment, created_at, updated_at)
VALUES (5, 2, 2, 3, 'lecture2-2', now(), now());