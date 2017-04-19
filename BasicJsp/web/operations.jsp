<%-- 
    Document   : operations
    Created on : Apr 19, 2017, 10:53:28 PM
    Author     : a
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Operations</title>
    </head>
    <body>
        
        <%! 
            public int facto(int num){
                if(num <= 1) return 1;
                return num * facto(num-1);
            }
        %>
        <%!
            public boolean isPrime(int num){
                for(int i = 2; i < Math.sqrt(num); i++){
                    if(num % i == 0) return false;
                }
                return true;
            }
        %>
        <%
            int num = Integer.parseInt(request.getParameter("num"));
            if(request.getParameter("sbt").equals("factorial")){
                out.print("The factorial of the number is: " + facto(num) );
            }else{
              if(isPrime(num)){
                  out.print("The given number is prime");
              }else{
                  out.print("The given number is composite");
              }
            }
        %>
        <h1></h1>
    </body>
</html>
