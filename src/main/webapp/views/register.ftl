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
            <form id="loginform" method="POST" class="form-vertical" action="/login/register">
				 <div class="control-group normal_text"> <h3><img src="/img/logo.png" alt="用户注册" /></h3></div>
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
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_ly"><i class="icon-envelope"></i></span><input name="email" type="text" placeholder="邮箱" />
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                	<span class="pull-left"><a href="/login/page" class="flip-link btn btn-success" id="to-login">&laquo; Back to login</a></span>
                    <span class="pull-right"><input type="submit" value="注册新用户"  class="btn btn-success" /> </input></span>
                </div>
            </form>
        </div>
        
        <script src="/js/jquery.min.js"></script>  
        <script src="/js/matrix.login.js"></script> 
    </body>

</html>
