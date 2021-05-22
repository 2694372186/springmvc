
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script>
        function a1(){
            $.post({
              url: "${pageContext.request.contextPath}/a1",
              data: {"username":$("#username").val()},
              success: function (data){
                if(data === 'ok'){
                  alert(data);
                  $("#span").css("color","green");
                  $("#span").html(data);
                }else{
                  $("#span").css("color","red");
                  $("#span").html(data);
                }
              }
            })
        }

        function a2(){
          $.post({
            url: "${pageContext.request.contextPath}/a2",
            data: {"password":$("#password").val()},
            success: function (data){
              if(data === 'ok'){
                $("#span1").css("color","green");
                $("#span1").html(data);
              }else {
                $("#span1").css("color","red");
                $("#span1").html(data);
              }
            }
          })
        }

    </script>
  </head>
  <body>
  <p>用户名:</p> <input type="text" name="username" id="username" onblur="a1()"><span id="span"></span>
  <p>密码:</p> <input type="text" name="password" id="password" onblur="a2()"><span id="span1"></span>
  </body>
</html>
