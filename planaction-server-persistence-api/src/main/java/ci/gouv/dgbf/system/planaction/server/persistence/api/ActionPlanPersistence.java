package ci.gouv.dgbf.system.planaction.server.persistence.api;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlan;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.server.persistence.PersistenceEntity;

public interface ActionPlanPersistence extends PersistenceEntity<ActionPlan> {

	Byte readMaxOrderNumberByAdministrativeUnitCodeByYear(String administrativeUnitCode,Short year,Properties properties);
	
}