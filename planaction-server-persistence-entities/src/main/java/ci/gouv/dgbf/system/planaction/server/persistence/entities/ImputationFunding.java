package ci.gouv.dgbf.system.planaction.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.cyk.utility.__kernel__.object.__static__.persistence.AbstractIdentifiableSystemScalarStringImpl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=ImputationFunding.TABLE_NAME,uniqueConstraints= {
		@UniqueConstraint(name=ImputationFunding.UNIQUE_CONSTRAINT_IMPUTATION_FUNDING_YEAR
				,columnNames= {ImputationFunding.COLUMN_IMPUTATION,ImputationFunding.COLUMN_YEAR}
		)})
public class ImputationFunding extends AbstractIdentifiableSystemScalarStringImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name=COLUMN_IMPUTATION) @NotNull private Imputation imputation;
	@Column(name = COLUMN_YEAR) @NotNull @PositiveOrZero private Short year;
	@Column(name = COLUMN_PAYMENT_CREDIT) @NotNull @PositiveOrZero private Integer paymentCredit;
	@Column(name = COLUMN_ENTRY_AUTHORIZATION) @NotNull @PositiveOrZero private Integer entryAuthorization;
	
	@Override
	public ImputationFunding setIdentifier(String identifier) {
		return (ImputationFunding) super.setIdentifier(identifier);
	}
	
	public static final String FIELD_IMPUTATION = "imputation";
	public static final String FIELD_YEAR = "year";
	public static final String FIELD_PAYMENT_CREDIT = "paymentCredit";
	public static final String FIELD_ENTRY_AUTHORIZATION = "entryAuthorization";
	
	public static final String TABLE_NAME = "financement";	
	
	public static final String COLUMN_IMPUTATION = Imputation.TABLE_NAME;
	public static final String COLUMN_YEAR = "annee";
	public static final String COLUMN_PAYMENT_CREDIT = "cp";
	public static final String COLUMN_ENTRY_AUTHORIZATION = "ae";
	
	public static final String UNIQUE_CONSTRAINT_IMPUTATION_FUNDING_YEAR = COLUMN_IMPUTATION+"_"+COLUMN_YEAR;
}