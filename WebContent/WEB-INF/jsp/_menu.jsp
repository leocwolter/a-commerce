<nav>
	<ul>
	<li> <a href="<c:url value="/"/>"> Home </a>
		<c:if test="${not empty loggedUser}">
			<li><a href="<c:url value="/new-category"/>"> Nova categoria </a></li>
			<li><a href="<c:url value="/new-book"/>"> Novo livro </a></li>
			<li><a href="<c:url value="/logout"/>"> Sair </a></li>
		</c:if>
		<c:if test="${empty loggedUser}">
			<li><a href="<c:url value="/sign-up"/>"> Cadastrar </a></li>
			<li><a href="<c:url value="/login"/>"> Entrar </a></li>
		</c:if>
	</ul>
</nav>