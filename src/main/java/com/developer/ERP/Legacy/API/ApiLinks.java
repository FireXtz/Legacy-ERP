package com.developer.ERP.Legacy.API;

import org.springframework.hateoas.TemplateVariable;
import org.springframework.hateoas.TemplateVariable.VariableType;
import org.springframework.hateoas.TemplateVariables;
import org.springframework.stereotype.Component;


@Component
public class ApiLinks {
	
	public static final TemplateVariables VARIAVEIS_DE_PAGINACAO = new TemplateVariables(
			new TemplateVariable("page",VariableType.REQUEST_PARAM),
			new TemplateVariable("size",VariableType.REQUEST_PARAM),
			new TemplateVariable("sort",VariableType.REQUEST_PARAM));
	
	public static final TemplateVariables VARIAVEIS_DE_PROJECOES = new TemplateVariables(
			new TemplateVariable("projecao",VariableType.REQUEST_PARAM));
				
}
