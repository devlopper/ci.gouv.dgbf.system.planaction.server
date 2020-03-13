package ci.gouv.dgbf.system.planaction.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.representation.api.FundingSourceRepresentation;
import ci.gouv.dgbf.system.planaction.server.representation.entities.FundingSourceDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class FundingSourceRepresentationImpl extends AbstractRepresentationEntityImpl<FundingSourceDto> implements FundingSourceRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}
