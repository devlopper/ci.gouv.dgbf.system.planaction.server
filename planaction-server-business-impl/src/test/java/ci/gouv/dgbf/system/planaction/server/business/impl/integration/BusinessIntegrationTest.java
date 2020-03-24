package ci.gouv.dgbf.system.planaction.server.business.impl.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.server.business.test.arquillian.AbstractBusinessArquillianIntegrationTestWithDefaultDeployment;
import org.junit.Test;

import ci.gouv.dgbf.system.planaction.server.business.api.ActionPlanBusiness;
import ci.gouv.dgbf.system.planaction.server.business.api.ActivityBusiness;
import ci.gouv.dgbf.system.planaction.server.business.api.AdministrativeUnitBusiness;
import ci.gouv.dgbf.system.planaction.server.business.api.CostUnitBusiness;
import ci.gouv.dgbf.system.planaction.server.business.api.EntryAuthorizationBusiness;
import ci.gouv.dgbf.system.planaction.server.business.api.ImputationBusiness;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ActionPlanActivityPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ActionPlanPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.api.AdministrativeUnitPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.api.EntryAuthorizationPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.api.ImputationPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.api.query.ActionPlanActivityByActionPlansQuerier;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlan;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.AdministrativeUnit;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.CostUnit;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.EntryAuthorization;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Imputation;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.PaymentCredit;

public class BusinessIntegrationTest extends AbstractBusinessArquillianIntegrationTestWithDefaultDeployment {
	private static final long serialVersionUID = 1L;
	
	/* Create */
	
	@Test
	public void actionPlan_create_one(){
		__inject__(AdministrativeUnitBusiness.class).create(new AdministrativeUnit().setIdentifier("1").setCode("1").setName("1"));
		__inject__(ActionPlanBusiness.class).create(new ActionPlan().setIdentifier("1").setProducerFromIdentifier("1").setYear((short)2020));
		ActionPlan actionPlan = __inject__(ActionPlanBusiness.class).findBySystemIdentifier("1");
		assertThat(actionPlan).isNotNull();
		assertThat(actionPlan.getCode()).isEqualTo("PA_2020_2022_UA_1_V1");
		assertThat(actionPlan.getName()).isEqualTo("Plan d'action 2020 - 2022 de l'unité administrative 1 1 Version 1");
		assertThat(actionPlan.getOrderNumber()).isEqualTo((byte)1);
	}
	
	@Test
	public void actionPlan_create_two_sameProducer_sameYear(){
		__inject__(AdministrativeUnitBusiness.class).create(new AdministrativeUnit().setIdentifier("1").setCode("1").setName("1"));
		__inject__(ActionPlanBusiness.class).create(new ActionPlan().setIdentifier("1").setProducerFromIdentifier("1").setYear((short)2020));
		ActionPlan actionPlan = __inject__(ActionPlanBusiness.class).findBySystemIdentifier("1");
		assertThat(actionPlan).isNotNull();
		assertThat(actionPlan.getCode()).isEqualTo("PA_2020_2022_UA_1_V1");
		assertThat(actionPlan.getName()).isEqualTo("Plan d'action 2020 - 2022 de l'unité administrative 1 1 Version 1");
		assertThat(actionPlan.getOrderNumber()).isEqualTo((byte)1);
		
		__inject__(ActionPlanBusiness.class).create(new ActionPlan().setIdentifier("2").setProducerFromIdentifier("1").setYear((short)2020));
		actionPlan = __inject__(ActionPlanBusiness.class).findBySystemIdentifier("2");
		assertThat(actionPlan).isNotNull();
		assertThat(actionPlan.getCode()).isEqualTo("PA_2020_2022_UA_1_V2");
		assertThat(actionPlan.getName()).isEqualTo("Plan d'action 2020 - 2022 de l'unité administrative 1 1 Version 2");
		assertThat(actionPlan.getOrderNumber()).isEqualTo((byte)2);
	}
	
