package ci.gouv.dgbf.system.planaction.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.planaction.server.representation.entities.ProducerDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(ProducerRepresentation.PATH)
public interface ProducerRepresentation extends RepresentationEntity<ProducerDto> {
	
	String PATH = "producer";
	
}
