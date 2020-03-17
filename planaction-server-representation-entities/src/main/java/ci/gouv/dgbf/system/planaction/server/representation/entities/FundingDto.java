package ci.gouv.dgbf.system.planaction.server.representation.entities;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
public class FundingDto extends AbstractFundingDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public FundingDto setIdentifier(String identifier) {
		return (FundingDto) super.setIdentifier(identifier);
	}

}