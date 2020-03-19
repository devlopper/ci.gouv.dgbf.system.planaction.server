package ci.gouv.dgbf.system.planaction.server.representation.entities;

import java.io.Serializable;

import org.cyk.utility.__kernel__.object.__static__.representation.AbstractIdentifiableSystemScalarStringImpl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
public class ImputationDto extends AbstractIdentifiableSystemScalarStringImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ActionPlanDto actionPlan;
	private ActivityDto activity;
	private CostUnitDto costUnit;
	
	private Long fundingEntryAuthorizationsCumulation;
	private Long entryAuthorizationsAmountsCumulation;
	
	@Override
	public ImputationDto setIdentifier(String identifier) {
		return (ImputationDto) super.setIdentifier(identifier);
	}

}