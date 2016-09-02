<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	onload=function(){
	if("${message}"!=""){
	alert("${message}");
	}
	if("${nsId}"==""){
	for(var i=1;i<19;i++){
	document.getElementById("tr"+i).style.display="none";
	}
	}
	if("${mId1}"==""){
	for(var i=6;i<11;i++){
	document.getElementById("tr"+i).style.background="FF88C2";
	}
	}
	if("${nsId}"=="${sId1}"&&"${nsId}"!=""){
	document.getElementById("tr1").style.background="#FF88C2";
	}
	if("${nsId}"=="${sId2}"&&"${nsId}"!=""){
	document.getElementById("tr2").style.background="#FF88C2";
	}
	if("${nsId}"=="${sId3}"&&"${nsId}"!=""){
	document.getElementById("tr3").style.background="#FF88C2";
	}
	if("${nsId}"=="${sId4}"&&"${nsId}"!=""){
	document.getElementById("tr4").style.background="#FF88C2";
	}
	if("${nsId}"=="${sId5}"&&"${nsId}"!=""){
	document.getElementById("tr5").style.background="#FF88C2";
	}
	
	if("${nmId}"=="${mId1}"&&"${nmId}"!=""){
	document.getElementById("tr6").style.background="#66FF66";
	document.getElementById("tr7").style.background="#FF88C2";
	document.getElementById("tr8").style.background="#FF88C2";
	document.getElementById("tr9").style.background="#FF88C2";
	document.getElementById("tr10").style.background="#FF88C2";
	}
	if("${nmId}"=="${mId2}"&&"${nmId}"!=""){
	document.getElementById("tr7").style.background="#66FF66";
	document.getElementById("tr6").style.background="#FF88C2";
	document.getElementById("tr8").style.background="#FF88C2";
	document.getElementById("tr9").style.background="#FF88C2";
	document.getElementById("tr10").style.background="#FF88C2";
	}
	if("${nmId}"=="${mId3}"&&"${nmId}"!=""){
	document.getElementById("tr8").style.background="#66FF66";
	document.getElementById("tr7").style.background="#FF88C2";
	document.getElementById("tr6").style.background="#FF88C2";
	document.getElementById("tr9").style.background="#FF88C2";
	document.getElementById("tr10").style.background="#FF88C2";
	}
	if("${nmId}"=="${mId4}"&&"${nmId}"!=""){
	document.getElementById("tr9").style.background="#66FF66";
	document.getElementById("tr7").style.background="#FF88C2";
	document.getElementById("tr8").style.background="#FF88C2";
	document.getElementById("tr6").style.background="#FF88C2";
	document.getElementById("tr10").style.background="#FF88C2";
	}
	if("${nmId}"=="${mId5}"&&"${nmId}"!=""){
	document.getElementById("tr10").style.background="#66FF66";
	document.getElementById("tr7").style.background="#FF88C2";
	document.getElementById("tr8").style.background="#FF88C2";
	document.getElementById("tr9").style.background="#FF88C2";
	document.getElementById("tr6").style.background="#FF88C2";
	}
	if("${nsId}"!=""){
	document.getElementById("tr11").style.background="#66FF66";
	document.getElementById("tr12").style.background="#66FF66";
	document.getElementById("tr13").style.background="#66FF66";
	document.getElementById("tr14").style.background="#66FF66";
	document.getElementById("tr15").style.background="#66FF66";
	}
	}
	function clickCourse(i){
	if(i==11&&"${cId1}"!=""){
	document.getElementById("td11").style.background="DDDDDD";
	document.getElementById("td12").style.background="66FF66";
	document.getElementById("td13").style.background="66FF66";
	document.getElementById("td14").style.background="66FF66";
	document.getElementById("td15").style.background="66FF66";
	document.getElementById("ncId").value="${cId1}";
	}
	if(i==12&&"${cId2}"!=""){
	document.getElementById("td12").style.background="DDDDDD";
    document.getElementById("td11").style.background="66FF66";
	document.getElementById("td13").style.background="66FF66";
	document.getElementById("td14").style.background="66FF66";
	document.getElementById("td15").style.background="66FF66";
	document.getElementById("ncId").value="${cId2}";
	}
	if(i==13&&"${cId3}"!=""){
	document.getElementById("td13").style.background="DDDDDD";
    document.getElementById("td11").style.background="66FF66";
	document.getElementById("td12").style.background="66FF66";
	document.getElementById("td14").style.background="66FF66";
	document.getElementById("td15").style.background="66FF66";
	document.getElementById("ncId").value="${cId3}";
	}
	if(i==14&&"${cId4}"!=""){
	document.getElementById("td14").style.background="DDDDDD";
    document.getElementById("td11").style.background="66FF66";
	document.getElementById("td13").style.background="66FF66";
	document.getElementById("td12").style.background="66FF66";
	document.getElementById("td15").style.background="66FF66";
	document.getElementById("ncId").value="${cId4}";
	}
	if(i==15&&"${cId5}"!=""){
	document.getElementById("td15").style.background="DDDDDD";
    document.getElementById("td11").style.background="66FF66";
	document.getElementById("td13").style.background="66FF66";
	document.getElementById("td14").style.background="66FF66";
	document.getElementById("td12").style.background="66FF66";
	document.getElementById("ncId").value="${cId5}";
	}
	}
	
	//跳转
	function skip1(){
	if ("${sId1}"!=""){
	window.location.href="<%=path%>/ManagerServlet?method=queryMajor&sId=${sId1}&spage=${spage}&mpage=1";
	}
	}
	
	function skip2(){
	if ("${sId2}"!=""){
	window.location.href="<%=path%>/ManagerServlet?method=queryMajor&sId=${sId2}&spage=${spage}&mpage=1";
	}
	}
	function skip3(){
	if ("${sId3}"!=""){
	window.location.href="<%=path%>/ManagerServlet?method=queryMajor&sId=${sId3}&spage=${spage}&mpage=1";
	}
	}
	function skip4(){
	if ("${sId4}"!=""){
	window.location.href="<%=path%>/ManagerServlet?method=queryMajor&sId=${sId4}&spage=${spage}&mpage=1";
	}
	}
	function skip5(){
	if ("${sId5}"!=""){
	window.location.href="<%=path%>/ManagerServlet?method=queryMajor&sId=${sId5}&spage=${spage}&mpage=1";
	}
	}
	function skip6(){
	if ("${mId1}"!=""){
	window.location.href="<%=path%>/ManagerServlet?method=queryCourse&mId=${mId1}&nsId=${nsId}&spage=${spage}&mpage=${mpage}&cpage=1";
	}
	}
	function skip7(){
	if ("${mId2}"!=""){
	window.location.href="<%=path%>/ManagerServlet?method=queryCourse&mId=${mId2}&nsId=${nsId}&spage=${spage}&mpage=${mpage}&cpage=1";
	}
	}
	function skip8(){
	if ("${mId3}"!=""){
	window.location.href="<%=path%>/ManagerServlet?method=queryCourse&mId=${mId3}&nsId=${nsId}&spage=${spage}&mpage=${mpage}&cpage=1";
	}
	}
	function skip9(){
	if ("${mId4}"!=""){
	window.location.href="<%=path%>/ManagerServlet?method=queryCourse&mId=${mId4}&nsId=${nsId}&spage=${spage}&mpage=${mpage}&cpage=1";
	}
	}
	function skip10(){
	if ("${mId5}"!=""){
	window.location.href="<%=path%>/ManagerServlet?method=queryCourse&mId=${mId5}&nsId=${nsId}&spage=${spage}&mpage=${mpage}&cpage=1";
	}
	}
	
	//删除
	function deleteSch(){
	if("${nsId}"!=""){
	window.location.href="<%=path%>/ManagerServlet?method=deleteSchool&nsId=${nsId}&spage=${spage}&mpage=${mpage}&cpage=${cpage}";
	}
	else{
	alert("请先选择大学");
	}
	}
	function deleteMaj(){
	if("${nmId}"!=""){
	window.location.href="<%=path%>/ManagerServlet?method=deleteMajor&nsId=${nsId}&nmId=${nmId}&spage=${spage}";
	}
	else{
	alert("请先选择专业");
	}
	}
	function deleteCour(){
	if(document.getElementById("ncId").value!=""){
	var ncId=document.getElementById("ncId").value;
	window.location.href="<%=path%>/ManagerServlet?method=deleteCour&nsId=${nsId}&nmId=${nmId}&ncId="+ncId+"&spage=${spage}&mpage=${mpage}";
	}
	else{
	alert("请先选择课程");
	}
	}
	
	
	//添加功能
	function showAdd(){
	document.getElementById("addSchool").style.display="";
	document.getElementById("addMajor").style.display="none";
	document.getElementById("addCourse").style.display="none";
	}
	function showAddMajor(){
	document.getElementById("addMajor").style.display="";
	document.getElementById("addSchool").style.display="none";
	document.getElementById("addCourse").style.display="none";
	}
	function showAddCourse(){
	document.getElementById("addCourse").style.display="";
	document.getElementById("addSchool").style.display="none";
	document.getElementById("addMajor").style.display="none";
	}
	function closeSchool(){
	document.getElementById("addSchool").style.display="none";
	}
	function closeMajor(){
	document.getElementById("addMajor").style.display="none";
	}
	function closeCourse(){
	document.getElementById("addCourse").style.display="none";
	}
	
	
	//分页
	function page1(){
	if("${spage}"=="1"){
	alert("这是第一页");
	}
	else{
	window.location.href="<%=path%>/ManagerServlet?method=queryAll&spage=${spage-1}";
	}
	}
	function page2(){
	if("${sAllPages}"=="${spage}"){
	alert("这是最后一页");
	}
	else{
	window.location.href="<%=path%>/ManagerServlet?method=queryAll&spage=${spage+1}";
	}
	}
	function page3(){
	if("${mpage}"=="1"){
	alert("这是第一页");
	}
	else{
	window.location.href="<%=path%>/ManagerServlet?method=queryMajor&sId=${nsId}&mpage=${mpage-1}&spage=${spage}";
	}
	}
	function page4(){
	if("${mAllPages}"=="${mpage}"){
	alert("这是最后一页");
	}
	else{
	window.location.href="<%=path%>/ManagerServlet?method=queryMajor&sId=${nsId}&mpage=${mpage+1}&spage=${spage}";
	}
	}
	function page5(){
	if("${cpage}"=="1"){
	alert("这是第一页");
	}
	else{
	window.location.href="<%=path%>/ManagerServlet?method=queryCourse&nsId=${nsId}&mId=${nmId}&mpage=${mpage}&spage=${spage}&cpage=${cpage-1}";
	}
	}
	function page6(){
	if("${cAllPages}"=="${cpage}"){
	alert("这是最后一页");
	}
	else{
	window.location.href="<%=path%>/ManagerServlet?method=queryCourse&nsId=${nsId}&mId=${nmId}&mpage=${mpage}&spage=${spage}&cpage=${cpage+1}";
	}
	}
	
	//输入框检验
	function check(name){
	if(document.getElementById(name).value==""){
	alert("输入不能为空");
	return false;
	}
	else return true;
	}
	</script>
  </head>
  
  <body>
  <div
		style="position:absolute; left: 0;top: 0;height: 100%;width:100%;background: url('img/adminbg.jpg');background-size: 100% 100%">
  <div style="position: absolute;top: 30px;left: 500px;font-size: 30">管理员界面</div>
     <div style="position: absolute;top: 80px;left: 50px;background: #00DDDD;width: 940px;height: 340px"><input type="hidden" value="" id="ncId">
     <div style="position: absolute;top: 0px;left: 0px;background: #AAAAAA;width: 100%;height: 25px">查询结果</div>
     <table cellpadding="10px" cellspacing="0" width="300px"  border="0px solid black" style="position:absolute; left: 20px;top: 60px">
         <tr id="tr1" align="center" onclick="skip1()"><td width="20%">1</td><td width="80%">${schoolN1}</td></tr>
         <tr id="tr2" align="center" onclick="skip2()"><td width="20%">2</td><td width="80%">${schoolN2}</td></tr>
         <tr id="tr3" align="center" onclick="skip3()"><td width="20%">3</td><td width="80%">${schoolN3}</td></tr>
         <tr id="tr4" align="center" onclick="skip4()"><td width="20%">4</td><td width="80%">${schoolN4}</td></tr>
         <tr id="tr5" align="center" onclick="skip5()"><td width="20%">5</td><td width="80%">${schoolN5}</td></tr>
         <tr id="tr16"><td width="30%" align="center"><a onclick="page1()" >上一页</a></td><td width="80%" align="right"><a onclick="page2()">下一页</a></td></tr>
          </table>
          <table cellpadding="10px" cellspacing="0" width="300px"  border="0px solid black" style="position:absolute; left: 320px;top: 60px">
         <tr id="tr6" align="center" onclick="skip6()"><td  width="20%">1</td><td id="td6" width="80%">${majorN1}</td></tr>
         <tr id="tr7" align="center" onclick="skip7()"><td  width="20%">2</td><td id="td7" width="80%">${majorN2}</td></tr>
         <tr id="tr8" align="center" onclick="skip8()"><td  width="20%">3</td><td id="td8" width="80%">${majorN3}</td></tr>
         <tr id="tr9" align="center" onclick="skip9()"><td  width="20%">4</td><td id="td9" width="80%">${majorN4}</td></tr>
         <tr id="tr10" align="center" onclick="skip10()"><td width="20%">5</td><td id="td10" width="80%">${majorN5}</td></tr>
         <tr id="tr17"><td width="30%" align="center"><a onclick="page3()">上一页</a></td><td width="80%" align="right"><a onclick="page4()">下一页</a></td></tr>
          </table>
          <table cellpadding="10px" cellspacing="0" width="300px"  border="0px solid black" style="position:absolute; left: 620px;top: 60px">
         <tr id="tr11" onclick="clickCourse(11)" align="center"><td width="20%">1</td><td id="td11" width="80%">${courseN1}</td></tr>
         <tr id="tr12" onclick="clickCourse(12)" align="center"><td width="20%">2</td><td id="td12" width="20%">${courseN2}</td></tr>
         <tr id="tr13" onclick="clickCourse(13)" align="center"><td width="20%">3</td><td id="td13" width="20%">${courseN3}</td></tr>
         <tr id="tr14" onclick="clickCourse(14)" align="center"><td width="20%">4</td><td id="td14" width="20%">${courseN4}</td></tr>
         <tr id="tr15" onclick="clickCourse(15)" align="center"><td width="20%">5</td><td id="td15" width="20%">${courseN5}</td></tr>
          <tr id="tr18"><td width="30%" align="center"><a onclick="page5()">上一页</a></td><td width="80%" align="right"><a onclick="page6()">下一页</a></td></tr>
          </table>
          </div>
          <div style="position: absolute;top: 80px;left: 1020px;background: #00DDDD;width: 150px;height: 340px">
           <div style="position: absolute;top: 0px;left: 0px;background: #AAAAAA;width: 100%;height: 25px">相关操作</div>
           <div style="position:absolute; left: 20px;top: 60px">
           <input type="button" value="删除所选大学" style="width: 100px" onclick="deleteSch()">
           </div>
           <div style="position:absolute; left: 20px;top: 105px">
           <input type="button" value="删除所选专业" style="width: 100px" onclick="deleteMaj()">
           </div>
           <div style="position:absolute; left: 20px;top: 150px">
           <input type="button" value="删除所选课程" style="width: 100px" onclick="deleteCour()">
           </div>
            <div style="position:absolute; left: 20px;top: 195px">
           <input type="button" value="增加大学" style="width: 100px" onclick="showAdd()">
           </div>
           <div style="position:absolute; left: 20px;top: 240px">
           <input type="button" value="增加对应专业" style="width: 100px" onclick="showAddMajor()">
           </div>
           <div style="position:absolute; left: 20px;top: 285px">
           <input type="button" value="增加对应课程" style="width: 100px" onclick="showAddCourse()">
           </div>
          </div>
          <div id="querySchool" style="position: absolute;left:50px ;top:450px ;width:940px ;height:200px ;background: #00DDDD">
           <div style="position: absolute;top: 0px;left: 0px;background: #AAAAAA;width: 100%;height: 25px">搜索导航</div>
           <div style="position: absolute;top: 100px;left: 100px;width: 100%;height: 150px"><form action="<%=path%>/ManagerServlet?method=querySch" method="post">
             请输入大学名字：<input type="text" name="sname" value="" style="width: 153px;height: 25px">&nbsp;&nbsp;<input type="submit" value="查询大学" style="width: 100px;height: 25px">
    <input type="button" value="查看全部" style="width: 100px;height: 25px" onclick="window.location.href='<%=path%>/ManagerServlet?method=queryAll&spage=1'"></form>
          </div>
          </div>
          
          <div id="addSchool" style="position: absolute;left:50px ;top:450px ;width:940px ;height:200px ;background: #00DDDD;display: none">
           <div style="position: absolute;top: 0px;left: 0px;background: #AAAAAA;width: 100%;height: 25px">添加导航</div>
           <div style="position: absolute;top: 100px;left: 100px;width: 100%;height: 150px"><form action="<%=path%>/ManagerServlet?method=addSch&nsId=${nsId}&nmId=${nmId}" method="post">
             请输入大学名字：<input type="text" id="sname" name="sname" value="" style="width: 153px;height: 25px">&nbsp;&nbsp;<input type="submit" value="确认添加" onclick="return check('sname')" style="width: 100px;height: 25px">
    <input type="button" value="取消操作" style="width: 100px;height: 25px" onclick="closeSchool()"></form>
          </div>
          </div>
          
          <div id="addMajor" style="position: absolute;left:50px ;top:450px ;width:940px ;height:200px ;background: #00DDDD;display: none">
           <div style="position: absolute;top: 0px;left: 0px;background: #AAAAAA;width: 100%;height: 25px">添加导航</div>
           <div style="position: absolute;top: 100px;left: 100px;width: 100%;height: 150px"><form action="<%=path%>/ManagerServlet?method=addMaj&nsId=${nsId}&nmId=${nmId}&spage=${spage}" method="post">
             请输入专业名字：<input type="text" id="mname" name="mname" value="" style="width: 153px;height: 25px">&nbsp;&nbsp;<input type="submit" value="确认添加" onclick="return check('mname')" style="width: 100px;height: 25px">
    <input type="button" value="取消操作" style="width: 100px;height: 25px" onclick="closeMajor()"></form>
          </div>
          </div>
          
           <div id="addCourse" style="position: absolute;left:50px ;top:450px ;width:940px ;height:200px ;background: #00DDDD;display: none">
           <div style="position: absolute;top: 0px;left: 0px;background: #AAAAAA;width: 100%;height: 25px">添加导航</div>
           <div style="position: absolute;top: 100px;left: 100px;width: 100%;height: 150px"><form action="<%=path%>/ManagerServlet?method=addCour&nsId=${nsId}&nmId=${nmId}&spage=${spage}&mpage=${mpage}" method="post">
             请输入课程名字：<input type="text" id="cname" name="cname" value="" style="width: 153px;height: 25px">&nbsp;&nbsp;<input type="submit" onclick="return check('cname')" value="确认添加" style="width: 100px;height: 25px">
    <input type="button" value="取消操作" style="width: 100px;height: 25px" onclick="closeCourse()"></form>
          </div>
          </div>
          </div>
  </body>
</html>
