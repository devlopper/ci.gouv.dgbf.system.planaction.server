package ci.gouv.dgbf.system.planaction.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.cyk.utility.__kernel__.array.ArrayHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryContext;
import org.cyk.utility.__kernel__.persistence.query.QueryStringHelper;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;
import org.cyk.utility.server.persistence.PersistenceFunctionReader;

import ci.gouv.dgbf.system.planaction.server.persistence.api.ActionPlanPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.ActionPlan;

@ApplicationScoped
public class ActionPlanPersistenceImpl extends AbstractPersistenceEntityImpl<ActionPlan> implements ActionPlanPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	private String readMaxOrderNumberByProducerCodeByYear;
	
	@Override
	protected void __listenPostConstructPersistenceQueries__() {
		super.__listenPostConstructPersistenceQueries__();
		addQuery(readMaxOrderNumberByProducerCodeByYear, "SELECT MAX(actionPlan.orderNumber) FROM ActionPlan actionPlan "
				+ "WHERE actionPlan.producer.code = :producerCode AND actionPlan.year = :year",Byte.class);
		addQueryCollectInstances(readByFiltersLike, 
				"SELECT actionPlan FROM ActionPlan actionPlan "
				+ "WHERE "
				+ " ("+QueryStringHelper.formatTupleFieldLike("actionPlan", "code") + " OR " + QueryStringHelper.formatTupleFieldLike("actionPlan", "name")+") "
				+ " ORDER BY actionPlan.code ASC");
	}
	
	@Override
	public Byte readMaxOrderNumberByProducerCodeByYear(String producerCode,Short year, Properties properties) {
		Byte maxOrderNumber = null;
		try {
			maxOrderNumber = __inject__(EntityManager.class).createNamedQuery(readMaxOrderNumberByProducerCodeByYear, Byte.class)
					.setParameter("producerCode", producerCode)
					.setParameter("year", year)
					.getSingleResult();
		} catch (NoResultException exception) {}
		if(maxOrderNumber == null)
			maxOrderNumber = 0;
		return maxOrderNumber;
	}
	
	@Override
	protected String __getQueryIdentifier__(Class<?> klass, Properties properties, Object... objects) {
		if(PersistenceFunctionReader.class.equals(klass)) {
			if(Boolean.TRUE.equals(__isFilterByKeys__(properties, ActionPlan.FIELD_CODE)))
				return readByFiltersLike;
		}
		return super.__getQueryIdentifier__(klass, properties, objects);
	}
	
	@Override
	protected Object[] __getQueryParameters__(QueryContext queryContext, Properties properties, Object... objects) {
		if(queryContext.getQuery().isIdentifierEqualsToOrQueryDerivedFromQueryIdentifierEqualsTo(readByFiltersLike)) {
			if(ArrayHelper.isEmpty(objects)) {
				objects = new Object[] {queryContext.getStringLike(ActionPlan.FIELD_CODE),queryContext.getStringLike(ActionPlan.FIELD_NAME)};
			}
			int index = 0;
			objects = new Object[]{"code",objects[index++],"name",objects[index++]};
			return objects;
		}
		return super.__getQueryParameters__(queryContext, properties, objects);
	}
}