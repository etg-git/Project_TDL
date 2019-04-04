# Eight Day
---
##### spring security 적용하기

~~~ java


.authorizeRequests() //httpserveletrequest기반으로 설정
.antMatchers("/bootstrap/css/**", "/bootstrap/js/**", "/bootstrap/img/**", "/register/**")//요청 패턴을 리스트형식으로 변환
.permitAll()//모든 권한을 허용
.anyRequest()//요청 이외의 리퀘스트 요청을 표현
.authenticated() //인증된 사용자만 사용할수 있도록 요청

.and()
.formLogin() //로그인 요청
.loginPage("/login")
.successForwardUrl("/login") //로그인 성공하면 매핑된 /login으로 이동
.usernameParameter("id") //파라미터값 id
.permitAll() //모든 권한을 허용

.and()
.logout() //로그아웃 요청
.logoutUrl("/logout")
.logoutSuccessUrl("/login") //로그아웃 성공하면 /login이동
.permitAll()

.and()
.csrf().disable(); //문자인코딩필터보다 보안필터를 먼저 실행
~~~
##### 비밀번호 노출방지를 위한 클래스
~~~java
@Bean
   public PasswordEncoder passwordEncoder() {
       return PasswordEncoderFactories.createDelegatingPasswordEncoder();
   }
}
~~~
```loginController, registerController 매핑 통일```


....
