package ci.gouv.dgbf.system.planaction.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.business.EntitySaver;
import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.__kernel__.string.Strings;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;
import org.cyk.utility.server.business.BusinessFunctionCreator;
import org.cyk.utility.server.business.BusinessFunctionModifier;

import ci.gouv.dgbf.system.planaction.server.business.api.EntryAuthorizationBusiness;
import ci.gouv.dgbf.system.planaction.server.business.api.PaymentCreditBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.api.EntryAuthorizationPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ImputationPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.api.query.PaymentCreditByEntryAuthorizationsQuerier;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.EntryAuthorization;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.PaymentCredit;

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
		if(CollectionHelper.isNotEmpty(entryAuthorization.getPaymentCredits())) {
			entryAuthorization.getPaymentCredits().forEach(paymentCredit -> {paymentCredit.setEntryAuthorization(entryAuthorization);});
			__inject__(PaymentCreditBusiness.class).createMany(entryAuthorization.getPaymentCredits());
		}			
	}
	
	@Override
	protected void __listenExecuteUpdateBefore__(EntryAuthorization entryAuthorization, Properties properties,BusinessFunctionModifier function) {
		super.__listenExecuteUpdateBefore__(entryAuthorization, properties, function);
		Strings fields = __getFieldsFromProperties__(properties);
		if(CollectionHelper.isEmpty(fields))
			return;
		for(String index : fields.get()) {
			if(EntryAuthorization.FIELD_PAYMENT_CREDITS.equals(index)) {
				if(CollectionHelper.isNotEmpty(entryAuthorization.getPaymentCredits()))
					entryAuthorization.getPaymentCredits().forEach(paymentCredit -> {paymentCredit.setEntryAuthorization(entryAuthorization);});
				EntitySaver.getInstance().save(PaymentCredit.class, new EntitySaver.Arguments<PaymentCredit>()
						.setProvidedCollection(entryAuthorization.getPaymentCredits())
						.setExistingCollection(PaymentCreditByEntryAuthorizationsQuerier.getInstance().read(entryAuthorization)));
			}
		}
	}
	
	@Override
	protected Boolean __isCallDeleteByInstanceOnDeleteByIdentifier__() {
		return Boolean.TRUE;
	}
}
