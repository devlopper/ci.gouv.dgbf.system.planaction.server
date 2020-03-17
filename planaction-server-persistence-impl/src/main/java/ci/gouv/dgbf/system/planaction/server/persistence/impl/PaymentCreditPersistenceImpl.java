package ci.gouv.dgbf.system.planaction.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.array.ArrayHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryContext;
import org.cyk.utility.__kernel__.persistence.query.QueryStringHelper;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

import ci.gouv.dgbf.system.planaction.server.persistence.api.PaymentCreditPersistence;
import ci.gouv.dgbf.system.planaction.server.persistence.entities.PaymentCredit;

@ApplicationScoped
public class PaymentCreditPersistenceImpl extends AbstractPersistenceEntityImpl<PaymentCredit> implements PaymentCreditPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void __listenPostConstructPersistenceQueries__() {
		super.__listenPostConstructPersistenceQueries__();
		addQueryCollectInstances(readByFiltersLike, 
				"SELECT paymentCredit FROM PaymentCredit paymentCredit "
				+ "WHERE "
				
				+ " ("+QueryStringHelper.formatTupleFieldLike("paymentCredit", "entryAuthorization.imputation.actionPlan.producer.code","producer") + " OR " 
				+ QueryStringHelper.formatTupleFieldLike("paymentCredit", "entryAuthorization.imputation.actionPlan.producer.name","producer")+") "
				
				+ " AND ("+QueryStringHelper.formatTupleFieldLike("paymentCredit", "entryAuthorization.imputation.actionPlan.code","actionPlan") + " OR " 
					+ QueryStringHelper.formatTupleFieldLike("paymentCredit", "entryAuthorization.imputation.actionPlan.name","actionPlan")+") "
				
				+ " AND ("+QueryStringHelper.formatTupleFieldLike("paymentCredit", "entryAuthorization.imputation.activity.code","activity") + " OR " 
				+ QueryStringHelper.formatTupleFieldLike("paymentCredit", "entryAuthorization.imputation.activity.name","activity")+") "
				
				+ " AND ("+QueryStringHelper.formatTupleFieldLike("paymentCredit", "entryAuthorization.imputation.costUnit.code","costUnit") + " OR " 
				+ QueryStringHelper.formatTupleFieldLike("paymentCredit", "entryAuthorization.imputation.costUnit.name","costUnit")+") "
				
				+ " AND ("+QueryStringHelper.formatTupleFieldLike("paymentCredit", "entryAuthorization.identifier","entryAuthorization") + ") "
				
				+ " ORDER BY "
				+ "paymentCredit.entryAuthorization.imputation.actionPlan.producer.code,paymentCredit.entryAuthorization.imputation.actionPlan.year"
				+ ",paymentCredit.entryAuthorization.imputation.actionPlan.orderNumber"
				+ ",paymentCredit.entryAuthorization.imputation.activity.code,paymentCredit.entryAuthorization.imputation.costUnit.code"
				+ ",paymentCredit.entryAuthorization.year,paymentCredit.year ASC");
	}
	
	@Override
	protected Object[] __getQueryParameters__(QueryContext queryContext, Properties properties, Object... objects) {
		if(queryContext.getQuery().isIdentifierEqualsToOrQueryDerivedFromQueryIdentifierEqualsTo(readByFiltersLike)) {
			if(ArrayHelper.isEmpty(objects)) {
				objects = new Object[] {queryContext.getStringLike(PaymentCredit.FIELD_PRODUCER),queryContext.getStringLike(PaymentCredit.FIELD_ACTION_PLAN)
						,queryContext.getStringLike(PaymentCredit.FIELD_ACTIVITY),queryContext.getStringLike(PaymentCredit.FIELD_COST_UNIT)
						,queryContext.getStringLike(PaymentCredit.FIELD_ENTRY_AUTHORIZATION)};
			}
			int index = 0;
			objects = new Object[]{PaymentCredit.FIELD_PRODUCER,objects[index++],PaymentCredit.FIELD_ACTION_PLAN,objects[index++],PaymentCredit.FIELD_ACTIVITY,objects[index++]
					,PaymentCredit.FIELD_COST_UNIT,objects[index++],PaymentCredit.FIELD_ENTRY_AUTHORIZATION,objects[index++]};
			return objects;
		}
		return super.__getQueryParameters__(queryContext, properties, objects);
	}
}