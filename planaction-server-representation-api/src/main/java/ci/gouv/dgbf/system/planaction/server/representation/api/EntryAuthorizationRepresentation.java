package ci.gouv.dgbf.system.planaction.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.planaction.server.representation.entities.EntryAuthorizationDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(EntryAuthorizationRepresentation.PATH)
public interface EntryAuthorizationRepresentation extends RepresentationEntity<EntryAuthorizationDto> {
	
	String PATH = "entryauthorization";
	
}
