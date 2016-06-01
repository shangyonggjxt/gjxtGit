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

		<title>组织机构</title>

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
	
<script type="text/javascript">

function showButton(){
  var a = document.StationGroup.getElementsByTagName("input");
  for(i=0;i<a.length;i++) {
     if(a[i].type=="button") {
          a[i].disabled=false;
     }
  }
}

</script>
	
	</head>

	<body onLoad="showButton()">
	
	<div class="easyui-panel" title="组织机构||三级节点" style="width:800px;padding:0px 0px">
	
		<s:hidden name="currentPage" id="currentPage" value="%{currentPage}"></s:hidden>
		<s:hidden name="totalPage" id="totalPage" value="%{totalPage}"></s:hidden>

		<s:form method="post" name="StationGroup" id="StationGroup" theme="simple">
<table width="50%" cellspacing="1" bgcolor="#CCCCCC">
  <tr height="30px">
    <td bgcolor="#FFFFFF"><input type="button" name="Submit6" value="一级节点" onClick="query1()" class="easyui-linkbutton" style="font-size:14px;"></td>
    <td bgcolor="#FFFFFF"><input type="button" name="Submit62" value="二级节点" onClick="query2()" class="easyui-linkbutton" style="font-size:14px;"></td>
    <td bgcolor="#FFFFFF"><input type="button" name="Submit63" value="三级节点" onClick="query3()" class="easyui-linkbutton" style="font-size:14px;"></td>
    <td bgcolor="#FFFFFF"><input type="button" name="Submit64" value="四级节点" onClick="query4()" class="easyui-linkbutton" style="font-size:14px;"></td>
  </tr>
</table>

			<table width="100%" cellspacing="1" bgcolor="#CCCCCC">
				<tr>
					<td width="20%" align="right" bgcolor="#FFFFFF">组织机构名称</td>
					<td width="20%" bgcolor="#FFFFFF">
					 <input class="easyui-textbox" style="width:100%;height:30px;padding:12px" data-options="prompt:'请输入组织机构名称'"  name="groupThird.group_name" id="groupThird.group_name" value="${groupThird.group_name}">
				    </td>
					<td width="20%" bgcolor="#FFFFFF">
											每页显示
				  <s:select list="#{'10':'10条数据','12':'12条数据','13':'13条数据','15':'15条数据','20':'20条数据','30':'30条数据','40':'40条数据','50':'50条数据','100':'100条数据'}" name="pageSize" value="%{pageSize}"></s:select>					</td>
					<td width="20%" bgcolor="#FFFFFF" align="center"><label>
					  <input type="button" name="Submit4" value="查询" disabled="true" onClick="query()">
				  </label></td>
					<td width="20%" bgcolor="#FFFFFF" align="center">
					  <input type="button" name="Submit5" value="新增" disabled="true" onClick="preSave()">
				  </td>
				</tr>
		  </table>
			<table width="100%" cellspacing="1" bgcolor="#CCCCCC">
  <tr bgcolor="#CCCCCC">
    <td width="25%">一级节点</td>
    <td width="25%">二级节点</td>
    <td width="25%">三级节点</td>
    <td width="25%" align="center">操作</td>
  </tr>
   <s:iterator value="list" id="v">
  <tr>
    <td bgcolor="#FFFFFF"><s:property value="first_name" /></td>
    <td bgcolor="#FFFFFF"><s:property value="second_name" /></td>
    <td bgcolor="#FFFFFF"><s:property value="group_name" /></td>
    <td bgcolor="#FFFFFF"><input type="button" name="Submit" value="修改" disabled="true" onClick="update(${v.group_id})">
      <input type="button" name="Submit2" value="删除" disabled="true" onClick="deleteStation(${v.group_id})"></td>
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
 StationGroup.action="<%=request.getContextPath()%>/stationGroup.action?functionName=queryGroupThird&currentPage="+currentPage;
 StationGroup.submit();
 
}



function query1(){
 var currentPage=document.getElementById("currentPage").value;
 StationGroup.action="<%=request.getContextPath()%>/stationGroup.action?functionName=queryGroupFirst&currentPage="+currentPage;
 StationGroup.submit();
 
}


function query2(){
 var currentPage=document.getElementById("currentPage").value;
 StationGroup.action="<%=request.getContextPath()%>/stationGroup.action?functionName=queryGroupSecond&currentPage="+currentPage;
 StationGroup.submit();
 
}


function query3(){
 var currentPage=document.getElementById("currentPage").value;
 StationGroup.action="<%=request.getContextPath()%>/stationGroup.action?functionName=queryGroupThird&currentPage="+currentPage;
 StationGroup.submit();
 
}


