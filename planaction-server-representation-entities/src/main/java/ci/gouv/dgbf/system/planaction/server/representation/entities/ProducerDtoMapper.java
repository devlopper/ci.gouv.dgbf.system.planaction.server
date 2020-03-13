package ci.gouv.dgbf.system.planaction.server.representation.entities;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.Producer;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class ProducerDtoMapper extends AbstractMapperSourceDestinationImpl<ProducerDto, Producer> {
	private static final long serialVersionUID = 1L;
     
}