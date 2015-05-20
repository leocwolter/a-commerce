<a:page title="Busca avançada">
	<h2>Selecione pelo que quer buscar: </h2>
	<br>
	<form action="<c:url value="/advanced-search"/>" method="POST">
		<div class="checkbox">
			<label><input type="checkbox" name="query-tables" value="PUBLISHER">Nome da editora</label>
		</div>
		<div class="checkbox"> 
			<label><input type="checkbox" name="query-tables" value="AUTHOR">Nome do autor</label>
		</div>
		<div class="checkbox">	 
			<label><input type="checkbox" name="query-tables" value="BOOK">Nome do livro</label> 
		</div>
		<div class="checkbox">	 
			<label><input type="checkbox" name="query-tables" value="CATEGORY">Nome da categoria</label> 
		</div>
		<br>
		<label for="q">Valor a ser buscado: </label>
		<input required type="text" name="q" class="form-control" id="q">
		<br>
		<input class="btn btn-default" type="submit" value="Buscar">
	</form>
</a:page>