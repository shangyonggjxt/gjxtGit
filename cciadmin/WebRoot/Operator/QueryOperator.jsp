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
    
    <title>监控平台账号</title>
    
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

  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <base target="_self">
  </head>
  <font color="red"> <s:fielderror></s:fielderror> </font>
  <body>
  
    <div class="easyui-panel" title="账号详细" style="width:600px;padding:30px 60px">

    <table width="100%" cellspacing="1" bgcolor="#CCCCCC">

      <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">账号</td>
        <td width="25%" bgcolor="#FFFFFF">
		<s:property value="operator.operator_code" />        </td>
        <td width="25%" bgcolor="#FFFFFF">密码</td>
        <td width="25%" bgcolor="#FFFFFF">
		<s:property value="operator.operator_pwd" />        </td>
      </tr>
      <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">姓名</td>
        <td width="25%" bgcolor="#FFFFFF">
		<s:property value="operator.operator_name" />        </td>
        <td width="25%" bgcolor="#FFFFFF">电话</td>
        <td width="25%" bgcolor="#FFFFFF">
				<s:property value="operator.telephone" />        </td>
      </tr>
      <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">地址</td>
        <td width="25%" bgcolor="#FFFFFF">
		<s:property value="operator.address" />        </td>
        <td width="25%" bgcolor="#FFFFFF">部门</td>
        <td width="25%" bgcolor="#FFFFFF">
				<s:property value="operator.department" />        </td>
      </tr>
      <tr>
        <td align="right" bgcolor="#FFFFFF">控制权限</td>
        <td bgcolor="#FFFFFF">
		 			<s:if test="operator.action==0">无</s:if>
					<s:if test="operator.action==1">有</s:if>        </td>
        <td bgcolor="#FFFFFF">备注</td>
        <td bgcolor="#FFFFFF">
		<s:property value="operator.comments" />		</td>
      </tr>
	        <tr>
        <td align="right" bgcolor="#FFFFFF">日志权限</td>
        <td bgcolor="#FFFFFF">
		 			<s:if test="operator.querylog==0">无</s:if>
					<s:if test="operator.querylog==1">有</s:if>        </td>
        <td bgcolor="#FFFFFF">&nbsp;</td>
        <td bgcolor="#FFFFFF">&nbsp;</td>
      </tr>
    </table>
</div>

  </body>
</html>



