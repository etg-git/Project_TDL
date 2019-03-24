# Five Day
---
* ```User.java 클래스 생성```
  * ```User와 ToDoList OneToOne(단방향) 연결```
* ```login.html 생성```
  * ```tpye:POST인 ajax통신 객체 생성```
  * ```회원가입 성공했을때, 로그인화면으로 redirect```
  * ```user 값 넣기```
* ```register.html 생성```
  * ```tpye:POST인 ajax통신 객체 생성```
  * ```로그인 성공했을때, 리스트로 redirect```
  * ```db저장된 값과 다를경우 null값으로 출력```
* ```LoginController.java, RegisterController.java 생성```
  * ```postmapping("/api/register") 매핑```
  * ```postmapping("/api/login")매핑```
    1. ```비밀번호가 다른경우```

    2. ```아이디가 없는경우```
    3. ```아이디와 비밀번호가 db에 저장된 값과 일치할경우```
---
##### 로그인화면
![image](/capture/todolist06.PNG)
---
##### 회원가입화면
![image](/capture/todolist07.PNG)
