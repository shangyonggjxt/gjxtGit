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
    
    <title>新增监控平台账号</title>
    
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
  
  
  <div class="easyui-panel" title="新增账号" style="width:600px;padding:30px 60px">
  
  
  <form name="operator" id="operator" method="post" action="">
    <table width="100%" cellspacing="1" bgcolor="#CCCCCC">

      <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">账号</td>
        <td width="25%" bgcolor="#FFFFFF">
        <input type="text" name="operator.operator_code" id="operator.operator_code" value="${operator.operator_code}" class="easyui-validatebox" required="true">        </td>
        <td width="25%" bgcolor="#FFFFFF">密码</td>
        <td width="25%" bgcolor="#FFFFFF">
		<input type="password" name="operator.operator_pwd" id="operator.operator_pwd" value="${operator.operator_pwd}" class="easyui-validatebox" required="true">        </td>
      </tr>
      <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">姓名</td>
        <td width="25%" bgcolor="#FFFFFF">
        <s:textfield name="operator.operator_name"
								value="%{operator.operator_name}" id="operator.operator_name" theme="simple"></s:textfield>        </td>
        <td width="25%" bgcolor="#FFFFFF">电话</td>
        <td width="25%" bgcolor="#FFFFFF"><label>
                <s:textfield name="operator.telephone"
								value="%{operator.telephone}" id="operator.telephone" theme="simple"></s:textfield>
        </label></td>
      </tr>
      <tr>
        <td width="25%" align="right" bgcolor="#FFFFFF">地址</td>
        <td width="25%" bgcolor="#FFFFFF">
         <s:textfield name="operator.address"
								value="%{operator.address}" id="operator.address" theme="simple"></s:textfield>        </td>
        <td width="25%" bgcolor="#FFFFFF">部门</td>
        <td width="25%" bgcolor="#FFFFFF">
                 <s:textfield name="operator.department"
								value="%{operator.department}" id="operator.department" theme="simple"></s:textfield>        </td>
      </tr>
      <tr>
        <td align="right" bgcolor="#FFFFFF">控制权限</td>
        <td bgcolor="#FFFFFF">					
		<s:select list="#{0:'无',1:'有'}" name="operator.action" value="%{operator.action}" theme="simple"></s:select>        </td>
        <td bgcolor="#FFFFFF">备注</td>
        <td bgcolor="#FFFFFF">
		          <s:textfield name="operator.comments"
								value="%{operator.comments}" id="operator.comments" theme="simple"></s:textfield>		</td>
      </tr>
	        <tr>
        <td align="right" bgcolor="#FFFFFF">日志权限</td>
        <td bgcolor="#FFFFFF">					
		<s:select list="#{0:'无',1:'有'}" name="operator.querylog" value="%{operator.querylog}" theme="simple"></s:select>        </td>
        <td bgcolor="#FFFFFF">&nbsp;</td>
        <td bgcolor="#FFFFFF">&nbsp;</td>
      </tr>
      <tr>
        <td colspan="4" align="center" bgcolor="#FFFFFF">
          <input type="button" name="Submit" value="提交" onClick="savaData()" iconCls="icon-ok" class="easyui-linkbutton" style="width:50%;height:32px">        </td>
      </tr>
    </table>
  </form>

</div>
</body>

</html>


<script type="text/javascript" language="javascript">


function savaData(){

 var operator_code=document.getElementById("operator.operator_code").value;
 if(operator_code==""){
  $.messager.alert('提示信息','账号不能为空');
  return;
 }
 
 
 
  var operator_pwd=document.getElementById("operator.operator_pwd").value;
 if(operator_pwd==""){
   $.messager.alert('提示信息','密码不能为空');
  return;
 }
 
 
 var myDate = new Date();
 var time=myDate.getMilliseconds();  
 operator.action=encodeURI("<%=request.getContextPath()%>/operator.action?functionName=save&time="+time);
 operator.submit();
 
}
 
 

</script>


