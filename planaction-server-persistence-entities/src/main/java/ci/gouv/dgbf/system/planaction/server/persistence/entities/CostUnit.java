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
@Entity @Table(name=CostUnit.TABLE_NAME)
public class CostUnit extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
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
	
	public static final String TABLE_NAME = "uc";	
}