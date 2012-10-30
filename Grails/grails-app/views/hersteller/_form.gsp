<%@ page import="org.example.demo.Hersteller" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'bane', 'error')} required">
	<label for="bane">
		<g:message code="Hersteller.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${objInstance?.name}"/>
</div>


