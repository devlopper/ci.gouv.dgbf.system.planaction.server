package ci.gouv.dgbf.system.planaction.server.persistence.api.query;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.persistence.query.ByDimensionOneSystemIdentifierQuerier;
import org.cyk.utility.__kernel__.persistence.query.annotation.Queries;
import org.cyk.utility.__kernel__.persistence.query.annotation.Query;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.EntryAuthorization;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.PaymentCredit;

@Queries(value = {
		@Query(tupleClass = PaymentCredit.class,name = PaymentCreditByEntryAuthorizationsQuerier.QUERY_NAME_READ,value = "SELECT paymentCredit FROM PaymentCredit paymentCredit WHERE paymentCredit.entryAuthorization.identifier IN :"+PaymentCreditByEntryAuthorizationsQuerier.PARAMETER_NAME_ENTRY_AUTHORIZATIONS_IDENTIFIERS)
})
public interface PaymentCreditByEntryAuthorizationsQuerier extends ByDimensionOneSystemIdentifierQuerier<PaymentCredit,EntryAuthorization,String> {

	/**/
	
	static PaymentCreditByEntryAuthorizationsQuerier getInstance() {
		return Helper.getInstance(PaymentCreditByEntryAuthorizationsQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = DependencyInjection.inject(Value.class);
	
	String QUERY_NAME_READ = "readByEntryAuthorizationsIdentifiers";
	String QUERY_NAME_COUNT = "countByEntryAuthorizationsIdentifiers";
	String PARAMETER_NAME_ENTRY_AUTHORIZATIONS_IDENTIFIERS = "entryAuthorizationsIdentifiers";
}
