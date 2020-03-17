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

import ci.gouv.dgbf.system.planaction.server.persistence.api.CostUnitPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.CostUnit;

@ApplicationScoped
public class CostUnitPersistenceImpl extends AbstractPersistenceEntityImpl<CostUnit> implements CostUnitPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	private String readWhereImputationDoNotExistByActionPlanCodeByActivityCode;
	
	@Override
	protected void __listenPostConstructPersistenceQueries__() {
		super.__listenPostConstructPersistenceQueries__();
		addQueryCollectInstances(readWhereImputationDoNotExistByActionPlanCodeByActivityCode, "SELECT costUnit FROM CostUnit costUnit "
				+ "WHERE NOT EXISTS(SELECT imputation FROM Imputation imputation WHERE imputation.costUnit = costUnit AND imputation.actionPlan.code = :actionPlanCode "
				+ "AND imputation.activity.code = :activityCode) ORDER BY costUnit.code ASC");		
		addQueryCollectInstances(readByFiltersLike, 
				"SELECT costUnit FROM CostUnit costUnit "
				+ "WHERE "
				+ "("+QueryStringHelper.formatTupleFieldLike("costUnit", "code","costUnit") + " OR " + QueryStringHelper.formatTupleFieldLikeOrTokens("costUnit", "name","costUnitName",4,LogicalOperator.AND)+")"
				
				+ " AND (EXISTS (SELECT imputation FROM Imputation imputation WHERE imputation.costUnit = costUnit AND "
				+ " (LOWER(imputation.actionPlan.code) LIKE LOWER(:actionPlan) OR imputation.actionPlan.name LIKE LOWER(:actionPlan)) "
				+ ")) "
				
				+ " AND (EXISTS (SELECT imputation FROM Imputation imputation WHERE imputation.costUnit = costUnit AND "
				+ " (LOWER(imputation.activity.code) LIKE LOWER(:activity) OR imputation.activity.name LIKE LOWER(:activity)) "
				+ ")) "
				
				+ "ORDER BY costUnit.code ASC");
	}
	
	@Override
	protected Object[] __getQueryParameters__(QueryContext queryContext, Properties properties, Object... objects) {
		if(queryContext.getQuery().isIdentifierEqualsToOrQueryDerivedFromQueryIdentifierEqualsTo(readWhereImputationDoNotExistByActionPlanCodeByActivityCode)) {
			if(ArrayHelper.isEmpty(objects)) {
				return new Object[] {"actionPlanCode",queryContext.getFilter().getFields().getAt(0).getValue()
						,"activityCode",queryContext.getFilter().getFields().getAt(1).getValue()};
			}
		}
		if(queryContext.getQuery().isIdentifierEqualsToOrQueryDerivedFromQueryIdentifierEqualsTo(readByFiltersLike)) {
			if(ArrayHelper.isEmpty(objects)) {
				List<String> costUnitTokens = queryContext.getFieldValueLikes("costUnit",5);
				objects = new Object[] {costUnitTokens.get(0),costUnitTokens.get(0),costUnitTokens.get(1),costUnitTokens.get(2)
						,costUnitTokens.get(3),costUnitTokens.get(4),queryContext.getStringLike(CostUnit.FIELD_ACTION_PLAN)
						,queryContext.getStringLike(CostUnit.FIELD_ACTIVITY)};
			}
			int index = 0;
			objects = new Object[]{"costUnit",objects[index++],"costUnitName",objects[index++]
					,"costUnitName1",objects[index++],"costUnitName2",objects[index++],"costUnitName3",objects[index++],"costUnitName4",objects[index++]
					,CostUnit.FIELD_ACTION_PLAN,objects[index++],CostUnit.FIELD_ACTIVITY,objects[index++]};
			return objects;
		}
		return super.__getQueryParameters__(queryContext, properties, objects);
	}
}