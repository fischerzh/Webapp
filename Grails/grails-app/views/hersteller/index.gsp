
<%@ page import="org.example.demo.Hersteller" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'Hersteller.label', default: 'Hersteller')}" />
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
				
				<table class="table table-striped">
					<thead>
						<tr>	
							<g:sortableColumn property="name" title="${message(code: 'Hersteller.name.label', default: 'Name')}" />
													
							<th></th>
						</tr>
					</thead>
					<tbody>
					<g:each in="${objInstanceList}" var="objInstance">
						<tr>
						
							<td>${fieldValue(bean: objInstance, field: "name")}</td>
							
							<td>
								<g:each in="${objInstanceList }" var="hersteller">
									${hersteller.name }
								</g:each>
							</td>
						
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
