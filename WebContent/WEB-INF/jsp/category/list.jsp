<a:page title="Categorias">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nome</th>
				<c:if test="${not empty loggedUser}">
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</c:if>
			</tr>
		</thead>
		<c:forEach items="${categories}" var="category">
			<tr>
				<td>${category.name}</td>
				<c:if test="${not empty loggedUser}">
					<td>
						<a href="<c:url value="/edit-category?id=${category.id}"/>">
							Alterar
						</a>
					</td>
					<td>
						<a href="<c:url value="/delete-category?id=${category.id}"/>">
							Remover
						</a>
					</td>
				</c:if>
			</tr>		
		</c:forEach>
	</table>
</a:page>