package ci.gouv.dgbf.system.planaction.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.array.ArrayHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryContext;
import org.cyk.utility.__kernel__.persistence.query.QueryStringHelper;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

import ci.gouv.dgbf.system.planaction.server.persistence.api.EntryAuthorizationPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.EntryAuthorization;

@ApplicationScoped
public class EntryAuthorizationPersistenceImpl extends AbstractPersistenceEntityImpl<EntryAuthorization> implements EntryAuthorizationPersistence,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __listenPostConstructPersistenceQueries__() {
		super.__listenPostConstructPersistenceQueries__();
		addQueryCollectInstances(readByFiltersLike, 
				"SELECT entryAuthorization FROM EntryAuthorization entryAuthorization "
				+ "WHERE "
				
				+ " ("+QueryStringHelper.formatTupleFieldLike("entryAuthorization", "imputation.actionPlan.producer.code","producer") + " OR " 
				+ QueryStringHelper.formatTupleFieldLike("entryAuthorization", "imputation.actionPlan.producer.name","producer")+") "
				
				+ " AND ("+QueryStringHelper.formatTupleFieldLike("entryAuthorization", "imputation.actionPlan.code","actionPlan") + " OR " 
					+ QueryStringHelper.formatTupleFieldLike("entryAuthorization", "imputation.actionPlan.name","actionPlan")+") "
				
				+ " AND ("+QueryStringHelper.formatTupleFieldLike("entryAuthorization", "imputation.activity.code","activity") + " OR " 
				+ QueryStringHelper.formatTupleFieldLike("entryAuthorization", "imputation.activity.name","activity")+") "
				
				+ " AND ("+QueryStringHelper.formatTupleFieldLike("entryAuthorization", "imputation.costUnit.code","costUnit") + " OR " 
				+ QueryStringHelper.formatTupleFieldLike("entryAuthorization", "imputation.costUnit.name","costUnit")+") "
								
				+ " ORDER BY "
				+ "entryAuthorization.imputation.actionPlan.producer.code,entryAuthorization.imputation.actionPlan.year,entryAuthorization.imputation.actionPlan.orderNumber"
				+ ",entryAuthorization.imputation.activity.code,entryAuthorization.imputation.costUnit.code,entryAuthorization.year ASC");
	}
	
	@Override
	protected Object[] __getQueryParameters__(QueryContext queryContext, Properties properties, Object... objects) {
		if(queryContext.getQuery().isIdentifierEqualsToOrQueryDerivedFromQueryIdentifierEqualsTo(readByFiltersLike)) {
			if(ArrayHelper.isEmpty(objects)) {
				objects = new Object[] {queryContext.getStringLike(EntryAuthorization.FIELD_PRODUCER),queryContext.getStringLike(EntryAuthorization.FIELD_ACTION_PLAN)
						,queryContext.getStringLike(EntryAuthorization.FIELD_ACTIVITY),queryContext.getStringLike(EntryAuthorization.FIELD_COST_UNIT)};
			}
			int index = 0;
			objects = new Object[]{EntryAuthorization.FIELD_PRODUCER,objects[index++],EntryAuthorization.FIELD_ACTION_PLAN,objects[index++],EntryAuthorization.FIELD_ACTIVITY
					,objects[index++],EntryAuthorization.FIELD_COST_UNIT,objects[index++]};
			return objects;
		}
		return super.__getQueryParameters__(queryContext, properties, objects);
	}
}