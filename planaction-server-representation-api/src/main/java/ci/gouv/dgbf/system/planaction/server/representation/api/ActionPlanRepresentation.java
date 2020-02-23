package ci.gouv.dgbf.system.planaction.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.planaction.server.representation.entities.ActionPlanDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(ActionPlanRepresentation.PATH)
public interface ActionPlanRepresentation extends RepresentationEntity<ActionPlanDto> {
	
	String PATH = "actionplan";
	
}
