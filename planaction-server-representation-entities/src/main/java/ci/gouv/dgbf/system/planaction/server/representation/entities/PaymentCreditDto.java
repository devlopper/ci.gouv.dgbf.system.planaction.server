package ci.gouv.dgbf.system.planaction.server.representation.entities;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
public class PaymentCreditDto extends AbstractAmountPlanningDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private EntryAuthorizationDto entryAuthorization;
	
	@Override
	public PaymentCreditDto setIdentifier(String identifier) {
		return (PaymentCreditDto) super.setIdentifier(identifier);
	}

}