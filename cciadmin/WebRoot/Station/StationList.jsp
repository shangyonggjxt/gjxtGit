<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="/checklogin.jsp"></jsp:include>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'OperatorList.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
	    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 
 	<link rel="stylesheet" type="text/css" href="js/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="js/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="js/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/locale/easyui-lang-zh_CN.js"></script>
	
<script type="text/javascript">

function showButton(){
  var a = document.station.getElementsByTagName("input");
  for(i=0;i<a.length;i++) {
     if(a[i].type=="button") {
          a[i].disabled=false;
     }
  }
}

</script>
	
	</head>

	<body onLoad="showButton()">
	
	  <div class="easyui-panel" title="基站控制器" style="width:800px;padding:0px 0px">
	
		<s:hidden name="currentPage" id="currentPage" value="%{currentPage}"></s:hidden>
		<s:hidden name="totalPage" id="totalPage" value="%{totalPage}"></s:hidden>

		<s:form method="post" name="station" id="station" theme="simple">

			<table width="100%" cellspacing="1" bgcolor="#CCCCCC">
				<tr>
					<td width="20%" align="right" bgcolor="#FFFFFF">控制器名称</td>
					<td width="20%" bgcolor="#FFFFFF">
		<input class="easyui-textbox" style="width:100%;height:30px;padding:12px" data-options="prompt:'请输入控制器名称'"  name="station.station_name" id="station.station_name" value="${station.station_name}">
				  </td>
					<td width="20%" bgcolor="#FFFFFF">
											每页显示
											  <s:select list="#{'10':'10条数据','12':'12条数据','13':'13条数据','15':'15条数据','20':'20条数据','30':'30条数据','40':'40条数据','50':'50条数据','100':'100条数据'}" name="pageSize" value="%{pageSize}"></s:select>
				  </td>
					<td width="20%" bgcolor="#FFFFFF" align="center"><label>
					  <input type="button" name="Submit4" value="查询" disabled="true" onClick="query()">
				  </label></td>
					<td width="20%" bgcolor="#FFFFFF" align="center"><label>
					  <input type="button" name="Submit5" value="新增" disabled="true" onClick="preSave()">
				  </label></td>
				</tr>
				<tr bgcolor="#CCCCCC">
					<td width="20%" bgcolor="#CCCCCC">控制器名称</td>
					<td width="20%" bgcolor="#CCCCCC">控制器代码</td>
					<td width="20%" bgcolor="#CCCCCC">类型</td>
					<td width="20%" bgcolor="#CCCCCC">所属基站</td>
					<td width="20%" bgcolor="#CCCCCC" align="center">操作					</td>
				</tr>
				<s:iterator value="list" id="v">
				<tr>
				  <td bgcolor="#FFFFFF"><s:property value="station_name" /></td>
				  <td bgcolor="#FFFFFF"><s:property value="station_code" /></td>
				  <td bgcolor="#FFFFFF">
				  	<s:if test="#v.station_type==1">TB8100</s:if>
					<s:if test="#v.station_type==2">VHF_JRC</s:if>
					<s:if test="#v.station_type==3">MX800</s:if>
					<s:if test="#v.station_type==4">AIS_JRC</s:if>
					<s:if test="#v.station_type==5">GJ712</s:if>
					<s:if test="#v.station_type==6">天奥</s:if>
				  </td>
				  <td bgcolor="#FFFFFF"><s:property value="basestation_name" /></td>
				  <td bgcolor="#FFFFFF"><span>
				    <input type="button" name="Submit" value="修改" disabled="true" onClick="update(${v.station_code},${v.station_type})">
				    <input type="button" name="Submit2" value="删除" disabled="true" onClick="deleteStation(${v.station_code},${v.station_type})">
				    <input type="button" name="Submit3" value="查看" disabled="true" onClick="view(${v.station_code},${v.station_type})">
				  </span></td>
			  </tr>
			  </s:iterator>
		  </table>
			
			<table width="780px" border="0"  cellpadding="5" cellspacing="0" bordercolor="6dbdd8" style=" font-size:12px; color:#000000; ">
			
<tr>
					<td colspan="8">
						<center>
							<p>
							<input disabled="true" name="button" type="button" value="首页"
								onclick="toSubmit('首页')">
							&nbsp;&nbsp;&nbsp;
							<input disabled="true" name="button" type="button" value="上一页"
								onclick="toSubmit('上一页')">
							&nbsp;&nbsp;&nbsp;
							<input disabled="true" name="button" type="button" value="下一页"
								onclick="toSubmit('下一页')">
							&nbsp;&nbsp;&nbsp;
							<input disabled="true" name="button" type="button" value="尾页"
								onclick="toSubmit('尾页')">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共${totalPage
							}页&nbsp;&nbsp;&nbsp;第${currentPage}页&nbsp;&nbsp;&nbsp;共${totalElements
							}条
							
						    跳转到
						    <label>
						    <input name="goto" id="goto" type="text" size="5" input onKeyUp="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
						    </label>
							页
							<label>
											<input disabled="true" type="button" name="Submit3" value="跳转" onClick="goTo()">
			</label>
							</p>
						</center>
					</td>
			  </tr>
			</table>

		</s:form>
    </div>
	</body>
