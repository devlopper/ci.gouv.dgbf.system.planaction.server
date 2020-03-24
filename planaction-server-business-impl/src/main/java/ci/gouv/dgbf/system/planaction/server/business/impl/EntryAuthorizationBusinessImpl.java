package ci.gouv.dgbf.system.planaction.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.business.api.EntryAuthorizationBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.api.EntryAuthorizationPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ImputationPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.EntryAuthorization;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;
import org.cyk.utility.server.business.BusinessFunctionCreator;
import org.cyk.utility.server.business.BusinessFunctionModifier;

@ApplicationScoped
public class EntryAuthorizationBusinessImpl extends AbstractBusinessEntityImpl<EntryAuthorization, EntryAuthorizationPersistence> implements EntryAuthorizationBusiness,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __listenExecuteCreateBefore__(EntryAuthorization entryAuthorization, Properties properties,BusinessFunctionCreator function) {
		super.__listenExecuteCreateBefore__(entryAuthorization, properties, function);
		if(entryAuthorization.getImputation() == null) {
			if(entryAuthorization.getActionPlan() != null && entryAuthorization.getActivity() != null && entryAuthorization.getCostUnit() != null)
				entryAuthorization.setImputation(__inject__(ImputationPersistence.class).readByActionPlanCodeByActivityCodeByCostUnitCode(entryAuthorization.getActionPlan().getCode()
						, entryAuthorization.getActivity().getCode(), entryAuthorization.getCostUnit().getCode()));
		}
	}
	
	@Override
	protected void __listenExecuteCreateAfter__(EntryAuthorization entryAuthorization, Properties properties,BusinessFunctionCreator function) {
		super.__listenExecuteCreateAfter__(entryAuthorization, properties, function);
		savePaymentCredits(entryAuthorization);
	}
	
	@Override
	protected void __listenExecuteUpdateBefore__(EntryAuthorization entryAuthorization, Properties properties,BusinessFunctionModifier function) {
		super.__listenExecuteUpdateBefore__(entryAuthorization, properties, function);
		savePaymentCredits(entryAuthorization);
	}
	
	private void savePaymentCredits(EntryAuthorization entryAuthorization) {
		
	}
	
	@Override
	protected Boolean __isCallDeleteByInstanceOnDeleteByIdentifier__() {
		return Boolean.TRUE;
	}
}
