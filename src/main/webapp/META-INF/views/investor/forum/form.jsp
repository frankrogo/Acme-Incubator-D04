<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not thread any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<h4><acme:message code="investor.forum.form.label.investmentRoundTicker"/> <acme:print value="${investmentRoundTicker}"/></h4><br>
	<acme:form-textbox code="investor.forum.form.label.title" path="title"/>
	<acme:form-submit code="investor.forum.form.button.messages" action="/investor/message/list-by-forum?forumid=${id}"  method="get"/>
	<acme:form-submit test="${command == 'show'}" method="get" code="investor.forum.form.button.messengers" action="/investor/messenger/list-by-forumId?forumId=${forumId}"/>
	<acme:form-return code="investor.forum.form.button.return"/>
</acme:form>