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
  
    <div class="easyui-panel" title="编辑四级节点" style="width:600px;padding:30px 60px">
  
  <form name="groupFourth" id="groupFourth" method="post" action="">
     <s:hidden name="groupFourth.group_id" id="groupFourth.group_id" value="%{groupFourth.group_id}"></s:hidden>
    <table width="100%" cellspacing="1" bgcolor="#CCCCCC">

	  	        <tr>
        <td align="right" bgcolor="#FFFFFF">一级节点</td>
        <td colspan="3" align="left" bgcolor="#FFFFFF"> <s:property value="groupFourth.first_name" />	</td>
      </tr>
	        <tr>
        <td align="right" bgcolor="#FFFFFF">二级节点</td>
        <td colspan="3" align="left" bgcolor="#FFFFFF"> <s:property value="groupFourth.second_name" />		</td>
      </tr>
	  	        <tr>
        <td align="right" bgcolor="#FFFFFF">三级节点</td>
        <td colspan="3" align="left" bgcolor="#FFFFFF"> <s:property value="groupFourth.third_name" />		</td>
      </tr>
      <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">节点名称</td>
        <td width="25%" bgcolor="#FFFFFF">
		<s:textfield name="groupFourth.group_name"
								value="%{groupFourth.group_name}" id="groupFourth.group_name" theme="simple"></s:textfield>		</td>
        <td width="25%" align="right" bgcolor="#FFFFFF">备注</td>
        <td width="25%" bgcolor="#FFFFFF">
	    <s:textfield name="groupFourth.demo"
								value="%{groupFourth.demo}" id="groupFourth.demo" theme="simple"></s:textfield>		</td>
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

 
 var myDate = new Date();
 var time=myDate.getMilliseconds();  
 groupFourth.action=encodeURI("<%=request.getContextPath()%>/stationGroup.action?functionName=updateGroupFourth&time="+time);
 groupFourth.submit();
 
}
 

</script>
