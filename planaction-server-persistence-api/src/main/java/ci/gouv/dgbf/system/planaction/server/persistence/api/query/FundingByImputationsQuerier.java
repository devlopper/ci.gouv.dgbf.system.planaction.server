package ci.gouv.dgbf.system.planaction.server.persistence.api.query;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.persistence.query.annotation.Queries;
import org.cyk.utility.__kernel__.persistence.query.annotation.Query;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.Funding;

@Queries(value = {
		@Query(tupleClass = Funding.class,name = FundingByImputationsQuerier.QUERY_NAME_READ
				,value = "SELECT funding FROM Funding funding WHERE funding.imputation.code IN :"+FundingByImputationsQuerier.PARAMETER_NAME_IMPUTATIONS_CODES)
})
public interface FundingByImputationsQuerier {

	/**/
	
	static FundingByImputationsQuerier getInstance() {
		return Helper.getInstance(FundingByImputationsQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = DependencyInjection.inject(Value.class);
	
	String QUERY_NAME_READ = "readByImputationsCodes";
	String QUERY_NAME_COUNT = "countByImputationsCodes";
	String PARAMETER_NAME_IMPUTATIONS_CODES = "imputationsCodes";
}