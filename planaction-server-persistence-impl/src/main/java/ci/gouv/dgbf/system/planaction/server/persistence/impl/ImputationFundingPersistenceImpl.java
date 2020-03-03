package ci.gouv.dgbf.system.planaction.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.persistence.api.ImputationFundingPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ImputationFunding;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class ImputationFundingPersistenceImpl extends AbstractPersistenceEntityImpl<ImputationFunding> implements ImputationFundingPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}