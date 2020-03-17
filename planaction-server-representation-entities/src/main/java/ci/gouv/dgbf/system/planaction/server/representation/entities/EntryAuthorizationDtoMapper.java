package ci.gouv.dgbf.system.planaction.server.representation.entities;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.EntryAuthorization;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class EntryAuthorizationDtoMapper extends AbstractMapperSourceDestinationImpl<EntryAuthorizationDto, EntryAuthorization> {
	private static final long serialVersionUID = 1L;
     
}