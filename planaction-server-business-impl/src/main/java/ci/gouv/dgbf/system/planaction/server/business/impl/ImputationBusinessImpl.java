package ci.gouv.dgbf.system.planaction.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;
import org.cyk.utility.server.business.BusinessFunctionCreator;

import ci.gouv.dgbf.system.planaction.server.business.api.ActionPlanActivityBusiness;
import ci.gouv.dgbf.system.planaction.server.business.api.ImputationBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ActionPlanActivityPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ImputationPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlanActivity;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Imputation;

@ApplicationScoped
public class ImputationBusinessImpl extends AbstractBusinessEntityImpl<Imputation, ImputationPersistence> implements ImputationBusiness,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void __listenExecuteCreateBefore__(Imputation imputation, Properties properties,BusinessFunctionCreator function) {
		super.__listenExecuteCreateBefore__(imputation, properties, function);
	}
	
	@Override
	protected void __listenExecuteCreateAfter__(Imputation imputation, Properties properties,BusinessFunctionCreator function) {
		super.__listenExecuteCreateAfter__(imputation, properties, function);
		Long count = __inject__(ActionPlanActivityPersistence.class).countByActionPlanByActivity(imputation.getActionPlan(), imputation.getActivity());
		if(count == null || count <= 0) {
			__inject__(ActionPlanActivityBusiness.class).create(new ActionPlanActivity().setActionPlan(imputation.getActionPlan()).setActivity(imputation.getActivity()));
		}
	}
	
}
