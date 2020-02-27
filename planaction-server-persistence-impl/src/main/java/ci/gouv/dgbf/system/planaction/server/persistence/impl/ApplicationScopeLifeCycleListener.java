package ci.gouv.dgbf.system.planaction.server.persistence.impl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.AbstractApplicationScopeLifeCycleListener;
import org.cyk.utility.__kernel__.klass.PersistableClassesGetter;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlan;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.AdministrativeUnit;

@ApplicationScoped
public class ApplicationScopeLifeCycleListener extends AbstractApplicationScopeLifeCycleListener implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void __initialize__(Object object) {
		PersistableClassesGetter.COLLECTION.set(List.of(ActionPlan.class,Activity.class,AdministrativeUnit.class));
		__inject__(org.cyk.utility.server.persistence.impl.ApplicationScopeLifeCycleListener.class).initialize(null);
		__inject__(ci.gouv.dgbf.system.planaction.server.persistence.entities.ApplicationScopeLifeCycleListener.class).initialize(null);
		
	}
	
	@Override
	public void __destroy__(Object object) {}
	
}
