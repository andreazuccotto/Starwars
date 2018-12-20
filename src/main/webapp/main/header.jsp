<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<ul class="navbar-nav mr-auto">
		<li class="nav-item active">
			<a class="nav-link" href="/main/homepage.jsp">
				<i title="Home" class="fas fa-home"></i>
				<span class="sr-only">(current)</span>
			</a>
		</li>
	</ul>
	<span class="navbar-text">${session.user.username}</span>
	<span class="navbar-text">
		<a class="nav-link" href="/main/settings.jsp">
			<i title="Impostazioni" class="fas fa-cog"></i>
			<span class="sr-only">(current)</span>
		</a>
	</span>
</nav>