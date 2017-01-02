<!doctype html>
<html>

	<head>
		<title>Matrix Admin</title>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/jquery.fileupload.css" />
	</head>

	<body>
		<div id="content">
			<div class="container-fluid">
				<hr>
				<div>
					<div class="progress progress-striped" style="width:520px;float:left;height:30px;">
						<div style="width: 0%;" class="bar"></div>
					</div>
					<span class="btn btn-success fileinput-button" style="float:right;">
				        <i class="glyphicon glyphicon-plus"></i>
				        <span>Select files...</span>
						<input id="fileupload" type="file" name="file" data-url="/war/upload/${project_id}" style="width:90px;" multiple>
					</span>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<div class="widget-box">
							<div class="widget-title"> <span class="icon"> <i class="icon-th"></i> </span>
							</div>
							<div class="widget-content nopadding" style="height:200px;">
								<table class="table table-bordered table-striped">
									<thead>
										<tr>
											<th>名称</th>
											<th>上传时间</th>
										</tr>
									</thead>
									<tbody>
										<#list wars as war >
											<tr class="odd gradeX">
												<td>${war.file_name}</td>
												<td>${war.timestamp}</td>
											</tr>
										</#list>

									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
			<script src="/js/jquery.min.js"></script>
			<script src="/js/jquery.ui.widget.js"></script>
			<script src="/js/jquery.iframe-transport.js"></script>
			<script src="/js/jquery.fileupload.js"></script>
			<script src="/js/bootstrap.min.js"></script>
			<script>
				$(function() {
					$('#fileupload').fileupload({
						dataType: 'json',
						done: function(e, data) {
							document.location.href="/war/packagepage/"+data.result;
						},
						progressall: function(e, data) {
							var progress = parseInt(data.loaded / data.total * 100);
							$('.bar').css('width',progress + '%');
						}
					});
				});
			</script>

	</body>

</html>