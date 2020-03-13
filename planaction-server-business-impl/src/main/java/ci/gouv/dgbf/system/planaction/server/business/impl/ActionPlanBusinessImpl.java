package ci.gouv.dgbf.system.planaction.server.business.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.__kernel__.string.StringHelper;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;
import org.cyk.utility.server.business.BusinessFunctionCreator;
import org.cyk.utility.server.business.BusinessFunctionModifier;
import org.cyk.utility.server.business.BusinessFunctionRemover;

import ci.gouv.dgbf.system.planaction.server.business.api.ActionPlanActivityBusiness;
import ci.gouv.dgbf.system.planaction.server.business.api.ActionPlanBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ActionPlanPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.api.query.ActionPlanActivityByActionPlansQuerier;
import ci.gouv.dgbf.system.planaction.server.persistence.api.query.ActivityByAdministrativeUnitsQuerier;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlan;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlanActivity;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.AdministrativeUnit;

@ApplicationScoped
public class ActionPlanBusinessImpl extends AbstractBusinessEntityImpl<ActionPlan, ActionPlanPersistence> implements ActionPlanBusiness,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __listenExecuteCreateBefore__(ActionPlan actionPlan, Properties properties,BusinessFunctionCreator function) {
		super.__listenExecuteCreateBefore__(actionPlan, properties, function);
		__computeOrderNumber__(actionPlan,Boolean.FALSE);
		__computeNumberOfYears__(actionPlan, Boolean.FALSE);
		__computeCode__(actionPlan,Boolean.FALSE);
		__computeName__(actionPlan,Boolean.FALSE);
	}
	
	@Override
	protected void __listenExecuteCreateAfter__(ActionPlan actionPlan, Properties properties,BusinessFunctionCreator function) {
		super.__listenExecuteCreateAfter__(actionPlan, properties, function);
		Collection<Activity> activities = null;
		if(actionPlan.getProducer() instanceof AdministrativeUnit) {
			activities = ActivityByAdministrativeUnitsQuerier.getInstance().readByBusinessIdentifiers(actionPlan.getProducer().getCode());
		}
		if(CollectionHelper.isNotEmpty(activities)) {
			__inject__(ActionPlanActivityBusiness.class).createMany(activities.stream().map(activity -> new ActionPlanActivity().setActionPlan(actionPlan)
					.setActivity(activity)).collect(Collectors.toList()));
		}
	}
	
	@Override
	protected void __listenExecuteUpdateBefore__(ActionPlan actionPlan, Properties properties,BusinessFunctionModifier function) {
		super.__listenExecuteUpdateBefore__(actionPlan, properties, function);
		__computeOrderNumber__(actionPlan,Boolean.FALSE);
		__computeNumberOfYears__(actionPlan, Boolean.FALSE);
		__computeCode__(actionPlan,Boolean.FALSE);
		__computeName__(actionPlan,Boolean.FALSE);
	}
	
	private void __computeOrderNumber__(ActionPlan actionPlan,Boolean override) {
		if(actionPlan.getOrderNumber() != null && !Boolean.TRUE.equals(override))
			return;
		Byte latestOrderNumber = null;
		if(actionPlan.getProducer() != null && actionPlan.getYear() != null)
			latestOrderNumber = __persistence__.readMaxOrderNumberByProducerCodeByYear(actionPlan.getProducer().getCode(), actionPlan.getYear(), null);
		if(latestOrderNumber == null)
			latestOrderNumber = 0;
		latestOrderNumber = (byte) (latestOrderNumber + 1);
		actionPlan.setOrderNumber(latestOrderNumber);
	}
	
	private void __computeNumberOfYears__(ActionPlan actionPlan,Boolean override) {
		if(actionPlan.getNumberOfYears() != null && !Boolean.TRUE.equals(override))
			return;
		actionPlan.setNumberOfYears((byte)3);
	}
	
	private void __computeCode__(ActionPlan actionPlan,Boolean override) {
		if(StringHelper.isNotBlank(actionPlan.getCode()) && !Boolean.TRUE.equals(override))
			return;
		if(actionPlan.getYear() != null && actionPlan.getNumberOfYears() != null) {
			String producerTypeName = null;
			if(actionPlan.getProducer() instanceof AdministrativeUnit)
				producerTypeName = "UA";
			else
				producerTypeName = "???";
			actionPlan.setCode(String.format(CODE_FORMAT,actionPlan.getYear(),actionPlan.getYear()+actionPlan.getNumberOfYears()-1,producerTypeName
					,actionPlan.getProducer().getCode(),actionPlan.getOrderNumber()));
		}
	}
	
	private void __computeName__(ActionPlan actionPlan,Boolean override) {
		if(StringHelper.isNotBlank(actionPlan.getName()) && !Boolean.TRUE.equals(override))
			return;
		if(actionPlan.getYear() != null && actionPlan.getNumberOfYears() != null) {
			String producerTypeName = null;
			if(actionPlan.getProducer() instanceof AdministrativeUnit)
				producerTypeName = "l'unité administrative";
			else
				producerTypeName = "???";
			actionPlan.setName(String.format(NAME_FORMAT,actionPlan.getYear(),actionPlan.getYear()+actionPlan.getNumberOfYears()-1,producerTypeName
					,actionPlan.getProducer().toString(),actionPlan.getOrderNumber()));
		}
	}
	
	@Override
	protected void __listenExecuteDeleteBefore__(ActionPlan actionPlan, Properties properties,BusinessFunctionRemover function) {
		super.__listenExecuteDeleteBefore__(actionPlan, properties, function);
		Collection<ActionPlanActivity> actionPlanActivities = ActionPlanActivityByActionPlansQuerier.getInstance().read(actionPlan);
		if(CollectionHelper.isNotEmpty(actionPlanActivities))
			__inject__(ActionPlanActivityBusiness.class).deleteMany(actionPlanActivities);
	}
	
	@Override
	protected Boolean __isCallDeleteByInstanceOnDeleteByIdentifier__() {
		return Boolean.TRUE;
	}
	
	/**/
	
	public static final String CODE_FORMAT = "PA_%s_%s_%s_%s_V%s";
	public static final String NAME_FORMAT = "Plan d'action %s - %s de %s %s Version %s";
}
