package ci.gouv.dgbf.system.planaction.server.persistence.api.query;

import java.io.Serializable;
import java.util.Collection;

import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutor;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutor.Arguments;
import org.cyk.utility.__kernel__.persistence.query.QueryGetter;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.Activity;

public class ActivityByActionPlansQuerierImpl extends AbstractObject implements ActivityByActionPlansQuerier,Serializable {

	@Override
	public Collection<Activity> readByBusinessIdentifiers(Collection<String> businessIdentifiers,Arguments arguments) {
		if(CollectionHelper.isEmpty(businessIdentifiers))
			return null;
		if(arguments == null)
			arguments = new Arguments().setQuery(QueryGetter.getInstance().getBySelect(Activity.class,QUERY_NAME_READ))
			.addFilterField(PARAMETER_NAME_ADMINISTRATIVE_UNITS_CODES,businessIdentifiers);
		return QueryExecutor.getInstance().executeReadMany(Activity.class,arguments);
	}

	@Override
	public Long countByBusinessIdentifiers(Collection<String> businessIdentifiers, Arguments arguments) {
		if(CollectionHelper.isEmpty(businessIdentifiers))
			return null;
		if(arguments == null)
			arguments = new Arguments().setQuery(QueryGetter.getInstance().getByCount(Activity.class,QUERY_NAME_COUNT))
			.addFilterField(PARAMETER_NAME_ADMINISTRATIVE_UNITS_CODES,businessIdentifiers);
		return QueryExecutor.getInstance().executeCount(arguments);
	}
	
}