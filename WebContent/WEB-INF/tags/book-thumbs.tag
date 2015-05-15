<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="books" required="true" type="java.util.List"%>

<c:forEach items="${books}" var="book">
	<c:if test="${status.count % 5 == 0}">
		<ul class="row list-unstyled">
	</c:if>
		  <li class="col-sm-5 col-md-3 text-center">
		    <div class="thumbnail">
		      <div class="caption">
		        <h3>${book.name}</h3>
				<p>
					<fmt:formatNumber value="${book.price}" minFractionDigits="2" type="currency"/>
				</p>
				<p>
		        	<a href="/add-to-cart?id=${book.id}" class="btn btn-primary" role="button">Comprar</a>
		        	<a href="/book?id=${book.id}" class="btn btn-default" role="button">Detalhes</a>
				</p>
		      </div>
		    </div>
		  </li>
	<c:if test="${status.count % 5 == 0}">
		</ul>
	</c:if>
</c:forEach>