	@Test
	public void actionPlan_create_three(){
		__inject__(AdministrativeUnitBusiness.class).createMany(List.of(new AdministrativeUnit().setIdentifier("1").setCode("1").setName("1"),new AdministrativeUnit().setIdentifier("2").setCode("2").setName("2")));
		__inject__(ActionPlanBusiness.class).create(new ActionPlan().setIdentifier("1").setProducerFromIdentifier("1").setYear((short)2020));
		ActionPlan actionPlan = __inject__(ActionPlanBusiness.class).findBySystemIdentifier("1");
		assertThat(actionPlan).isNotNull();
		assertThat(actionPlan.getCode()).isEqualTo("PA_2020_2022_UA_1_V1");
		assertThat(actionPlan.getName()).isEqualTo("Plan d'action 2020 - 2022 de l'unité administrative 1 1 Version 1");
		assertThat(actionPlan.getOrderNumber()).isEqualTo((byte)1);
		
		__inject__(ActionPlanBusiness.class).create(new ActionPlan().setIdentifier("2").setProducerFromIdentifier("1").setYear((short)2020));
		actionPlan = __inject__(ActionPlanBusiness.class).findBySystemIdentifier("2");
		assertThat(actionPlan).isNotNull();
		assertThat(actionPlan.getCode()).isEqualTo("PA_2020_2022_UA_1_V2");
		assertThat(actionPlan.getName()).isEqualTo("Plan d'action 2020 - 2022 de l'unité administrative 1 1 Version 2");
		assertThat(actionPlan.getOrderNumber()).isEqualTo((byte)2);
		
	
		__inject__(ActionPlanBusiness.class).create(new ActionPlan().setIdentifier("3").setProducerFromIdentifier("2").setYear((short)2020));
		actionPlan = __inject__(ActionPlanBusiness.class).findBySystemIdentifier("3");
		assertThat(actionPlan).isNotNull();
		assertThat(actionPlan.getCode()).isEqualTo("PA_2020_2022_UA_2_V1");
		assertThat(actionPlan.getName()).isEqualTo("Plan d'action 2020 - 2022 de l'unité administrative 2 2 Version 1");
		assertThat(actionPlan.getOrderNumber()).isEqualTo((byte)1);
	}
	
	@Test
	public void actionPlan_create_then_update_sameProducer_differentYear() {
		__inject__(AdministrativeUnitBusiness.class).create(new AdministrativeUnit().setIdentifier("1").setCode("1").setName("1"));
		__inject__(ActionPlanBusiness.class).create(new ActionPlan().setIdentifier("1").setProducerFromIdentifier("1").setYear((short)2020));
		ActionPlan actionPlan = __inject__(ActionPlanBusiness.class).findBySystemIdentifier("1");
		assertThat(actionPlan).isNotNull();
		assertThat(actionPlan.getCode()).isEqualTo("PA_2020_2022_UA_1_V1");
		assertThat(actionPlan.getName()).isEqualTo("Plan d'action 2020 - 2022 de l'unité administrative 1 1 Version 1");
		assertThat(actionPlan.getOrderNumber()).isEqualTo((byte)1);
		
		actionPlan.setYear((short)2021);
		__inject__(ActionPlanBusiness.class).update(actionPlan);
		actionPlan = __inject__(ActionPlanBusiness.class).findBySystemIdentifier("1");
		assertThat(actionPlan).isNotNull();
		assertThat(actionPlan.getCode()).isEqualTo("PA_2020_2022_UA_1_V1");
		assertThat(actionPlan.getName()).isEqualTo("Plan d'action 2020 - 2022 de l'unité administrative 1 1 Version 1");
		assertThat(actionPlan.getOrderNumber()).isEqualTo((byte)1);
	}
	
