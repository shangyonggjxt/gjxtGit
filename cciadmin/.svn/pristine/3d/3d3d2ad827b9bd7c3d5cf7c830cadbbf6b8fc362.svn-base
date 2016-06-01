<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<jsp:include page="checklogin.jsp"></jsp:include>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'leftFrame.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link rel="stylesheet" type="text/css"
			href="js/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="js/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="js/demo.css">
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/locale/easyui-lang-zh_CN.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

		<script type="text/javascript">
    
    
       function getHref(){
       
       var location_href=document.getElementById("location_href").value;
       
       if(location_href==""){
          return;
       }
       
       location_href="<%=basePath%>"+location_href;
       
       var el = [];
        _el = document.getElementsByTagName('a');
        for (var i=0; i<_el.length; i++ ) {
             value = _el[i].href;
             if(value==location_href){
                  _el[i].click();
                  break;
             }

        }
        
       }
        
        
    </script>


	</head>

	<body onload="getHref()">
	<input type="hidden" name="location_href" id="location_href" value="${location_href}"> 
		<div class="easyui-panel" title="目录列表"
			style="width: 127px; padding: 0px 0px 0px 0px">
			<div>
				<a href="operator.action?functionName=query"
					class="easyui-linkbutton" style="padding: 0px; width: 100%;"
					target="mainFrame"> <span style="font-size: 14px;">监控平台账号</span>
				</a>
			</div>

			<div>
				<a href="stationGroup.action?functionName=queryGroupFirst"
					class="easyui-linkbutton" style="padding: 0px; width: 100%;"
					target="mainFrame"> <span style="font-size: 14px;">组织机构</span>
				</a>
			</div>

			<div>
				<a href="baseStation.action?functionName=query"
					class="easyui-linkbutton" style="padding: 0px; width: 100%;"
					target="mainFrame"> <span style="font-size: 14px;">基站</span> </a>
			</div>


			<div>
				<a href="station.action?functionName=query"
					class="easyui-linkbutton" style="padding: 0px; width: 100%;"
					target="mainFrame"> <span style="font-size: 14px;">基站控制器</span>
				</a>
			</div>



		</div>

	</body>
</html>
