package ci.gouv.dgbf.system.planaction.server.persistence.api.query;

import java.io.Serializable;
import java.util.Collection;

import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutor;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutor.Arguments;
import org.cyk.utility.__kernel__.persistence.query.QueryGetter;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.PaymentCredit;

public class PaymentCreditByEntryAuthorizationsQuerierImpl extends AbstractObject implements PaymentCreditByEntryAuthorizationsQuerier,Serializable {

	@Override
	public Collection<PaymentCredit> readByIdentifiers(Collection<String> identifiers,Arguments arguments) {
		if(CollectionHelper.isEmpty(identifiers))
			return null;
		if(arguments == null)
			arguments = new Arguments().setQuery(QueryGetter.getInstance().getBySelect(PaymentCredit.class,QUERY_NAME_READ))
			.addFilterField(PARAMETER_NAME_ENTRY_AUTHORIZATIONS_IDENTIFIERS,identifiers);
		return QueryExecutor.getInstance().executeReadMany(PaymentCredit.class,arguments);
	}

	@Override
	public Long countByIdentifiers(Collection<String> identifiers, Arguments arguments) {
		if(CollectionHelper.isEmpty(identifiers))
			return null;
		if(arguments == null)
			arguments = new Arguments().setQuery(QueryGetter.getInstance().getByCount(PaymentCredit.class,QUERY_NAME_COUNT))
			.addFilterField(PARAMETER_NAME_ENTRY_AUTHORIZATIONS_IDENTIFIERS,identifiers);
		return QueryExecutor.getInstance().executeCount(arguments);
	}
	
}
