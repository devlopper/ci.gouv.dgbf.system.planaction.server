package ci.gouv.dgbf.system.planaction.server.persistence.impl;
import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.persistence.query.Query;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutor;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

import ci.gouv.dgbf.system.planaction.server.persistence.api.ImputationFundingPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Imputation;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ImputationFunding;

@ApplicationScoped
public class ImputationFundingPersistenceImpl extends AbstractPersistenceEntityImpl<ImputationFunding> implements ImputationFundingPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	private String readByImputationsIdentifiers;
	
	@Override
	protected void __listenPostConstructPersistenceQueries__() {
		super.__listenPostConstructPersistenceQueries__();
		addQueryCollectInstances(readByImputationsIdentifiers, "SELECT imputationFunding FROM ImputationFunding imputationFunding WHERE imputationFunding.imputation.identifier IN :identifiers");
	}
	
	@Override
	public Collection<ImputationFunding> readByImputations(Collection<Imputation> imputations) {
		if(CollectionHelper.isEmpty(imputations))
			return null;
		return QueryExecutor.getInstance().executeReadMany(ImputationFunding.class, new QueryExecutor.Arguments()
				.setQuery(new Query().setIdentifier(readByImputationsIdentifiers)).setParameters("identifiers",imputations.stream().map(x->x.getIdentifier()).collect(Collectors.toList())));
	}

	
}