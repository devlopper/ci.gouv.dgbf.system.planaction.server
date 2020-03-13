package ci.gouv.dgbf.system.planaction.server.representation.entities;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.Amount;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class AmountDtoMapper extends AbstractMapperSourceDestinationImpl<AmountDto, Amount> {
	private static final long serialVersionUID = 1L;
     
}