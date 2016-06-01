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
    
    <title>控制器管理</title>
    
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
  
  <div class="easyui-panel" title="基站控制器信息" style="width:600px;padding:30px 60px">
  
  
  <form name="station" id="station" method="post" action="">
    <table width="100%" cellspacing="1" bgcolor="#CCCCCC">

      <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">控制器名称</td>
        <td width="25%" bgcolor="#FFFFFF">
		<s:property value="station.station_name" />
		</td>
        <td width="25%" align="right" bgcolor="#FFFFFF">控制器代码</td>
        <td width="25%" bgcolor="#FFFFFF">
			<s:property value="station.station_code" />
		</td>
      </tr>
      <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">类型</td>
        <td width="25%" bgcolor="#FFFFFF">
					<s:if test="station.station_type==1">TB8100</s:if>
					<s:if test="station.station_type==2">JRC</s:if>
					<s:if test="station.station_type==3">MX800</s:if>
					<s:if test="station.station_type==4">AIS_JRC</s:if>
					<s:if test="station.station_type==5">GJ712</s:if>
					<s:if test="station.station_type==6">天奥</s:if>
		</td>
        <td width="25%" align="right" bgcolor="#FFFFFF">IP</td>
        <td width="25%" bgcolor="#FFFFFF">
		<s:property value="station.IP" />
		</td>
      </tr>
      <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">所属基站</td>
        <td width="25%" bgcolor="#FFFFFF">
		<s:property value="station.basestation_name" />
		</td>
        <td width="25%" align="right" bgcolor="#FFFFFF">备注</td>
        <td width="25%" bgcolor="#FFFFFF">
		<s:property value="station.demo" />
		</td>
      </tr>
	        <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">服务IP</td>
        <td width="25%" bgcolor="#FFFFFF">
		<s:property value="station.server_ip" />
		</td>
        <td width="25%" align="right" bgcolor="#FFFFFF">服务端口</td>
        <td width="25%" bgcolor="#FFFFFF">
		<s:property value="station.server_port" />
		</td>
      </tr>

    </table>
  
  </form>
   </div>
  </body>
</html>




