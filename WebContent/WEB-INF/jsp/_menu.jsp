<nav>
	<ul>
	<li> <a href="<c:url value="/"/>"> Home </a>
		<c:if test="${not empty loggedUser}">
			<li><a href="new-book"> Novo livro </a></li>
		</c:if>
		<c:if test="${empty loggedUser}">
			<li><a href="sign-up"> Cadastrar </a></li>
			<li><a href="login"> Entrar </a></li>
		</c:if>
	</ul>
</nav>