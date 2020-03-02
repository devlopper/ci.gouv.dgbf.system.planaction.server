package ci.gouv.dgbf.system.planaction.server.persistence.api.query;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.persistence.query.ByReferencesQuerier;
import org.cyk.utility.__kernel__.persistence.query.annotation.Queries;
import org.cyk.utility.__kernel__.persistence.query.annotation.Query;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.AdministrativeUnit;

@Queries(value = {
		@Query(tupleClass = Activity.class,name = ActivityByActionPlansQuerier.QUERY_NAME_READ,value = "SELECT activity FROM Activity activity WHERE activity.administrativeUnit.code IN :"+ActivityByActionPlansQuerier.PARAMETER_NAME_ADMINISTRATIVE_UNITS_CODES)
})
public interface ActivityByActionPlansQuerier extends ByReferencesQuerier<Activity, String,AdministrativeUnit,String> {

	/**/
	
	static ActivityByActionPlansQuerier getInstance() {
		return Helper.getInstance(ActivityByActionPlansQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = DependencyInjection.inject(Value.class);
	
	String QUERY_NAME_READ = "readByAdministrativeUnitsCodes";
	String QUERY_NAME_COUNT = "countByAdministrativeUnitsCodes";
	String PARAMETER_NAME_ADMINISTRATIVE_UNITS_CODES = "administrativeUnitsCodes";
}
