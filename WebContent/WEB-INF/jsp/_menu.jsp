<nav>
	<ul class="nav nav-tabs">
		<li><a href="<c:url value="/"/>"> Home </a></li>
		<c:if test="${not empty loggedUser}">
			<li><a href="<c:url value="/new-category"/>"> Nova categoria </a></li>
			<li><a href="<c:url value="/categories"/>"> Listar categorias </a></li>
			<li><a href="<c:url value="/new-book"/>"> Novo livro </a></li>
			<li><a href="<c:url value="/new-publisher"/>"> Nova editora </a></li>
			<li><a href="<c:url value="/logout"/>"> Sair </a></li>
		</c:if>
		<c:if test="${empty loggedUser}">
			<li><a href="<c:url value="/sign-up"/>"> Cadastrar </a></li>
			<li><a href="<c:url value="/login"/>"> Entrar </a></li>
		</c:if>
	</ul>
</nav>
<br>