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
    
    <title>三级级节点</title>
    
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
  
  <div class="easyui-panel" title="编辑三级节点" style="width:600px;padding:30px 60px">
  
  <form name="groupThird" id="groupThird" method="post" action="">
   <s:hidden name="groupThird.group_id" id="groupThird.group_id" value="%{groupThird.group_id}"></s:hidden>
    <table width="100%" cellspacing="1" bgcolor="#CCCCCC">

	  	        <tr>
        <td align="right" bgcolor="#FFFFFF">一级节点</td>
        <td colspan="3" align="left" bgcolor="#FFFFFF">
         <s:property value="groupThird.first_name" />		
		</td>
      </tr>
	        <tr>
        <td align="right" bgcolor="#FFFFFF">二级节点</td>
        <td colspan="3" align="left" bgcolor="#FFFFFF">
         <s:property value="groupThird.second_name" />			
		</td>
      </tr>
      <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">节点名称</td>
        <td width="25%" bgcolor="#FFFFFF">
		<s:textfield name="groupThird.group_name"
								value="%{groupThird.group_name}" id="groupThird.group_name" theme="simple"></s:textfield>		</td>
        <td width="25%" align="right" bgcolor="#FFFFFF">备注</td>
        <td width="25%" bgcolor="#FFFFFF">
	    <s:textfield name="groupThird.demo"
								value="%{groupThird.demo}" id="groupThird.demo" theme="simple"></s:textfield>		</td>
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
 

 var group_name=document.getElementById("groupThird.group_name").value;
 if(group_name==""){
 // alert("节点名称不能为空");
  $.messager.alert('提示信息','节点名称不能为空');
  return;
 }
 
 
 var myDate = new Date();
 var time=myDate.getMilliseconds();  
 groupThird.action=encodeURI("<%=request.getContextPath()%>/stationGroup.action?functionName=updateGroupThird&time="+time);
 groupThird.submit();
 
}
 

</script>
