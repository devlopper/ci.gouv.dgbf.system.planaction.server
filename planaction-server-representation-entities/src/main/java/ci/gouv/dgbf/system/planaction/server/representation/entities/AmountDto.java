package ci.gouv.dgbf.system.planaction.server.representation.entities;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AmountDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Short year;
	private Integer paymentCredit;
	private Integer entryAuthorization;
	
	/**/
	
	public static final String FIELD_YEAR = "year";
	public static final String FIELD_PAYMENT_CREDIT = "paymentCredit";
	public static final String FIELD_ENTRY_AUTHORIZATION = "entryAuthorization";
}
