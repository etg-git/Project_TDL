# Ten Day
---
##### 댓글 만들기

* ```domain Comment.java 생성```
  * ```content, createdDate, modifiedDate 필드 생성```
  * ```todolist와 ManyToOne 관계 생성```

* ```CommentController.java 생성```
  * ```/comment/list/{idx} PostMapping```
  * ```comment ajax 전송```
  * ```@Pathvariable넣어 url 경로에 변수 추가```

* ```list.html 뷰 수정```
  * ```table th reply, td button, input태그 추가```

* ```jquery 메소드 추가```
~~~Jquery
$('.showing2').hide();
   $('.reply').click(function() {
     var replyBtn = $(this).parent().parent().find('.showing2');
        replyBtn.slideToggle("slow"); //서서히 hide and show
    });
~~~
##### hide 일때
![image](/capture/todolist17.png)
---
##### show 일때
![image](/capture/todolist18.png)

~~~JQuery
$('.comment').click(function () {
       var commentBtn = $(this).parent().parent().find('#reply');
       var node = $(this).val() - 1;
       var test = $('.showing2 input').eq(node).val();

       var jsonData = JSON.stringify({
           content : test
       });
       $.ajax({
           url : "/comment/" + $(this).val(),
           type : "POST",
           data : jsonData,
           contentType : "application/json",
           dataType : "json",
           success : function () {
               location.href = "/toDoList/list";
           },
           error : function () {
               alert('댓글x');
           }
       });
   });
~~~

##### comment db값
![image](/capture/todolist19.PNG)
