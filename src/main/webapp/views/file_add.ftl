<!DOCTYPE html>
<html lang="en">

	<head>
		<title>Matrix Admin</title>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/bootstrap-responsive.min.css" />
		<link rel="stylesheet" href="/css/colorpicker.css" />
		<link rel="stylesheet" href="/css/datepicker.css" />
		<link rel="stylesheet" href="/css/uniform.css" />
		<link rel="stylesheet" href="/css/select2.css" />
		<link rel="stylesheet" href="/css/matrix-style.css" />
		<link rel="stylesheet" href="/css/matrix-media.css" />
		<link rel="stylesheet" href="/css/bootstrap-wysihtml5.css" />
		<link href="/font-awesome/css/font-awesome.css" rel="stylesheet" />
		<!--<link href='http://fonts.useso.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>-->
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
					<a title="" href="#" data-toggle="dropdown" data-target="#profile-messages" class="dropdown-toggle"><i class="icon icon-user"></i> <span class="text">Welcome User</span><b class="caret"></b></a>
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
					<a title="" href="login.html"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a>
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
			<a href="#" class="visible-phone"><i class="icon icon-list"></i>Forms</a>
			<ul>
				<li class="active">
					<a href="/project/list"><i class="icon icon-home"></i> <span>项目管理</span></a>
				</li>
			</ul>
		</div>

		<!--close-left-menu-stats-sidebar-->

		<div id="content">
			<div id="content-header">
				<div id="breadcrumb">
					<a href="/login/home" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>
					<a href="#" class="current">添加文件</a>
				</div>
				<h1>添加文件</h1>
			</div>
			<div class="container-fluid">
				<hr>
				<div class="row-fluid">
					<div class="span6">
						<div class="widget-box">
							<div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
							</div>
							<div class="widget-content nopadding">
								<form action="/file/add" method="post" class="form-horizontal">
									<div class="control-group">
										<label class="control-label">文件名称 :</label>
										<div class="controls">
											<input type="text" class="span11" placeholder="First name" name="file_name" />
										</div>
									</div>
									<div class="control-group" style="display:none;">
										<label class="control-label">项目ID :</label>
										<div class="controls">
											<input type="text" class="span11" value="${project_id}" name="project_id" />
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">文件描述 :</label>
										<div class="controls">
											<input type="text" class="span11" placeholder="项目描述" name="project_id" />
										</div>
									</div>
									<div class="form-actions">
										<button type="submit" class="btn btn-success">Save</button>
									</div>
								</form>
							</div>
						</div>
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
		<script src="/js/bootstrap-colorpicker.js"></script>
		<script src="/js/bootstrap-datepicker.js"></script>
		<script src="/js/jquery.toggle.buttons.html"></script>
		<script src="/js/masked.js"></script>
		<script src="/js/jquery.uniform.js"></script>
		<script src="/js/select2.min.js"></script>
		<script src="/js/matrix.js"></script>
		<script src="/js/matrix.form_common.js"></script>
		<script src="/js/wysihtml5-0.3.0.js"></script>
		<script src="/js/jquery.peity.min.js"></script>
		<script src="/js/bootstrap-wysihtml5.js"></script>
		<script>
			$('.textarea_editor').wysihtml5();
		</script>
	</body>

</html>