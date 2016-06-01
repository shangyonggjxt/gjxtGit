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
    
    <title>新增二级节点</title>
    
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
  
  <div class="easyui-panel" title="新增二级节点" style="width:600px;padding:30px 60px">
  
  <form name="groupSecond" id="groupSecond" method="post" action="">
    <table width="100%" cellspacing="1" bgcolor="#CCCCCC">

	    <tr>
        <td align="right" bgcolor="#FFFFFF">一级节点</td>
        <td colspan="3" align="left" bgcolor="#FFFFFF">
		<s:select list="%{firstList}" listKey="group_id" headerKey="0"
							headerValue="所有" listValue="group_name" name="stationGroup.first_id"  id="stationGroup.first_id"
							value="%{stationGroup.first_id}" theme="simple"></s:select>		
		</td>
      </tr>
      <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">节点名称</td>
        <td width="25%" bgcolor="#FFFFFF">
		<input type="text" name="groupSecond.group_name" id="groupSecond.group_name" value="${groupSecond.group_name}" class="easyui-validatebox" required="true">
		</td>
        <td width="25%" align="right" bgcolor="#FFFFFF">备注</td>
        <td width="25%" bgcolor="#FFFFFF">
	    <s:textfield name="groupSecond.demo"
								value="%{groupSecond.demo}" id="groupSecond.demo" theme="simple"></s:textfield>		</td>
      </tr>
      <tr>
        <td colspan="4" align="center" bgcolor="#FFFFFF">
        <input type="button" name="Submit" value="提交" onClick="savaData()" class="easyui-linkbutton" style="width:50%;height:32px">        </td>
      </tr>
    </table>
  
  </form>

  </div>

  </body>
</html>



<script type="text/javascript" language="javascript">


function savaData(){


 var first_id=document.getElementById("stationGroup.first_id").value;
 if(first_id==""||parseInt(first_id)==0){
 // alert("请选择一级节点");
  $.messager.alert('提示信息','请选择一级节点');
  return;
 }

 var group_name=document.getElementById("groupSecond.group_name").value;
 if(group_name==""){
 // alert("节点名称不能为空");
 $.messager.alert('提示信息','节点名称不能为空');
  return;
 }
 
 
 var myDate = new Date();
 var time=myDate.getMilliseconds();  
 groupSecond.action=encodeURI("<%=request.getContextPath()%>/stationGroup.action?functionName=insertGroupSecond&time="+time);
 groupSecond.submit();
 
}
 

</script>
