package ci.gouv.dgbf.system.planaction.server.business.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;
import org.cyk.utility.server.business.BusinessFunctionCreator;
import org.cyk.utility.server.business.BusinessFunctionRemover;

import ci.gouv.dgbf.system.planaction.server.business.api.ActionPlanActivityBusiness;
import ci.gouv.dgbf.system.planaction.server.business.api.ImputationBusiness;
import ci.gouv.dgbf.system.planaction.server.business.api.FundingBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ActionPlanActivityPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.api.FundingPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ImputationPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlanActivity;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Imputation;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Funding;

@ApplicationScoped
public class ImputationBusinessImpl extends AbstractBusinessEntityImpl<Imputation, ImputationPersistence> implements ImputationBusiness,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void __listenExecuteCreateAfter__(Collection<Imputation> imputations, Properties properties,BusinessFunctionCreator function) {
		super.__listenExecuteCreateAfter__(imputations, properties, function);
		if(CollectionHelper.isNotEmpty(imputations)) {
			Collection<ActionPlanActivity> actionPlanActivities = null;
			for(Imputation imputation : imputations) {
				if(actionPlanActivities !=null && !actionPlanActivities.stream()
						.filter(x-> x.getActionPlan().equals(imputation.getActionPlan()) && x.getActivity().equals(imputation.getActivity())).collect(Collectors.toList()).isEmpty())
					continue;
				Long count = __inject__(ActionPlanActivityPersistence.class).countByActionPlanByActivity(imputation.getActionPlan(), imputation.getActivity());
				if(count == null || count <= 0) {
					if(actionPlanActivities == null)
						actionPlanActivities = new ArrayList<>();
					actionPlanActivities.add(new ActionPlanActivity().setActionPlan(imputation.getActionPlan()).setActivity(imputation.getActivity()));
				}
			}	
			if(CollectionHelper.isNotEmpty(actionPlanActivities))
				__inject__(ActionPlanActivityBusiness.class).createMany(actionPlanActivities);
		}
	}
	
	@Override
	protected void __listenExecuteCreateAfter__(Imputation imputation, Properties properties,BusinessFunctionCreator function) {
		super.__listenExecuteCreateAfter__(imputation, properties, function);
		Collection<Funding> fundings = null;
		for(Integer index = 0; index < imputation.getActionPlan().getNumberOfYears(); index = index + 1) {
			if(fundings == null)
				fundings = new ArrayList<>();	
			Funding funding = new Funding();
			funding.setImputation(imputation);
			funding.setYear((short)(imputation.getActionPlan().getYear()+index)).setEntryAuthorization(0).setPaymentCredit(0);
			fundings.add(funding);
		}
		if(CollectionHelper.isNotEmpty(fundings))
			__inject__(FundingBusiness.class).createMany(fundings);
	}
	
	@Override
	protected void __listenExecuteDeleteBefore__(Imputation imputation, Properties properties,BusinessFunctionRemover function) {
		super.__listenExecuteDeleteBefore__(imputation, properties, function);
		Collection<Funding> fundings = __inject__(FundingPersistence.class).readByImputations(List.of(imputation));
		if(CollectionHelper.isNotEmpty(fundings))
			__inject__(FundingBusiness.class).deleteMany(fundings);
	}
	
	@Override
	protected Boolean __isCallDeleteByInstanceOnDeleteByIdentifier__() {
		return Boolean.TRUE;
	}
}