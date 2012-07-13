<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<% 
com.hp.webconsole.SyncData sd = com.hp.webconsole.SyncData.getInstance("test");
java.util.Random r = new java.util.Random();
for (int i = 0 ; i < 20 ; i++) {
	sd.putData(r.nextInt() + " = " + System.nanoTime());
}
%>