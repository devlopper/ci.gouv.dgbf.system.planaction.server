package ci.gouv.dgbf.system.planaction.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.persistence.api.AdministrativeUnitPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.AdministrativeUnit;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class AdministrativeUnitPersistenceImpl extends AbstractPersistenceEntityImpl<AdministrativeUnit> implements AdministrativeUnitPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}