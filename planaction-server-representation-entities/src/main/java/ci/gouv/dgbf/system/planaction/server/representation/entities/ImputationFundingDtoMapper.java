package ci.gouv.dgbf.system.planaction.server.representation.entities;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.ImputationFunding;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class ImputationFundingDtoMapper extends AbstractMapperSourceDestinationImpl<ImputationFundingDto, ImputationFunding> {
	private static final long serialVersionUID = 1L;
     
}