package ci.gouv.dgbf.system.planaction.server.persistence.api;

import java.util.Collection;

import org.cyk.utility.server.persistence.PersistenceEntity;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.Imputation;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ImputationFunding;

public interface ImputationFundingPersistence extends PersistenceEntity<ImputationFunding> {

	Collection<ImputationFunding> readByImputations(Collection<Imputation> imputations);
	
}