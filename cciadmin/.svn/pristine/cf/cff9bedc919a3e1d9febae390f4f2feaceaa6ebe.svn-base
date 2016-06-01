<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/checklogin.jsp"></jsp:include>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>基站详细信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="js/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="js/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/locale/easyui-lang-zh_CN.js"></script>

 <base target="_self">
  </head>
  <font color="red"> <s:fielderror></s:fielderror> </font>
  <body>
  
  <div class="easyui-panel" title="基站详细信息" style="width:600px;padding:30px 60px">
  
  <form name="baseStation" id="baseStation" method="post" action="">
    <table width="100%" cellspacing="1" bgcolor="#CCCCCC">

	  	<tr>
        <td align="right" bgcolor="#FFFFFF">所属组织</td>
        <td colspan="3" align="left" bgcolor="#FFFFFF">
		<s:property value="baseStation.group_name" />		</td>
      </tr>
      <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">基站名称</td>
        <td width="25%" bgcolor="#FFFFFF">
		<s:property value="baseStation.basestation_name" />		</td>
        <td width="25%" align="right" bgcolor="#FFFFFF">部门</td>
        <td width="25%" bgcolor="#FFFFFF">
		<s:property value="baseStation.department" />		</td>
      </tr>

      <tr>
        <td align="right" bgcolor="#FFFFFF">经度</td>
        <td align="left" bgcolor="#FFFFFF">
		<s:property value="baseStation.lng" />		</td>
        <td align="right" bgcolor="#FFFFFF">纬度</td>
        <td align="left" bgcolor="#FFFFFF">	
		<s:property value="baseStation.lat" />		</td>
      </tr>
      <tr>
        <td align="right" bgcolor="#FFFFFF">地址</td>
        <td align="left" bgcolor="#FFFFFF">
        <s:property value="baseStation.address" />		</td>
        <td align="right" bgcolor="#FFFFFF">备注</td>
        <td align="left" bgcolor="#FFFFFF">
		<s:property value="baseStation.demo" />		</td>
      </tr>
    </table>
  
  </form>

  </div>

  </body>
</html>

