package ci.gouv.dgbf.system.planaction.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.cyk.utility.__kernel__.object.__static__.identifiable.AbstractEmbedded;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Embeddable
public class Amount extends AbstractEmbedded implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = COLUMN_YEAR) @NotNull @PositiveOrZero private Short year;
	@Column(name = COLUMN_PAYMENT_CREDIT) @NotNull @PositiveOrZero private Integer paymentCredit;
	@Column(name = COLUMN_ENTRY_AUTHORIZATION) @NotNull @PositiveOrZero private Integer entryAuthorization;
	
	/**/
	
	public static final String FIELD_YEAR = "year";
	public static final String FIELD_PAYMENT_CREDIT = "paymentCredit";
	public static final String FIELD_ENTRY_AUTHORIZATION = "entryAuthorization";
	
	public static final String COLUMN_YEAR = "annee";
	public static final String COLUMN_PAYMENT_CREDIT = "cp";
	public static final String COLUMN_ENTRY_AUTHORIZATION = "ae";
	
}
