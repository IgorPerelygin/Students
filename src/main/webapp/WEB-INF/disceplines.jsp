
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
    <title>disciplines</title>
</head>
<body>
<aside class="navigation">
    <a href="../index.jsp" class="navigation-item">на главную</a>

</aside>

<main class="main">
    <h1 class="main-heading"> система управления студентами и их успеваемостью</h1>
    <h2 class="heading-secondary">список дисциплин</h2>

    <div class="container">
        <table class="discipline-table" border="1">
            <tr>
                <th>&nbsp</th>
                <th> название дисциплин</th>
            </tr>
            <tr>
                <td><input type="checkbox" id=""></td>
                <td> высшая математика </td>
            </tr>
            <tr>
                <td><input type="checkbox" id=""></td>
                <td> история науки и техники </td>
            </tr>
            <tr>
                <td><input type="checkbox" id=""></td>
                <td> политология </td>
            </tr>
            <tr>
                <td><input type="checkbox" id=""></td>
                <td> информатика </td>
            </tr>
            <tr>
                <td><input type="checkbox" id=""></td>
                <td> теория алгоритмизации </td>
            </tr>


        </table>
        <div class="discipline-btns">
            <button>создать дисциплину</button>
            <button>модифицировать выбранную дисциплину</button>
            <button>удалить выбранную дисциплину</button>
        </div>
    </div>

</main>
<aside class="logout">
    <a href="#" class="logout-btn">logout</a>

</aside>

</body>
</html>