package ci.gouv.dgbf.system.planaction.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.representation.api.ImputationFundingRepresentation;
import ci.gouv.dgbf.system.planaction.server.representation.entities.ImputationFundingDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class ImputationFundingRepresentationImpl extends AbstractRepresentationEntityImpl<ImputationFundingDto> implements ImputationFundingRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}
