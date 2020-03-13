package ci.gouv.dgbf.system.planaction.server.persistence.impl;
import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.array.ArrayHelper;
import org.cyk.utility.__kernel__.persistence.query.Query;
import org.cyk.utility.__kernel__.persistence.query.QueryContext;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutor;
import org.cyk.utility.__kernel__.persistence.query.QueryStringHelper;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;
import org.cyk.utility.server.persistence.PersistenceFunctionReader;

import ci.gouv.dgbf.system.planaction.server.persistence.api.ImputationPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Imputation;

@ApplicationScoped
public class ImputationPersistenceImpl extends AbstractPersistenceEntityImpl<Imputation> implements ImputationPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	private String readByActionPlanCodeByActivityCode;
	
	@Override
	protected void __listenPostConstructPersistenceQueries__() {
		super.__listenPostConstructPersistenceQueries__();
		addQueryCollectInstances(readByActionPlanCodeByActivityCode, "SELECT imputation FROM Imputation imputation WHERE imputation.actionPlan.code = :actionPlanCode AND imputation.activity.code = :activityCode");
		addQueryCollectInstances(readByFiltersLike, 
				"SELECT imputation FROM Imputation imputation "
				+ "WHERE "
				+ " ("+QueryStringHelper.formatTupleFieldLike("imputation", "actionPlan.code","actionPlan") + " OR " + QueryStringHelper.formatTupleFieldLike("imputation", "actionPlan.name","actionPlan")+") "
				+ " AND ("+QueryStringHelper.formatTupleFieldLike("imputation", "activity.code","activity") + " OR " + QueryStringHelper.formatTupleFieldLike("imputation", "activity.name","activity")+") "
				+ " AND ("+QueryStringHelper.formatTupleFieldLike("imputation", "costUnit.code","costUnit") + " OR " + QueryStringHelper.formatTupleFieldLike("imputation", "costUnit.name","costUnit")+") "
				+ " ORDER BY imputation.activity.code ASC, imputation.costUnit.code ASC");
	}
	
	@Override
	public Collection<Imputation> readByActionPlanCodeByActivityCode(String actionPlanCode, String activityCode) {
		return QueryExecutor.getInstance().executeReadMany(Imputation.class, new QueryExecutor.Arguments()
				.setQuery(new Query().setIdentifier(readByActionPlanCodeByActivityCode)).setParameters("actionPlanCode",actionPlanCode,"activityCode",activityCode));
	}
	
	@Override
	protected String __getQueryIdentifier__(Class<?> klass, Properties properties, Object... objects) {
		if(PersistenceFunctionReader.class.equals(klass)) {
			if(Boolean.TRUE.equals(__isFilterByKeys__(properties, Imputation.FIELD_ACTION_PLAN)) || Boolean.TRUE.equals(__isFilterByKeys__(properties, Imputation.FIELD_ACTIVITY))
					|| Boolean.TRUE.equals(__isFilterByKeys__(properties, Imputation.FIELD_COST_UNIT)))
				return readByFiltersLike;
		}
		return super.__getQueryIdentifier__(klass, properties, objects);
	}
	
	@Override
	protected Object[] __getQueryParameters__(QueryContext queryContext, Properties properties, Object... objects) {
		if(queryContext.getQuery().isIdentifierEqualsToOrQueryDerivedFromQueryIdentifierEqualsTo(readByFiltersLike)) {
			if(ArrayHelper.isEmpty(objects)) {
				objects = new Object[] {queryContext.getStringLike(Imputation.FIELD_ACTION_PLAN),queryContext.getStringLike(Imputation.FIELD_ACTIVITY),queryContext.getStringLike(Imputation.FIELD_COST_UNIT)};
			}
			int index = 0;
			objects = new Object[]{Imputation.FIELD_ACTION_PLAN,objects[index++],Imputation.FIELD_ACTIVITY,objects[index++],Imputation.FIELD_COST_UNIT,objects[index++]};
			return objects;
		}
		if(queryContext.getQuery().isIdentifierEqualsToOrQueryDerivedFromQueryIdentifierEqualsTo(readByActionPlanCodeByActivityCode)) {
			if(ArrayHelper.isEmpty(objects)) {
				objects = new Object[] {queryContext.getFilterFieldByKeys(Imputation.FIELD_ACTION_PLAN).getValue(),queryContext.getFilterFieldByKeys(Imputation.FIELD_ACTIVITY).getValue()};
			}
			int index = 0;
			objects = new Object[]{"actionPlanCode",objects[index++],"activityCode",objects[index++]};
			return objects;
		}
		return super.__getQueryParameters__(queryContext, properties, objects);
	}
}