	@Test
	public void actionPlanActivity_delete_withImputations(){
		__inject__(CostUnitBusiness.class).createMany(List.of(new CostUnit().setCode("1").setName("1"),new CostUnit().setCode("2").setName("1")));
		__inject__(AdministrativeUnitBusiness.class).createMany(List.of(new AdministrativeUnit().setIdentifier("1").setCode("1").setName("1")
				,new AdministrativeUnit().setIdentifier("2").setCode("2").setName("2")));
		__inject__(ActivityBusiness.class).createMany(List.of(new Activity().setCode("1").setName("1").setAdministrativeUnit(__inject__(AdministrativeUnitPersistence.class).readBySystemIdentifier("1"))
				,new Activity().setCode("2").setName("1").setAdministrativeUnit(__inject__(AdministrativeUnitPersistence.class).readBySystemIdentifier("2"))
				,new Activity().setCode("3").setName("1").setAdministrativeUnit(__inject__(AdministrativeUnitPersistence.class).readBySystemIdentifier("1"))));
		__inject__(ActionPlanBusiness.class).create(new ActionPlan().setIdentifier("1").setProducerFromIdentifier("1").setYear((short)2020));
		
		ActionPlan actionPlan = __inject__(ActionPlanPersistence.class).readBySystemIdentifier("1");
		assertThat(__inject__(ActionPlanActivityPersistence.class).count()).isEqualTo(2l);
		assertThat(ActionPlanActivityByActionPlansQuerier.getInstance().countByIdentifiers(actionPlan.getCode())).isEqualTo(2l);
		
		__inject__(ImputationBusiness.class).createMany(List.of(new Imputation().setActionPlanFromIdentifier("1").setActivityFromCode("1").setCostUnitFromCode("1")
				,new Imputation().setActionPlanFromIdentifier("1").setActivityFromCode("1").setCostUnitFromCode("2")));
		
		actionPlan = __inject__(ActionPlanPersistence.class).readBySystemIdentifier("1");
		assertThat(CollectionHelper.getSize(__inject__(ImputationPersistence.class).readByActionPlanCodeByActivityCode(actionPlan.getCode(), "1"))).isEqualTo(2);
		assertThat(CollectionHelper.getSize(__inject__(ImputationPersistence.class).readByActionPlanCodeByActivityCode(actionPlan.getCode(), "2"))).isEqualTo(0);
	}

	@Test
	public void imputation_update_one_entryAutorizations(){
		__inject__(CostUnitBusiness.class).createMany(List.of(new CostUnit().setCode("1").setName("1"),new CostUnit().setCode("2").setName("1")));
		__inject__(AdministrativeUnitBusiness.class).create(new AdministrativeUnit().setIdentifier("1").setCode("1").setName("1"));
		__inject__(ActivityBusiness.class).createMany(List.of(new Activity().setCode("1").setName("1").setAdministrativeUnitFromCode("1")
				,new Activity().setCode("2").setName("1").setAdministrativeUnitFromCode("1"),new Activity().setCode("3").setName("1").setAdministrativeUnitFromCode("1")));
		__inject__(ActionPlanBusiness.class).create(new ActionPlan().setIdentifier("1").setProducerFromIdentifier("1").setYear((short)2020));
		__inject__(ImputationBusiness.class).createMany(List.of(new Imputation().setIdentifier("1").setActionPlanFromIdentifier("1").setActivityFromCode("1")
				.setCostUnitFromCode("1"),new Imputation().setIdentifier("2").setActionPlanFromIdentifier("1").setActivityFromCode("1").setCostUnitFromCode("2")));
		Imputation imputation = __inject__(ImputationPersistence.class).readBySystemIdentifier("1", new Properties().setFields(Imputation.FIELD_ENTRY_AUTHORIZATIONS));
		assertThat(imputation).isNotNull();
		assertThat(imputation.getEntryAuthorizations()).isNull();
		imputation.setEntryAuthorizations(List.of(new EntryAuthorization().setYear((short)2020).setAmount(100l)));
		__inject__(ImputationBusiness.class).update(imputation,new Properties().setFields(Imputation.FIELD_ENTRY_AUTHORIZATIONS));
		imputation = __inject__(ImputationPersistence.class).readBySystemIdentifier("1", new Properties().setFields(Imputation.FIELD_ENTRY_AUTHORIZATIONS));
		assertThat(imputation.getEntryAuthorizations()).isNotNull();
		assertThat(imputation.getEntryAuthorizations().stream().map(x -> x.getYear()).collect(Collectors.toList())).contains((short)2020);
		imputation.getEntryAuthorizations().addAll(List.of(new EntryAuthorization().setYear((short)2021).setAmount(150l)
				,new EntryAuthorization().setYear((short)2022).setAmount(300l)));
		__inject__(ImputationBusiness.class).update(imputation,new Properties().setFields(Imputation.FIELD_ENTRY_AUTHORIZATIONS));
		imputation = __inject__(ImputationPersistence.class).readBySystemIdentifier("1", new Properties().setFields(Imputation.FIELD_ENTRY_AUTHORIZATIONS));
		assertThat(imputation.getEntryAuthorizations().stream().map(x -> x.getYear()).collect(Collectors.toList())).contains((short)2020,(short)2022,(short)2022);
		imputation.getEntryAuthorizations().clear();
		__inject__(ImputationBusiness.class).update(imputation,new Properties().setFields(Imputation.FIELD_ENTRY_AUTHORIZATIONS));
		imputation = __inject__(ImputationPersistence.class).readBySystemIdentifier("1", new Properties().setFields(Imputation.FIELD_ENTRY_AUTHORIZATIONS));
		assertThat(imputation.getEntryAuthorizations()).isNull();
	}
	
