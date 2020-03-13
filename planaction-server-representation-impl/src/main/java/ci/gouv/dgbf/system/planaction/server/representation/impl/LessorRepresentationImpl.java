package ci.gouv.dgbf.system.planaction.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.representation.api.LessorRepresentation;
import ci.gouv.dgbf.system.planaction.server.representation.entities.LessorDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class LessorRepresentationImpl extends AbstractRepresentationEntityImpl<LessorDto> implements LessorRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}
