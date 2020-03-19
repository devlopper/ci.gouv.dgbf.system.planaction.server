package ci.gouv.dgbf.system.planaction.server.representation.entities;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
public class EntryAuthorizationDto extends AbstractAmountPlanningDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ImputationDto imputation;
	private Long paymentCreditsAmountsCumulation;
	
	@Override
	public EntryAuthorizationDto setIdentifier(String identifier) {
		return (EntryAuthorizationDto) super.setIdentifier(identifier);
	}

}