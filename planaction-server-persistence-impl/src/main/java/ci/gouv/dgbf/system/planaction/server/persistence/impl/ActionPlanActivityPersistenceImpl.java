package ci.gouv.dgbf.system.planaction.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.array.ArrayHelper;
import org.cyk.utility.__kernel__.persistence.query.Query;
import org.cyk.utility.__kernel__.persistence.query.QueryContext;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutor;
import org.cyk.utility.__kernel__.persistence.query.QueryStringHelper;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;
import org.cyk.utility.server.persistence.PersistenceFunctionReader;

import ci.gouv.dgbf.system.planaction.server.persistence.api.ActionPlanActivityPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlanActivity;

@ApplicationScoped
public class ActionPlanActivityPersistenceImpl extends AbstractPersistenceEntityImpl<ActionPlanActivity> implements ActionPlanActivityPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	private String readByActionPlanCodeByActivityCode;
	 
	@Override
	protected void __listenPostConstructPersistenceQueries__() {
		super.__listenPostConstructPersistenceQueries__();
		addQueryCollectInstances(readByActionPlanCodeByActivityCode, "SELECT actionPlanActivity FROM ActionPlanActivity actionPlanActivity "
				+ "WHERE actionPlanActivity.actionPlan.code = :actionPlanCode AND actionPlanActivity.activity.code = :activityCode");
		addQueryCollectInstances(readByFiltersLike, 
				"SELECT actionPlanActivity FROM ActionPlanActivity actionPlanActivity "
				+ "WHERE "
				+ " ("+QueryStringHelper.formatTupleFieldLike("actionPlanActivity", "actionPlan.code","actionPlan") + " OR " + QueryStringHelper.formatTupleFieldLike("actionPlanActivity", "actionPlan.name","actionPlan")+") "
				+ " AND ("+QueryStringHelper.formatTupleFieldLike("actionPlanActivity", "activity.code","activity") + " OR " + QueryStringHelper.formatTupleFieldLike("actionPlanActivity", "activity.name","activity")+") "
				+ " ORDER BY actionPlanActivity.activity.code ASC");
	}
	
	@Override
	public ActionPlanActivity readByActionPlanCodeByActivityCode(String actionPlanCode, String activityCode) {
		return QueryExecutor.getInstance().executeReadOne(ActionPlanActivity.class, new QueryExecutor.Arguments()
				.setQuery(new Query().setIdentifier(readByActionPlanCodeByActivityCode)).setParameters("actionPlanCode",actionPlanCode,"activityCode",activityCode));
	}
	
	@Override
	protected String __getQueryIdentifier__(Class<?> klass, Properties properties, Object... objects) {
		if(PersistenceFunctionReader.class.equals(klass)) {
			if(Boolean.TRUE.equals(__isFilterByKeys__(properties, ActionPlanActivity.FIELD_ACTION_PLAN)))
				return readByFiltersLike;
		}
		return super.__getQueryIdentifier__(klass, properties, objects);
	}
	
	@Override
	protected Object[] __getQueryParameters__(QueryContext queryContext, Properties properties, Object... objects) {
		if(queryContext.getQuery().isIdentifierEqualsToOrQueryDerivedFromQueryIdentifierEqualsTo(readByFiltersLike)) {
			if(ArrayHelper.isEmpty(objects)) {
				objects = new Object[] {queryContext.getStringLike(ActionPlanActivity.FIELD_ACTION_PLAN),queryContext.getStringLike(ActionPlanActivity.FIELD_ACTIVITY)};
			}
			int index = 0;
			objects = new Object[]{"actionPlan",objects[index++],"activity",objects[index++]};
			return objects;
		}
		return super.__getQueryParameters__(queryContext, properties, objects);
	}
}