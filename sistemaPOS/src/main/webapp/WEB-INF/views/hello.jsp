<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${model.ahora}"/></p>
    <c:forEach items="${model.productos}" var="prod">
      <c:out value="${prod.descripcion}"/> <i>$<c:out value="${prod.precio}"/></i><br><br>
    </c:forEach>
  </body>
</html>