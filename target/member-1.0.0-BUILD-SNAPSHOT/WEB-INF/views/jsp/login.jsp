<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>SysInfoEye</title>

		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mainstyle.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />

		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.cookie.js" ></script>
				
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
	    <script type="text/javascript">

			if("${resultFlag}" == "0"){
				alert("사용자 정보를 정확하게 입력하세요...!!!");
			}
		
		
			function sendform(){
				var frm = document.login;
				
				frm.userId.value = "sysinfoeye";
				frm.userPwd.value = "1234qwer";
				
				if(frm.userId.value == null || frm.userId.value == ""){
					alert("사용자 ID를 입력 하세요..!!!");
					return;
				}
				else if(frm.userPwd.value == null || frm.userPwd.value == ""){
					alert("사용자 암호를 입력 하세요..!!!");
					return;
				}
				
				frm.action = "${pageContext.request.contextPath}/loginProc";
				frm.submit();
			}
			</script>
	</head>

	<body>
		<div id="head">
			<div id="title">SPTek-Shopping
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
					<li><a href="${pageContext.request.contextPath}/svrInfoSelect">환경설정</a></li>
				</ul>
			</div>
		</div>
		<div id="body_wrapper">
			<div id="body">
				<div id="all">
					<div class="top"></div>
					<div class="content">
						<!--내용테이블 끝--->
						<FORM name="login" id="login" method=post>
						<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td align="center" valign="middle">
									<table width="552" height="322" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td colspan="3" bgcolor="#A9A9A9" height="1"></td>
										</tr>			
										<tr>
											<td bgcolor="#C2C2C2" width="1" height="322"></td>
											<td align="center" valign="middle">
												<table width="531" height="307" border="0" cellspacing="0" cellpadding="0">
													<tr>
														<td colspan="2"><img src="${pageContext.request.contextPath}/images/login_img/top_login_img.jpg" width="531" height="170"></td>
													</tr>							
													<tr>
														<td><img src="${pageContext.request.contextPath}/images/login_img/logo2.gif" width="235" height="86"></td>
														<td width="296" height="106" align="center" bgcolor="#E6F5FF">
															<table width="296" border="0" cellspacing="0" cellpadding="0">
																<tr>
																	<td rowspan="3" width="20"></td>
																	<td width="70"><img src="${pageContext.request.contextPath}/images/login_img/login_id.gif" width="50" height="20"></td>
																	<td width="150"><INPUT type="text" id="userId" name="userId" onkeypress="if(event.keyCode==13) javascript:sendform();" class="style1" style="width:120px"></td>
																	<td width="66" rowspan="2">
																		<img src="${pageContext.request.contextPath}/images/login_img/btn_login.gif" width="50" height="49" style="cursor:hand;" onclick="javascript:sendform(); return false;">
																		</td>
																</tr>
																<tr>
																	<td><img src="${pageContext.request.contextPath}/images/login_img/login_pass.gif" width="50" height="20"></td>
																	<td><INPUT type="password" id="userPwd" name="userPwd" onkeypress="if(event.keyCode==13) javascript:sendform();" class="style1" style="width:120px" ></td>
																</tr>
																<tr>
																	<td>&nbsp;</td>
																	<td align="left"></td>
																	<td>&nbsp;</td>
																</tr>										
															</table>
														</td>
													</tr>
													<tr>
														<td colspan="2"><img src="${pageContext.request.contextPath}/images/login_img/login_img_bottom.gif" width="531" height="25"></td>
													</tr>
												</table>
											</td>
											<td bgcolor="#C2C2C2" width="1" height="322"></td>
										</tr>
										<tr>
											<td colspan="3" bgcolor="#A9A9A9" height="1"></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
						</FORM>
						<!--내용테이블 끝--->
						<table>
							<tr>
								<td height="100">
									&nbsp;
								</td>
							</tr>	
						</table>

					</div>
					<div class="bottom"></div>
				</div>
				 <div class="clearer"></div>
			</div>
			 <div class="clearer"></div>
		</div>
		<div id="end_body"></div>
    
  	</body>
</html>