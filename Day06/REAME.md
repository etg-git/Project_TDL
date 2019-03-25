# Six Day
---
1. ```list.html 로그아웃 버튼 구현```
    * ```user에 null값이면 toDoList/login 리다이렉트```

2. ```controller toDoList/complete mapping```
    * ```@RequestBody map<string, string> user 선언```
    * ```db에 저장된 user id는 현재 id값으로 저장```
    * ```ajax 통신 객체 생성 type:post```
    * ```toDoList/api/login으로 매핑한 클래스에서 아이디와 비밀번호가 db에 저장된 값과 같은지 여부를 판단하고 ajax에서 success된 경우 toDoList/complete에서 현재id값을 저장한 다음 location.href = toDoList/list 경로로 전송```

3. ```login이 안될때 toDoList/list가 아닌 toDoList/login으로 리다이렉트```
    * ```id값이 null인 경우```

4. ```임의로 만든 각 사용자마다 새 리스트 주게끔 구현```
    * ```repository : findByAllOrderByIdxAsc(User user);```

5. ```입력 버튼 생성```
    * ```complete 버튼을 눌릴때, 현재시간과 업데이트버튼 사라지게 구현```

---

##### 뷰 수정
----
![image](/capture/todolist08.png)
---
