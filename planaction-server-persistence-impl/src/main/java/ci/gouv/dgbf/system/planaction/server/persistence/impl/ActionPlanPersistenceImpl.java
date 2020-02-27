package ci.gouv.dgbf.system.planaction.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import ci.gouv.dgbf.system.planaction.server.persistence.api.ActionPlanPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlan;

import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class ActionPlanPersistenceImpl extends AbstractPersistenceEntityImpl<ActionPlan> implements ActionPlanPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	private String readMaxOrderNumberByAdministrativeUnitCodeByYear;
	
	@Override
	protected void __listenPostConstructPersistenceQueries__() {
		super.__listenPostConstructPersistenceQueries__();
		addQuery(readMaxOrderNumberByAdministrativeUnitCodeByYear, "SELECT MAX(actionPlan.orderNumber) FROM ActionPlan actionPlan "
				+ "WHERE actionPlan.administrativeUnit.code = :administrativeUnitCode AND actionPlan.year = :year",Byte.class);
	}
	
	@Override
	public Byte readMaxOrderNumberByAdministrativeUnitCodeByYear(String administrativeUnitCode,Short year, Properties properties) {
		Byte maxOrderNumber = null;
		try {
			maxOrderNumber = __inject__(EntityManager.class).createNamedQuery(readMaxOrderNumberByAdministrativeUnitCodeByYear, Byte.class)
					.setParameter("administrativeUnitCode", administrativeUnitCode)
					.setParameter("year", year)
					.getSingleResult();
		} catch (NoResultException exception) {}
		if(maxOrderNumber == null)
			maxOrderNumber = 0;
		return maxOrderNumber;
	}
	
}