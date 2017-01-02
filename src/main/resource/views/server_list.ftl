<!DOCTYPE html>
<html lang="en">

	<head>
		<title>Matrix Admin</title>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="/css/uniform.css" />
		<link rel="stylesheet" href="/css/select2.css" />
		<link rel="stylesheet" href="/css/matrix-style.css" />
		<link rel="stylesheet" href="/css/matrix-media.css" />
		<link href="/font-awesome/css/font-awesome.css" rel="stylesheet" />
	</head>

	<body>

		<!--Header-part-->
		<div id="header">
			<h1><a href="dashboard.html">Matrix Admin</a></h1>
		</div>
		<!--close-Header-part-->

		<!--top-Header-menu-->
		<div id="user-nav" class="navbar navbar-inverse">
			<ul class="nav">
				<li class="dropdown" id="profile-messages">
					<a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i> <span class="text">${user.user_name}</span><b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li>
							<a href="#"><i class="icon-user"></i> My Profile</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="#"><i class="icon-check"></i> My Tasks</a>
						</li>
						<li class="divider"></li>
						<li>
							<a href="/login/logout"><i class="icon-key"></i> Log Out</a>
						</li>
					</ul>
				</li>
				<li class="dropdown" id="menu-messages">
					<a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">5</span> <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li>
							<a class="sAdd" title="" href="#"><i class="icon-plus"></i> new message</a>
						</li>
						<li class="divider"></li>
						<li>
							<a class="sInbox" title="" href="#"><i class="icon-envelope"></i> inbox</a>
						</li>
						<li class="divider"></li>
						<li>
							<a class="sOutbox" title="" href="#"><i class="icon-arrow-up"></i> outbox</a>
						</li>
						<li class="divider"></li>
						<li>
							<a class="sTrash" title="" href="#"><i class="icon-trash"></i> trash</a>
						</li>
					</ul>
				</li>
				<li class="">
					<a title="" href="#"><i class="icon icon-cog"></i> <span class="text">Settings</span></a>
				</li>
				<li class="">
					<a title="" href="/login/logout"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a>
				</li>
			</ul>
		</div>

		<!--start-top-serch-->
		<div id="search">
			<input type="text" placeholder="Search here..." />
			<button type="submit" class="tip-bottom" title="Search"><i class="icon-search icon-white"></i></button>
		</div>
		<!--close-top-serch-->

		<!--sidebar-menu-->

		<div id="sidebar">
			<a href="#" class="visible-phone"><i class="icon icon-th"></i>Tables</a>
			<ul>
				<li>
					<a href="/project/list"><i class="icon icon-home"></i> <span>配置管理</span></a>
				</li>
				<li class="active">
					<a href="/project/deploy_list"><i class="icon icon-home"></i> <span>部署管理</span></a>
				</li>
			</ul>
		</div>
		<div id="content">
			<div id="content-header">
				<div id="breadcrumb">
					<a href="/login/index" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
					<a href="/project/list" title="Go to Home" class="tip-bottom"> 项目列表</a>
					<a href="#" class="current">服务器列表</a>
				</div>
				<!--<h1>Tables</h1>-->
			</div>
			<div class="container-fluid">
				<hr>
				<a class="btn btn-success" href="/server/addpage?project_id=${project_id}">添加服务器</a>
				<a href="#myModal" onclick="openPackage()" data-toggle="modal" class="btn btn-success">War包管理</a>
				
				<div class="row-fluid">
					<div class="span12">
						<div class="widget-box">
							<div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
								<h5>服务器列表</h5>
							</div>
							<div class="widget-content nopadding">
								<table class="table table-bordered table-striped">
									<thead>
										<tr>
											<th>服务器名称</th>
											<th>TOMCAT目录</th>
											<th>服务器IP</th>
											<th>用户名</th>
											<th>密码</th>
											<th>描述</th>
											<th style="width: 100px;">操作</th>
										</tr>
									</thead>
									<tbody>
										<#list servers as server >
											<tr class="odd gradeX">
												<td>${server.server_name}</td>
												<td>${server.tomcat_dir}</td>
												<td>${server.server_ip}</td>
												<td>${server.server_user}</td>
												<td>${server.server_pwd}</td>
												<td>${server.server_desc}</td>
												<td>
													<a class="btn btn-success btn-mini" onclick="logServer(${server.server_id})">控制台</a>
													<a class="btn btn-danger btn-mini" onclick="logServer(${server.server_id})">删除</a>
												</td>
											</tr>
										</#list>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--Footer-part-->
			<div class="row-fluid">
				<div id="footer" class="span12"> 2013 &copy; Matrix Admin. Brought to you by
					<a href="http://themedesigner.in/">Themedesigner.in</a>
				</div>
			</div>
			<!--end-Footer-part-->
			<script src="/js/jquery.min.js"></script>
			<script src="/js/jquery.ui.custom.js"></script>
			<script src="/js/bootstrap.min.js"></script>
			<script src="/js/jquery.uniform.js"></script>
			<script src="/js/select2.min.js"></script>
			<script src="/js/jquery.dataTables.min.js"></script>
			<script src="/js/matrix.js"></script>
			<script src="/js/matrix.tables.js"></script>
			<script src="/layer/layer.js"></script>
			<script type="text/javascript">
				
				function openPackage(){
					layer.open({
					  title:"WAR包列表",
					  type: 2,
					  area: ['700px', '530px'],
					  fixed: false, //不固定
					  maxmin: false,
					  content: '/war/packagepage/${project_id}'
					});
				}
				
				// 日志服务
				function logServer(server_id){
					layer.open({
					  title:"WAR包列表",
					  type: 2,
					  area: ['700px', '530px'],
					  fixed: false, //不固定
					  maxmin: false,
					  content: '/server/logpage/'+server_id
					});
				}
			</script>
	</body>

</html>