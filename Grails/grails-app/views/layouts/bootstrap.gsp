<%@ page
	import="org.codehaus.groovy.grails.web.servlet.GrailsApplicationAttributes"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><g:layoutTitle default="${meta(name: 'app.name')}" /></title>
<meta name="description" content="">
<meta name="author" content="">

<meta name="viewport" content="initial-scale = 1.0">

<r:require modules="scaffolding" />

<g:layoutHead />
<r:layoutResources />
</head>

<body>

	<nav class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<p>
					<a class="brand" href="${createLink(uri: '/')}">Mobile Food Web
						App</a>
				</p>
				<p>
					<sec:ifLoggedIn>
						<sec:ifAllGranted roles="ROLE_ADMIN">
						
						<div class="nav-collapse">							
							<ul class="nav nav-pills">
							<li<%=  controllerName == 'home'? ' class="active"' : '' %>>
								<g:link controller='home'>Home</g:link></li>
								<li<%= controllerName == 'user'? ' class="active"' : '' %>>
								<g:link controller='user'>User </g:link></li>		
							<li class="dropdown">
								 <a class="dropdown-toggle" data-toggle="dropdown" href="#">
									 Datenbank
							 	 <b class="caret"></b>
							     </a>
							  <ul class="dropdown-menu">
							    <li<%= controllerName == 'produkt'? ' class="active"' : '' %>>
								<g:link controller='produkt'>Produkte </g:link></li>
								<li<%= controllerName == 'verteiler'? ' class="active"' : '' %>>
								<g:link controller='verteiler'>Verteiler </g:link></li>
								<li<%= controllerName == 'hersteller'? ' class="active"' : '' %>>
								<g:link controller='hersteller'>Hersteller </g:link></li>
								<li<%= controllerName == 'Gemeinde'? ' class="active"' : '' %>>
								<g:link controller='gemeinde'>Gemeinde </g:link></li>
								<li<%= controllerName == 'inhaltsstoffe'? ' class="active"' : '' %>>
								<g:link controller='inhaltsstoffe'>Inhaltsstoffe </g:link></li>
								<li<%= controllerName == 'kontrolleur'? ' class="active"' : '' %>>
								<g:link controller='kontrolleur'>Kontrolleur </g:link></li>
								<li<%= controllerName == 'produktfamilie'? ' class="active"' : '' %>>
								<g:link controller='produktFamilie'>Produktfamilie </g:link></li>
								<li<%= controllerName == 'rabbinat'? ' class="active"' : '' %>>
								<g:link controller='rabbinat'>Rabbinat </g:link></li>
								<li<%= controllerName == 'verkaufsort'? ' class="active"' : '' %>>
								<g:link controller='verkaufsort'>Verkaufsort </g:link></li>
								<li<%= controllerName == 'zusammensetzung'? ' class="active"' : '' %>>
								<g:link controller='zusammensetzung'>Zusammensetzung </g:link></li>
							  </ul> </li></ul>
						</div>
						
						</sec:ifAllGranted>
						<sec:ifAllGranted roles="ROLE_USER">
						<div class="nav-collapse">
							<ul class="nav">
								<li<%= controllerName == 'home'? ' class="active"' : '' %>><g:link controller='home'>Home</g:link></li>
								<li<%= controllerName == 'produkt'? ' class="active"' : '' %>><g:link controller='produkt'>Produkte </g:link></li>

							</ul>
						</div>
						</sec:ifAllGranted>
						<div align="right">
							<font color="grey"> Welcome <sec:username /> - 
							<g:link	controller='logout'>Log Out </g:link>
							</font>
						</div>
					</sec:ifLoggedIn>

				</p>

			</div>

		</div>
	</nav>

	<div class="container-fluid">
		<g:layoutBody />

		<hr>

		<footer>
			<p>&copy; UZH 2012</p>
		</footer>
	</div>

	<r:layoutResources />

</body>
</html>