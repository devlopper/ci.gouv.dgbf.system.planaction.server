package ci.gouv.dgbf.system.planaction.server.representation.entities;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.Lessor;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class LessorDtoMapper extends AbstractMapperSourceDestinationImpl<LessorDto, Lessor> {
	private static final long serialVersionUID = 1L;
     
}