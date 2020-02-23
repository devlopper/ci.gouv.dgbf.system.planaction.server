package ci.gouv.dgbf.system.planaction.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.business.api.ActionPlanBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ActionPlanPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlan;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class ActionPlanBusinessImpl extends AbstractBusinessEntityImpl<ActionPlan, ActionPlanPersistence> implements ActionPlanBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}
