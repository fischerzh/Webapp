
<%@ page import="org.example.demo.Filter" %>
<!doctype html>
<html>
	<head>
	<r:require module="export"/>
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
				
				<g:select name="filter.name" from="${Filter.list()}" value="${filter?.name}" optionKey="id" />
				
				<export:formats formats="['json']" />
										
				<table class="table table-striped">
					<thead>
						<tr>						
							<g:sortableColumn property="name" title="${message(code: 'produkt.name.label', default: 'Name')}" />
							
							<th></th>
						</tr>
					</thead>
					<tbody>
					<g:each in="${objInstanceList}" var="objInstance">
						<tr>
						
							
						
							<td>${fieldValue(bean: objInstance, field: "name")}</td>
														
											
							<td class="link">
								<g:link action="show" id="${objInstance.id}" class="btn btn-small">Show &raquo;</g:link>
							</td>
						</tr>
					</g:each>
					</tbody>
				</table>
				
				<div class="pagination">
					<bootstrap:paginate total="${objInstanceTotal}" />
				</div>
			</div>

		</div>
	</body>
</html>
