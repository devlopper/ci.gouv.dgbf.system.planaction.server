package ci.gouv.dgbf.system.planaction.server.persistence.api;

import org.cyk.utility.__kernel__.persistence.query.QueryExecutor;
import org.cyk.utility.__kernel__.persistence.query.QueryGetter;
import org.cyk.utility.server.persistence.PersistenceEntity;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlan;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlanActivity;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Activity;

public interface ActionPlanActivityPersistence extends PersistenceEntity<ActionPlanActivity> {

	ActionPlanActivity readByActionPlanCodeByActivityCode(String actionPlanCode,String activityCode);
	
	default ActionPlanActivity readByActionPlanByActivity(ActionPlan actionPlan,Activity activity) {
		if(actionPlan == null || activity == null)
			return null;
		return readByActionPlanCodeByActivityCode(actionPlan.getCode(), activity.getCode());
	}
	
	default Long countByActionPlanCodeByActivityCode(String actionPlanCode,String activityCode) {
		return QueryExecutor.getInstance().executeCount(new QueryExecutor.Arguments().setQuery(QueryGetter.getInstance()
				.getByCount(ActionPlanActivity.class,"countByActionPlanCodeByActivityCode")).setParameters("actionPlanCode",actionPlanCode,"activityCode",activityCode));
	}
	
	default Long countByActionPlanByActivity(ActionPlan actionPlan,Activity activity) {
		if(actionPlan == null || activity == null)
			return 0l;
		return countByActionPlanCodeByActivityCode(actionPlan.getCode(), activity.getCode());
	}
	
}