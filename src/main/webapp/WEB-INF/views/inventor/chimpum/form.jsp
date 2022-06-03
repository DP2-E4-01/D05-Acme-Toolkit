<%@page language="java"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:form>
		
	<jstl:choose>
		<jstl:when test="${command == 'show'}">
			
			<acme:input-textbox code="inventor.chimpum.form.label.code" path="code" readonly="true"/>
			<acme:input-textbox code="inventor.chimpum.form.label.creationMoment" path="creationMoment" readonly="true"/>
			<acme:input-textbox code="inventor.chimpum.form.label.title" path="title" readonly="true"/>
			<acme:input-textbox code="inventor.chimpum.form.label.description" path="description" readonly="true"/>
			<acme:input-textbox code="inventor.chimpum.form.label.startsAt" path="startsAt" readonly="true"/>
			<acme:input-textbox code="inventor.chimpum.form.label.finishesAt" path="finishesAt" readonly="true"/>
			<acme:input-money code="inventor.chimpum.form.label.budget" path="budget" readonly="true" />
			<acme:input-money code="inventor.label.moneyExchange" path="moneyExchange" readonly="true" />
			<acme:input-textbox code="inventor.chimpum.form.label.link" path="link" readonly="true"/>
			
			<acme:button code="inventor.chimpum.form.button.update" action="/inventor/chimpum/update?id=${id}"/>
			<acme:submit code="inventor.chimpum.form.button.delete" action="/inventor/chimpum/delete"/>
			
			
			<h2> <acme:message code="inventor.chimpum.form.label.item"/> </h2>
		
			<acme:input-textbox code="inventor.chimpum.form.label.item.name" path="item.name" readonly= "true"/>
			<acme:input-textbox code="inventor.chimpum.form.label.item.code" path="item.code" readonly= "true"/>
			<acme:input-textbox code="inventor.chimpum.form.label.item.description" path="item.description" readonly= "true"/>
			<acme:input-textbox code="inventor.chimpum.form.label.item.retailPrice" path="item.retailPrice" readonly= "true"/>
		</jstl:when>
	
		<jstl:when test="${command == 'create'}">
			
			<acme:input-textbox code="inventor.chimpum.form.label.code" path="code"/>
			<acme:input-textbox code="inventor.chimpum.form.label.creationMoment" path="creationMoment" readonly="true"/>
			<acme:input-textbox code="inventor.chimpum.form.label.title" path="title"/>
			<acme:input-textbox code="inventor.chimpum.form.label.description" path="description"/>
			<acme:input-textbox code="inventor.chimpum.form.label.startsAt" path="startsAt" readonly="true"/>
			<acme:input-textbox code="inventor.chimpum.form.label.finishesAt" path="finishesAt" readonly="true"/>
			<acme:input-money code="inventor.chimpum.form.label.budget" path="budget"/>
			<acme:input-textbox code="inventor.chimpum.form.label.link" path="link"/>
			
			<acme:submit code="inventor.chimpum.form.button.create" action="/inventor/chimpum/create?id=${id}"/>
			
		</jstl:when>
		
		<jstl:when test="${command == 'update'}">
			
			<acme:input-textbox code="inventor.chimpum.form.label.code" path="code"/>
			<acme:input-textbox code="inventor.chimpum.form.label.creationMoment" path="creationMoment" readonly="true"/>
			<acme:input-textbox code="inventor.chimpum.form.label.title" path="title"/>
			<acme:input-textbox code="inventor.chimpum.form.label.description" path="description"/>
			<acme:input-textbox code="inventor.chimpum.form.label.startsAt" path="startsAt" readonly="true"/>
			<acme:input-textbox code="inventor.chimpum.form.label.finishesAt" path="finishesAt" readonly="true"/>
			<acme:input-money code="inventor.chimpum.form.label.budget" path="budget"/>
			<acme:input-textbox code="inventor.chimpum.form.label.link" path="link"/>
			
			<acme:submit code="inventor.chimpum.form.button.update" action="/inventor/chimpum/update?id=${id}"/>
			
		</jstl:when>
	</jstl:choose>
				
			
</acme:form>