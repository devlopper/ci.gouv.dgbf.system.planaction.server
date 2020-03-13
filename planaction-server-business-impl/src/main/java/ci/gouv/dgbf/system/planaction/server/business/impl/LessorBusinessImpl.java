package ci.gouv.dgbf.system.planaction.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.business.api.LessorBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.api.LessorPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Lessor;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class LessorBusinessImpl extends AbstractBusinessEntityImpl<Lessor, LessorPersistence> implements LessorBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}
