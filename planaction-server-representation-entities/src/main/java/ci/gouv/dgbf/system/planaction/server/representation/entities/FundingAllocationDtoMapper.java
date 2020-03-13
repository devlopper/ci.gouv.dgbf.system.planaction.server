package ci.gouv.dgbf.system.planaction.server.representation.entities;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.FundingAllocation;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class FundingAllocationDtoMapper extends AbstractMapperSourceDestinationImpl<FundingAllocationDto, FundingAllocation> {
	private static final long serialVersionUID = 1L;
     
}