<a:page title="Perfil">
	<p>
		<label>Email:</label>
		${loggedUser.email}
	</p>
	<a href="<c:url value="/edit-user"/>" class="btn btn-primary" role="button">Editar</a>
	<a href="<c:url value="/delete-user"/>" class="btn btn-danger" role="button">Deletar</a>
</a:page>