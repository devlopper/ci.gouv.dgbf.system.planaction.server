package ci.gouv.dgbf.system.planaction.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.cyk.utility.__kernel__.object.__static__.persistence.AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=CostUnit.TABLE_NAME)
public class CostUnit extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Transient private String actionPlan;
	@Transient private String activity;
	
	@Override
	public CostUnit setIdentifier(String identifier) {
		return (CostUnit) super.setIdentifier(identifier);
	}
	
	@Override
	public CostUnit setCode(String code) {
		return (CostUnit) super.setCode(code);
	}
	
	@Override
	public CostUnit setName(String name) {
		return (CostUnit) super.setName(name);
	}
	
	@Override
	public String toString() {
		return getCode()+" "+getName();
	}
	
	public static final String FIELD_ACTION_PLAN = "actionPlan";
	public static final String FIELD_ACTIVITY = "activity";
	
	public static final String TABLE_NAME = "uc";	
}