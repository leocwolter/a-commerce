<a:page title="Autores">
	<table class="table striped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Cidade</th>
				<th>Estado</th>
				<th>País</th>
				<th>CEP</th>
				<th>Rua</th>
				<th>Complemento</th>
				<th>Numero</th>
				<th>CPF</th>
				<th>Biografia</th>
				<th>Data de aniversário</th>
				<c:if test="${not empty loggedUser}">
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</c:if>
			</tr>
		</thead>
		<c:forEach items="${authors}" var="author">
			<tr>
				<td>${author.name}</td>
				<td>${author.city}</td>
				<td>${author.state}</td>
				<td>${author.country}</td>
				<td>${author.street}</td>
				<td>${author.zipCode}</td>
				<td>${author.complement}</td>
				<td>${author.number}</td>
				<td>${author.cpf}</td>
				<td>${author.biography}</td>
				<td><fmt:formatDate value="${author.birthDay.time}" pattern="dd/MM/yyyy"/></td>
				<c:if test="${not empty loggedUser}">
					<td>
						<a href="<c:url value="/edit-author?id=${author.id}"/>">
							Alterar
						</a>
					</td>
					<td>
						<a href="<c:url value="/delete-author?id=${author.id}"/>">
							Remover
						</a>
					</td>
				</c:if>
			</tr>		
		</c:forEach>
	</table>
</a:page>