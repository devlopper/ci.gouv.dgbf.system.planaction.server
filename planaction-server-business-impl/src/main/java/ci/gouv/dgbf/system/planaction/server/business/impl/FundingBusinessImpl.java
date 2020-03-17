package ci.gouv.dgbf.system.planaction.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

import ci.gouv.dgbf.system.planaction.server.business.api.FundingBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.api.FundingPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Funding;

@ApplicationScoped
public class FundingBusinessImpl extends AbstractBusinessEntityImpl<Funding, FundingPersistence> implements FundingBusiness,Serializable {
	private static final long serialVersionUID = 1L;
	
}
