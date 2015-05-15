<a:page title="Editoras">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Rua</th>
				<th>Cidade</th>
				<th>Estado</th>
				<th>País</th>
				<th>CEP</th>
				<th>CNPJ</th>
				<th>Complemento</th>
				<th>Numero</th>
				<c:if test="${not empty loggedUser}">
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</c:if>
			</tr>
		</thead>
		<c:forEach items="${publishers}" var="publisher">
			<tr>
				<td>${publisher.name}</td>
				<td>${publisher.street}</td>
				<td>${publisher.city}</td>
				<td>${publisher.state}</td>
				<td>${publisher.country}</td>
				<td>${publisher.zipCode}</td>
				<td>${publisher.cnpj}</td>
				<td>${publisher.complement}</td>
				<td>${publisher.number}</td>
				<c:if test="${not empty loggedUser}">
					<td>
						<a href="<c:url value="/edit-publisher?id=${publisher.id}"/>">
							Alterar
						</a>
					</td>
					<td>
						<a href="<c:url value="/delete-publisher?id=${publisher.id}"/>">
							Remover
						</a>
					</td>
				</c:if>
			</tr>		
		</c:forEach>
	</table>
</a:page>