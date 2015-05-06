<a:page title="Categoria">
	<form action="${empty category ? 'new-category' : 'edit-category' }" method="POST">
		<label for="name">Nome:</label>
		<input class="form-control" type="text" name="name" value="${category.name}" id="name">
		<c:if test="${not empty category}">
			<input type="hidden" name="id" value="${category.id}">
		</c:if>
		<br>
		<input class="btn btn-default" type="submit" value="Cadastrar">
	</form>
</a:page>