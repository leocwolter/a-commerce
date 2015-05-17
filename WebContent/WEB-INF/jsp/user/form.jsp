<a:page title="Perfil">
	<form action="${empty loggedUser ? 'sign-up' : 'edit-profile' }" method="POST">
		<label for="email">Email:</label>
		<input class="form-control" type="text" name="email" value="${loggedUser.email}" id="email">
		<br>
		<label for="password">Senha:</label>
		<input class="form-control" type="password" name="password" id="password">
		<br>
		<input class="btn btn-default" type="submit" value="Confirmar">
	</form>
</a:page>