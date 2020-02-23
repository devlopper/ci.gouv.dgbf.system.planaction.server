package ci.gouv.dgbf.system.planaction.server.representation.entities;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlan;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class ActionPlanDtoMapper extends AbstractMapperSourceDestinationImpl<ActionPlanDto, ActionPlan> {
	private static final long serialVersionUID = 1L;
     
}