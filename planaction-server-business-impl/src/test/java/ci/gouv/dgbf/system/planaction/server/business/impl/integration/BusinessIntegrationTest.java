package ci.gouv.dgbf.system.planaction.server.business.impl.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.cyk.utility.server.business.test.arquillian.AbstractBusinessArquillianIntegrationTestWithDefaultDeployment;
import org.junit.Test;

import ci.gouv.dgbf.system.planaction.server.business.api.ActionPlanBusiness;
import ci.gouv.dgbf.system.planaction.server.business.api.AdministrativeUnitBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlan;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.AdministrativeUnit;

public class BusinessIntegrationTest extends AbstractBusinessArquillianIntegrationTestWithDefaultDeployment {
	private static final long serialVersionUID = 1L;
	
	/* Create */
	
	@Test
	public void actionPlan_create_one() throws Exception{
		__inject__(AdministrativeUnitBusiness.class).create(new AdministrativeUnit().setCode("1").setName("1"));
		__inject__(ActionPlanBusiness.class).create(new ActionPlan().setIdentifier("1").setAdministrativeUnitFromCode("1").setYear((short)2020));
		ActionPlan actionPlan = __inject__(ActionPlanBusiness.class).findBySystemIdentifier("1");
		assertThat(actionPlan).isNotNull();
		assertThat(actionPlan.getCode()).isEqualTo("PA_1_2020_V1");
		assertThat(actionPlan.getName()).isEqualTo("Plan d'action de 1 de 2020 Version 1");
		assertThat(actionPlan.getOrderNumber()).isEqualTo((byte)1);
	}
	
	@Test
	public void actionPlan_create_two_sameAdministrativeUnit_sameYear() throws Exception{
		__inject__(AdministrativeUnitBusiness.class).create(new AdministrativeUnit().setCode("1").setName("1"));
		__inject__(ActionPlanBusiness.class).create(new ActionPlan().setIdentifier("1").setAdministrativeUnitFromCode("1").setYear((short)2020));
		ActionPlan actionPlan = __inject__(ActionPlanBusiness.class).findBySystemIdentifier("1");
		assertThat(actionPlan).isNotNull();
		assertThat(actionPlan.getCode()).isEqualTo("PA_1_2020_V1");
		assertThat(actionPlan.getName()).isEqualTo("Plan d'action de 1 de 2020 Version 1");
		assertThat(actionPlan.getOrderNumber()).isEqualTo((byte)1);
		
		__inject__(ActionPlanBusiness.class).create(new ActionPlan().setIdentifier("2").setAdministrativeUnitFromCode("1").setYear((short)2020));
		actionPlan = __inject__(ActionPlanBusiness.class).findBySystemIdentifier("2");
		assertThat(actionPlan).isNotNull();
		assertThat(actionPlan.getCode()).isEqualTo("PA_1_2020_V2");
		assertThat(actionPlan.getName()).isEqualTo("Plan d'action de 1 de 2020 Version 2");
		assertThat(actionPlan.getOrderNumber()).isEqualTo((byte)2);
	}
	
	@Test
	public void actionPlan_create_three() throws Exception{
		__inject__(AdministrativeUnitBusiness.class).createMany(List.of(new AdministrativeUnit().setCode("1").setName("1"),new AdministrativeUnit().setCode("2").setName("2")));
		__inject__(ActionPlanBusiness.class).create(new ActionPlan().setIdentifier("1").setAdministrativeUnitFromCode("1").setYear((short)2020));
		ActionPlan actionPlan = __inject__(ActionPlanBusiness.class).findBySystemIdentifier("1");
		assertThat(actionPlan).isNotNull();
		assertThat(actionPlan.getCode()).isEqualTo("PA_1_2020_V1");
		assertThat(actionPlan.getName()).isEqualTo("Plan d'action de 1 de 2020 Version 1");
		assertThat(actionPlan.getOrderNumber()).isEqualTo((byte)1);
		
		__inject__(ActionPlanBusiness.class).create(new ActionPlan().setIdentifier("2").setAdministrativeUnitFromCode("1").setYear((short)2020));
		actionPlan = __inject__(ActionPlanBusiness.class).findBySystemIdentifier("2");
		assertThat(actionPlan).isNotNull();
		assertThat(actionPlan.getCode()).isEqualTo("PA_1_2020_V2");
		assertThat(actionPlan.getName()).isEqualTo("Plan d'action de 1 de 2020 Version 2");
		assertThat(actionPlan.getOrderNumber()).isEqualTo((byte)2);
		
		__inject__(ActionPlanBusiness.class).create(new ActionPlan().setIdentifier("3").setAdministrativeUnitFromCode("2").setYear((short)2020));
		actionPlan = __inject__(ActionPlanBusiness.class).findBySystemIdentifier("3");
		assertThat(actionPlan).isNotNull();
		assertThat(actionPlan.getCode()).isEqualTo("PA_2_2020_V1");
		assertThat(actionPlan.getName()).isEqualTo("Plan d'action de 2 de 2020 Version 1");
		assertThat(actionPlan.getOrderNumber()).isEqualTo((byte)1);
	}
	
	@Test
	public void actionPlan_create_then_update_sameAdministrativeUnit_differentYear() throws Exception{
		__inject__(AdministrativeUnitBusiness.class).create(new AdministrativeUnit().setCode("1").setName("1"));
		__inject__(ActionPlanBusiness.class).create(new ActionPlan().setIdentifier("1").setAdministrativeUnitFromCode("1").setYear((short)2020));
		ActionPlan actionPlan = __inject__(ActionPlanBusiness.class).findBySystemIdentifier("1");
		assertThat(actionPlan).isNotNull();
		assertThat(actionPlan.getCode()).isEqualTo("PA_1_2020_V1");
		assertThat(actionPlan.getName()).isEqualTo("Plan d'action de 1 de 2020 Version 1");
		assertThat(actionPlan.getOrderNumber()).isEqualTo((byte)1);
		
		actionPlan.setYear((short)2021);
		__inject__(ActionPlanBusiness.class).update(actionPlan);
		actionPlan = __inject__(ActionPlanBusiness.class).findBySystemIdentifier("1");
		assertThat(actionPlan).isNotNull();
		assertThat(actionPlan.getCode()).isEqualTo("PA_1_2021_V1");
		assertThat(actionPlan.getName()).isEqualTo("Plan d'action de 1 de 2021 Version 1");
		assertThat(actionPlan.getOrderNumber()).isEqualTo((byte)1);
	}
}
