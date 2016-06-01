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
    
    <title>账号赋权</title>
    
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
  
    <div class="easyui-panel" title="${operator.operator_code}&nbsp;账号赋权（请选择所管辖的组织机构）" style="width:600px;padding:30px 60px">
  
  
  <form name="stationGroup" id="stationGroup" method="post" action="">
   <s:hidden name="operator.operator_id" id="operator.operator_id" value="%{operator.operator_id}"></s:hidden>
    <table width="100%" cellspacing="1" bgcolor="#CCCCCC">

	  <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">一级节点</td>
        <td width="75%" colspan="3" align="left" bgcolor="#FFFFFF">
		<s:select list="%{firstList}" listKey="group_id" headerKey="0"
							headerValue="所有" listValue="group_name" name="stationGroup.first_id"  id="stationGroup.first_id"
							value="%{stationGroup.first_id}" theme="simple" onchange="query()"></s:select>		</td>
      </tr>
	        <tr>
        <td align="right" bgcolor="#FFFFFF">二级节点</td>
        <td colspan="3" align="left" bgcolor="#FFFFFF">
		<s:select list="%{secondList}" listKey="group_id" headerKey="0"
							headerValue="所有" listValue="group_name" name="stationGroup.second_id"  id="stationGroup.second_id"
							value="%{stationGroup.second_id}" theme="simple" onchange="query()"></s:select>		</td>
      </tr>
	  	        <tr>
        <td align="right" bgcolor="#FFFFFF">三级节点</td>
        <td colspan="3" align="left" bgcolor="#FFFFFF">
		<s:select list="%{thirdList}" listKey="group_id" headerKey="0"
							headerValue="所有" listValue="group_name" name="stationGroup.third_id"  id="stationGroup.third_id"
							value="%{stationGroup.third_id}" theme="simple" onchange="query()"></s:select>		</td>
      </tr>
	  	  	        <tr>
        <td align="right" bgcolor="#FFFFFF">四级节点</td>
        <td colspan="3" align="left" bgcolor="#FFFFFF">
		<s:select list="%{fourthList}" listKey="group_id" headerKey="0"
							headerValue="所有" listValue="group_name" name="stationGroup.fourth_id"  id="stationGroup.fourth_id"
							value="%{stationGroup.fourth_id}" theme="simple"></s:select>		</td>
      </tr>
	        <tr>
        <td colspan="4" align="center" bgcolor="#FFFFFF">
          <input type="button" name="Submit" value="赋权" onClick="savaData()" class="easyui-linkbutton" style="width:25%;height:32px">&nbsp;&nbsp;&nbsp;
		  <input type="button" name="Submit" value="清空赋权" onClick="cancelAuth()" class="easyui-linkbutton" style="width:25%;height:32px"> 
		  </td>
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
 stationGroup.action=encodeURI("<%=request.getContextPath()%>/operator.action?functionName=preAuth&time="+time);
 stationGroup.submit();
     
}


function savaData(){
 
 var myDate = new Date();
 var time=myDate.getMilliseconds();  
 stationGroup.action=encodeURI("<%=request.getContextPath()%>/operator.action?functionName=saveAuth&time="+time);
 stationGroup.submit();
 
}


function cancelAuth(){
 
 var myDate = new Date();
 var time=myDate.getMilliseconds();  
 stationGroup.action=encodeURI("<%=request.getContextPath()%>/operator.action?functionName=cancelAuth&time="+time);
 stationGroup.submit();
 
}
 

</script>
