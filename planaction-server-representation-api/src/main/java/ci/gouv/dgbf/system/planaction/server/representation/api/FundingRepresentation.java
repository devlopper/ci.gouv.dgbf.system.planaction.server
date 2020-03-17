package ci.gouv.dgbf.system.planaction.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.planaction.server.representation.entities.FundingDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(FundingRepresentation.PATH)
public interface FundingRepresentation extends RepresentationEntity<FundingDto> {
	
	String PATH = "funding";
	
}
