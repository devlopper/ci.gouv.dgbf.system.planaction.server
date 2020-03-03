package ci.gouv.dgbf.system.planaction.server.business.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;
import org.cyk.utility.server.business.BusinessFunctionRemover;

import ci.gouv.dgbf.system.planaction.server.business.api.ActionPlanActivityBusiness;
import ci.gouv.dgbf.system.planaction.server.business.api.ImputationBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ActionPlanActivityPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ImputationPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlanActivity;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Imputation;

@ApplicationScoped
public class ActionPlanActivityBusinessImpl extends AbstractBusinessEntityImpl<ActionPlanActivity, ActionPlanActivityPersistence> implements ActionPlanActivityBusiness,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __listenExecuteDeleteBefore__(ActionPlanActivity actionPlanActivity, Properties properties,BusinessFunctionRemover function) {
		super.__listenExecuteDeleteBefore__(actionPlanActivity, properties, function);
		Collection<Imputation> imputations = __inject__(ImputationPersistence.class).readByActionPlanCodeByActivityCode(actionPlanActivity.getActionPlan().getCode()
				, actionPlanActivity.getActivity().getCode());
		if(CollectionHelper.isNotEmpty(imputations)) {
			__inject__(ImputationBusiness.class).deleteMany(imputations);
		}
	}
	
	@Override
	protected Boolean __isCallDeleteByInstanceOnDeleteByIdentifier__() {
		return Boolean.TRUE;
	}
}
