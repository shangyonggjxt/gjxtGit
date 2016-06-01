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
    
    <title>修改基站</title>
    
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
  
    <div class="easyui-panel" title="修改基站" style="width:600px;padding:30px 60px">
  
  <form name="baseStation" id="baseStation" method="post" action="">
  <s:hidden name="baseStation.basestation_id" id="baseStation.basestation_id" value="%{baseStation.basestation_id}"></s:hidden>
    <table width="100%" cellspacing="1" bgcolor="#CCCCCC">
	   <tr>
        <td align="right" bgcolor="#FFFFFF">所属组织</td>
        <td colspan="3" align="left" bgcolor="#FFFFFF">
		<s:property value="baseStation.group_name" />
		</td>
      </tr>
      <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">基站名称</td>
        <td width="25%" bgcolor="#FFFFFF">
		<s:textfield name="baseStation.basestation_name"
								value="%{baseStation.basestation_name}" id="baseStation.basestation_name" theme="simple"></s:textfield>		</td>
        <td width="25%" align="right" bgcolor="#FFFFFF">部门</td>
        <td width="25%" bgcolor="#FFFFFF">
	    <s:textfield name="baseStation.department"
								value="%{baseStation.department}" id="baseStation.department" theme="simple"></s:textfield>		</td>
      </tr>

      <tr>
        <td align="right" bgcolor="#FFFFFF">经度</td>
        <td align="left" bgcolor="#FFFFFF">
	    <s:textfield name="baseStation.lng"
								value="%{baseStation.lng}" id="baseStation.lng" theme="simple"></s:textfield>		</td>
        <td align="right" bgcolor="#FFFFFF">纬度</td>
        <td align="left" bgcolor="#FFFFFF">
	    <s:textfield name="baseStation.lat"
								value="%{baseStation.lat}" id="baseStation.lat" theme="simple"></s:textfield>		</td>
      </tr>
      <tr>
        <td align="right" bgcolor="#FFFFFF">地址</td>
        <td align="left" bgcolor="#FFFFFF">
		<s:textfield name="baseStation.address"
								value="%{baseStation.address}" id="baseStation.address" theme="simple"></s:textfield>		</td>
        <td align="right" bgcolor="#FFFFFF">备注</td>
        <td align="left" bgcolor="#FFFFFF">
		<s:textfield name="baseStation.demo"
								value="%{baseStation.demo}" id="baseStation.demo" theme="simple"></s:textfield>		</td>
      </tr>
	        <tr>
        <td colspan="4" align="center" bgcolor="#FFFFFF">
          <input type="button" name="Submit" value="修改" onClick="savaData()" class="easyui-linkbutton" style="width:50%;height:32px">        </td>
      </tr>
    </table>
  
  </form>

 </div>
  </body>
</html>



<script type="text/javascript" language="javascript">

function savaData(){

 var basestation_name=document.getElementById("baseStation.basestation_name").value;
 if(basestation_name==""){
 //alert("基站名称不能为空");
  $.messager.alert('提示信息','基站名称不能为空');
  return;
 }
 
 
 var myDate = new Date();
 var time=myDate.getMilliseconds();  
 baseStation.action=encodeURI("<%=request.getContextPath()%>/baseStation.action?functionName=update&time="+time);
 baseStation.submit();
 
}
 

</script>
