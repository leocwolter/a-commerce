<a:page title="Suas compras">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Livros</th>
				<th>Data de compra</th>
				<th>Frete</th>
				<th>Preço total</th>
			</tr>
		</thead>
		<c:forEach items="${orders}" var="order">
			<tr>
				<td>
				<c:forEach items="${order.orderedBooks}" var="book" varStatus="status">
					Nome: <a href="<c:url value="/book?id=${book.book.id}"/>"> ${book.name} </a>
					<br>
					Preço individual: <fmt:formatNumber value="${book.price}" minFractionDigits="2" type="currency"/>
					<br>
					Qtd: ${book.quantity}
					<c:if test="${status.count != order.orderedBooks.size()}">
						<hr>
					</c:if>
				</c:forEach>
				</td>
				<td>
					<fmt:formatDate value="${order.creationDate.time}" pattern="dd/MM/yyyy HH:mm:ss"/>
				</td>
				<td>${order.shippingOption.name()} - ${order.shippingOption.price}</td>
				<td>
					<fmt:formatNumber value="${order.totalPrice}" minFractionDigits="2" type="currency"/>
				</td>
			</tr>		
		</c:forEach>
	</table>
</a:page>