<%--
  Created by IntelliJ IDEA.
  User: molod
  Date: 10.04.2024
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Kelly+Slab&display=swap" rel="stylesheet">
  <title>discipline-modifying</title>
</head>
<body>
<aside class="navigation">
  <a href="#" class="navigation-item">на главную</a>
  <a href="#" class="navigation-item">назад</a>

</aside>

<main class="main">
  <h1 class="main-heading"> система управления студентами и их успеваемостью</h1>
  <h3 class="heading-secondary">для того, что бы модифицировать дисциплину введите новое значение поля и нажмите кнопку "применить":</h3>
  <form >
    <div class="name-window">
      <label for="name"> <h3>название:</h3></label>
      <input type="text" id="name">
    </div>

    <br>

    <input type="button" value=" применить" class="field">
  </form>





</main>
<aside class="logout">
  <a href="#" class="logout-btn">logout</a>

</aside>

</body>
</html>