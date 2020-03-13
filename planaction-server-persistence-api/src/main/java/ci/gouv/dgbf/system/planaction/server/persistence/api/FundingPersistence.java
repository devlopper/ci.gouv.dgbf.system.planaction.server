package ci.gouv.dgbf.system.planaction.server.persistence.api;

import java.util.Collection;

import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.server.persistence.PersistenceEntity;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.Imputation;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Funding;

public interface FundingPersistence extends PersistenceEntity<Funding> {

	Collection<Funding> readByImputations(Collection<Imputation> imputations);
	
	String READ_BY_IMPUTATIONS_IDENTIFIERS = QueryIdentifierBuilder.getInstance().build(Funding.class,"readByImputationsIdentifiers");
	String COUNT_BY_IMPUTATIONS_IDENTIFIERS = QueryIdentifierBuilder.getInstance().build(Funding.class,"countByImputationsIdentifiers");
	
	String READ_BY_ACTION_PLAN_CODE_BY_ACTIVITY_CODE = QueryIdentifierBuilder.getInstance().build(Funding.class,"readByActionPlanCodeByActivityCode");
	String COUNT_BY_ACTION_PLAN_CODE_BY_ACTIVITY_CODE = QueryIdentifierBuilder.getInstance().build(Funding.class,"countByActionPlancodeByActivityCode");
	
}