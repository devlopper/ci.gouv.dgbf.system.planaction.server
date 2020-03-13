package ci.gouv.dgbf.system.planaction.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.business.api.ProducerBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ProducerPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Producer;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class ProducerBusinessImpl extends AbstractBusinessEntityImpl<Producer, ProducerPersistence> implements ProducerBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}
