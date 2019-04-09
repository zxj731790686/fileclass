<form action="login.jsp" method="post">
	username
	<input type="text" name="username">
	<p>

		password
		<input type="password" name="password">
		<p>
			<input type="submit" value="Login" />
</form>

<%
	String name = request.getParameter("username");
	String pass = request.getParameter("password");
	if (name == null || pass == null) {
	} else {
		if (name.equals("tom") && pass.equals("123456")
				|| name.equals("admin") && pass.equals("admin")) {
			session.setAttribute("username", name);
			response.sendRedirect("user.jsp");
		}
	}
%>