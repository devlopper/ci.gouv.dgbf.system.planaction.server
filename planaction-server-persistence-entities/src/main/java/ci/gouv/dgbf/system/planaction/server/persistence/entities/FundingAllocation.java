package ci.gouv.dgbf.system.planaction.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.cyk.utility.__kernel__.object.__static__.persistence.AbstractIdentifiableSystemScalarStringImpl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=FundingAllocation.TABLE_NAME,uniqueConstraints= {
		@UniqueConstraint(name=FundingAllocation.UNIQUE_CONSTRAINT_IMPUTATION_FUNDING_SOURCE_LESSOR_YEAR
				,columnNames= {FundingAllocation.COLUMN_IMPUTATION,FundingAllocation.COLUMN_FUNDING_SOURCE,FundingAllocation.COLUMN_LESSOR,Amount.COLUMN_YEAR}
		)})
public class FundingAllocation extends AbstractIdentifiableSystemScalarStringImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name=COLUMN_IMPUTATION) @NotNull private Imputation imputation;
	@ManyToOne @JoinColumn(name=COLUMN_FUNDING_SOURCE) @NotNull private FundingSource fundingSource;
	@ManyToOne @JoinColumn(name=COLUMN_LESSOR) @NotNull private Lessor lessor;
	@Embedded private Amount amount;
	
	@Override
	public FundingAllocation setIdentifier(String identifier) {
		return (FundingAllocation) super.setIdentifier(identifier);
	}
	
	public static final String FIELD_IMPUTATION = "imputation";
	public static final String FIELD_FUNDING_SOURCE = "fundingSource";
	public static final String FIELD_LESSOR = "lessor";
	public static final String FIELD_AMOUNT = "amount";
	
	public static final String TABLE_NAME = "dt_financement";
	
	public static final String COLUMN_IMPUTATION = Imputation.TABLE_NAME;
	public static final String COLUMN_FUNDING_SOURCE = FundingSource.TABLE_NAME;
	public static final String COLUMN_LESSOR = Lessor.TABLE_NAME;
	
	public static final String UNIQUE_CONSTRAINT_IMPUTATION_FUNDING_SOURCE_LESSOR_YEAR = COLUMN_IMPUTATION+"_"+COLUMN_FUNDING_SOURCE+"_"+COLUMN_LESSOR+"_"+Amount.COLUMN_YEAR;
}