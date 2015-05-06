<a:page title="Livro">
	<form action="${empty book ? 'new-book' : 'edit-book' }" method="POST">
		<label for="name">Nome:</label>
		<input type="text" class="form-control" name="name" value="${book.name}" id="name">
		<br>		
		<label for="categories">Categorias:</label>
		<select  class="form-control" multiple name="categories" id="categories">
			<c:forEach items="${categories}" var="category">
				<option value="${category.id}" ${book.contains(category) ? 'selected' : '' }>${category.name}</option>
			</c:forEach>
		</select>
		<br>		
		<label for="price">Preço:</label>
		<input type="text" class="form-control" name="price" value="${book.price}" id="price">
		<br>		
		<label for="authors">Autores:</label>
		<input type="text" class="form-control" name="authors" value="${book.authors}" id="authors">
		<br>		
		<c:if test="${not empty book.id}">
			<input type="hidden" class="form-control" name="id" value="${book.id}">
		</c:if>
		<input class="btn btn-default" type="submit" value="Cadastrar">
	</form>
</a:page>