<a:page title="Bem-vindo ao A-Commerce">
	<table class="table striped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Categorias</th>
				<th>Preço</th>
				<th>Autores</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.name}</td>
				<td>${book.categoriesAsString}</td>
				<td>
					<fmt:formatNumber value="${book.price}" minFractionDigits="2" type="currency"/>
				</td>
				<td>${book.authors}</td>
				<td>
					<a href="<c:url value="/edit-book?id=${book.id}"/>">
						Alterar
					</a>
				</td>
				<td>
					<a href="<c:url value="/delete-book?id=${book.id}"/>">
						Remover
					</a>
				</td>
			</tr>		
		</c:forEach>
	</table>
</a:page>