package ci.gouv.dgbf.system.planaction.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.persistence.api.CostUnitPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.CostUnit;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class CostUnitPersistenceImpl extends AbstractPersistenceEntityImpl<CostUnit> implements CostUnitPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}