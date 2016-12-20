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
							<a href="login.html"><i class="icon-key"></i> Log Out</a>
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
				<li class="active">
					<a href="/project/list"><i class="icon icon-home"></i> <span>项目管理</span></a>
				</li>
			</ul>
		</div>
		<div id="content">
			<div id="content-header">
				<div id="breadcrumb">
					<a href="/login/index" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
					<a href="/project/list" title="Go to Home" > 项目列表</a>
					<a href="/file/list?project_id=${project_id}" >文件列表</a>
					<a href="#" class="current">属性列表</a>
				</div>
				<!--<h1>Tables</h1>-->
			</div>
			<div class="container-fluid">
				<hr>
				<a class="btn btn-success" href="/property/addpage?file_id=${file_id}&project_id=#{project_id}">添加属性</a>
				<div class="row-fluid">
					<div class="span12">
						<div class="widget-box">
							<div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
								<h5>属性列表</h5>
							</div>
							<div class="widget-content nopadding">
								<table class="table table-bordered table-striped">
									<thead>
										<tr>
											<th>属性KEY</th>
											<th>属性VALUE</th>
											<th style="width: 200px;">操作</th>
										</tr>
									</thead>
									<tbody>
										<#list properties as property >
											<tr class="odd gradeX">
												<td>${property.pro_key}</td>
												<td>${property.pro_value}</td>
												<td>
													<a class="btn btn-success btn-mini" href="/property/editpage?keyvalue_id=#{property.keyvalue_id}&project_id=#{project_id}">编辑</a>
													<a class="btn btn-danger  btn-mini" href="/property/delete?project_id=${project_id}&file_id=${property.file_id}&keyvalue_id=${property.keyvalue_id}">删除</a>
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
	</body>

</html>