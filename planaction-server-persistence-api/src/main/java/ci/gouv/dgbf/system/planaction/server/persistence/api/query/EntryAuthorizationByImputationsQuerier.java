package ci.gouv.dgbf.system.planaction.server.persistence.api.query;

import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.persistence.query.ByDimensionOneSystemIdentifierQuerier;
import org.cyk.utility.__kernel__.persistence.query.annotation.Queries;
import org.cyk.utility.__kernel__.persistence.query.annotation.Query;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.planaction.server.persistence.entities.EntryAuthorization;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Imputation;

@Queries(value = {
		@Query(tupleClass = EntryAuthorization.class,name = EntryAuthorizationByImputationsQuerier.QUERY_NAME_READ,value = "SELECT entryAuthorization FROM EntryAuthorization entryAuthorization WHERE entryAuthorization.imputation.identifier IN :"
				+EntryAuthorizationByImputationsQuerier.PARAMETER_NAME_IMPUTATIONS_IDENTIFIERS+" ORDER BY entryAuthorization.year ASC")
})
public interface EntryAuthorizationByImputationsQuerier extends ByDimensionOneSystemIdentifierQuerier<EntryAuthorization,Imputation,String> {

	/**/
	
	static EntryAuthorizationByImputationsQuerier getInstance() {
		return Helper.getInstance(EntryAuthorizationByImputationsQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = DependencyInjection.inject(Value.class);
	
	String QUERY_NAME_READ = "readByImputationsIdentifiers";
	String QUERY_NAME_COUNT = "countByImputationsIdentifiers";
	String PARAMETER_NAME_IMPUTATIONS_IDENTIFIERS = "imputationsIdentifiers";
}
