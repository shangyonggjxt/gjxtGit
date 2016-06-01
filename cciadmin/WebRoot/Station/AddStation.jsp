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
    
    <title>新增基站控制器</title>
    
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
 
 <script type="text/javascript">
 
 $(function(){
 
 			$('#station\\.station_code').numberbox({
				min:0 , 
				max:99999999 ,
				required:true , 
				missingMessage:'控制器代码必填!' ,
				precision:0
			});
			
});
 
 </script>
 
  </head>
  <font color="red"> <s:fielderror></s:fielderror> </font>
  <body>
  
  <div class="easyui-panel" title="新增基站控制器" style="width:600px;padding:30px 60px">
  
  <form name="station" id="station" method="post" action="">
    <table width="100%" cellspacing="1" bgcolor="#CCCCCC">
	    <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">所属基站</td>
        <td colspan="3" bgcolor="#FFFFFF">
		  <s:select list="%{baseStationList}" listKey="basestation_id" headerKey="0"
							headerValue="所有" listValue="basestation_name" name="station.basestation_id"  id="station.basestation_id"
							value="%{station.basestation_id}" theme="simple"></s:select>		</td>
      </tr>
      <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">控制器名称</td>
        <td width="25%" bgcolor="#FFFFFF">
		<input type="text" name="station.station_name" id="station.station_name" value="${station.station_name}" class="easyui-validatebox" required="true">
		</td>
        <td width="25%" align="right" bgcolor="#FFFFFF">控制器代码</td>
        <td width="25%" bgcolor="#FFFFFF">
		<input type="text" name="station.station_code" id="station.station_code" value="${station.station_code}">
		</td>
      </tr>
      <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">类型</td>
        <td width="25%" bgcolor="#FFFFFF">
	    <s:select list="#{1:'TB8100',2:'VHF_JRC',3:'MX800',4:'AIS_JRC',5:'GJ712',6:'天奥'}" name="station.station_type" value="%{station.station_type}" theme="simple"></s:select>		</td>
        <td width="25%" align="right" bgcolor="#FFFFFF">IP</td>
        <td width="25%" bgcolor="#FFFFFF">
		<s:textfield name="station.IP"
								value="%{station.IP}" id="station.IP" theme="simple"></s:textfield>		</td>
      </tr>
	        <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">服务IP</td>
        <td width="25%" bgcolor="#FFFFFF">
	    	<s:textfield name="station.server_ip"
								value="%{station.server_ip}" id="station.server_ip" theme="simple"></s:textfield>	</td>
        <td width="25%" align="right" bgcolor="#FFFFFF">服务端口</td>
        <td width="25%" bgcolor="#FFFFFF">
		<s:textfield name="station.server_port"
								value="%{station.server_port}" id="station.server_port" theme="simple"></s:textfield>		</td>
      </tr>
      <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">备注</td>
        <td colspan="3" bgcolor="#FFFFFF">
			<s:textfield name="station.demo"
								value="%{station.demo}" id="station.demo" theme="simple"></s:textfield>
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


function savaData(){


 var basestation_id=document.getElementById("station.basestation_id").value;
 if(basestation_id==""||parseInt(basestation_id)==0){
  //alert("请选择所属基站");
  $.messager.alert('提示信息','请选择所属基站');
  return;
 }


 var station_code=document.getElementById("station.station_code").value;
 if(station_code==""){
  //alert("基站代码不能为空");
  $.messager.alert('提示信息','控制器代码不能为空');
  return;
 }
 
 
 
  var station_name=document.getElementById("station.station_name").value;
 if(station_name==""){
 // alert("基站名称不能为空");
 $.messager.alert('提示信息','控制器名称不能为空');
  return;
 }
 
 
 var myDate = new Date();
 var time=myDate.getMilliseconds();  
 station.action=encodeURI("<%=request.getContextPath()%>/station.action?functionName=save&time="+time);
 station.submit();
 
}
 

</script>
