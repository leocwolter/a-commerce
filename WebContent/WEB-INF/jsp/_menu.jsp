<nav>
	<ul class="nav nav-tabs">
		<li><a href="<c:url value="/"/>"> Home </a></li>
		<c:if test="${not empty loggedUser}">
			<li role="presentation" class="dropdown">
			    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
			      Categorias <span class="caret"></span>
			    </a>
			    <ul class="dropdown-menu" role="menu">
					<li><a href="<c:url value="/new-category"/>">Criar</a></li>
					<li><a href="<c:url value="/categories"/>">Lista</a></li>
			    </ul>
			</li>

			<li role="presentation" class="dropdown">
			    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
			      Editoras <span class="caret"></span>
			    </a>
			    <ul class="dropdown-menu" role="menu">
					<li><a href="<c:url value="/new-publisher"/>">Criar</a></li>
					<li><a href="<c:url value="/publishers"/>">Lista</a></li>
			    </ul>
			</li>
		
			<li role="presentation" class="dropdown">
			    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
			      Autores <span class="caret"></span>
			    </a>
			    <ul class="dropdown-menu" role="menu">
					<li><a href="<c:url value="/new-author"/>">Criar</a></li>
					<li><a href="<c:url value="/authors"/>">Lista</a></li>
			    </ul>
			</li>
		
			<li role="presentation" class="dropdown">
			    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">
			      Livros <span class="caret"></span>
			    </a>
			    <ul class="dropdown-menu" role="menu">
					<li><a href="<c:url value="/new-book"/>">Criar</a></li>
			    </ul>
			</li>
		
			<li><a href="<c:url value="/logout"/>"> Sair </a></li>
		</c:if>
		<c:if test="${empty loggedUser}">
			<li><a href="<c:url value="/sign-up"/>"> Cadastrar </a></li>
			<li><a href="<c:url value="/login"/>"> Entrar </a></li>
		</c:if>
	</ul>
</nav>
<br>