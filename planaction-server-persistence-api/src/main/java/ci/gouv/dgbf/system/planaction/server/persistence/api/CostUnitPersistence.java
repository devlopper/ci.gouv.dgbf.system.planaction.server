package ci.gouv.dgbf.system.planaction.server.persistence.api;

import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.server.persistence.PersistenceEntity;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.CostUnit;

public interface CostUnitPersistence extends PersistenceEntity<CostUnit> {

	String READ_WHERE_IMPUTATION_DO_NOT_EXIST_BY_ACTION_PLAN_CODE_BY_ACTIVITY_CODE = QueryIdentifierBuilder.getInstance().build(CostUnit.class,"readWhereImputationDoNotExistByActionPlanCodeByActivityCode");
	String COUNT_WHERE_IMPUTATION_DO_NOT_EXIST_BY_ACTION_PLAN_CODE_BY_ACTIVITY_CODE = QueryIdentifierBuilder.getInstance().build(CostUnit.class,"countWhereImputationDoNotExistByActionPlanCodeByActivityCode");
	
}