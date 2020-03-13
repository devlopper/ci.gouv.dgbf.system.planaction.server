package ci.gouv.dgbf.system.planaction.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.planaction.server.representation.entities.LessorDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(LessorRepresentation.PATH)
public interface LessorRepresentation extends RepresentationEntity<LessorDto> {
	
	String PATH = "lessor";
	
}
