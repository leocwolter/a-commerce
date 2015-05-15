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
		<label for="publisher">Editora:</label>
		<select  class="form-control" name="publisher" id="publisher">
			<c:forEach items="${publishers}" var="publisher">
				<option value="${publisher.id}" ${book.isPublishedBy(publisher) ? 'selected' : '' }>${publisher.name}</option>
			</c:forEach>
		</select>
		<br>		
		<label for="price">Preço:</label>
		<input type="text" class="form-control" name="price" value="${book.price}" id="price">
		<br>	
		<label for="authors">Autores:</label>
		<select  class="form-control" multiple name="authors" id="authors">
			<c:forEach items="${authors}" var="author">
				<option value="${author.id}" ${book.isWrittenBy(author) ? 'selected' : '' }>${author.name}</option>
			</c:forEach>
		</select>
		<br>	
		<label for="synopsis">Sinopse:</label>
		<textarea class="form-control" name="synopsis" id="synopsis">${book.synopsis}</textarea>
		<br>	
		<label for="toc">Tabela de conteúdo:</label>
		<textarea class="form-control" name="toc" id="toc">${book.toc}</textarea>
		<br>	
		<label for="length">Tamanho(em páginas):</label>
		<input type="number" class="form-control" name="length" value="${book.length}" id="length" min="1">
		<br>	
		<label for="language">Idioma:</label>
		<input type="text" class="form-control" name="language" value="${book.language}" id="language">
		<br>	
		<c:if test="${not empty book.id}">
			<input type="hidden" class="form-control" name="id" value="${book.id}">
		</c:if>
		<input class="btn btn-default" type="submit" value="Cadastrar">
	</form>
</a:page>