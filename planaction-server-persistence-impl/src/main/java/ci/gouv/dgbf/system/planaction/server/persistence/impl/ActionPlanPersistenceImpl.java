package ci.gouv.dgbf.system.planaction.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.persistence.api.ActionPlanPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlan;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class ActionPlanPersistenceImpl extends AbstractPersistenceEntityImpl<ActionPlan> implements ActionPlanPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}