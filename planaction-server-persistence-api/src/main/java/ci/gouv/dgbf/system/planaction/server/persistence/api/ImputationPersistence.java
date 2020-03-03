package ci.gouv.dgbf.system.planaction.server.persistence.api;

import java.util.Collection;

import org.cyk.utility.server.persistence.PersistenceEntity;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.Imputation;

public interface ImputationPersistence extends PersistenceEntity<Imputation> {

	Collection<Imputation> readByActionPlanCodeByActivityCode(String actionPlanCode,String activityCode);
	
}