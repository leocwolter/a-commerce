<a:page title="Escolha sua opção de frete">
	<form action="<c:url value="/show-final-price"/>">
		<c:forEach items="${shippingOptions}" var="shippingOption">
			<label><input type="radio" name="shipping-option" id="shipping-option" value="${shippingOption.name()}"> ${shippingOption.name()} - ${shippingOption.price}</label>
		</c:forEach>
		<input class="btn btn-default" type="submit" value="Escolher">
	</form>
</a:page> 