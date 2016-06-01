<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>集中监控管理平台</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    
        <style type="text/css">
             #box{
               MARGIN-RIGHT: auto;
               MARGIN-LEFT: auto;
               height:600px;
               width:400px;
               padding:100px 0px 0px 0px;
            }
    </style>

	<link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="js/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="js/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/locale/easyui-lang-zh_CN.js"></script>
	
	<script type="text/javascript" src="js/jquery.md5.js"></script>
	<script type="text/javascript" src="js/Base64-80.js"></script>
    
  <script language="javascript">
     
			function submit_click(){
				if(loginForm.username2.value==""){
					alert1();
					loginForm.username2.focus();
					return;
				}
				
				document.getElementById("sysmUser.username").value=encode64(document.getElementById("username2").value);	
                document.getElementById("sysmUser.password").value=encode64($.md5(document.getElementById("password2").value));		
				
				loginForm.action=encodeURI("<%=request.getContextPath()%>/userLogin.action");
				loginForm.submit();
			}
			
			
		    function alert2(){
			$.messager.alert('错误提示','用户名或者密码错误!','error');
		    }
		    
		   function alert1(){
			$.messager.alert('提示信息','你输入的用户无效。\r\n请检查用户名拼写，然后再试');
		   }
		   
		   
		   function show3(){
		     
		     var browser=navigator.appName;
		     var b_version=navigator.appVersion;
		     var version=b_version.split(";");
		     var trim_Version=version[1].replace(/[ ]/g,"");
		     
		   
		     if(!!window.ActiveXObject || "ActiveXObject" in window){
		        if(trim_Version!="WOW64"){
		         $.messager.alert('提示信息','推荐使用IE10及以上浏览器！');
		        }
		        
             }else{
                   $.messager.alert('提示信息','推荐使用IE10及以上浏览器！');
             }
             
           }
			
  </script>
  
  
  </head>
  <body onload="alert2();show3()">
  <s:form action="login.action" id="loginForm">
  
    <s:hidden name="sysmUser.username" id="sysmUser.username" value="%{sysmUser.username}"></s:hidden>
  <s:hidden name="sysmUser.password" id="sysmUser.password" value="%{sysmUser.password}"></s:hidden>

	<div id="box">
	<div class="easyui-panel" title="登录系统" style="width:400px;padding:30px 70px 20px 70px">
		<div style="margin-bottom:10px">
			<input class="easyui-textbox" style="width:100%;height:40px;padding:12px" data-options="prompt:'请输入用户名',iconCls:'icon-man',iconWidth:38"  id="username2">
		</div>
		<div style="margin-bottom:20px" onKeyDown="if(event.keyCode==13) submit_click()">
			<input class="easyui-textbox" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'请输入密码',iconCls:'icon-lock',iconWidth:38" id="password2">
		</div>
		<div style="margin-bottom:20px">
			<input type="checkbox" checked="checked">
			<span>记住密码</span>
		</div>
		<div>
			<div class="easyui-linkbutton" data-options="iconCls:'icon-ok'" style="padding:5px 0px;width:100%;" onClick="submit_click()">
				<span style="font-size:14px;">登录</span>
			</div>
		</div>
	</div>
	
	</div>

  </s:form>

  </body>
</html>
