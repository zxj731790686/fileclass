
<%
	if (session.getAttribute("username") != null) {
		String name = (String) session.getAttribute("username");
		out.println("Welcome " + name);
		out.println("<a href='logout.jsp'>logout</a>");
	} else {
		out.println("please login  <a href='login.jsp'>login</a>");
	}
%>