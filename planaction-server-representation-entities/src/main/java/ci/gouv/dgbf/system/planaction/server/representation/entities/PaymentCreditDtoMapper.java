package ci.gouv.dgbf.system.planaction.server.representation.entities;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.PaymentCredit;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class PaymentCreditDtoMapper extends AbstractMapperSourceDestinationImpl<PaymentCreditDto, PaymentCredit> {
	private static final long serialVersionUID = 1L;
     
}