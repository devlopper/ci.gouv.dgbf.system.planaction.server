package ci.gouv.dgbf.system.planaction.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.persistence.api.ProducerPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Producer;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class ProducerPersistenceImpl extends AbstractPersistenceEntityImpl<Producer> implements ProducerPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}