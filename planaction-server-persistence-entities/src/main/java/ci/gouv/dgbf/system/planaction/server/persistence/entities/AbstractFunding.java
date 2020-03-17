package ci.gouv.dgbf.system.planaction.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.cyk.utility.__kernel__.object.__static__.persistence.AbstractIdentifiableSystemScalarStringImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
@MappedSuperclass
public abstract class AbstractFunding extends AbstractIdentifiableSystemScalarStringImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name=COLUMN_IMPUTATION) @NotNull protected Imputation imputation;
	@Column(name = COLUMN_YEAR) @NotNull @PositiveOrZero protected Short year;
	@Column(name = COLUMN_ENTRY_AUTHORIZATION) @NotNull @PositiveOrZero protected Integer entryAuthorization;
	@Column(name = COLUMN_PAYMENT_CREDIT) @NotNull @PositiveOrZero protected Integer paymentCredit;
	
	@Override
	public String toString() {
		return imputation+" : "+year+" : "+entryAuthorization+" : "+paymentCredit;
	}
	
	public static final String FIELD_IMPUTATION = "imputation";
	public static final String FIELD_YEAR = "year";
	public static final String FIELD_PAYMENT_CREDIT = "paymentCredit";
	public static final String FIELD_ENTRY_AUTHORIZATION = "entryAuthorization";
	
	public static final String COLUMN_IMPUTATION = Imputation.TABLE_NAME;
	public static final String COLUMN_YEAR = "annee";
	public static final String COLUMN_PAYMENT_CREDIT = "cp";
	public static final String COLUMN_ENTRY_AUTHORIZATION = "ae";
}