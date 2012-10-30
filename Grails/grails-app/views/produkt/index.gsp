
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
				
					<div class="input-prepend"> 
     			   <span class="add-on"><i class="icon-search"></i></span><input name="url" type="text" class="span2" placeholder="Page Url"> 
   				 </div> 
				
				<table class="table table-striped">
					<thead>
						<tr>
											
						
							<g:sortableColumn property="name" title="${message(code: 'produkt.name.label', default: 'Name')}" />
							<g:sortableColumn property="produktfamilie" title="${message(code: 'produkt.produktfamilie.label', default: 'ProduktFamilie')}" />
							<g:sortableColumn property="hersteller" title="${message(code: 'produkt.hersteller.label', default: 'Hersteller')}" />
							<g:sortableColumn property="verteiler" title="${message(code: 'produkt.verteiler.label', default: 'Verteiler')}" />
							<g:sortableColumn property="zusammensetzung" title="${message(code: 'produkt.zusammensetzung.label', default: 'Zusammensetzung')}" />
							<g:sortableColumn property="verpackung" title="${message(code: 'produkt.verpackung.label', default: 'Verpackung')}" />
							<th></th>
						</tr>
					</thead>
					<tbody>
					<g:each in="${productInstanceList}" var="productInstance">
						<tr>
						
							
						
							<td>${fieldValue(bean: productInstance, field: "name")}</td>
							<td>${fieldValue(bean: productInstance, field: "produktfamilie")}</td>
							<td>${fieldValue(bean: productInstance, field: "hersteller")}</td>
							<td>${fieldValue(bean: productInstance, field: "verteiler")}</td>
							<td>${fieldValue(bean: productInstance, field: "zusammensetzung")}</td>
							<td>${fieldValue(bean: productInstance, field: "verpackung")}</td>
							
							
							<td class="link">
								<g:link action="edit" id="${productInstance.id}" class="btn btn-small">Edit &raquo;</g:link>
							</td>
						
							<td class="link">
								<g:link action="show" id="${productInstance.id}" class="btn btn-small">Show &raquo;</g:link>
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
					<bootstrap:paginate total="${productInstanceTotal}" />
				</div>
			</div>

		</div>
	</body>
</html>
