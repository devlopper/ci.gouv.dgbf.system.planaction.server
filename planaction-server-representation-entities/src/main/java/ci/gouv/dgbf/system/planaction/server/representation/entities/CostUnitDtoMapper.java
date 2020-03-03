package ci.gouv.dgbf.system.planaction.server.representation.entities;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.CostUnit;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class CostUnitDtoMapper extends AbstractMapperSourceDestinationImpl<CostUnitDto, CostUnit> {
	private static final long serialVersionUID = 1L;
     
}