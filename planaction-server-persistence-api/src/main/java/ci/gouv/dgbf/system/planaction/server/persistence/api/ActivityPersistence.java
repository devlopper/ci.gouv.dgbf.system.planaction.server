package ci.gouv.dgbf.system.planaction.server.persistence.api;

import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.server.persistence.PersistenceEntity;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.Activity;

public interface ActivityPersistence extends PersistenceEntity<Activity> {

	String READ_PLANABLE_BY_ADMINISTRATIVE_UNIT_CODE_BY_ACTION_PLAN_CODE = QueryIdentifierBuilder.getInstance().build(Activity.class,"readPlanableByAdministrativeUnitCodeByActionPlanCode");
	String COUNT_PLANABLE_BY_ADMINISTRATIVE_UNIT_CODE_BY_ACTION_PLAN_CODE = QueryIdentifierBuilder.getInstance().build(Activity.class,"countPlanableByAdministrativeUnitCodeByActionPlanCode");
	
	String READ_BY_ADMINISTRATIVE_UNIT_CODES = QueryIdentifierBuilder.getInstance().build(Activity.class,"readByAdministrativeUnitsCodes");
	String COUNT_BY_ADMINISTRATIVE_UNITS_CODES = QueryIdentifierBuilder.getInstance().build(Activity.class,"countByAdministrativeUnitsCodes");
}