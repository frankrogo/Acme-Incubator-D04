
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox readonly= "true" code="authenticated.forum.form.label.title" path="title"/>
	<acme:form-submit readonly= "true" method="get" code="authenticated.forum.form.button.messages" action="/authenticated/message/list-by-forum?forumId=${forumId}"/>
	<acme:form-submit readonly= "true" method="get" code="authenticated.forum.form.button.messengers" action="/authenticated/messenger/list-by-forum?forumId=${forumId}"/>
	<acme:form-return code="authenticated.forum.form.button.return"/>
</acme:form>