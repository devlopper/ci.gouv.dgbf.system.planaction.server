package ci.gouv.dgbf.system.planaction.server.representation.entities;

import java.io.Serializable;

import org.cyk.utility.__kernel__.object.__static__.representation.AbstractIdentifiableSystemScalarStringImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public abstract class AbstractFundingDto extends AbstractIdentifiableSystemScalarStringImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected ImputationDto imputation;
	protected Short year;
	protected Integer paymentCredit;
	protected Integer entryAuthorization;
	
	@Override
	public AbstractFundingDto setIdentifier(String identifier) {
		return (AbstractFundingDto) super.setIdentifier(identifier);
	}

}