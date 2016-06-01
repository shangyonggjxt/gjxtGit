<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<jsp:include page="checklogin.jsp"></jsp:include>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>基站集中监控管理平台</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>


	<frameset cols="*,1024,*" frameborder="no" border="0" framespacing="0">
		<frame src="about:blank"></frame>



		<frameset rows="127,*,40" cols="*" frameborder="no" border="0"
			framespacing="0">
			<frame src="topFrame.jsp" name="topFrame" scrolling="No"
				noresize="noresize" id="topFrame" title="topFrame">
			<frameset rows="*" cols="168,*" framespacing="1" frameborder="no"
				border="0">
				<frame src="leftFrame.jsp" name="leftFrame" scrolling="No"
					noresize="noresize" id="leftFrame" title="leftFrame">
				<frame src="mainFrame.jsp" name="mainFrame" id="mainFrame"
					scrolling="yes" title="mainFrame">
			</frameset>
            
            <frame src="CopyRight.jsp" name="bottom" scrolling="No"
				noresize="noresize" id="bottom" title="bottom">
		</frameset>


		<frame src="about:blank"></frame>
	</frameset>


	<noframes>
		<body>
		</body>
	</noframes>
</html>
