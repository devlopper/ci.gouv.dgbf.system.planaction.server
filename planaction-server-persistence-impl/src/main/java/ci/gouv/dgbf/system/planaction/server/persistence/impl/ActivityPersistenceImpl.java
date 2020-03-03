package ci.gouv.dgbf.system.planaction.server.persistence.impl;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.array.ArrayHelper;
import org.cyk.utility.__kernel__.computation.LogicalOperator;
import org.cyk.utility.__kernel__.persistence.query.QueryContext;
import org.cyk.utility.__kernel__.persistence.query.QueryStringHelper;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

import ci.gouv.dgbf.system.planaction.server.persistence.api.ActivityPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.Activity;

@ApplicationScoped
public class ActivityPersistenceImpl extends AbstractPersistenceEntityImpl<Activity> implements ActivityPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	private String readPlanableByAdministrativeUnitCodeByActionPlanCode,readByAdministrativeUnitsCodes;
	
	@Override
	protected void __listenPostConstructPersistenceQueries__() {
		super.__listenPostConstructPersistenceQueries__();
		addQueryCollectInstances(readByAdministrativeUnitsCodes, "SELECT activity FROM Activity activity WHERE activity.administrativeUnit.code IN :administrativeUnitsCodes ORDER BY activity.code ASC");
		addQueryCollectInstances(readPlanableByAdministrativeUnitCodeByActionPlanCode, "SELECT activity FROM Activity activity WHERE activity.administrativeUnit.code = :administrativeUnitCode "
				+ "AND NOT EXISTS(SELECT actionPlanActivity FROM ActionPlanActivity actionPlanActivity WHERE actionPlanActivity.actionPlan.code = :actionPlanCode AND actionPlanActivity.activity = activity) ORDER BY activity.code ASC");
		addQueryCollectInstances(readByFiltersLike, 
				"SELECT activity FROM Activity activity "
				+ "WHERE "
				+ "("+QueryStringHelper.formatTupleFieldLike("activity", "code","activity") + " OR " + QueryStringHelper.formatTupleFieldLikeOrTokens("activity", "name","activityName",4,LogicalOperator.AND)+")"
				+ " AND ("+QueryStringHelper.formatTupleFieldLike("activity", "administrativeUnit.code","administrativeUnit") + " OR " + QueryStringHelper.formatTupleFieldLike("activity", "administrativeUnit.name","administrativeUnit")+")"
				+ "ORDER BY activity.code ASC");
	}
	
	@Override
	protected Object[] __getQueryParameters__(QueryContext queryContext, Properties properties, Object... objects) {
		if(queryContext.getQuery().isIdentifierEqualsToOrQueryDerivedFromQueryIdentifierEqualsTo(readByFiltersLike)) {
			if(ArrayHelper.isEmpty(objects)) {
				List<String> activityTokens = queryContext.getFieldValueLikes("activity",5);
				objects = new Object[] {activityTokens.get(0),activityTokens.get(0),activityTokens.get(1),activityTokens.get(2)
						,activityTokens.get(3),activityTokens.get(4),queryContext.getStringLike(Activity.FIELD_ADMINISTRATIVE_UNIT)};
			}
			int index = 0;
			objects = new Object[]{"activity",objects[index++],"activityName",objects[index++]
					,"activityName1",objects[index++],"activityName2",objects[index++],"activityName3",objects[index++],"activityName4",objects[index++]
					,Activity.FIELD_ADMINISTRATIVE_UNIT,objects[index++]};
			return objects;
		}
		if(queryContext.getQuery().isIdentifierEqualsToOrQueryDerivedFromQueryIdentifierEqualsTo(readPlanableByAdministrativeUnitCodeByActionPlanCode)) {
			if(ArrayHelper.isEmpty(objects)) {
				return new Object[] {"actionPlanCode",queryContext.getFilterFieldByKeys("actionPlanCode").getValue()
						,"administrativeUnitCode",queryContext.getFilterFieldByKeys("administrativeUnitCode").getValue()};
			}
		}
		if(queryContext.getQuery().isIdentifierEqualsToOrQueryDerivedFromQueryIdentifierEqualsTo(readByAdministrativeUnitsCodes)) {
			if(ArrayHelper.isEmpty(objects)) {
				return new Object[] {"administrativeUnitsCodes",queryContext.getFilterFieldByKeys("administrativeUnitsCodes").getValue()};
			}
		}
		return super.__getQueryParameters__(queryContext, properties, objects);
	}
}