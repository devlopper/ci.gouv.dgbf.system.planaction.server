package ci.gouv.dgbf.system.planaction.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.planaction.server.representation.entities.FundingAllocationDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(FundingAllocationRepresentation.PATH)
public interface FundingAllocationRepresentation extends RepresentationEntity<FundingAllocationDto> {
	
	String PATH = "fundingallocation";
	
}
