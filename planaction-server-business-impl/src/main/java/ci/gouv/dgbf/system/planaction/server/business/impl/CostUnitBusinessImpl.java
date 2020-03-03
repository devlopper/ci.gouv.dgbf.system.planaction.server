package ci.gouv.dgbf.system.planaction.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.business.api.CostUnitBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.api.CostUnitPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.CostUnit;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class CostUnitBusinessImpl extends AbstractBusinessEntityImpl<CostUnit, CostUnitPersistence> implements CostUnitBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}
