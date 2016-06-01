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
    
    <title>基站</title>
    
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
  
  <div class="easyui-panel" title="新增基站" style="width:600px;padding:30px 60px">
  
  <form name="baseStation" id="baseStation" method="post" action="">
    <table width="100%" cellspacing="1" bgcolor="#CCCCCC">

	  	<tr>
        <td align="right" bgcolor="#FFFFFF">一级节点</td>
        <td colspan="3" align="left" bgcolor="#FFFFFF">
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
        <td width="25%" align="right" bgcolor="#FFFFFF">基站名称</td>
        <td width="25%" bgcolor="#FFFFFF">		
		<input type="text" name="baseStation.basestation_name" id="baseStation.basestation_name" value="${baseStation.basestation_name}" class="easyui-validatebox" required="true">
		</td>
        <td width="25%" align="right" bgcolor="#FFFFFF">部门</td>
        <td width="25%" bgcolor="#FFFFFF">
	    <s:textfield name="baseStation.department"
								value="%{baseStation.department}" id="baseStation.department" theme="simple"></s:textfield>		</td>
      </tr>

      <tr>
        <td align="right" bgcolor="#FFFFFF">经度</td>
        <td align="left" bgcolor="#FFFFFF">
				 <s:textfield name="baseStation.lng"
								value="%{baseStation.lng}" id="baseStation.lng" theme="simple"></s:textfield>	
		</td>
        <td align="right" bgcolor="#FFFFFF">纬度</td>
        <td align="left" bgcolor="#FFFFFF">
						 <s:textfield name="baseStation.lat"
								value="%{baseStation.lat}" id="baseStation.lat" theme="simple"></s:textfield>
		</td>
      </tr>
      <tr>
        <td align="right" bgcolor="#FFFFFF">地址</td>
        <td align="left" bgcolor="#FFFFFF">
		<s:textfield name="baseStation.address"
								value="%{baseStation.address}" id="baseStation.address" theme="simple"></s:textfield>
		</td>
        <td align="right" bgcolor="#FFFFFF">备注</td>
        <td align="left" bgcolor="#FFFFFF">
				<s:textfield name="baseStation.demo"
								value="%{baseStation.demo}" id="baseStation.demo" theme="simple"></s:textfield>
		</td>
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
 baseStation.action=encodeURI("<%=request.getContextPath()%>/baseStation.action?functionName=preSave&time="+time);
 baseStation.submit();
     
}


function savaData(){

var group_id;
 var fourth_id=document.getElementById("stationGroup.fourth_id").value;
  group_id=fourth_id;
 var third_id=document.getElementById("stationGroup.third_id").value;
   group_id=third_id;
 var second_id=document.getElementById("stationGroup.second_id").value;
   group_id=second_id;
 var first_id=document.getElementById("stationGroup.first_id").value;
   group_id=first_id;
  
  
if(parseInt(group_id)==0){
      // alert("请选择所属组织");
      $.messager.alert('提示信息','请选择所属组织');
       return;
}

 var basestation_name=document.getElementById("baseStation.basestation_name").value;
 if(basestation_name==""){
  //alert("基站名称不能为空");
   $.messager.alert('提示信息','基站名称不能为空');
  return;
 }
 
 
 var myDate = new Date();
 var time=myDate.getMilliseconds();  
 baseStation.action=encodeURI("<%=request.getContextPath()%>/baseStation.action?functionName=insert&time="+time);
 baseStation.submit();
 
}
 

</script>
