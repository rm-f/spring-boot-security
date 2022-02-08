INSERT INTO USERS (USER_NO, ENABLED, USER_ID, EMAIL, USER_NAME, PASSWORD, USER_ROLE)
VALUES ((SELECT NEXTVAL('SQ_USERS_USERNO')), TRUE, 'test', 'test@test.com', '개발이', 'TEST1234',
        'USER');
-- insert into users (enabled, userid, username, password, user_role) values (true, 'test','개발이','test1234','USER');
