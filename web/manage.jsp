<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html lang="zh-CN">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<!-- Bootstrap CSS -->
	<!--link rel="stylesheet"
          href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous"-->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<title>汽车调查问卷后台管理系统</title>
	<style>
		body{
			text-align: center;
		}

		.row img{
			height: 150px;
			width: 100px;
			margin-top: 10px;
		}

		.row .img-wrap{
			display: block;
			margin: 0 auto;
			width: 150px;
			height: 160px;
			background: #DDE5ED;
		}

		.row .content-wrap{
			width: 150px;
			margin: 0 auto;
			background-color: #fff;
			box-sizing: border-box;
			border: 1px solid #eaeaea;
		}

		.row .content-wrap h4{
			display: block;
		}

		.col-xs-6 , .col-md-4{
			height: 222px;
			margin-bottom: 10px;
		}

		#add button{
			margin: 0;
			padding: 0;
			width: 150px;
			height: 150px
		}

		#add{
			margin: 0 auto;
		}
	</style>
</head>
<body>
<jsp:include page="head.jsp"/>
<%--<iframe src="head.jsp" width="100%"></iframe>--%>

<div class=".container" style="margin: 0 auto; width: 80%">
	<div class="row">
		<s:iterator value="backstages" var="backstage">
			<div class="col-xs-6 col-md-4">
				<div class="img-wrap" onclick="location.href='${pageContext.request.contextPath}/select?surveyID=${backstage.surveyID}'">
					<img class="img-rounded" src="images/${backstage.image_name}">
				</div>
				<div class="content-wrap">
					<h5>${backstage.title}</h5>
					<h6>已有${backstage.member_nums}人参加此问卷</h6>
				</div>
			</div>
		</s:iterator>
		<div class="col-xs-6 col-md-4">
			<div id="add">
				<button type="button" class="btn btn-default btn-lg" onclick="location.href='${pageContext.request.contextPath}/add'">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 添加问卷
				</button>
			</div>
		</div>
	</div>
</div>

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script
		src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</body>
</html>