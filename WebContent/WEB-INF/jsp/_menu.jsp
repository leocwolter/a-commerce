<c:if test="${not empty loggedUser}">
	<nav>
		<ul>
			<li>
				<a href="new-product"> Novo produto </a>
			</li>
		</ul>
	</nav>
</c:if>
<c:if test="${empty loggedUser}">
	<nav>
		<ul>
			<li>
				<a href="sign-up"> Cadastrar </a>
			</li>
			<li>
				<a href="login"> Entrar </a>
			</li>
		</ul>
	</nav>
</c:if>