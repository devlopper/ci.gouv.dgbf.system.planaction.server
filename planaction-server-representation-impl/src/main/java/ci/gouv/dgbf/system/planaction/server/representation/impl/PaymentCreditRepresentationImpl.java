package ci.gouv.dgbf.system.planaction.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.representation.api.PaymentCreditRepresentation;
import ci.gouv.dgbf.system.planaction.server.representation.entities.PaymentCreditDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class PaymentCreditRepresentationImpl extends AbstractRepresentationEntityImpl<PaymentCreditDto> implements PaymentCreditRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}
