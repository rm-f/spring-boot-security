CREATE SEQUENCE SQ_USERS_USERNO START WITH 1 INCREMENT BY 1;
CREATE TABLE USERS
(
    USER_NO       BIGINT       NOT NULL,
    ENABLED  BOOLEAN      NOT NULL,
    USER_ID       VARCHAR(255) NOT NULL,
    USER_NAME     VARCHAR(64) NOT NULL,
    EMAIL       VARCHAR(255) NOT NULL,
    PASSWORD VARCHAR(72),
    USER_ROLE     VARCHAR(12) DEFAULT USER,
    PRIMARY KEY (USER_NO)
);
ALTER TABLE USERS
    ADD CONSTRAINT IDX_USERS_USERID UNIQUE (USER_ID);