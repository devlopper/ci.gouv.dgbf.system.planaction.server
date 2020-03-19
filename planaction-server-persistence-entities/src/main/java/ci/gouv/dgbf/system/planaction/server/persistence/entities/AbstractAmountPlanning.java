package ci.gouv.dgbf.system.planaction.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.cyk.utility.__kernel__.object.__static__.persistence.AbstractIdentifiableSystemScalarStringImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
@MappedSuperclass
public abstract class AbstractAmountPlanning extends AbstractIdentifiableSystemScalarStringImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = COLUMN_YEAR) @NotNull @Positive protected Short year;
	@Column(name = COLUMN_AMOUNT) @NotNull @Positive protected Long amount;
	
	@Transient protected Producer producer;
	@Transient protected ActionPlan actionPlan;
	@Transient protected Activity activity;
	@Transient protected CostUnit costUnit;
	
	
	public static final String FIELD_YEAR = "year";
	public static final String FIELD_AMOUNT = "amount";
	public static final String FIELD_PRODUCER = "producer";
	public static final String FIELD_ACTION_PLAN = "actionPlan";
	public static final String FIELD_ACTIVITY = "activity";
	public static final String FIELD_COST_UNIT = "costUnit";
		
	public static final String COLUMN_YEAR = "annee";
	public static final String COLUMN_AMOUNT = "montant";
}