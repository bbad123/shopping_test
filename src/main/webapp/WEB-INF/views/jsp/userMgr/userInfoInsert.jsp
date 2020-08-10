<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>SysInfoEye</title>

		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mainstyle.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.treeview.css" />

		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.cookie.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.treeview.js" ></script>
	
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
	    <script type="text/javascript">
			$(document).ready(function() {
				
				$("#insertUserInfo").click(function() {
					
					if ( $("#userId").get(0).value == null || $("#userId").get(0).value == ""){
						alert("서버 IP을 입력 하세요.");
						return;
					}
					
					if ( $("#userPwd").get(0).value == null || $("#userPwd").get(0).value == ""){
						alert("서버 IP을 입력 하세요.");
						return;
					}
					
					if ( $("#userMail").get(0).value == null || $("#userMail").get(0).value == ""){
						alert("서버 IP을 입력 하세요.");
						return;
					}
					
					if ( $("#userSms").get(0).value == null || $("#userSms").get(0).value == ""){
						alert("서버 IP을 입력 하세요.");
						return;
					}
					
					
					$('#saveUserInfofrm').attr("action", "${pageContext.request.contextPath}/userInfoSave");
					$('#saveUserInfofrm').submit();
				});
				
				$("#cancelUserInfo").click(function() {
					$('#cancelUserInfoFrm').attr("action", "${pageContext.request.contextPath}/userInfoSelect");
					$('#cancelUserInfoFrm').submit();
				});
				
			});
		</script>
	</head>

	<body>
		<div id="head">
			<div id="title">SysInfoEye
				<table width="100" border="0"	cellspacing="0"	cellpadding="0" align="center">
					<tr>
						<td	style='text-align:right'">
							&nbsp;
						</td>
					</tr>
				</table>		
			</div>
			<div id="menu">
				<ul>
					<li><a href="${pageContext.request.contextPath}/summaryInfo">DashBoard</a></li>
					<li><a href="${pageContext.request.contextPath}/logInfoSelect">검사로그</a></li>
					<li class="active"><a href="${pageContext.request.contextPath}/userInfoSelect">환경설정</a></li>
				</ul>
			</div>
		</div>
		<div id="body_wrapper">
			<div id="body">
				<div id="left">
					<div class="top"></div>
					<div class="content">
					<table border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td valign="top">
						<!--컨텐츠 시작--->
							<table width="680" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td>
										<!--현재위치--->
										<table width=650 border="0" cellpadding="0" cellspacing="0" align="center">
											<tr>
												<td width="2%" height="28"><div align="left"><img src="${pageContext.request.contextPath}/images/link_left.gif" width="23" height="28"></div></td>
												<td width="98%" background="${pageContext.request.contextPath}/images/link_center.gif" class="submenu_ti">
													환경설정  &gt; 사용자설정 &gt;<strong>사용자설정등록</strong>
												</td>
												<td width="0%"><div align="right"><img src="${pageContext.request.contextPath}/images/link_right.gif" width="8" height="28"></div></td>
											</tr>
										</table>
										<!--현재위치 끝--->
									</td>
								</tr>
								<tr>
				  					<td>
										<!--서브타이틀--->         
										<table width="650" border="0"	cellspacing="0"	cellpadding="0" align="center">
											<tr>
												<td	height="34"	background="${pageContext.request.contextPath}/images/center_title_bg.gif">
													<img src ="${pageContext.request.contextPath}/images/step_4.gif" border=0> <strong>사용자설정</strong>
												</td>
												<td	style='text-align:right' background="${pageContext.request.contextPath}/images/center_title_bg.gif">
													<a href="#" id="insertUserInfo"><img src="${pageContext.request.contextPath}/images/bt/bt_save.gif" width="73" height="28" ></a>
													<a href="#" id="cancelUserInfo"><img src="${pageContext.request.contextPath}/images/bt/bt_cancel.gif"  width="73" height="28"></a>
												</td>
											</tr>
										</table>
										<!--서브타이틀	끝--->
									</td>
								</tr>	
								<tr>
									<td>
										<!--내용테이블 시작--->
										<form id="saveUserInfofrm" name="saveUserInfofrm" method="get">
										<input type="hidden" name="currentPage" id="currentPage" value="${Condition.currentPage}"/>
										<table width="650" border="0" cellspacing="0" cellpadding="0" class="table" valign="top" align="center">
											<tr>
												<th width="130" class="log_th"><strong>사용자이름</strong></th>
												<th width="130" class="log_th"><strong>사용자ID*</strong></th>
												<th width="130" class="log_th"><strong>사용자PWD*</strong></th>
												<th width="130" class="log_th"><strong>사용자 E-Mail*</strong></th>
												<th width="130" class="log_th"><strong>사용자 SMS*</strong></th>
											</tr>
											<tr	bgcolor='#FBFBFB'>
												<td align="center"><input type="text" name="userNm" id="userNm" title="사용자이름" class="style1" style="width:130px"></td>
												<td align="center"><input type="text" name="userId" id="userId" title="사용자ID" class="style1" style="width:130px"></td>
												<td align="center"><input type="password" name="userPwd" id="userPwd" title="사용자 암호" class="style1" style="width:130px"></td>
												<td align="center"><input type="text" name="userMail" id="userMail" title="이메일" class="style1" style="width:130px"></td>
												<td align="center"><input type="text" name="userSms" id="userSms" title="연락처" class="style1" style="width:130px"></td>
											</tr>
										</table>
										</form>
										<!--내용테이블 끝--->
									</td>
								</tr>
								<tr>
									<td height="350">
										<form id="cancelUserInfoFrm" name="cancelUserInfoFrm" method="get">
			  							</form>
										&nbsp;
									</td>
								</tr>	
							</table>
							<!--컨텐츠 끝--->
						</td>
					</tr>
					</table>
					</div>
					<div class="bottom"></div>
				</div>
				<div id="right">
					<div class="top"></div>
					<div class="content">
						<h4><img src ="${pageContext.request.contextPath}/images/left_location.gif" border=0> 환경설정</h4>
						<ul>
						  <li><a href="${pageContext.request.contextPath}/svrInfoSelect"><img src ="${pageContext.request.contextPath}/images/minus.gif" border=0> 대상서버설정</a></li>
						  <li><a href="${pageContext.request.contextPath}/userInfoSelect"><img src ="${pageContext.request.contextPath}/images/minus.gif" border=0> 사용자 설정</a></li>
						  <li><a href="${pageContext.request.contextPath}/limitInfoSelect"><img src ="${pageContext.request.contextPath}/images/minus.gif" border=0> 임계치 설정</a></li>
						  <li><a href="${pageContext.request.contextPath}/logout"><img src ="${pageContext.request.contextPath}/images/minus.gif" border=0> 로그아웃</a></li>
						</ul>
						
					</div>
					<div class="bottom"></div>
				</div>
			</div>
		</div>
		<div id="end_body"></div>
    
  	</body>
</html>