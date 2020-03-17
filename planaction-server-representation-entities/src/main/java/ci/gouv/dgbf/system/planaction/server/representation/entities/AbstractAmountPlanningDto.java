package ci.gouv.dgbf.system.planaction.server.representation.entities;

import java.io.Serializable;

import org.cyk.utility.__kernel__.object.__static__.representation.AbstractIdentifiableSystemScalarStringImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public abstract class AbstractAmountPlanningDto extends AbstractIdentifiableSystemScalarStringImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected Short year;
	protected Integer amount;
	
	protected ActionPlanDto actionPlan;
	protected ActivityDto activity;
	protected CostUnitDto costUnit;
	
	@Override
	public AbstractAmountPlanningDto setIdentifier(String identifier) {
		return (AbstractAmountPlanningDto) super.setIdentifier(identifier);
	}

}