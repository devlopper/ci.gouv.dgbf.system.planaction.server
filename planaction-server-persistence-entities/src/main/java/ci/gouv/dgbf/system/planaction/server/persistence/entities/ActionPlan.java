package ci.gouv.dgbf.system.planaction.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.cyk.utility.__kernel__.instance.InstanceGetter;
import org.cyk.utility.__kernel__.object.__static__.persistence.AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl;
import org.cyk.utility.__kernel__.string.StringHelper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=ActionPlan.TABLE_NAME,uniqueConstraints= {
		@UniqueConstraint(name=ActionPlan.UNIQUE_CONSTRAINT_ADMINISTRATIVE_ORDER_NUMBER_VERSION
				,columnNames= {ActionPlan.COLUMN_ADMINISTRATIVE_UNIT,ActionPlan.COLUMN_YEAR,ActionPlan.COLUMN_ORDER_NUMBER}
		)})
public class ActionPlan extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name = COLUMN_ADMINISTRATIVE_UNIT) @NotNull private AdministrativeUnit administrativeUnit;
	@Column(name = COLUMN_YEAR) @NotNull private Short year;
	@Column(name = COLUMN_ORDER_NUMBER) @NotNull private Byte orderNumber;
	//@Column(name = COLUMN_VERSION) @NotNull private Integer version;
	
	@Override
	public ActionPlan setIdentifier(String identifier) {
		return (ActionPlan) super.setIdentifier(identifier);
	}
	
	@Override
	public ActionPlan setCode(String code) {
		return (ActionPlan) super.setCode(code);
	}
	
	@Override
	public ActionPlan setName(String name) {
		return (ActionPlan) super.setName(name);
	}
	
	public ActionPlan setAdministrativeUnitFromCode(String code) {
		if(StringHelper.isBlank(code))
			setAdministrativeUnit(null);
		else
			setAdministrativeUnit(InstanceGetter.getInstance().getByBusinessIdentifier(AdministrativeUnit.class, code));
		return this;
	}
	
	public static final String FIELD_ADMINISTRATIVE_UNIT = "administrativeUnit";
	public static final String FIELD_YEAR = "year";
	public static final String FIELD_ORDER_NUMBER = "orderNumber";
	//public static final String FIELD_VERSION = "version";
	
	public static final String TABLE_NAME = "pa";
	
	public static final String COLUMN_ADMINISTRATIVE_UNIT = AdministrativeUnit.TABLE_NAME;
	public static final String COLUMN_YEAR = "annee";
	public static final String COLUMN_ORDER_NUMBER = "numero_ordre";
	//public static final String COLUMN_VERSION = "version";

	//public static final String UNIQUE_CONSTRAINT_ADMINISTRATIVE_YEAR_VERSION = COLUMN_ADMINISTRATIVE_UNIT+"_"+COLUMN_YEAR+"_"+COLUMN_VERSION;
	public static final String UNIQUE_CONSTRAINT_ADMINISTRATIVE_ORDER_NUMBER_VERSION = COLUMN_ADMINISTRATIVE_UNIT+"_"+COLUMN_YEAR+"_"+COLUMN_ORDER_NUMBER;
}