package ci.gouv.dgbf.system.planaction.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.planaction.server.representation.entities.PaymentCreditDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(PaymentCreditRepresentation.PATH)
public interface PaymentCreditRepresentation extends RepresentationEntity<PaymentCreditDto> {
	
	String PATH = "paymentcredit";
	
}
