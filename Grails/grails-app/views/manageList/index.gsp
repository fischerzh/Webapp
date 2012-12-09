
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
				
				<g:form url='[controller: "manageList", action: "index"]' id="search" name="search" method="get">
				<g:textField name="q" value="${params.q}" size="10"/> 
				<input type="submit" value="Search" />
				</g:form>
												
				<div id=tableList>								
				<table class="table table-striped">
					<thead>
						<tr>						
							<g:sortableColumn property="name" title="${message(code: 'produkt.name.label', default: 'Name')}" />
							<g:sortableColumn property="produktfamilie" title="${message(code: 'produkt.produktfamilie.label', default: 'ProduktFamilie')}" />
							<g:sortableColumn property="hersteller" title="${message(code: 'produkt.hersteller.label', default: 'Hersteller')}" />
							<g:sortableColumn property="verteiler" title="${message(code: 'produkt.verteiler.label', default: 'Verteiler')}" />
							<g:sortableColumn property="inhaltsstoffe" title="${message(code: 'produkt.inhaltsstoffe.label', default: 'Inhaltsstoffe')}" />
							<g:sortableColumn property="verpackung" title="${message(code: 'produkt.verpackung.label', default: 'Verpackung')}" />						
							<g:sortableColumn property="aktiv" title="${message(code: 'produkt.aktiv.label', default: 'Aktiv')}" />						
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
							<td>${fieldValue(bean: objInstance, field: "inhaltsstoffe")}</td>
							<td>${fieldValue(bean: objInstance, field: "verpackung")}</td>
							<td>${fieldValue(bean: objInstance, field: "aktiv")}</td>							
							
							<td class="link">
								<g:link action="show" id="${objInstance.id}" class="btn btn-small">Show &raquo;</g:link>
							</td>
							<td class="link">
								<g:link action="deactivate" id="${objInstance.id}" class="btn btn-small">Deactivate &raquo;</g:link>
							</td>
							<td class="link">
								<g:link action="activate" id="${objInstance.id}" class="btn btn-small">Activate &raquo;</g:link>
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
		</div>
	</body>
</html>
