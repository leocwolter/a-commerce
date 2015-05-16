<a:page title="Livro: ${book.name}">
	<h2>${book.name}</h2>
	<p>
		<label>Preço:</label>
		<fmt:formatNumber value="${book.price}" minFractionDigits="2" type="currency"/>
	</p>
	<p>
		<label>Categorias:</label>
		${book.categoriesAsString}
	</p>
	<p>
		<label>Editora:</label>
		${book.publisher.name}
	</p>
	<p>
		<label>Editora:</label>
		${book.authorsAsString}
	</p>
	<p>
		<label>Sinopse:</label>
		${book.synopsis}
	</p>
	<p>
		<label>Tabela de conteúdo:</label>
		${book.toc}
	</p>
	<p>
		<label>Tamanho:</label>
		${book.length}
	</p>
	<p>
		<label>Idioma:</label>
		${book.language}
	</p>
	<a href="<c:url value="/add-to-cart?id=${book.id}"/>" class="btn btn-primary" role="button">Comprar</a>
</a:page>
