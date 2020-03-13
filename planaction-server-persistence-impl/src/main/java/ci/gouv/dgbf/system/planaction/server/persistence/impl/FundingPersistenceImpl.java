package ci.gouv.dgbf.system.planaction.server.persistence.impl;
import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.array.ArrayHelper;
import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.persistence.query.Query;
import org.cyk.utility.__kernel__.persistence.query.QueryContext;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutor;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;
import org.cyk.utility.server.persistence.PersistenceFunctionReader;

import ci.gouv.dgbf.system.planaction.server.persistence.api.FundingPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Funding;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Imputation;

@ApplicationScoped
public class FundingPersistenceImpl extends AbstractPersistenceEntityImpl<Funding> implements FundingPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	private String readByImputationsIdentifiers,readByActionPlanCodeByActivityCode;
	
	@Override
	protected void __listenPostConstructPersistenceQueries__() {
		super.__listenPostConstructPersistenceQueries__();
		addQueryCollectInstances(readByImputationsIdentifiers, "SELECT funding FROM Funding funding WHERE funding.imputation.identifier IN :identifiers");
		addQueryCollectInstances(readByActionPlanCodeByActivityCode, "SELECT funding FROM Funding funding WHERE funding.imputation.actionPlan.code = :actionPlanCode AND funding.imputation.activity.code = :activityCode");
	}
	
	@Override
	public Collection<Funding> readByImputations(Collection<Imputation> imputations) {
		if(CollectionHelper.isEmpty(imputations))
			return null;
		return QueryExecutor.getInstance().executeReadMany(Funding.class, new QueryExecutor.Arguments()
				.setQuery(new Query().setIdentifier(readByImputationsIdentifiers)).setParameters("identifiers",imputations.stream().map(x->x.getIdentifier()).collect(Collectors.toList())));
	}
	
	@Override
	protected String __getQueryIdentifier__(Class<?> klass, Properties properties, Object... objects) {
		if(PersistenceFunctionReader.class.equals(klass)) {
			if(Boolean.TRUE.equals(__isFilterByKeys__(properties, Funding.FIELD_IMPUTATION)))
				return readByImputationsIdentifiers;
			if(Boolean.TRUE.equals(__isFilterByKeys__(properties, Funding.FIELD_ACTION_PLAN)))
				return readByActionPlanCodeByActivityCode;
		}
		return super.__getQueryIdentifier__(klass, properties, objects);
	}

	@Override
	protected Object[] __getQueryParameters__(QueryContext queryContext, Properties properties, Object... objects) {
		if(queryContext.getQuery().isIdentifierEqualsToOrQueryDerivedFromQueryIdentifierEqualsTo(readByImputationsIdentifiers)) {
			if(ArrayHelper.isEmpty(objects)) {
				objects = new Object[] {queryContext.getFilterFieldByKeys(Funding.FIELD_IMPUTATION).getValue()};
			}
			int index = 0;
			objects = new Object[]{"identifiers",objects[index++]};
			return objects;
		}
		if(queryContext.getQuery().isIdentifierEqualsToOrQueryDerivedFromQueryIdentifierEqualsTo(readByActionPlanCodeByActivityCode)) {
			if(ArrayHelper.isEmpty(objects)) {
				objects = new Object[] {queryContext.getFilterFieldByKeys(Funding.FIELD_ACTION_PLAN).getValue(),queryContext.getFilterFieldByKeys(Funding.FIELD_ACTIVITY).getValue()};
			}
			int index = 0;
			objects = new Object[]{"actionPlanCode",objects[index++],"activityCode",objects[index++]};
			return objects;
		}
		return super.__getQueryParameters__(queryContext, properties, objects);
	}
	
}