<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-hidden path="forumId"/>
	<h4><acme:message code="authenticated.messenger.form.label.forumName"/> <acme:print value="${forumName}"/></h4><br>
	<acme:form-textbox readonly = "true" code="authenticated.messenger.form.label.ownsTheForum" path="ownsTheForum"/>	
	<acme:form-return code="authenticated.messenger.form.button.return"/>
</acme:form>