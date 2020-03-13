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
@Entity @Table(name=Lessor.TABLE_NAME)
public class Lessor extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public Lessor setIdentifier(String identifier) {
		return (Lessor) super.setIdentifier(identifier);
	}
	
	@Override
	public Lessor setCode(String code) {
		return (Lessor) super.setCode(code);
	}
	
	@Override
	public Lessor setName(String name) {
		return (Lessor) super.setName(name);
	}
	
	public static final String TABLE_NAME = "bailleur";	
}