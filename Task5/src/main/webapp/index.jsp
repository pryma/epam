<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Index Page</title>
</head>
<body>
<form action="controller" method="post">
    <input type="hidden" name="command" value="dom_parse"/>
    <input type="hidden" name="nameXmlFIle" value="D:\\bank.xml"/>
    <input type="submit" value="DOM"/><br/>
</form>
<form action="controller" method="post">
    <input type="hidden" name="command" value="sax_parse"/>
    <input type="hidden" name="nameXmlFIle" value="D:\\bank.xml"/>
    <input type="submit" value="SAX"/><br/>
</form>
<form action="controller" method="post">
    <input type="hidden" name="command" value="stax_parse"/>
    <input type="hidden" name="nameXmlFIle" value="D:\\bank.xml"/>
    <input type="submit" value="STAX"/><br/>
</form>
</body>
</html>
