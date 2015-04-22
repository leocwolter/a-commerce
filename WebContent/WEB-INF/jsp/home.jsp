<a:page title="Bem-vindo ao A-Commerce">
	<table>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.name}</td>
				<td>${book.genre}</td>
				<td>
					<fmt:formatNumber value="${book.price}" minFractionDigits="2" type="currency"/>
				</td>
				<td>${book.authors}</td>
			</tr>		
		</c:forEach>
	</table>
</a:page>
