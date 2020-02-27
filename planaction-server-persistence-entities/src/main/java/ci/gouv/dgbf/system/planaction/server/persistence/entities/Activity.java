package ci.gouv.dgbf.system.planaction.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.cyk.utility.__kernel__.object.__static__.persistence.AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=Activity.TABLE_NAME)
public class Activity extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name = COLUMN_MANAGER) @NotNull private AdministrativeUnit manager;
	@ManyToOne @JoinColumn(name = COLUMN_BENEFICIARY) @NotNull private AdministrativeUnit beneficiary;
	
	/**/
	
	@Override
	public Activity setIdentifier(String identifier) {
		return (Activity) super.setIdentifier(identifier);
	}
	
	public static final String FIELD_MANAGER = "manager";
	public static final String FIELD_BENEFICIARY = "beneficiary";
	
	public static final String TABLE_NAME = "activite";	
	
	public static final String COLUMN_MANAGER = "gestionnaire";
	public static final String COLUMN_BENEFICIARY = "beneficiaire";
}