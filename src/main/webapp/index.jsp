<html>
<body>
<h2>Hola Ardillas!</h2>
<p>Se ha generado un servlet en:</p>
<p>
<code><%=page.getClass().getProtectionDomain().getCodeSource().getLocation().toURI().getPath() %></code>
<code><%= request.getMethod()%></code><br>
<code><%= request.getRequestURL()%></code>
</p>
</body>
</html>
