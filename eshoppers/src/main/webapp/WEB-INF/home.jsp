<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>
<%@taglib prefix="sec" uri="http://lokman.com/functions"%>
<div class="container">
	<div class="jumbotron">
		<h1>Welcome to e-shoppers!</h1>
		<img src="<c:url value="/image/cart.png"/>" style="height: 180px"
			alt="" />
	</div>
	<div class="col-6 mb-4">
		<c:if test="${cart!=null && cart.cartItems.size()>0}">
			<div class="card shadow-sm p-3 mb-5 bg-white">
				<div class="card-header">
					<h4>Your cart</h4>
				</div>
				<div class="card-body">
					<p>
						Total Item:
						<c:out value="${cart.totalItem}" />
						
					</p>
					<p>
						Total price:$
						<c:out value="${cart.totalPrice}" />
					</p>
					<p>
						<a class="btn btn-outline-info" href="<c:url value="/checkout"/>">Checkout</a>
					</p>
				</div>
			</div>
		</c:if>
	</div>
	<div class="row">
		<c:forEach var="product" items="${products}">
			<div class="col-sm-4">
				<div class="card h-100 mb-4">
					<div class="card-body">
						<h5 class="card-title">
							<c:out value="${product.name}"></c:out>
						</h5>
						<p class="card-text">
							<c:out value="${product.description}"></c:out>
						</p>
						<p class="card-text">
							price:$
							<c:out value="${product.price}"></c:out>
						</p>
						<a href="#" class="card-link btn btn-outline-info"
							onclick="addToCart(${product.id})">Add to cart</a>
						<form style="visibility: hidden" id="addToCart_${product.id}"
							method="post"
							action="<c:url value="/add-to-cart?productId=${product.id}"/>">


						</form>
					</div>
				</div>
			</div>

		</c:forEach>
	</div>
	<div class="jumbotron">
		<c:if test="${sec:isAuthenticated(pageContext.request) }">
			<h1>
				hello
				<c:out value="${sec:getCurrentUser(pageContext.request).firstName}" />
				, welcome to e-shoppers!
			</h1>
		</c:if>
		<img src="<c:url value="/image/cart.png"/>" style="height: 200px"
			alt="" />
	</div>
</div>

<script>
function addToCart(productId){
	let form = document.getElementById("addToCart_"+productId);
	form.submit();
}
</script>
<%@include file="includes/footer.jsp"%>
