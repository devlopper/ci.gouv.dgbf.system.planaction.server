package ci.gouv.dgbf.system.planaction.server.representation.entities;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
public class FundingAllocationDto extends AbstractFundingDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private FundingSourceDto fundingSource;
	private LessorDto lessor;
	
	@Override
	public FundingAllocationDto setIdentifier(String identifier) {
		return (FundingAllocationDto) super.setIdentifier(identifier);
	}
}