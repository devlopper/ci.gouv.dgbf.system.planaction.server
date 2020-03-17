package ci.gouv.dgbf.system.planaction.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.business.api.PaymentCreditBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.api.PaymentCreditPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.PaymentCredit;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class PaymentCreditBusinessImpl extends AbstractBusinessEntityImpl<PaymentCredit, PaymentCreditPersistence> implements PaymentCreditBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}