function query4(){
 var currentPage=document.getElementById("currentPage").value;
 StationGroup.action="<%=request.getContextPath()%>/stationGroup.action?functionName=queryGroupFourth&currentPage="+currentPage;
 StationGroup.submit();
 
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


function update(group_id){
  var myDate = new Date();
  var time=myDate.getMilliseconds();  
  
    if(!!window.ActiveXObject || "ActiveXObject" in window){
    window.showModalDialog(encodeURI("<%=request.getContextPath()%>/stationGroup.action?functionName=groupThird_update_view&groupThird.group_id="+group_id+"&time="+time),"","dialogWidth=700px;dialogHeight=500px;toolbar=no;menubar=no;scrollbars=no;resizable=no;location=no;status=no");
  query();
  }else{
  window.open(encodeURI("<%=request.getContextPath()%>/stationGroup.action?functionName=groupThird_update_view&groupThird.group_id="+group_id+"&time="+time),"","height=500,width=700,top=100,left=100,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no, status=no");
  query();
  }
  
}


function preSave(){

  var myDate = new Date();
  var time=myDate.getMilliseconds();  
  
    if(!!window.ActiveXObject || "ActiveXObject" in window){
     window.showModalDialog(encodeURI("<%=request.getContextPath()%>/stationGroup.action?functionName=preSaveThird&time="+time),"","dialogWidth=700px;dialogHeight=500px;toolbar=no;menubar=no;scrollbars=no;resizable=no;location=no;status=no");
   query();
  }else{
   window.open(encodeURI("<%=request.getContextPath()%>/stationGroup.action?functionName=preSaveThird&time="+time),"","height=500,width=700,top=100,left=100,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no, status=no");
   query();
  }
  
}


function deleteStation(group_id){

  
    $.messager.confirm('提示信息', '确认要删除吗？', function(r){
		if (r){
             var myDate = new Date();
             var time=myDate.getMilliseconds(); 
             
               if(!!window.ActiveXObject || "ActiveXObject" in window){
                            window.showModalDialog(encodeURI("<%=request.getContextPath()%>/stationGroup.action?functionName=delGroupThird&groupThird.group_id="+group_id+"&time="+time),"","dialogWidth=700px;dialogHeight=500px;toolbar=no;menubar=no;scrollbars=no;resizable=no;location=no;status=no");
             query();
  
  }else{
               window.open(encodeURI("<%=request.getContextPath()%>/stationGroup.action?functionName=delGroupThird&groupThird.group_id="+group_id+"&time="+time),"","height=500,width=700,top=100,left=100,toolbar=no,menubar=no,scrollbars=yes,resizable=yes,location=no, status=no");
             query();

  }

		}
    });
  
	
}




function toSubmit(toValue){

     if(toValue == '首页'){
         StationGroup.action="<%=request.getContextPath()%>/stationGroup.action?functionName=queryGroupThird&currentPage="+1;
         StationGroup.submit();
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
         StationGroup.action="<%=request.getContextPath()%>/stationGroup.action?functionName=queryGroupThird&currentPage="+currentPage;
         StationGroup.submit();
       }
       
        if(toValue == '下一页'){
         
         var currentPage=document.getElementById("currentPage").value;
         var totalPage=document.getElementById("totalPage").value;
            if(parseInt(currentPage)<parseInt(totalPage)){
              currentPage=parseInt(currentPage)+1;
            }else{
            //  alert("最后一页");
             $.messager.alert('提示信息','最后一页');
              return;
            }
         
         StationGroup.action="<%=request.getContextPath()%>/stationGroup.action?functionName=queryGroupThird&currentPage="+currentPage;
         StationGroup.submit();
       }
       
        if(toValue == '尾页'){
         var currentPage=document.getElementById("currentPage").value;
         var totalPage=document.getElementById("totalPage").value;
         currentPage=totalPage;
         StationGroup.action="<%=request.getContextPath()%>/stationGroup.action?functionName=queryGroupThird&currentPage="+currentPage;
         StationGroup.submit();
       }

}


function goTo(){
   
   var currentPage=document.getElementById("goto").value;
   if(currentPage==""){
    //alert("页数不能为空");
     $.messager.alert('提示信息','页数不能为空');
   return;
  }
  
   StationGroup.action="<%=request.getContextPath()%>/stationGroup.action?functionName=queryGroupThird&currentPage="+currentPage;
   StationGroup.submit();
   
}


</script>
