<%@ page import="org.example.demo.*" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="bootstrap">
		<g:set var="entityName" value="${message(code: 'produkt.label', default: 'Produkt')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
	
		
	<script type="text/javascript">
		$(document).ready(function(){
			
		 //This line clones the row inside the '.row' class and transforms it to plain html.
		 var clonedRow = $('.row').clone().html();
		 
		 //This line wraps the clonedRow and wraps it <tr> tags since cloning ignores those tags
		 var appendRow = '<tr class = "row">' + clonedRow + '</tr>';  
		      
		 $('#btnAddMore').click(function(){
		  //this line get's the last row and appends the appendRow when it finds the correct row.
		        $('.productTable tr:last').after(appendRow);
		    });
		 
		 //when you click on the button called "delete", the function inside will be triggered.
		 $('.deleteThisRow').live('click',function(){
		     var rowLength = $('.row').length;
		         //this line makes sure that we don't ever run out of rows.
		      if(rowLength > 1){
		   deleteRow(this);
		  }else{
		   $('.productTable tr:last').after(appendRow);
		   deleteRow(this);
		  }
		 });
		   
		 function deleteRow(currentNode){
		  $(currentNode).parent().parent().remove();
		 }
		 });
 	</script>
	
		<div class="row-fluid">			
			<div class="span9">
			
				<div class="page-header">
					<g:link class="list" action="index">
						<i class="icon-list"></i>
						<g:message code="default.list.label" args="[entityName]" />
					</g:link>
				</div>
				
				<div class="page-header">
					<h1><g:message code="default.create.label" args="[entityName]" /></h1>
				</div>
				
					<fieldset>
					<g:form class="form-horizontal" action="create" >
						<fieldset>
							<f:field bean="productInstance" property="name"/>
							<f:field bean="productInstance" property="ean"/>
							<f:field bean="productInstance" property="istKoscher"/>
							<f:field bean="productInstance" property="istVegan"/>
							<f:field bean="productInstance" property="istBischulak"/>
							<f:field bean="productInstance" property="istBliothlssur"/>
							<f:field bean="productInstance" property="istChalavakum"/>
							<f:field bean="productInstance" property="istIsraelischesProdukt"/>
							<f:field bean="productInstance" property="istTarovetlssur"/>
							<f:field bean="productInstance" property="pasPalter"/>
							<f:field bean="productInstance" property="istIGFLProdukt"/>
							<f:field bean="productInstance" property="istMp"/>
							<f:field bean="productInstance" property="externeKontrolle"/>
							<f:field bean="productInstance" property="parve"/>
							<f:field bean="productInstance" property="tolaim"/>
							<f:field bean="productInstance" property="erstellung"/>
							<f:field bean="productInstance" property="veroeffentlichung"/>
							<f:field bean="productInstance" property="kontrolle"/>
							<f:field bean="productInstance" property="geaendert"/>
							<f:field bean="productInstance" property="naechsteKontrolle"/>
							<f:field bean="productInstance" property="hersteller"/>
							<f:field bean="productInstance" property="verteiler"/>
							<f:field bean="productInstance" property="verpackung"/>
							<f:field bean="productInstance" property="produktfamilie"/>
							<f:field bean="productInstance" property="verkaeufer"/>
							<f:field bean="productInstance" property="kontrolleur"/>
							<f:field bean="productInstance" property="inhaltsstoffe">
								<table class="productTable">
								 <tr class = "row">
								 <td><form name="select">
									<g:select name="selectedValue" from="${Inhaltsstoffe.list()}" optionKey="id" 
									onchange="${remoteFunction(
          							action:'ajaxGetCities', 
            						params:'\'id=\' + escape(this.value)' 
									)}"/>
									</form><input type="button" class="deleteThisRow"/ value="Delete &raquo;"></td>
								 </tr>
								</table>
								<input type="button" id="btnAddMore"  value="Hinzufügen &raquo;"/>
							</f:field>
							<div class="form-actions">
								<button type="submit" class="btn btn-primary">
									<i class="icon-ok icon-white"></i>
									<g:message code="default.button.create.label" default="Create" />
								</button>
								</div>
						</fieldset>
					</g:form>
					</fieldset>								
			</div>			
		</div>
	</body>
 
</html>
