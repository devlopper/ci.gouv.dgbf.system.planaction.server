package ci.gouv.dgbf.system.planaction.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.cyk.utility.__kernel__.object.__static__.persistence.AbstractIdentifiableSystemScalarStringImpl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=Funding.TABLE_NAME,uniqueConstraints= {
		@UniqueConstraint(name=Funding.UNIQUE_CONSTRAINT_IMPUTATION_FUNDING_YEAR,columnNames= {Funding.COLUMN_IMPUTATION,Amount.COLUMN_YEAR})})
public class Funding extends AbstractIdentifiableSystemScalarStringImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name=COLUMN_IMPUTATION) @NotNull private Imputation imputation;
	@Embedded private Amount amount;
	
	@Transient private ActionPlan actionPlan;
	@Transient private Activity activity;
	
	@Override
	public Funding setIdentifier(String identifier) {
		return (Funding) super.setIdentifier(identifier);
	}
	
	public Amount getAmount(Boolean instantiateIfNull) {
		if(amount == null && Boolean.TRUE.equals(instantiateIfNull))
			amount = new Amount();
		return amount;
	}
	
	public static final String FIELD_IMPUTATION = "imputation";
	public static final String FIELD_AMOUNT = "amount";
	public static final String FIELD_ACTION_PLAN = "actionPlan";
	public static final String FIELD_ACTIVITY = "activity";
	
	public static final String TABLE_NAME = "financement";	
	
	public static final String COLUMN_IMPUTATION = Imputation.TABLE_NAME;
	
	public static final String UNIQUE_CONSTRAINT_IMPUTATION_FUNDING_YEAR = COLUMN_IMPUTATION+"_"+Amount.COLUMN_YEAR;
}