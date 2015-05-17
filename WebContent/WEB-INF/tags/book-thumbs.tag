<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ attribute name="books" required="true" type="java.util.List"%>

<c:forEach items="${books}" var="book" varStatus="status">
	<c:if test="${status.count-1 % 4 == 0}">
		<ul class="row list-unstyled">
	</c:if>
		  <li class="col-sm-5 col-md-3 text-center">
		    <div class="thumbnail">
		      <div class="caption">
		      	<c:if test="${not empty loggedUser}">
					<c:if test="${not wishlist.contains(book)}">
						<a href="<c:url value="/add-to-wishlist?id=${book.id}"/>" class="pull-right">
							<span class="glyphicon glyphicon glyphicon-heart-empty"></span>
						</a>
					</c:if>
					<c:if test="${wishlist.contains(book)}">
						<a href="<c:url value="/remove-from-wishlist?id=${book.id}"/>" class="pull-right">
							<span class="glyphicon glyphicon glyphicon-heart"></span>
						</a>
					</c:if>
		      	</c:if>
		        <h3>${book.name}</h3>
				<p>
					<fmt:formatNumber value="${book.price}" minFractionDigits="2" type="currency"/>
				</p>
				<p>
		        	<a href="<c:url value="/add-to-cart?id=${book.id}"/>" class="btn btn-primary" role="button">Comprar</a>
		        	<a href="<c:url value="/book?id=${book.id}"/>" class="btn btn-default" role="button">Detalhes</a>
				</p>
		      </div>
		    </div>
		  </li>
	<c:if test="${status.count % 5 == 0}">
		</ul>
	</c:if>
</c:forEach>