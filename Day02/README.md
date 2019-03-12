# Two Day
---
#### 한 것들
* ```class 생성```
    * ```ToDoListRepository 생성```
    * ```ToDoListService 생성```
    * ```ToDoListController 생성```
    * ```application.test 생성```
###    
* ```To Do List html만들기```
####
* ```Boot Strap 적용하기```
####
* ```MySQL연결 및 Schema(tdl_db), User(spring_boot) 생성```
####
* ```TimeZone 설정 : url: jdbc:mysql://127.0.0.1:3306/tdl_db?serverTimezone=Asia/Seoul```
---
#### list.html
~~~html
<!DOCTYPE html>

>> http://localhost:8080/toDoList/list

<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>  //bootstrap
    <title>ToDoList</title>//bootstrap
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>//bootstrap
    <link rel="stylesheet" th:href="@{/css/base.css}" />//bootstrap
    <link rel="stylesheet" th:href="@{/css/bootstrap.min.css}" /> //bootstrap
</head>
<body>
<!--<div th:replace="layout/header::header"></div>-->

<div class="container">
    <div class="page-header">
        <h1>Hello To Do List</h1>
        <h2>리스트 목록</h2>
    </div>
    <br/><br/><br/>
    <div id="mainHide">
        <table class="table table-striped"> << bootstrap
            <tr>
                <th class="col-md-1">#</th>
                <th class="col-md-2">완료 여부</th>
                <th class="col-md-5">내용</th>
                <th class="col-md-2">생성 날짜</th>
                <th class="col-md-2">완료 날짜</th>
            </tr>
            </thead>
            <tbody>
            <tr th:each="toDoList : ${toDoListList}">
                <td th:text="${toDoList.idx}"></td>
                <td th:text="${toDoList.status}"></td>
                <td th:text="${toDoList.description}"></td>
                <td th:text="${toDoList.createdDate} ? ${#temporals.format(toDoList.createdDate,'yyyy-MM-dd HH:mm')} : ${toDoList.createdDate}"></td>
                <td th:text="${toDoList.completedDate} ? ${#temporals.format(toDoList.completedDate,'yyyy-MM-dd HH:mm')} : ${toDoList.completedDate}"></td>
            </tr>
            </tbody>
        </table>
    </div>
    <br/>

</div>

<!--<div th:replace="layout/footer::footer"></div>-->
</body>
</html>
~~~
###
---

![image](/capture/todolist01.PNG)


---
#### 집에서 보충한것들
* ```웹 디자인 바꾸기```

#### list.html
~~~html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>ToDoList</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" th:href="@{/css/base.css}" />
    <link rel="stylesheet" th:href="@{/css/bootstrap.min.css}" />
</head>
<style>
    table, th, td {
        border : 1px solid deepskyblue;
        text-align : center;
    }
    th{
        background-color: #337ab7;
        color : white;
    }
    table tr:nth-child(even) {
        background-color: #9acfea;
    }
    table tr:nth-child(odd) {
        background-color: #c7ddef;
    }
    h1 {
        background-color: aqua;
        text-align : center;
    }

</style>
<body  style="font-family:verdana;">
<!--<div th:replace="layout/header::header"></div>-->

<div class="container">
    <div class="page-header">
        <h1><b>To Do List</b></h1>
    </div>
    <br/><br/><br/>
    <div id="mainHide">

        <table class="table table-striped">
            <tr>
                <th class="col-md-1">#</th>
                <th class="col-md-1">Status</th>
                <th class="col-md-4">Content</th>
                <th class="col-md-2">Create</th>
                <th class="col-md-2">Complete</th>
                <th class="col-md-4">Operaiton</th>

            </tr>
            </thead>
            <tbody>
            <tr th:each="toDoList : ${toDoList}">
                <td th:text="${toDoList.idx}"></td>
                <td th:text="${toDoList.status}"></td>
                <td th:text="${toDoList.description}"></td>
                <td th:text="${toDoList.createdDate} ? ${#temporals.format(toDoList.createdDate,'yyyy-MM-dd HH:mm')} : ${toDoList.createdDate}"></td>
                <td th:text="${toDoList.completedDate} ? ${#temporals.format(toDoList.completedDate,'yyyy-MM-dd HH:mm')} : ${toDoList.completedDate}"></td>
                <td><button class="btn btn-primary">Edit</button> <button class="btn btn-danger">Delete</button> </td>

            </tr>
            </tbody>
        </table>
    </div>
    <br/>

</div>


<!--<div th:replace="layout/footer::footer"></div>-->
</body>
</html>
~~~
---
![image](/capture/todolist02.PNG)
