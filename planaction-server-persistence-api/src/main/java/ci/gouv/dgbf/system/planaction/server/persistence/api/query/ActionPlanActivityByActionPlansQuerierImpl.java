package ci.gouv.dgbf.system.planaction.server.persistence.api.query;

import java.io.Serializable;
import java.util.Collection;

import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutor;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutor.Arguments;
import org.cyk.utility.__kernel__.persistence.query.QueryGetter;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlanActivity;

public class ActionPlanActivityByActionPlansQuerierImpl extends AbstractObject implements ActionPlanActivityByActionPlansQuerier,Serializable {

	@Override
	public Collection<ActionPlanActivity> readByBusinessIdentifiers(Collection<String> businessIdentifiers,Arguments arguments) {
		if(CollectionHelper.isEmpty(businessIdentifiers))
			return null;
		if(arguments == null)
			arguments = new Arguments().setQuery(QueryGetter.getInstance().getBySelect(ActionPlanActivity.class,QUERY_NAME_READ))
			.addFilterField(PARAMETER_NAME_ACTION_PLANS_CODES,businessIdentifiers);
		return QueryExecutor.getInstance().executeReadMany(ActionPlanActivity.class,arguments);
	}

	@Override
	public Long countByBusinessIdentifiers(Collection<String> businessIdentifiers, Arguments arguments) {
		if(CollectionHelper.isEmpty(businessIdentifiers))
			return null;
		if(arguments == null)
			arguments = new Arguments().setQuery(QueryGetter.getInstance().getByCount(ActionPlanActivity.class,QUERY_NAME_COUNT))
			.addFilterField(PARAMETER_NAME_ACTION_PLANS_CODES,businessIdentifiers);
		return QueryExecutor.getInstance().executeCount(arguments);
	}
	
}
