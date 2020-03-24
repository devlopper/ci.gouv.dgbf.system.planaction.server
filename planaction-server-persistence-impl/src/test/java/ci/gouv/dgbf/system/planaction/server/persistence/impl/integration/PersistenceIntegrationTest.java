package ci.gouv.dgbf.system.planaction.server.persistence.impl.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.cyk.utility.server.persistence.test.arquillian.AbstractPersistenceArquillianIntegrationTestWithDefaultDeployment;
import org.junit.Test;

import ci.gouv.dgbf.system.planaction.server.persistence.api.ActionPlanPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ActivityPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.api.AdministrativeUnitPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ProducerPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.api.query.ActivityByActionPlansQuerier;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlan;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.AdministrativeUnit;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Producer;

public class PersistenceIntegrationTest extends AbstractPersistenceArquillianIntegrationTestWithDefaultDeployment {
	private static final long serialVersionUID = 1L;
	
	@Test
	public void actionPlan_readMaxOrderNumberByProducerCodeByYear() throws Exception{
		userTransaction.begin();
		__inject__(ProducerPersistence.class).create(new Producer().setIdentifier("1").setCode("1").setName("1"));
		userTransaction.commit();
		assertThat(__inject__(ActionPlanPersistence.class).readMaxOrderNumberByProducerCodeByYear("1", (short)2020, null)).isEqualTo((byte) 0);
		userTransaction.begin();
		__inject__(ActionPlanPersistence.class).create(new ActionPlan().setCode("1").setName("1").setProducerFromIdentifier("1").setYear((short)2020).setOrderNumber((byte)1).setNumberOfYears((byte)1));
		userTransaction.commit();
		assertThat(__inject__(ActionPlanPersistence.class).readMaxOrderNumberByProducerCodeByYear("1", (short)2020, null)).isEqualTo((byte) 1);
		userTransaction.begin();
		__inject__(ActionPlanPersistence.class).create(new ActionPlan().setCode("2").setName("1").setProducerFromIdentifier("1").setYear((short)2020).setOrderNumber((byte)2).setNumberOfYears((byte)1));
		userTransaction.commit();
		assertThat(__inject__(ActionPlanPersistence.class).readMaxOrderNumberByProducerCodeByYear("1", (short)2020, null)).isEqualTo((byte) 2);
		userTransaction.begin();
		__inject__(ActionPlanPersistence.class).create(new ActionPlan().setCode("3").setName("1").setProducerFromIdentifier("1").setYear((short)2020).setOrderNumber((byte)10).setNumberOfYears((byte)1));
		userTransaction.commit();
		assertThat(__inject__(ActionPlanPersistence.class).readMaxOrderNumberByProducerCodeByYear("1", (short)2020, null)).isEqualTo((byte) 10);
	}
	
	@Test
	public void activity_readByProducersCodes() throws Exception{
		userTransaction.begin();
		__inject__(AdministrativeUnitPersistence.class).createMany(List.of(new AdministrativeUnit().setCode("1").setName("1"),new AdministrativeUnit().setCode("2").setName("2")
				,new AdministrativeUnit().setCode("3").setName("3")));
		userTransaction.commit();
		userTransaction.begin();
		__inject__(ActivityPersistence.class).createMany(List.of(new Activity().setCode("1").setName("1").setAdministrativeUnitFromCode("1")
				,new Activity().setCode("2").setName("2").setAdministrativeUnitFromCode("1"),new Activity().setCode("3").setName("3").setAdministrativeUnitFromCode("2")));
		userTransaction.commit();
		assertThat(ActivityByActionPlansQuerier.getInstance().readByIdentifiers("1").stream().map(x->x.getCode()).collect(Collectors.toList())).containsExactly("1","2");
		assertThat(ActivityByActionPlansQuerier.getInstance().countByIdentifiers("1")).isEqualTo(2l);
		assertThat(ActivityByActionPlansQuerier.getInstance().readByIdentifiers("2").stream().map(x->x.getCode()).collect(Collectors.toList())).containsExactly("3");
		assertThat(ActivityByActionPlansQuerier.getInstance().countByIdentifiers("2")).isEqualTo(1l);
		assertThat(ActivityByActionPlansQuerier.getInstance().readByIdentifiers("3")).isNull();
		assertThat(ActivityByActionPlansQuerier.getInstance().countByIdentifiers("3")).isEqualTo(0l);
	}
	
}
