package ci.gouv.dgbf.system.planaction.server.persistence.api.query;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.persistence.query.ByDimensionOneBusinessIdentifierQuerier;
import org.cyk.utility.__kernel__.persistence.query.annotation.Queries;
import org.cyk.utility.__kernel__.persistence.query.annotation.Query;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.AdministrativeUnit;

@Queries(value = {
		@Query(tupleClass = Activity.class,name = ActivityByAdministrativeUnitsQuerier.QUERY_NAME_READ,value = "SELECT tuple FROM Activity tuple WHERE tuple.administrativeUnit.code IN :"+ActivityByAdministrativeUnitsQuerier.PARAMETER_NAME_ADMINISTRATIVE_UNITS_CODES)
})
public interface ActivityByAdministrativeUnitsQuerier extends ByDimensionOneBusinessIdentifierQuerier<Activity,AdministrativeUnit,String> {

	/**/
	
	static ActivityByAdministrativeUnitsQuerier getInstance() {
		return Helper.getInstance(ActivityByAdministrativeUnitsQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = DependencyInjection.inject(Value.class);
	
	String QUERY_NAME_READ = "readByAdministrativeUnitsCodes";
	String QUERY_NAME_COUNT = "countByAdministrativeUnitsCodes";
	String PARAMETER_NAME_ADMINISTRATIVE_UNITS_CODES = "administrativeUnitsCodes";
}