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

	@Override
	protected void __listenPostConstructPersistenceQueries__() {
		super.__listenPostConstructPersistenceQueries__();
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
		return super.__getQueryParameters__(queryContext, properties, objects);
	}
}