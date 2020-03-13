package ci.gouv.dgbf.system.planaction.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.representation.api.FundingAllocationRepresentation;
import ci.gouv.dgbf.system.planaction.server.representation.entities.FundingAllocationDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class FundingAllocationRepresentationImpl extends AbstractRepresentationEntityImpl<FundingAllocationDto> implements FundingAllocationRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}
