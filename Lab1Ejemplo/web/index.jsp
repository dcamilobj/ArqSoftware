<%-- 
    Document   : index
    Created on : 19/07/2017, 11:09:25 AM
    Author     : Duban Camilo Bedoya - dcamilobj@gmail.com
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        </script>
    </head>
    <body>
        <div class="container well">
        <h1>Información del estudiante</h1>
        <form action="StudentServlet" method="POST" enctype="multipart/form-data">
            <table>
                <tr>
                    <th>Identificación</th>
                    <th><input type="text" class="form-control" 
                               placeholder="Identificación"
                               required="true" name="studentId"
                               value="${student.id}"/>
                    </th>
                </tr>
                <tr>
                    <th>Nombres</th>
                    <th><input type="text" class="form-control"
                               placeholder="Nombres"
                               name="firstName" value="${student.firstName}"/>
                    </th>
                </tr>
                <tr>
                    <th>Apellidos</th>
                    <th><input type="text" class="form-control"
                               placeholder="Apellidos"
                               name="lastName" value="${student.lastName}"/>
                    </th>
                </tr>
                <tr>
                    <th>Nivel</th>
                    <th><input type="text" class="form-control"
                               placeholder="Nivel"
                               name="level" value="${student.level}"/>
                    </th>
                </tr>
                <tr>
                    <th><label for="photo">Foto</label></th>
                    <th><input type="file" name="photo" id="photo"/></th>
                </tr>
                <tr>
                    <td colspan="2">
                        <input class="btn icon-btn btn-success" type="submit" 
                               name="action" value="Agregar"/>
                        <span class="glyphicon btn-glyphicon glyphicon-plus img-circle text-success"></span>

                        <input class="btn icon-btn btn-info" type="submit" name="action" value="Editar"/>
                        <span class="glyphicon btn-glyphicon glyphicon-share img-circle text-info"></span>

                        <input class="btn icon-btn btn-danger" type="submit" name="action" value="Eliminar"/>
                        <span class="glyphicon btn-glyphicon glyphicon-trash img-circle text-danger"></span>

                        <input class="btn icon-btn btn-primary" type="submit" name="action" value="Buscar"/>
                        <span class="glyphicon btn-glyphicon glyphicon-search img-circle text-primary"></span>
                        
                    </td>
                </tr>
            </table>
        </form>     
        <br>
        <table border="1" class="table table-striped">
            <th scope="row">Identificación</th>
            <th>Nombres</th>
            <th>Apellidos</th>
            <th>Nivel</th>
            <th>Foto</th>
            <c:forEach items="${allStudents}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td>${student.level}</td>
                    <td><img src="${student.getPhotoBase64()}"/></td>
                </tr>
            </c:forEach>
        </table>
        </div>
    </body>
</html>
