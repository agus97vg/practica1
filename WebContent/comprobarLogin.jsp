<%

HttpSession MYsesion=request.getSession();
String nombre=(String)MYsesion.getAttribute("correo");
if(nombre==null)
{
response.sendRedirect("index.jsp");
}

%>