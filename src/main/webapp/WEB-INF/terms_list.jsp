<%--
  Created by IntelliJ IDEA.
  User: molod
  Date: 10.04.2024
  Time: 11:52
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
  <title>terms-list</title>
</head>
<body>
<aside class="navigation">
  <a href="#" class="navigation-item">на главную</a>

</aside>

<main class="main">
  <h1 class="main-heading"> система управления студентами и их успеваемостью</h1>
  <div class="choice-semestr1">
    <h2> выбрать семестр       : </h2>
    <select border="1">
      <option class="choice"> семестр1 </option>
      <option class="choice"> семестр2 </option>

    </select>
    <form>
      <input type="button" class="choice-btn" value="выбрать">
    </form>

  </div>
  <br>


  <h2>
    длительность семестра: 24 недели
  </h2>
  <br>
  <h2>
    список дисциплин семестра
  </h2>
  <br>
  <div class="term">
    <table border="1">
      <tr>
        <th> название дисциплин</th>
      </tr>
      <tr>
        <td>высшая математика</td>
      </tr>
    </table>
    <div class="discipline-btns">
      <button>создать семестр</button>
      <button>модифицировать текущий семестр</button>
      <button>удалить текущий семестр</button>
    </div>
    <table>
      <tr>
        <td></td>
      </tr>
    </table>
  </div>



</main>
<aside class="logout">
  <a href="#" class="logout-btn">logout</a>

</aside>

</body>
</html>