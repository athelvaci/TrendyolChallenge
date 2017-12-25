<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>

    <title>Configuration Page</title>
    
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
        
       
        
    </style>
</head>
<body>


<h1>
    Add a Configuration
</h1>

<c:url var="addAction" value="/configuration/add" ></c:url>

<form:form action="${addAction}" commandName="configuration">
    <table>
        <c:if test="${!empty configuration.name}">
           
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                
                <td>
                    <form:input path="id" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="id" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="type">
                    <spring:message text="Type"/>
                </form:label>
            </td>
            <td>
                <form:input path="type" />
            </td>
        </tr>
         <tr>
            <td>
                <form:label path="value">
                    <spring:message text="Value"/>
                </form:label>
            </td>
            <td>
                <form:input path="value" />
            </td>
        </tr>
         <tr>
            <td>
                <form:label path="isactive">
                    <spring:message text="IsActive"/>
                </form:label>
            </td>
            <td>
                <form:input path="isactive" />
            </td>
        </tr>
         <tr>
            <td>
                <form:label path="applicationname">
                    <spring:message text="ApplicationName"/>
                </form:label>
            </td>
            <td>
                <form:input path="applicationname" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty configuration.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Configuration"/>" />
                </c:if>
                <c:if test="${empty configuration.name}">
                    <input type="submit"
                           value="<spring:message text="Add Configuration"/>" />
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
<br>

<h3>Configurations List</h3>
<c:if test="${!empty listConfigurations}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Type</th>
            <th width="120">Value</th>
            <th width="120">IsActive</th>
            <th width="120">ApplicationName</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listConfigurations}" var="configuration">
            <tr>
                <td>${configuration.id}</td>
                <td>${configuration.name}</td>
                <td>${configuration.type}</td>
                 <td>${configuration.value}</td>
                  <td>${configuration.isactive}</td>
                   <td>${configuration.applicationname}</td>
                <td><a href="<c:url value='/edit/${configuration.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/remove/${configuration.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
