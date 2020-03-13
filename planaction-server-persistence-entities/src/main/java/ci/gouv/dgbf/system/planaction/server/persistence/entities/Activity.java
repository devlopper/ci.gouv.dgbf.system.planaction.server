package ci.gouv.dgbf.system.planaction.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.cyk.utility.__kernel__.instance.InstanceGetter;
import org.cyk.utility.__kernel__.object.__static__.persistence.AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl;
import org.cyk.utility.__kernel__.string.StringHelper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=Activity.TABLE_NAME)
@AttributeOverrides(
	value = { 
		@AttributeOverride(name = Activity.FIELD_NAME,column = @Column(name = Activity.COLUMN_NAME,nullable = false,length = 1024 * 1))	
	}	
)
public class Activity extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name = COLUMN_ADMINISTRATIVE_UNIT) @NotNull private AdministrativeUnit administrativeUnit;
	
	@Transient private String activity;
	@Transient private String actionPlanCode;
	@Transient private String administrativeUnitCode;
	@Transient private String administrativeUnitsCodes;
	
	/**/
	
	@Override
	public Activity setIdentifier(String identifier) {
		return (Activity) super.setIdentifier(identifier);
	}
	
	@Override
	public Activity setCode(String code) {
		return (Activity) super.setCode(code);
	}
	
	@Override
	public Activity setName(String name) {
		return (Activity) super.setName(name);
	}
	
	public Activity setAdministrativeUnitFromCode(String code) {
		if(StringHelper.isBlank(code))
			administrativeUnit = null;
		else
			administrativeUnit = InstanceGetter.getInstance().getByBusinessIdentifier(AdministrativeUnit.class, code);
		return this;
	}
	
	/**/
	
	@Override
	public String toString() {
		return getCode()+" "+getName();
	}
	
	/**/
	
	public static final String FIELD_ADMINISTRATIVE_UNIT = "administrativeUnit";
	
	public static final String TABLE_NAME = "activite";	
	
	public static final String COLUMN_ADMINISTRATIVE_UNIT = AdministrativeUnit.TABLE_NAME;
}