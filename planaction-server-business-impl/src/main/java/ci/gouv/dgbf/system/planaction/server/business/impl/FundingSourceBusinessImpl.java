package ci.gouv.dgbf.system.planaction.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.business.api.FundingSourceBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.api.FundingSourcePersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.FundingSource;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class FundingSourceBusinessImpl extends AbstractBusinessEntityImpl<FundingSource, FundingSourcePersistence> implements FundingSourceBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}
