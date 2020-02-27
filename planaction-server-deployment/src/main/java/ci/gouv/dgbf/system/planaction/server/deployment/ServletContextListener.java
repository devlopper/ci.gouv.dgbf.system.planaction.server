package ci.gouv.dgbf.system.planaction.server.deployment;

import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

import org.cyk.utility.__kernel__.variable.VariableHelper;
import org.cyk.utility.__kernel__.variable.VariableName;
import org.cyk.utility.server.deployment.AbstractServletContextListener;

import ci.gouv.dgbf.system.planaction.server.representation.impl.ApplicationScopeLifeCycleListener;

@WebListener
public class ServletContextListener extends AbstractServletContextListener implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void __initialize__(ServletContext context) {
		VariableHelper.write(VariableName.SYSTEM_LOGGING_THROWABLE_PRINT_STACK_TRACE, Boolean.TRUE);
		super.__initialize__(context);
		__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);
	}

}
