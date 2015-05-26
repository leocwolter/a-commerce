<a:page title="Usuários">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Email</th>
				<c:if test="${not empty loggedUser && loggedUser.admin}">
					<th>&nbsp;</th>
					<th>&nbsp;</th>
				</c:if>
			</tr>
		</thead>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.email}</td>
				<c:if test="${not empty loggedUser && loggedUser.admin}">
					<td>
						<a href="<c:url value="/edit-user?id=${user.id}"/>">
							Alterar
						</a>
					</td>
					<td>
						<a href="<c:url value="/delete-user?id=${user.id}"/>">
							Remover
						</a>
					</td>
				</c:if>
			</tr>		
		</c:forEach>
	</table>
</a:page>