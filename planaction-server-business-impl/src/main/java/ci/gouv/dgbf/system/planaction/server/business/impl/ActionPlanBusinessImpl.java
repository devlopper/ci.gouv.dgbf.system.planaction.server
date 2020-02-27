package ci.gouv.dgbf.system.planaction.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;
import org.cyk.utility.server.business.BusinessFunctionCreator;
import org.cyk.utility.server.business.BusinessFunctionModifier;

import ci.gouv.dgbf.system.planaction.server.business.api.ActionPlanBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ActionPlanPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlan;

@ApplicationScoped
public class ActionPlanBusinessImpl extends AbstractBusinessEntityImpl<ActionPlan, ActionPlanPersistence> implements ActionPlanBusiness,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __listenExecuteCreateBefore__(ActionPlan actionPlan, Properties properties,BusinessFunctionCreator function) {
		super.__listenExecuteCreateBefore__(actionPlan, properties, function);
		__computeOrderNumberAndCodeAndName__(actionPlan);
	}
	
	@Override
	protected void __listenExecuteUpdateBefore__(ActionPlan actionPlan, Properties properties,BusinessFunctionModifier function) {
		super.__listenExecuteUpdateBefore__(actionPlan, properties, function);
		ActionPlan actionPlanPersisted = __persistence__.readBySystemIdentifier(actionPlan.getIdentifier());		
		if(!actionPlanPersisted.getAdministrativeUnit().getIdentifier().equals(actionPlan.getAdministrativeUnit().getIdentifier()) 
				|| !actionPlanPersisted.getYear().equals(actionPlan.getYear()) ) {
			actionPlan.setOrderNumber(null);
			__computeOrderNumberAndCodeAndName__(actionPlan);	
		}
	}
	
	private void __computeOrderNumberAndCodeAndName__(ActionPlan actionPlan) {
		//if(actionPlan.getOrderNumber() == null || Boolean.TRUE.equals(override)) {
			Byte latestOrderNumber = null;
			if(actionPlan.getAdministrativeUnit() != null && actionPlan.getYear() != null)
				latestOrderNumber = __persistence__.readMaxOrderNumberByAdministrativeUnitCodeByYear(actionPlan.getAdministrativeUnit().getCode(), actionPlan.getYear(), null);
			if(latestOrderNumber == null)
				latestOrderNumber = 0;
			latestOrderNumber = (byte) (latestOrderNumber + 1);
			actionPlan.setOrderNumber(latestOrderNumber);
	//	}
		__setCode__(actionPlan);
		__setName__(actionPlan);
	}
	
	private void __setCode__(ActionPlan actionPlan) {
		//if(StringHelper.isBlank(actionPlan.getCode())) {
			if(actionPlan.getYear() != null)
				actionPlan.setCode(String.format(CODE_FORMAT,actionPlan.getAdministrativeUnit().getCode(),actionPlan.getYear(),actionPlan.getOrderNumber()));
		//}
	}
	
	private void __setName__(ActionPlan actionPlan) {
		//if(StringHelper.isBlank(actionPlan.getName())) {
			if(actionPlan.getYear() != null)
				actionPlan.setName(String.format(NAME_FORMAT,actionPlan.getAdministrativeUnit().getCode(),actionPlan.getYear(),actionPlan.getOrderNumber()));
		//}
	}
	
	/**/
	
	private static final String CODE_FORMAT = "PA_%s_%s_V%s";
	private static final String NAME_FORMAT = "Plan d'action de %s de %s Version %s";
}
