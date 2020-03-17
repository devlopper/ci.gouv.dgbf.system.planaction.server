package ci.gouv.dgbf.system.planaction.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.representation.api.EntryAuthorizationRepresentation;
import ci.gouv.dgbf.system.planaction.server.representation.entities.EntryAuthorizationDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class EntryAuthorizationRepresentationImpl extends AbstractRepresentationEntityImpl<EntryAuthorizationDto> implements EntryAuthorizationRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}
