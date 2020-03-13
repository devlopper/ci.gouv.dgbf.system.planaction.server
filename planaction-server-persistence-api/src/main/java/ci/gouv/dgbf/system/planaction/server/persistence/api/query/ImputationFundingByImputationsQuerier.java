package ci.gouv.dgbf.system.planaction.server.persistence.api.query;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.persistence.query.ByDimensionOneQuerier;
import org.cyk.utility.__kernel__.persistence.query.annotation.Queries;
import org.cyk.utility.__kernel__.persistence.query.annotation.Query;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.Imputation;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ImputationFunding;

@Queries(value = {
		@Query(tupleClass = ImputationFunding.class,name = ImputationFundingByImputationsQuerier.QUERY_NAME_READ
				,value = "SELECT imputationFunding FROM ImputationFunding imputationFunding WHERE imputationFunding.imputation.code IN :"+ImputationFundingByImputationsQuerier.PARAMETER_NAME_IMPUTATIONS_CODES)
})
public interface ImputationFundingByImputationsQuerier /*extends ByDimensionOneQuerier<ImputationFunding, String,Imputation,String>*/ {

	/**/
	
	static ImputationFundingByImputationsQuerier getInstance() {
		return Helper.getInstance(ImputationFundingByImputationsQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = DependencyInjection.inject(Value.class);
	
	String QUERY_NAME_READ = "readByImputationsCodes";
	String QUERY_NAME_COUNT = "countByImputationsCodes";
	String PARAMETER_NAME_IMPUTATIONS_CODES = "imputationsCodes";
}
