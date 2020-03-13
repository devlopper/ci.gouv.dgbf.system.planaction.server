package ci.gouv.dgbf.system.planaction.server.representation.entities;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.Funding;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class FundingDtoMapper extends AbstractMapperSourceDestinationImpl<FundingDto, Funding> {
	private static final long serialVersionUID = 1L;
     
}