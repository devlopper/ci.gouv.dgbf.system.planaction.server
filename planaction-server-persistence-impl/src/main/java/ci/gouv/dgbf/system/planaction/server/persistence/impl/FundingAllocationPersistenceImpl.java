package ci.gouv.dgbf.system.planaction.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.persistence.api.FundingAllocationPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.FundingAllocation;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class FundingAllocationPersistenceImpl extends AbstractPersistenceEntityImpl<FundingAllocation> implements FundingAllocationPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}