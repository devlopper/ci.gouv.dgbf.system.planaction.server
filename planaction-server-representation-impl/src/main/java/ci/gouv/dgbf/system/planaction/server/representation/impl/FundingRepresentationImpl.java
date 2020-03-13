package ci.gouv.dgbf.system.planaction.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.representation.api.FundingRepresentation;
import ci.gouv.dgbf.system.planaction.server.representation.entities.FundingDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class FundingRepresentationImpl extends AbstractRepresentationEntityImpl<FundingDto> implements FundingRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}
