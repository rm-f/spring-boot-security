INSERT INTO USERS (USER_NO, ENABLED, USER_ID, EMAIL, USER_NAME, PASSWORD, USER_ROLE)
VALUES ((SELECT NEXTVAL('SQ_USERS_USERNO')), TRUE, 'test', 'test@test.com', '개발이', '$2a$10$vOJfuy7UCNg9i8mmru7I2eUg8siQ8EeweQXEiH7K/0oNZHT5NM5Ci',
        'USER');
-- insert into users (enabled, userid, username, password, user_role) values (true, 'test','개발이','test1234','USER');
