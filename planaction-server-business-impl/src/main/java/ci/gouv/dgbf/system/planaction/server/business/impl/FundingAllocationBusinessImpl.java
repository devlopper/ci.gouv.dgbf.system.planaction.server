package ci.gouv.dgbf.system.planaction.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.business.api.FundingAllocationBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.api.FundingAllocationPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.FundingAllocation;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class FundingAllocationBusinessImpl extends AbstractBusinessEntityImpl<FundingAllocation, FundingAllocationPersistence> implements FundingAllocationBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}
