<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not thread-message any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-hidden path="forumId"/>
	
		<h4><acme:message code="authenticated.message.form.userName"/> <acme:print value="${userName}"/></h4>
		<h4><acme:message code="authenticated.message.form.forumTitle"/> <acme:print value="${forumTitle}"/></h4>
		<acme:form-moment readonly = "true" code="authenticated.message.form.label.creationMoment" path="creationMoment"/>	
		<acme:form-textbox readonly = "true" code="authenticated.message.form.label.title" path="title"/>
		<acme:form-textarea readonly = "true" code="authenticated.message.form.label.tags" path="tags"/>
		<acme:form-textarea readonly = "true" code="authenticated.message.form.label.body" path="body"/>
		
  	<acme:form-return code="authenticated.message.form.button.return"/>
</acme:form>
