package ci.gouv.dgbf.system.planaction.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.cyk.utility.__kernel__.object.__static__.persistence.AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=Producer.TABLE_NAME) @Inheritance(strategy = InheritanceType.JOINED)
@AttributeOverrides(
	value = { 
		@AttributeOverride(name = Producer.FIELD_NAME,column = @Column(name = Producer.COLUMN_NAME,nullable = false,length = 1024 * 1))	
	}	
)
public class Producer extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public Producer setIdentifier(String identifier) {
		return (Producer) super.setIdentifier(identifier);
	}
	
	@Override
	public Producer setCode(String code) {
		return (Producer) super.setCode(code);
	}
	
	@Override
	public Producer setName(String name) {
		return (Producer) super.setName(name);
	}
	
	@Override
	public String toString() {
		return getCode()+" "+getName();
	}
	
	public static final String TABLE_NAME = "realisateur";
}