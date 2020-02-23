package ci.gouv.dgbf.system.planaction.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.planaction.server.representation.entities.AdministrativeUnitDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(AdministrativeUnitRepresentation.PATH)
public interface AdministrativeUnitRepresentation extends RepresentationEntity<AdministrativeUnitDto> {
	
	String PATH = "administrativeunit";
	
}
