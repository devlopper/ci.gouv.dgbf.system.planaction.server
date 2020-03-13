package ci.gouv.dgbf.system.planaction.server.persistence.api.query;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.persistence.query.ByDimensionOneQuerier;
import org.cyk.utility.__kernel__.persistence.query.annotation.Queries;
import org.cyk.utility.__kernel__.persistence.query.annotation.Query;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlan;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlanActivity;

@Queries(value = {
		@Query(tupleClass = ActionPlanActivity.class,name = ActionPlanActivityByActionPlansQuerier.QUERY_NAME_READ,value = "SELECT tuple FROM ActionPlanActivity tuple WHERE tuple.actionPlan.code IN :"+ActionPlanActivityByActionPlansQuerier.PARAMETER_NAME_ACTION_PLANS_CODES)
})
public interface ActionPlanActivityByActionPlansQuerier extends ByDimensionOneQuerier<ActionPlanActivity, String,ActionPlan,String> {

	/**/
	
	static ActionPlanActivityByActionPlansQuerier getInstance() {
		return Helper.getInstance(ActionPlanActivityByActionPlansQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = DependencyInjection.inject(Value.class);
	
	String QUERY_NAME_READ = "readByActionPlansCodes";
	String QUERY_NAME_COUNT = "countByActionPlansCodes";
	String PARAMETER_NAME_ACTION_PLANS_CODES = "actionPlansCodes";
}
