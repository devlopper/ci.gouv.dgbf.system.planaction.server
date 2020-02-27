package ci.gouv.dgbf.system.planaction.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.cyk.utility.__kernel__.object.__static__.persistence.AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=AdministrativeUnit.TABLE_NAME)
public class AdministrativeUnit extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public AdministrativeUnit setIdentifier(String identifier) {
		return (AdministrativeUnit) super.setIdentifier(identifier);
	}
	
	@Override
	public AdministrativeUnit setCode(String code) {
		return (AdministrativeUnit) super.setCode(code);
	}
	
	@Override
	public AdministrativeUnit setName(String name) {
		return (AdministrativeUnit) super.setName(name);
	}
	
	public static final String TABLE_NAME = "ua";	
}