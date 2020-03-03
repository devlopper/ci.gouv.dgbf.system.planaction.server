package ci.gouv.dgbf.system.planaction.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.planaction.server.representation.entities.CostUnitDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(CostUnitRepresentation.PATH)
public interface CostUnitRepresentation extends RepresentationEntity<CostUnitDto> {
	
	String PATH = "costunit";
	
}
