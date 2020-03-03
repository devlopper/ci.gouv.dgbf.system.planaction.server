package ci.gouv.dgbf.system.planaction.server.representation.entities;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlanActivity;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class ActionPlanActivityDtoMapper extends AbstractMapperSourceDestinationImpl<ActionPlanActivityDto, ActionPlanActivity> {
	private static final long serialVersionUID = 1L;
     
}