<%@ page import="org.example.demo.Verpackung_werte" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'bane', 'error')} required">
	<label for="bane">
		<g:message code="Verpackung_werte.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${objInstance?.name}"/>
</div>


