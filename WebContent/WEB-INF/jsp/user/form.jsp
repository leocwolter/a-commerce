<a:page title="Perfil">
	<form action="${empty loggedUser ? 'sign-up' : 'edit-user' }" method="POST">
		<label for="email">Email:</label>
		<input required class="form-control" type="text" name="email" value="${loggedUser.email}" id="email">
		<br>
		<label for="password">Senha:</label>
		<input required class="form-control" type="password" name="password" id="password">
		<br>
		<input required class="btn btn-default" type="submit" value="Confirmar">
	</form>
</a:page>