<a:page title="Meu carrinho">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Autores</th>
				<th>Editora</th>
				<th>Preço</th>
				<th>Idioma</th>
				<th>Quantidade</th>
				<th>&nbsp;</th>
			</tr>
		</thead>
		<c:forEach items="${cart.books}" var="book">
			<tr>
				<td>
        			<a href="<c:url value="/book?id=${book.id}"/>">${book.name}</a>
				</td>
				<td>${book.authorsAsString}</td>
				<td>${book.publisher.name}</td>
				<td>
					<fmt:formatNumber value="${book.price}" minFractionDigits="2" type="currency"/>
				</td>
				<td>${book.language}</td>
				<td>${cart.howManyOf(book)}</td>
				<td>
					<a href="<c:url value="/remove-from-cart?id=${book.id}"/>">
						Remover do carrinho
					</a>
				</td>
			</tr>		
		</c:forEach>
	</table>
	<br>
	<div class="pull-left">
		<label>Total: </label> ${cart.totalPrice}
	</div>
	<div class="pull-right">
		<form action="/checkout">
			<input type="submit" class="btn btn-primary" value="Comprar">
		</form>
	</div>
</a:page>	
	
