<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/3 0003
  Time: 下午 4:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>
    <meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <%@include file="../../common2.jsp"%>
    <link rel="stylesheet" type="text/css" href="${commonPath }/resource1/resource/css/style.css" />
    <link rel="stylesheet" type="text/css" href="${commonPath }/resource1/resource/css/WdatePicker.css" />
    <link rel="stylesheet" type="text/css" href="${commonPath }/resource1/resource/css/skin_/table.css" />
    <link rel="stylesheet" type="text/css" href="${commonPath }/resource1/resource/css/jquery.grid.css" />
    <link rel="stylesheet" type="text/css" href="${commonPath }/resource1/resource/css/listInfo.css" />
</head>
<body>
<div id="container">
    <div id="hd"></div>
    <div id="bd">
        <div id="main">
            <div class="search-box ue-clear">
                <div class="search-area">
                    <div class="kv-item ue-clear">
                        <label style="font-size: 14px"><span class="search_label">信息检索</span></label>
                        <div class="kv-item-content">
                            <input type="text" placeholder="输入关键信息" id="allSearchInfo">

                            <div class="kv-item-content">

                                <div class="kv-item-content">
                                    <select id="searchLevel">
                                        <option value="">全部</option>
                                        <c:forEach items="${BACKSTAGE_CITY_ALL}" var="mlevel">
                                            <option value="${mlevel.key}" ${EDIT_MENBER_INFO.menberLevel==mlevel.key?'selected':'' }>${mlevel.value}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="search-button">
                    <input class="button" type="button" id="searchButton" value="查询" />
                </div>
            </div>

            <div class="table">
                <div class="opt ue-clear">
                	<span class="sortarea">
                    	<span class="sort">
                        	<label>排序：</label>
                            <span class="name">
                            	<i class="icon"></i>
                                <span class="text">名称</span>
                            </span>
                        </span>

                        <i class="list" onclick="refreshTable()"></i>
                        <i class="card"></i>
                    </span>
                    <span class="optarea">


                        <a href="javascript:setRoles();" class="config">
                            <i class="icon"></i>
                            <span class="text">角色设置</span>
                        </a>

                    </span>
                </div>

                <div class="grid"></div>

                <div class="pagination"></div>

                <input type="hidden" id="refresh_condition" value="">
                <input type="hidden" id="pageNo" value="0">
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${commonPath }/resource1/resource/js/jquery.js"></script>
<script type="text/javascript" src="${commonPath }/resource1/resource/js/global.js"></script>
<script type="text/javascript" src="${commonPath }/resource1/resource/js/jquery.select.js"></script>
<script type="text/javascript" src="${commonPath }/resource1/resource/js/core.js"></script>
<script type="text/javascript" src="${commonPath }/resource1/resource/js/jquery.pagination.js"></script>
<script type="text/javascript" src="${commonPath }/resource1/resource/js/jquery.grid.js"></script>
<script type="text/javascript" src="${commonPath }/resource1/resource/js/WdatePicker.js"></script>
<script type="text/javascript" src="${commonPath }/resource1/resource/js/dateAndIPFormat.js?version=${commonVersion}"></script>
<script type="text/javascript" src="${commonPath }/resource1/resource/js/employee/employeeList.js?version=${commonVersion}"></script>
</html>
