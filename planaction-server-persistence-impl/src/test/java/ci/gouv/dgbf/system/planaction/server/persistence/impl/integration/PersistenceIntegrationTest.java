package ci.gouv.dgbf.system.planaction.server.persistence.impl.integration;

import static org.assertj.core.api.Assertions.assertThat;
import org.cyk.utility.server.persistence.test.arquillian.AbstractPersistenceArquillianIntegrationTestWithDefaultDeployment;
import org.junit.Test;

import ci.gouv.dgbf.system.planaction.server.persistence.api.ActionPlanPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.api.AdministrativeUnitPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlan;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.AdministrativeUnit;

public class PersistenceIntegrationTest extends AbstractPersistenceArquillianIntegrationTestWithDefaultDeployment {
	private static final long serialVersionUID = 1L;
	
	@Test
	public void actionPlan_readMaxOrderNumberByAdministrativeUnitCodeByYear() throws Exception{
		userTransaction.begin();
		__inject__(AdministrativeUnitPersistence.class).create(new AdministrativeUnit().setCode("1").setName("1"));
		userTransaction.commit();		
		assertThat(__inject__(ActionPlanPersistence.class).readMaxOrderNumberByAdministrativeUnitCodeByYear("1", (short)2020, null)).isEqualTo((byte) 0);
		userTransaction.begin();
		__inject__(ActionPlanPersistence.class).create(new ActionPlan().setCode("1").setName("1").setAdministrativeUnitFromCode("1").setYear((short)2020).setOrderNumber((byte)1));
		userTransaction.commit();
		assertThat(__inject__(ActionPlanPersistence.class).readMaxOrderNumberByAdministrativeUnitCodeByYear("1", (short)2020, null)).isEqualTo((byte) 1);
		userTransaction.begin();
		__inject__(ActionPlanPersistence.class).create(new ActionPlan().setCode("2").setName("1").setAdministrativeUnitFromCode("1").setYear((short)2020).setOrderNumber((byte)2));
		userTransaction.commit();
		assertThat(__inject__(ActionPlanPersistence.class).readMaxOrderNumberByAdministrativeUnitCodeByYear("1", (short)2020, null)).isEqualTo((byte) 2);
		userTransaction.begin();
		__inject__(ActionPlanPersistence.class).create(new ActionPlan().setCode("3").setName("1").setAdministrativeUnitFromCode("1").setYear((short)2020).setOrderNumber((byte)10));
		userTransaction.commit();
		assertThat(__inject__(ActionPlanPersistence.class).readMaxOrderNumberByAdministrativeUnitCodeByYear("1", (short)2020, null)).isEqualTo((byte) 10);
	}
	
}
