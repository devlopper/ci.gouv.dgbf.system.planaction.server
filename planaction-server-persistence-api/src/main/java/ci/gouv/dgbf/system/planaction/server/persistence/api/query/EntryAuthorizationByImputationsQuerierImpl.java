package ci.gouv.dgbf.system.planaction.server.persistence.api.query;

import java.io.Serializable;
import java.util.Collection;

import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutor;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutor.Arguments;
import org.cyk.utility.__kernel__.persistence.query.QueryGetter;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.EntryAuthorization;

public class EntryAuthorizationByImputationsQuerierImpl extends AbstractObject implements EntryAuthorizationByImputationsQuerier,Serializable {

	@Override
	public Collection<EntryAuthorization> readByIdentifiers(Collection<String> identifiers,Arguments arguments) {
		if(CollectionHelper.isEmpty(identifiers))
			return null;
		if(arguments == null)
			arguments = new Arguments().setQuery(QueryGetter.getInstance().getBySelect(EntryAuthorization.class,QUERY_NAME_READ))
			.addFilterField(PARAMETER_NAME_IMPUTATIONS_IDENTIFIERS,identifiers);
		return QueryExecutor.getInstance().executeReadMany(EntryAuthorization.class,arguments);
	}

	@Override
	public Long countByIdentifiers(Collection<String> identifiers, Arguments arguments) {
		if(CollectionHelper.isEmpty(identifiers))
			return null;
		if(arguments == null)
			arguments = new Arguments().setQuery(QueryGetter.getInstance().getByCount(EntryAuthorization.class,QUERY_NAME_COUNT))
			.addFilterField(PARAMETER_NAME_IMPUTATIONS_IDENTIFIERS,identifiers);
		return QueryExecutor.getInstance().executeCount(arguments);
	}
	
}
