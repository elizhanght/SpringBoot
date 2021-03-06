<!DOCTYPE html>
<html lang="en">
    
<head>
        <title>Matrix Admin</title><meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="/css/bootstrap.min.css" />
		<link rel="stylesheet" href="/css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="/css/matrix-login.css" />
        <link href="/font-awesome/css/font-awesome.css" rel="stylesheet" />
		<!--<link href='http://fonts.useso.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>-->

    </head>
    <body>
        <div id="loginbox">            
            <form id="loginform" method="POST" class="form-vertical" action="/login/home">
				 <div class="control-group normal_text"> <h3><img src="/img/logo.png" alt="用户登录" /></h3></div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_lg"><i class="icon-user"></i></span><input name="user_name" type="text" placeholder="用户名" />
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_ly"><i class="icon-lock"></i></span><input name="pass_word" type="password" placeholder="密码" />
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                    <span class="pull-left"><a href="/login/registerpage" class="btn btn-info" id="to-recover">新用户注册</a></span>
                    <span class="pull-right"><input type="submit" value="用户登录"  class="btn btn-success" /> </input></span>
                </div>
            </form>
        </div>
        
        <script src="/js/jquery.min.js"></script>  
        <script src="/js/matrix.login.js"></script> 
    </body>

</html>
