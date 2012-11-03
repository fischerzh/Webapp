
<%@ page import="org.example.demo.Verteiler" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'verteiler.label', default: 'Verteiler')}" />
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
				
				<div class="input-prepend"> 
       				 <span class="add-on"><i class="icon-search"></i></span><input name="url" type="text" class="span2" placeholder="Page Url"> 
   				 </div> 
				
				<table class="table table-striped">
				
					<thead>
						<tr>
						
							<g:sortableColumn property="name" title="${message(code: 'verteiler.name.label', default: 'Verteiler')}" />
													
							<th></th>
						</tr>
					</thead>
					<tbody>
					<g:each in="${objInstanceList}" var="objInstance">
						<tr>
						
							<td>${fieldValue(bean: objInstance, field: "name")}</td>												
						
						<td class="link">
								<g:link action="edit" id="${objInstance.id}" class="btn btn-small">Edit &raquo;</g:link>							</td>
					
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