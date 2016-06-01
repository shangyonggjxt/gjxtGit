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
    
    <title>四级节点</title>
    
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
  
      <div class="easyui-panel" title="新增四级节点" style="width:600px;padding:30px 60px">
  
  <form name="groupFourth" id="groupFourth" method="post" action="">
    <table width="100%" cellspacing="1" bgcolor="#CCCCCC">

	  	        <tr>
        <td align="right" bgcolor="#FFFFFF">一级节点</td>
        <td colspan="3" align="left" bgcolor="#FFFFFF">
		<s:select list="%{firstList}" listKey="group_id" headerKey="0"
							headerValue="所有" listValue="group_name" name="stationGroup.first_id"  id="stationGroup.first_id"
							value="%{stationGroup.first_id}" theme="simple" onchange="query()"></s:select>		
		</td>
      </tr>
	        <tr>
        <td align="right" bgcolor="#FFFFFF">二级节点</td>
        <td colspan="3" align="left" bgcolor="#FFFFFF">
		<s:select list="%{secondList}" listKey="group_id" headerKey="0"
							headerValue="所有" listValue="group_name" name="stationGroup.second_id"  id="stationGroup.second_id"
							value="%{stationGroup.second_id}" theme="simple" onchange="query()"></s:select>		
		</td>
      </tr>
	  	        <tr>
        <td align="right" bgcolor="#FFFFFF">三级节点</td>
        <td colspan="3" align="left" bgcolor="#FFFFFF">
		<s:select list="%{thirdList}" listKey="group_id" headerKey="0"
							headerValue="所有" listValue="group_name" name="stationGroup.third_id"  id="stationGroup.third_id"
							value="%{stationGroup.third_id}" theme="simple"></s:select>		
		</td>
      </tr>
      <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">节点名称</td>
        <td width="25%" bgcolor="#FFFFFF">
		<input type="text" name="groupFourth.group_name" id="groupFourth.group_name" value="${groupFourth.group_name}" class="easyui-validatebox" required="true">
		</td>
        <td width="25%" align="right" bgcolor="#FFFFFF">备注</td>
        <td width="25%" bgcolor="#FFFFFF">
	    <s:textfield name="groupFourth.demo"
								value="%{groupFourth.demo}" id="groupFourth.demo" theme="simple"></s:textfield>		</td>
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


function query(){

 var myDate = new Date();
 var time=myDate.getMilliseconds();  
 groupFourth.action=encodeURI("<%=request.getContextPath()%>/stationGroup.action?functionName=preSaveFourth&time="+time);
 groupFourth.submit();
     
}


function savaData(){


 var first_id=document.getElementById("stationGroup.first_id").value;
 if(first_id==""||parseInt(first_id)==0){
  //alert("请选择一级节点");
     $.messager.alert('提示信息','请选择一级节点');
  return;
 }
 
 
  var second_id=document.getElementById("stationGroup.second_id").value;
 if(second_id==""||parseInt(second_id)==0){
  //alert("请选择二级节点");
  $.messager.alert('提示信息','请选择二级节点');
  return;
 }
 
 
  var third_id=document.getElementById("stationGroup.third_id").value;
 if(third_id==""||parseInt(third_id)==0){
  //alert("请选择三级节点");
   $.messager.alert('提示信息','请选择三级节点');
  return;
 }
 

 var group_name=document.getElementById("groupFourth.group_name").value;
 if(group_name==""){
  //alert("节点名称不能为空");
   $.messager.alert('提示信息','节点名称不能为空');
  return;
 }
 
 
 var myDate = new Date();
 var time=myDate.getMilliseconds();  
 groupFourth.action=encodeURI("<%=request.getContextPath()%>/stationGroup.action?functionName=insertGroupFourth&time="+time);
 groupFourth.submit();
 
}
 

</script>
