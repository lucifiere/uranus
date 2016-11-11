<%--
  Created by IntelliJ IDEA.
  User: XD.Wang
  Date: 2016/11/3
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SQL Generator</title>
    <script src="/static/js/sql/sql.js"></script>
    <script src="/static/js/login/jquery-1.8.2.min.js"></script>
</head>
<body>
<div>
    <label for="tableList">表名：</label><select name="tableList" id="tableList" onchange="getCol()">
    <option>请选择</option>
    <c:forEach var="one" items="${tableName}" varStatus="status">
        <option>${one}</option>
    </c:forEach>
    </select>
        <label for="typeList">类型：</label><select name="typeList" id="typeList">
            <option value="1">select</option>
            <option value="2">update</option>
            <option value="3">delete</option>
            <option value="4">insert</option>
    </select>
    <br>
</div>
<div id="update">
    <table >
        <tr>
            设值：
        </tr>
        <tr id="set">
            <td>
                <label for="colList">列名：</label><select name="colList" id="colList">
                    <option>请选择</option>
                </select>
            </td>
            <td>
                <label>值：
                    <input value="" type="text" >
                </label>
            </td>
            <td>
                <button id="addV" onclick="addV()">添加</button>
            </td>
        </tr>
        <tr>
            条件：
        </tr>
        <tr id="where">
            <td>
                <label for="colList1">列名：</label><select name="colList" id="colList1">
                <option>请选择</option>
            </select>
            </td>
            <td>
                <label>值：
                    <input value="" type="text" >
                </label>
            </td>
            <td>
                <button id="addQ" onclick="addQ()">添加</button>
            </td>
        </tr>
    </table>
</div>
<label for="result">生成结果：</label><br><textarea id="result" style="width: 50%; height: 20%"></textarea>
</body>
</html>