	@Test
	public void entryAuthorization_update_one_paymentCredits(){
		__inject__(CostUnitBusiness.class).createMany(List.of(new CostUnit().setCode("1").setName("1"),new CostUnit().setCode("2").setName("1")));
		__inject__(AdministrativeUnitBusiness.class).create(new AdministrativeUnit().setIdentifier("1").setCode("1").setName("1"));
		__inject__(ActivityBusiness.class).createMany(List.of(new Activity().setCode("1").setName("1").setAdministrativeUnitFromCode("1")
				,new Activity().setCode("2").setName("1").setAdministrativeUnitFromCode("1"),new Activity().setCode("3").setName("1").setAdministrativeUnitFromCode("1")));
		__inject__(ActionPlanBusiness.class).create(new ActionPlan().setIdentifier("1").setProducerFromIdentifier("1").setYear((short)2020));
		__inject__(ImputationBusiness.class).createMany(List.of(new Imputation().setIdentifier("1").setActionPlanFromIdentifier("1").setActivityFromCode("1")
				.setCostUnitFromCode("1"),new Imputation().setIdentifier("2").setActionPlanFromIdentifier("1").setActivityFromCode("1").setCostUnitFromCode("2")));
		__inject__(EntryAuthorizationBusiness.class).createMany(List.of(
				new EntryAuthorization().setIdentifier("1").setImputationFromIdentifier("1").setYear((short)2020).setAmount(100l)
				,new EntryAuthorization().setIdentifier("2").setImputationFromIdentifier("2").setYear((short)2021).setAmount(175l)
				));
		EntryAuthorization entryAuthorization = __inject__(EntryAuthorizationPersistence.class).readBySystemIdentifier("1",new Properties().setFields(EntryAuthorization.FIELD_PAYMENT_CREDITS));
		assertThat(entryAuthorization).isNotNull();
		assertThat(entryAuthorization.getPaymentCredits()).isNull();
		entryAuthorization.setPaymentCredits(List.of( new PaymentCredit().setYear((short)2020).setAmount(100l)));
		__inject__(EntryAuthorizationBusiness.class).update(entryAuthorization,new Properties().setFields(EntryAuthorization.FIELD_PAYMENT_CREDITS));		
		entryAuthorization = __inject__(EntryAuthorizationPersistence.class).readBySystemIdentifier("1", new Properties().setFields(EntryAuthorization.FIELD_PAYMENT_CREDITS));
		assertThat(entryAuthorization.getPaymentCredits()).isNotNull();
		assertThat(entryAuthorization.getPaymentCredits().stream().map(x -> x.getYear()).collect(Collectors.toList())).contains((short)2020);
		entryAuthorization.getPaymentCredits().addAll(List.of(new PaymentCredit().setYear((short)2021).setAmount(150l)
				,new PaymentCredit().setYear((short)2022).setAmount(300l)));
		__inject__(EntryAuthorizationBusiness.class).update(entryAuthorization,new Properties().setFields(EntryAuthorization.FIELD_PAYMENT_CREDITS));
		entryAuthorization = __inject__(EntryAuthorizationPersistence.class).readBySystemIdentifier("1", new Properties().setFields(EntryAuthorization.FIELD_PAYMENT_CREDITS));
		assertThat(entryAuthorization.getPaymentCredits().stream().map(x -> x.getYear()).collect(Collectors.toList())).contains((short)2020,(short)2022,(short)2022);
		entryAuthorization.getPaymentCredits().clear();
		__inject__(EntryAuthorizationBusiness.class).update(entryAuthorization,new Properties().setFields(EntryAuthorization.FIELD_PAYMENT_CREDITS));
		entryAuthorization = __inject__(EntryAuthorizationPersistence.class).readBySystemIdentifier("1", new Properties().setFields(EntryAuthorization.FIELD_PAYMENT_CREDITS));
		assertThat(entryAuthorization.getPaymentCredits()).isNull();
	}
}
