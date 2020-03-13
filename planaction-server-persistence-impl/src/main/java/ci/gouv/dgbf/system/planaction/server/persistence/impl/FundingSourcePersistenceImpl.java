package ci.gouv.dgbf.system.planaction.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.persistence.api.FundingSourcePersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.FundingSource;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class FundingSourcePersistenceImpl extends AbstractPersistenceEntityImpl<FundingSource> implements FundingSourcePersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}