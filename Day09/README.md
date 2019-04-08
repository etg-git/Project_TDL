# Nine Day
---
##### 유효성 검사

* ```UserDTO 도메인 클래스 생성```
  * ```uid upassword uemail 필드 생성```
  * ```@NotBlank적용(null, " ", "" 허용하지 않는 어노테이션)```
  * ```uemail 필드 @email적용(@포함)```
  * ```upassword 필드 @size적용(최소값 8)```
###
* ```RegisterController PostMapping 수정```
  * ```@valid적용, userDTO로 ajax전송```
  * ```모든 error출력 담당하는 BindingResult 매개변수 추가```
###
* ```register.html 수정```
  * ```JQuery blur() 메소드 추가```
* ```id```
  1. ```중복 검사```
  2. ```아이디가 빈칸일때```
~~~html
  success: function () {
                   $('#checkMsg1').html('<span style="color:blue;"> 사용가능한 아이디입니다. </span>')
                   n=1;
               },
               error: function () {
                   $('#checkMsg1').html('<span style="color:red;"> 중복입니다. </span>')
                   n=0;
~~~                   
* ```password```
  1. ```비밀번호가 빈칸일때```
  2. ```비밀번호가 8자 이상(@Size(min=8))```
* ```email```
  1. ```이메일의 형식과 맞지 않을때(RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);)```
  2. ```이메일이 빈칸일때```

#### 스크린샷
```아이디, 비밀번호, 이메일 빈칸일때```
#####
![image](/capture/todolist15.PNG)

```이메일 형식이 맞지 않을때```
#####
![image](/capture/todolist14.PNG)

```아이디가 빈칸일때```
#####
![image](/capture/todolist13.PNG)

```아이디, 비밀번호, 이메일 형식이 다 맞을때```
#####
![image](/capture/todolist16.PNG)

```비밀번호 8자 이상이 아닐때```
#####
![image](/capture/todolist12.PNG)

```회원가입 되었을때 현재의 DB```
#####
![image](/capture/todolist11.PNG)
