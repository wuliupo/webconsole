<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<% 
com.hp.webconsole.SyncData sd = com.hp.webconsole.SyncData.getInstance("test");
for (int i = 0 ; i < 20 ; i++) {
	sd.putData(i + " = " + System.currentTimeMillis());
}

response.sendRedirect("./WebConsole?job=test");
%>