package ci.gouv.dgbf.system.planaction.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.persistence.api.LessorPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Lessor;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class LessorPersistenceImpl extends AbstractPersistenceEntityImpl<Lessor> implements LessorPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}