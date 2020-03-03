package ci.gouv.dgbf.system.planaction.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.business.api.ImputationFundingBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ImputationFundingPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ImputationFunding;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class ImputationFundingBusinessImpl extends AbstractBusinessEntityImpl<ImputationFunding, ImputationFundingPersistence> implements ImputationFundingBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}
