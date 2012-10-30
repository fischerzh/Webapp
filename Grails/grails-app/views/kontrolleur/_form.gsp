<%@ page import="org.example.demo.Kontrolleur" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'bane', 'error')} required">
	<label for="bane">
		<g:message code="Kontrolleur.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${objInstance?.name}"/>
</div>


