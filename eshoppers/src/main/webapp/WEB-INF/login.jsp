<%@ include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>
<div class="container">
	<h2 class="h2">Log in</h2>
	<hr class="mb-4">

	<form class="form-horizontal" role="form"
		action="<c:url value="/login"/>" method="post">

		<div class="form-group">
			<label for="username">Username</label> <input type="text"
				class="form-control" id="username" name="username" />

		</div>

		<div class="form-group">
			<label for="password">Password</label> <input type="password"
				class="form-control" id="password" name="password" />

		</div>

		<hr class="mb-4">
		<div class="form-group">
			<button class="btn btn-primary btn-lg" type="submit">Login</button>
		</div>
	</form>
</div>
<%@include file="includes/footer.jsp"%>