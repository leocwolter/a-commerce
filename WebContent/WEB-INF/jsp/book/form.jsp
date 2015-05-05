<a:page title="Livro">
	<form action="${empty book ? 'new-book' : 'edit-book' }" method="POST">
		<label>
			Nome:
			<input type="text" name="name" value="${book.name}">
		</label>
		<label>
			Categorias:
			<select multiple name="categories">
				<c:forEach items="${categories}" var="category">
					<option value="${category.id}" ${book.contains(category) ? 'selected' : '' }>${category.name}</option>
				</c:forEach>
			</select>
			
		</label>
		<label>
			Preço:
			<input type="text" name="price" value="${book.price}">
		</label>
		<label>
			Autores:
			<input type="text" name="authors" value="${book.authors}">
		</label>
		<c:if test="${not empty book.id}">
			<input type="hidden" name="id" value="${book.id}">
		</c:if>
		
		<input type="submit" value="Cadastrar">
	</form>
</a:page>