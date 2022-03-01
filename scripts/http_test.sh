## 회원 조회
curl -H "Content-Type: application/x-www-form-urlencoded" \
-X GET http://localhost:8080/v1/user/1
## 회원 가입
curl -d "userId=test100&password=test12341234&userName=개발이&email=test@test.com" \
-H "Content-Type: application/x-www-form-urlencoded" \
-X POST http://localhost:8080/v1/user/regist