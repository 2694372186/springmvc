
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script>
      function a(){
      $.get({
        url:"${pageContext.request.contextPath}/a1",
        date:{"name":$("#username").val()},
        success: function (data){
          alert(data);
        }
      })
      }
    </script>
  </head>
  <body>
  用户名:  <input type="text" name="username" onblur="a()">
  </body>
</html>
