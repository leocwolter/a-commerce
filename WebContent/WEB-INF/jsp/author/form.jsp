<a:page title="Autor">
	<form action="${empty author ? 'new-author' : 'edit-author' }" method="POST">
		<label for="name">Nome:</label>
		<input required class="form-control" type="text" name="name" value="${author.name}" id="name">
		<br>
		<label for="street">Rua:</label>
		<input required class="form-control" type="text" name="street" value="${author.street}" id="street">
		<br>
		<label for="city">Cidade:</label>
		<input required class="form-control" type="text" name="city" value="${author.city}" id="city">
		<br>
		<label for="state">Estado:</label>
		<input required class="form-control" type="text" name="state" value="${author.state}" id="state">
		<br>
		<label for="country">País:</label>
		<input required class="form-control" type="text" name="country" value="${author.country}" id="country">
		<br>
		<label for="zipCode">CEP:</label>
		<input required class="form-control" type="text" name="zipCode" value="${author.zipCode}" id="zipCode">
		<br>
		<label for="cpf">CPF:</label>
		<input required class="form-control" type="text" name="cpf" value="${author.cpf}" id="cpf">
		<br>
		<label for="complement">Complemento:</label>
		<input required class="form-control" type="text" name="complement" value="${author.complement}" id="complement">
		<br>
		<label for="number">Número:</label>
		<input required class="form-control" type="text" name="number" value="${author.number}" id="number">
		<br>
		<label for="biography">Biografia:</label>
		<textarea required class="form-control" name="biography" id="biography">${author.biography}</textarea>
		<br>
		<label for="birthDay">Data de aniversário (dd/mm/yyyy):</label>
		<input required class="form-control" type="text" name="birthDay" value="<fmt:formatDate value="${author.birthDay.time}" pattern="dd/MM/yyyy"/>" id="birthDay">
		<br>
		<c:if test="${not empty author}">
			<input type="hidden" name="id" value="${author.id}">
		</c:if>
		<br>
		<input class="btn btn-default" type="submit" value="Cadastrar">
	</form>
</a:page>