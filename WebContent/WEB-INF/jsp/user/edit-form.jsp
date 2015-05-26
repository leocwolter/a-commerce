<a:page title="Perfil">
	<c:set var="userToEdit" value="${empty user ? loggedUser : user }"/>
	<form action="<c:url value="/edit-user" />" method="POST">
		<label for="email">Email:</label>
		<input required class="form-control" type="text" name="email" value="${userToEdit.email}" id="email">
		<br>
		<label for="password">Senha:</label>
		<input required class="form-control" type="password" name="password" id="password">
		<br>
		<c:if test="${not empty user}">
			<input type="hidden" value="${user.id}" name="id">
		</c:if>
		
		<input required class="btn btn-default" type="submit" value="Confirmar">
	</form>
</a:page>