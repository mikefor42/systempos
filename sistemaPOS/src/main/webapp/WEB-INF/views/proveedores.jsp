<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    Clientes
    <c:forEach items="${clientes}" var="cliente">
      <c:out value="${cliente.nombre}"/> <br><br>
    </c:forEach>
  </body>
</html>