</html>

<script type="text/javascript" language="javascript">

function query(){
 var currentPage=document.getElementById("currentPage").value;
 station.action="<%=request.getContextPath()%>/station.action?functionName=query&currentPage="+currentPage;
 station.submit();
 
}



function view(station_code,station_type){

  var myDate = new Date();
  var time=myDate.getMilliseconds();  
  
    if(!!window.ActiveXObject || "ActiveXObject" in window){
    window.showModalDialog(encodeURI("<%=request.getContextPath()%>/station.action?functionName=view&station.station_code="+station_code+"&station.station_type="+station_type+"&time="+time),"","dialogWidth=700px;dialogHeight=500px;toolbar=no;menubar=no;scrollbars=no;resizable=no;location=no;status=no");
  }else{
  window.open(encodeURI("<%=request.getContextPath()%>/station.action?functionName=view&station.station_code="+station_code+"&station.station_type="+station_type+"&time="+time),"","height=500,width=700,top=100,left=100,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no, status=no");
  }
  

}


function update(station_code,station_type){
  var myDate = new Date();
  var time=myDate.getMilliseconds();  
  
    if(!!window.ActiveXObject || "ActiveXObject" in window){
    window.showModalDialog(encodeURI("<%=request.getContextPath()%>/station.action?functionName=update_view&station.station_code="+station_code+"&station.station_type="+station_type+"&time="+time),"","dialogWidth=700px;dialogHeight=500px;toolbar=no;menubar=no;scrollbars=no;resizable=no;location=no;status=no");
  query();
  }else{
  window.open(encodeURI("<%=request.getContextPath()%>/station.action?functionName=update_view&station.station_code="+station_code+"&station.station_type="+station_type+"&time="+time),"","height=500,width=700,top=100,left=100,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no, status=no");
  query();
  }
  
}


function preSave(){

  var myDate = new Date();
  var time=myDate.getMilliseconds();  
  
    if(!!window.ActiveXObject || "ActiveXObject" in window){
     window.showModalDialog(encodeURI("<%=request.getContextPath()%>/station.action?functionName=preSave&time="+time),"","dialogWidth=700px;dialogHeight=500px;toolbar=no;menubar=no;scrollbars=no;resizable=no;location=no;status=no");
   query();
  }else{
   window.open(encodeURI("<%=request.getContextPath()%>/station.action?functionName=preSave&time="+time),"","height=500,width=700,top=100,left=100,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no, status=no");
   query();
  }
  
}



function deleteStation(station_code,station_type){

     $.messager.confirm('提示信息', '确认要删除吗？', function(r){
		if (r){
             var myDate = new Date();
             var time=myDate.getMilliseconds(); 
             
               if(!!window.ActiveXObject || "ActiveXObject" in window){
               window.showModalDialog(encodeURI("<%=request.getContextPath()%>/station.action?functionName=delStation&time="+time+"&station.station_code="+station_code+"&station.station_type="+station_type),"","dialogWidth=700px;dialogHeight=500px;toolbar=no;menubar=no;scrollbars=no;resizable=no;location=no;status=no");
             query();
  }else{
               window.open(encodeURI("<%=request.getContextPath()%>/station.action?functionName=delStation&time="+time+"&station.station_code="+station_code+"&station.station_type="+station_type),"","height=500,width=700,top=100,left=100,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no, status=no");
             query();

  }
             
		}
  });
	
}




function toSubmit(toValue){

     if(toValue == '首页'){
         station.action="<%=request.getContextPath()%>/station.action?functionName=query&currentPage="+1;
         station.submit();
     }
     
        if(toValue == '上一页'){
         var currentPage=document.getElementById("currentPage").value;
         if(currentPage>1){
              currentPage=parseInt(currentPage)-1;
         }else{
              //alert("第一页");
                $.messager.alert('提示信息','第一页');
              return;
         }
         station.action="<%=request.getContextPath()%>/station.action?functionName=query&currentPage="+currentPage;
         station.submit();
       }
       
        if(toValue == '下一页'){
         
         var currentPage=document.getElementById("currentPage").value;
         var totalPage=document.getElementById("totalPage").value;
            if(parseInt(currentPage)<parseInt(totalPage)){
              currentPage=parseInt(currentPage)+1;
            }else{
              //alert("最后一页");
               $.messager.alert('提示信息','最后一页');
              return;
            }
         
         station.action="<%=request.getContextPath()%>/station.action?functionName=query&currentPage="+currentPage;
         station.submit();
       }
       
        if(toValue == '尾页'){
         var currentPage=document.getElementById("currentPage").value;
         var totalPage=document.getElementById("totalPage").value;
         currentPage=totalPage;
         station.action="<%=request.getContextPath()%>/station.action?functionName=query&currentPage="+currentPage;
         station.submit();
       }

}


function goTo(){
   
   var currentPage=document.getElementById("goto").value;
   if(currentPage==""){
    //alert("页数不能为空");
     $.messager.alert('提示信息','页数不能为空');
   return;
  }
  
   station.action="<%=request.getContextPath()%>/station.action?functionName=query&currentPage="+currentPage;
   station.submit();
   
}


</script>
