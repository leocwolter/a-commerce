<a:page title="Livro">
	<c:set var="canCreateBook" value="${not empty categories && not empty authors && not empty publishers}"/>
	<c:if test="${not canCreateBook}">
		<h1>Você precisa criar categorias, autores e ao menos uma editora para conseguir cadastrar um livro</h1>
	</c:if>
	<c:if test="${canCreateBook}">
		<form action="${empty book ? 'new-book' : 'edit-book' }" method="POST">
			<label for="name">Nome:</label>
			<input required type="text" class="form-control" name="name" value="${book.name}" id="name">
			<br>		
			<label for="categories">Selecione as Categorias:</label>
			<select required class="form-control" multiple name="categories" id="categories">
				<c:forEach items="${categories}" var="category">
					<option value="${category.id}" ${book.contains(category) ? 'selected' : '' }>${category.name}</option>
				</c:forEach>
			</select>
			<br>		
			<label for="publisher">Selecione uma Editora:</label>
			<select required class="form-control" name="publisher" id="publisher">
				<c:forEach items="${publishers}" var="publisher">
					<option value="${publisher.id}" ${book.isPublishedBy(publisher) ? 'selected' : '' }>${publisher.name}</option>
				</c:forEach>
			</select>
			<br>		
			<label for="price">Preço:</label>
			<input required type="text" class="form-control" name="price" value="${book.price}" id="price">
			<br>	
			<label for="authors">Selecione os Autores:</label>
			<select required class="form-control" multiple name="authors" id="authors">
				<c:forEach items="${authors}" var="author">
					<option value="${author.id}" ${book.isWrittenBy(author) ? 'selected' : '' }>${author.name}</option>
				</c:forEach>
			</select>
			<br>	
			<label for="synopsis">Sinopse:</label>
			<textarea required class="form-control" name="synopsis" id="synopsis">${book.synopsis}</textarea>
			<br>	
			<label for="toc">Tabela de conteúdo:</label>
			<textarea required class="form-control" name="toc" id="toc">${book.toc}</textarea>
			<br>	
			<label for="length">Tamanho(em páginas):</label>
			<input required type="number" class="form-control" name="length" value="${book.length}" id="length" min="1">
			<br>	
			<label for="language">Idioma:</label>
			<input required type="text" class="form-control" name="language" value="${book.language}" id="language">
			<br>	
			<c:if test="${not empty book.id}">
				<input type="hidden" class="form-control" name="id" value="${book.id}">
			</c:if>
			<input class="btn btn-default" type="submit" value="Cadastrar">
		</form>
	</c:if>
</a:page>