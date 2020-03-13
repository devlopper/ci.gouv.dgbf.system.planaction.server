package ci.gouv.dgbf.system.planaction.server.persistence.api;

import java.util.Collection;

import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.server.persistence.PersistenceEntity;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.Imputation;

public interface ImputationPersistence extends PersistenceEntity<Imputation> {

	Collection<Imputation> readByActionPlanCodeByActivityCode(String actionPlanCode,String activityCode);
	
	String READ_BY_ACTION_PLAN_CODE_BY_ACTIVITY_CODE = QueryIdentifierBuilder.getInstance().build(Imputation.class,"readByActionPlanCodeByActivityCode");
	String COUNT_BY_ACTION_PLAN_CODE_BY_ACTIVITY_CODE = QueryIdentifierBuilder.getInstance().build(Imputation.class,"countByActionPlancodeByActivityCode");
}