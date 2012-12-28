
<%@ page import="org.example.demo.Produkt" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'produkt.label', default: 'Produkt')}" />
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
				
				
				<g:form url='[controller: "produkt", action: "index"]' id="search" name="search" method="get">
					<g:textField name="q" value="${params.q}" size="10"/> 
					<input type="submit" value="Search" />
				</g:form>
						
				<table class="table table-striped">
					<thead>
						<tr>						
							<g:sortableColumn property="name" title="${message(code: 'produkt.name.label', default: 'Name')}" />
							<g:sortableColumn property="produktfamilie" title="${message(code: 'produkt.produktfamilie.label', default: 'ProduktFamilie')}" />
							<g:sortableColumn property="hersteller" title="${message(code: 'produkt.hersteller.label', default: 'Hersteller')}" />
							<g:sortableColumn property="verteiler" title="${message(code: 'produkt.verteiler.label', default: 'Verteiler')}" />
							
							<th></th>
						</tr>
					</thead>
					<tbody>
					<g:each in="${objInstanceList}" var="objInstance">
						<tr>												
							<td>${fieldValue(bean: objInstance, field: "name")}</td>
							<td>${fieldValue(bean: objInstance, field: "produktfamilie")}</td>
							<td>${fieldValue(bean: objInstance, field: "hersteller")}</td>
							<td>${fieldValue(bean: objInstance, field: "verteiler")}</td>

							
							
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
