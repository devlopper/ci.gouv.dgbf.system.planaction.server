package ci.gouv.dgbf.system.planaction.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.planaction.server.representation.entities.ActivityDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(ActivityRepresentation.PATH)
public interface ActivityRepresentation extends RepresentationEntity<ActivityDto> {
	
	String PATH = "activity";
	
}
