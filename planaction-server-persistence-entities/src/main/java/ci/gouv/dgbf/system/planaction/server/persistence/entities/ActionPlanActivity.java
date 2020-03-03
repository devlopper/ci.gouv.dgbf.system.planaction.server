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
@Entity @Table(name=ActionPlanActivity.TABLE_NAME,uniqueConstraints= {
		@UniqueConstraint(name=ActionPlanActivity.UNIQUE_CONSTRAINT_ACTION_PLAN_ACTIVITY
				,columnNames= {ActionPlanActivity.COLUMN_ACTION_PLAN,ActionPlanActivity.COLUMN_ACTIVITY}
		)})
public class ActionPlanActivity extends AbstractIdentifiableSystemScalarStringImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name=COLUMN_ACTION_PLAN) @NotNull private ActionPlan actionPlan;
	@ManyToOne @JoinColumn(name=COLUMN_ACTIVITY) @NotNull private Activity activity;
	
	@Override
	public ActionPlanActivity setIdentifier(String identifier) {
		return (ActionPlanActivity) super.setIdentifier(identifier);
	}
	
	public ActionPlanActivity setActionPlanFromIdentifier(String identifier) {
		if(StringHelper.isBlank(identifier))
			setActionPlan(null);
		else
			setActionPlan(InstanceGetter.getInstance().getBySystemIdentifier(ActionPlan.class, identifier));
		return this;
	}
	
	public ActionPlanActivity setActivityFromCode(String code) {
		if(StringHelper.isBlank(code))
			setActivity(null);
		else
			setActivity(InstanceGetter.getInstance().getByBusinessIdentifier(Activity.class, code));
		return this;
	}
	
	public static final String FIELD_ACTION_PLAN = "actionPlan";
	public static final String FIELD_ACTIVITY = "activity";
	
	public static final String TABLE_NAME = ActionPlan.TABLE_NAME+"_"+Activity.TABLE_NAME;
	
	public static final String COLUMN_ACTION_PLAN = ActionPlan.TABLE_NAME;
	public static final String COLUMN_ACTIVITY = Activity.TABLE_NAME;
	
	public static final String UNIQUE_CONSTRAINT_ACTION_PLAN_ACTIVITY = COLUMN_ACTION_PLAN+"_"+COLUMN_ACTIVITY;
}