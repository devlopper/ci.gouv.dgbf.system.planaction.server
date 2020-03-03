package ci.gouv.dgbf.system.planaction.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.planaction.server.representation.entities.ImputationFundingDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(ImputationFundingRepresentation.PATH)
public interface ImputationFundingRepresentation extends RepresentationEntity<ImputationFundingDto> {
	
	String PATH = "imputationfunding";
	
}
