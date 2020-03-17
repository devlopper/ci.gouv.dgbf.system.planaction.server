package ci.gouv.dgbf.system.planaction.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=Funding.TABLE_NAME,uniqueConstraints= {
		@UniqueConstraint(name=Funding.UNIQUE_CONSTRAINT_IMPUTATION_FUNDING_YEAR,columnNames= {Funding.COLUMN_IMPUTATION,Amount.COLUMN_YEAR})})
public class Funding extends AbstractFunding implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Transient private ActionPlan actionPlan;
	@Transient private Activity activity;
	
	@Override
	public Funding setIdentifier(String identifier) {
		return (Funding) super.setIdentifier(identifier);
	}
		
	public static final String FIELD_ACTION_PLAN = "actionPlan";
	public static final String FIELD_ACTIVITY = "activity";
	
	public static final String TABLE_NAME = "financement";	
	
	public static final String UNIQUE_CONSTRAINT_IMPUTATION_FUNDING_YEAR = COLUMN_IMPUTATION+"_"+Amount.COLUMN_YEAR;
}