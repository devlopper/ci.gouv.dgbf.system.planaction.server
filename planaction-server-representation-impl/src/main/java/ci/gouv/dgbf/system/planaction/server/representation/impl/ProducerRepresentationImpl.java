package ci.gouv.dgbf.system.planaction.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.representation.api.ProducerRepresentation;
import ci.gouv.dgbf.system.planaction.server.representation.entities.ProducerDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class ProducerRepresentationImpl extends AbstractRepresentationEntityImpl<ProducerDto> implements ProducerRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}
