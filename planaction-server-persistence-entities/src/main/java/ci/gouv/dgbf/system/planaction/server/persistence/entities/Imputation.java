package ci.gouv.dgbf.system.planaction.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.cyk.utility.__kernel__.instance.InstanceGetter;
import org.cyk.utility.__kernel__.object.__static__.persistence.AbstractIdentifiableSystemScalarStringImpl;
import org.cyk.utility.__kernel__.string.StringHelper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=Imputation.TABLE_NAME,uniqueConstraints= {
		@UniqueConstraint(name=Imputation.UNIQUE_CONSTRAINT_ACTION_PLAN_ACTIVITY_COST_UNIT
				,columnNames= {Imputation.COLUMN_ACTION_PLAN,Imputation.COLUMN_ACTIVITY,Imputation.COLUMN_COST_UNIT}
		)})
public class Imputation extends AbstractIdentifiableSystemScalarStringImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name=COLUMN_ACTION_PLAN) @NotNull private ActionPlan actionPlan;
	@ManyToOne @JoinColumn(name=COLUMN_ACTIVITY) @NotNull private Activity activity;
	@ManyToOne @JoinColumn(name=COLUMN_COST_UNIT) @NotNull private CostUnit costUnit;
	
	@Override
	public Imputation setIdentifier(String identifier) {
		return (Imputation) super.setIdentifier(identifier);
	}
	
	public Imputation setActionPlanFromIdentifier(String identifier) {
		if(StringHelper.isBlank(identifier))
			setActionPlan(null);
		else
			setActionPlan(InstanceGetter.getInstance().getBySystemIdentifier(ActionPlan.class, identifier));
		return this;
	}
	
	public Imputation setActivityFromCode(String code) {
		if(StringHelper.isBlank(code))
			setActivity(null);
		else
			setActivity(InstanceGetter.getInstance().getByBusinessIdentifier(Activity.class, code));
		return this;
	}
	
	public Imputation setCostUnitFromCode(String code) {
		if(StringHelper.isBlank(code))
			setCostUnit(null);
		else
			setCostUnit(InstanceGetter.getInstance().getByBusinessIdentifier(CostUnit.class, code));
		return this;
	}
	
	@Override
	public String toString() {
		return activity+"|"+costUnit;
	}
	
	public static final String FIELD_ACTION_PLAN = "actionPlan";
	public static final String FIELD_ACTIVITY = "activity";
	public static final String FIELD_COST_UNIT = "costUnit";
	
	public static final String TABLE_NAME = "imputation";
	
	public static final String COLUMN_ACTION_PLAN = ActionPlan.TABLE_NAME;
	public static final String COLUMN_ACTIVITY = Activity.TABLE_NAME;
	public static final String COLUMN_COST_UNIT = CostUnit.TABLE_NAME;
	
	
	public static final String UNIQUE_CONSTRAINT_ACTION_PLAN_ACTIVITY_COST_UNIT = COLUMN_ACTION_PLAN+"_"+COLUMN_ACTIVITY+"_"+COLUMN_COST_UNIT;
}