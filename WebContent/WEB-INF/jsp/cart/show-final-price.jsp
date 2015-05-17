<a:page title="Finalize sua compra">
	Valor final: ${cart.finalPrice}
	<br>
	<form action="<c:url value="/checkout"/>" method="POST">
		<input class="btn btn-default" type="submit" value="Fechar compra">
	</form>
</a:page> 