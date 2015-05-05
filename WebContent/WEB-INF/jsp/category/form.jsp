<a:page title="Categoria">
	<form action="${empty category ? 'new-category' : 'edit-category' }" method="POST">
		<label>
			Nome:
			<input type="text" name="name" value="${category.name}">
			<c:if test="${not empty category}">
				<input type="hidden" name="id" value="${category.id}">
			</c:if>
		</label>
		<input type="submit" value="Cadastrar">
	</form>
</a:page>