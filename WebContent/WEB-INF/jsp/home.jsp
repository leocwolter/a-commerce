<a:page title="Bem-vindo ao A-Commerce">
	<table class="table striped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Categorias</th>
				<th>Preço</th>
				<th>Autores</th>
				<c:if test="${not empty loggedUser}">
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</c:if>
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
				<c:if test="${not empty loggedUser}">
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
				</c:if>
			</tr>		
		</c:forEach>
	</table>
</a:page>