package ci.gouv.dgbf.system.planaction.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=EntryAuthorization.TABLE_NAME,uniqueConstraints= {
		@UniqueConstraint(name=EntryAuthorization.UNIQUE_CONSTRAINT_IMPUTATION_YEAR
				,columnNames= {EntryAuthorization.COLUMN_IMPUTATION,EntryAuthorization.COLUMN_YEAR})})
public class EntryAuthorization extends AbstractAmountPlanning implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name=COLUMN_IMPUTATION) @NotNull protected Imputation imputation;
	
	@Transient private Long paymentCreditsAmountsCumulation;
	
	@Override
	public EntryAuthorization setIdentifier(String identifier) {
		return (EntryAuthorization) super.setIdentifier(identifier);
	}
	
	@Override
	public String toString() {
		return String.format(TO_STRING_FORMAT, imputation,year,amount);
	}
	
	private static final String TO_STRING_FORMAT = "%s/%s/%s";
	
	public static final String FIELD_IMPUTATION = "imputation";
	
	public static final String TABLE_NAME = "ae";
	
	public static final String COLUMN_IMPUTATION = Imputation.TABLE_NAME;
	
	public static final String UNIQUE_CONSTRAINT_IMPUTATION_YEAR = COLUMN_IMPUTATION+"_"+COLUMN_YEAR;
}