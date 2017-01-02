<!doctype html>
<html>

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
		<div style="padding:20px;">
			<a class="btn btn-success btn-mini" onclick="startServer(${server_id})">启动</a>
					<a class="btn btn-danger  btn-mini" onclick="stopServer(${server_id})">停止</a>
					<a class="btn btn-success  btn-mini" onclick="deployWar(${server_id},2)">部署新版本</a>
					<div class="btn-group">
		              <button data-toggle="dropdown" class="btn btn-success dropdown-toggle btn-mini">查看日志 <span class="caret"></span></button>
		              <ul class="dropdown-menu">
		                <li><a href="#" onclick="logConsole(${server_id})" >IFNO</a></li>
		                <li><a href="#">ERROR</a></li>
		              </ul>
		            </div>
			<div class="container-fluid" style="padding:0px;">
				<div class="row-fluid">
					<textarea id="ta" style="width: 99%;height:350px; resize: none; font-size: 10px; " disabled ></textarea>	
				</div>
			</div>		
			<script src="/js/jquery.min.js"></script>
			<script src="/js/jquery.ui.custom.js"></script>
			<script src="/js/bootstrap.min.js"></script>
			<script src="/js/jquery.uniform.js"></script>
			<script src="/js/select2.min.js"></script>
			<script src="/js/jquery.dataTables.min.js"></script>
			<script src="/js/matrix.js"></script>
			<script src="/layer/layer.js"></script>
			<script src="/js/jquery.min.js"></script>
			<script>
				// 部署新版本
				function deployWar(server_id,war_id){
				
					$.ajax({
						type : "POST",
						url : "/server/deploy/"+server_id+"/"+war_id,
						success : function(data) {
							if (data.result == 0) {
								$("#ta").text(data.data);
							}else{
								layer.msg("删除失败 ！",{icon:3});
							}
						}
					});
				}
				// 启动服务
				function startServer(server_id){
				
					$.ajax({
						type : "POST",
						url : "/server/start/"+server_id,
						success : function(data) {
							if (data.result == 0) {
								$("#ta").text(data.data);
							}else{
								layer.msg("删除失败 ！",{icon:3});
							}
						}
					});
				}
				// 停止服务
				function stopServer(server_id){
				
					$.ajax({
						type : "POST",
						url : "/server/stop/"+server_id,
						success : function(data) {
							if (data.result == 0) {
								$("#ta").text(data.data);
							}else{
								layer.msg("删除失败 ！",{icon:3});
							}
						}
					});
				}
				// 查看日志信息
				function logConsole(server_id){
				
					$.ajax({
						type : "POST",
						url : "/server/log/"+server_id,
						success : function(data) {
							if (data.result == 0) {
								getLog(server_id);
							}else{
								layer.msg("删除失败 ！",{icon:3});
							}
						}
					});
					getLog(server_id);
				}
				function getLog(server_id){
					$.ajax({
						type : "POST",
						url : "/server/getlog",
						success : function(data) {
							if (data.result == 0) {
								$("#ta").text(data.data);
								getLog(server_id);
							}else{
								layer.msg("删除失败 ！",{icon:3});
							}
						}
					});
				}
			</script>

	</body>

</html>