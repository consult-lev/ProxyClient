<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="вход">
<meta name="author" content="dev">
<title>Вход</title>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="resources/libs/jquery-2.2.4.js" type="text/javascript"></script>
</head>

<body>

	<div class="container">

		<form class="form-signin" id="loginForm" action="http://localhost:8081/login" method="post">
			<h2 class="form-signin-heading">Вход</h2>
			<label for="username" class="sr-only">Имя пользователя</label> <input type="text" id="username" name="username" class="form-control"
				placeholder="Имя пользователя" required autofocus> <label for="password" class="sr-only">Пароль</label> <input type="password" id="password"
				name="password" class="form-control" placeholder="Пароль" required>
			<div class="checkbox hide">
				<!-- todo -->
				<label> <input type="checkbox" value="remember-me"> Remember me
				</label>
			</div>
			<!-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> -->
			<button class="btn btn-lg btn-primary btn-block" type="submit">Вход</button>
		</form>

		<script type="text/javascript">
			if (true)
				return;
			$("#loginForm").submit(function(e) {
				e.preventDefault();
				$.ajax({
					url : "http://localhost:8081/login",
					beforeSend : function(xhr) {
						xhr.withCredentials = true;
					},
					type : "POST",
					data : jQuery("#loginForm").serialize(),
					dataType : 'json',
					success : function(data, status) {
						console.log(data);
					},
					error : function(data, status) {
						console.log(data);
					},
				});
			});
		</script>

	</div>
</body>
</html>