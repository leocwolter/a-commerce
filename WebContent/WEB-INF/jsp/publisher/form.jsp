<a:page title="Editora">
	<form action="${empty publisher ? 'new-publisher' : 'edit-publisher' }" method="POST">
		<label for="name">Nome:</label>
		<input required class="form-control" type="text" name="name" value="${publisher.name}" id="name">
		<br>
		<label for="street">Rua:</label>
		<input required class="form-control" type="text" name="street" value="${publisher.street}" id="street">
		<br>
		<label for="city">Cidade:</label>
		<input required class="form-control" type="text" name="city" value="${publisher.city}" id="city">
		<br>
		<label for="state">Estado:</label>
		<input required class="form-control" type="text" name="state" value="${publisher.state}" id="state">
		<br>
		<label for="country">País:</label>
		<input required class="form-control" type="text" name="country" value="${publisher.country}" id="country">
		<br>
		<label for="zipCode">CEP:</label>
		<input required class="form-control" type="text" name="zipCode" value="${publisher.zipCode}" id="zipCode">
		<br>
		<label for="cnpj">CNPJ:</label>
		<input required class="form-control" type="text" name="cnpj" value="${publisher.cnpj}" id="cnpj">
		<br>
		<label for="complement">Complemento:</label>
		<input required class="form-control" type="text" name="complement" value="${publisher.complement}" id="complement">
		<br>
		<label for="number">Número:</label>
		<input required class="form-control" type="text" name="number" value="${publisher.number}" id="number">
		<br>
		<c:if test="${not empty publisher}">
			<input type="hidden" name="id" value="${publisher.id}">
		</c:if>
		<br>
		<input class="btn btn-default" type="submit" value="Cadastrar">
	</form>
</a:page>