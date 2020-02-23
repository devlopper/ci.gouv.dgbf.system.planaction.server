package ci.gouv.dgbf.system.planaction.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.business.api.ActivityBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ActivityPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Activity;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class ActivityBusinessImpl extends AbstractBusinessEntityImpl<Activity, ActivityPersistence> implements ActivityBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}
