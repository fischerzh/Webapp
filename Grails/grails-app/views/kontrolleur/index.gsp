
<%@ page import="org.example.demo.Kontrolleur" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'Kontrolleur.label', default: 'Kontrolleur')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="row-fluid">

			<div class="span9">
				
				<div class="page-header">
					<h1><g:message code="default.list.label" args="[entityName]" /></h1>
				</div>

				<g:if test="${flash.message}">
				<bootstrap:alert class="alert-info">${flash.message}</bootstrap:alert>
				</g:if>
				
				<g:form url='[controller: "kontrolleur", action: "index"]' id="search" name="search" method="get">
					<g:textField name="q" value="${params.q}" size="10"/> 
					<input type="submit" value="Search" />
				</g:form>
				
				<table class="table table-striped">
					<thead>
						<tr>	
							<g:sortableColumn property="name" title="${message(code: 'Kontrolleur.name.label', default: 'Name')}" />
							<g:sortableColumn property="istK" title="${message(code: 'Kontrolleur.istKontrolleur.label', default: 'ist Kontrolleur')}" />	
							<g:sortableColumn property="istR" title="${message(code: 'Kontrolleur.istRabbi.label', default: 'ist Rabbi')}" />
							<g:sortableColumn property="istA" title="${message(code: 'Kontrolleur.istAktiv.label', default: 'ist Aktiv')}" />					
							<th></th>
						</tr>
					</thead>
					<tbody>
					<g:each in="${objInstanceList}" var="objInstance">
						<tr>
						
							<td>${fieldValue(bean: objInstance, field: "name")}</td>
							<td>${fieldValue(bean: objInstance, field: "istKontrolleur")}</td>
							<td>${fieldValue(bean: objInstance, field: "istRabbi")}</td>
							<td>${fieldValue(bean: objInstance, field: "istAktiv")}</td>
						
							<td class="link">
								<g:link action="edit" id="${objInstance.id}" class="btn btn-small">Edit &raquo;</g:link>
							</td>
								<td class="link">
								<g:link action="show" id="${objInstance.id}" class="btn btn-small">Show &raquo;</g:link>
							</td>
						</tr>
					</g:each>
					</tbody>
				</table>
				
				<g:link class="create" action="create">
								<i class="icon-plus"></i>
								<g:message code="default.create.label" args="[entityName]" />
							</g:link>
				<div class="pagination">
					<bootstrap:paginate total="${objInstanceTotal}" />
				</div>
			</div>

		</div>
	</body>
</html>
