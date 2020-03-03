package ci.gouv.dgbf.system.planaction.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.planaction.server.representation.entities.ActionPlanActivityDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(ActionPlanActivityRepresentation.PATH)
public interface ActionPlanActivityRepresentation extends RepresentationEntity<ActionPlanActivityDto> {
	
	String PATH = "actionplanactivity";
	
}
