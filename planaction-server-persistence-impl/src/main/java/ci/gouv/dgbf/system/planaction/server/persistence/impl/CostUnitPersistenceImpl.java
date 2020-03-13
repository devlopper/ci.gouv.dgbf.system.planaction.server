package ci.gouv.dgbf.system.planaction.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.array.ArrayHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryContext;
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
	}
	
	@Override
	protected Object[] __getQueryParameters__(QueryContext queryContext, Properties properties, Object... objects) {
		if(queryContext.getQuery().isIdentifierEqualsToOrQueryDerivedFromQueryIdentifierEqualsTo(readWhereImputationDoNotExistByActionPlanCodeByActivityCode)) {
			if(ArrayHelper.isEmpty(objects)) {
				return new Object[] {"actionPlanCode",queryContext.getFilter().getFields().getAt(0).getValue()
						,"activityCode",queryContext.getFilter().getFields().getAt(1).getValue()};
			}
		}
		return super.__getQueryParameters__(queryContext, properties, objects);
	}
}