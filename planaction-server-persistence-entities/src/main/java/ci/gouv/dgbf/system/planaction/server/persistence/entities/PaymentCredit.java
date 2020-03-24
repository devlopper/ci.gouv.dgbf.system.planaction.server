package ci.gouv.dgbf.system.planaction.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=PaymentCredit.TABLE_NAME,uniqueConstraints= {
		@UniqueConstraint(name=PaymentCredit.UNIQUE_CONSTRAINT_ENTRY_AUTHORIZATION_YEAR,columnNames= {PaymentCredit.COLUMN_ENTRY_AUTHORIZATION,PaymentCredit.COLUMN_YEAR})})
public class PaymentCredit extends AbstractAmountPlanning implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name=COLUMN_ENTRY_AUTHORIZATION) @NotNull private EntryAuthorization entryAuthorization;
	
	@Override
	public PaymentCredit setIdentifier(String identifier) {
		return (PaymentCredit) super.setIdentifier(identifier);
	}
	
	@Override
	public PaymentCredit setYear(Short year) {
		return (PaymentCredit) super.setYear(year);
	}
	
	@Override
	public PaymentCredit setAmount(Long amount) {
		return (PaymentCredit) super.setAmount(amount);
	}
	
	@Override
	public String toString() {
		return String.format(TO_STRING_FORMAT, entryAuthorization,year,amount);
	}
	
	private static final String TO_STRING_FORMAT = "%s/%s/%s";
	
	public static final String FIELD_ENTRY_AUTHORIZATION = "entryAuthorization";
	
	public static final String TABLE_NAME = "cp";
	
	public static final String COLUMN_ENTRY_AUTHORIZATION = "ae";
	
	public static final String UNIQUE_CONSTRAINT_ENTRY_AUTHORIZATION_YEAR = COLUMN_ENTRY_AUTHORIZATION+"_"+COLUMN_YEAR;
}