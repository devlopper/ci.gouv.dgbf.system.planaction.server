package ci.gouv.dgbf.system.planaction.server.persistence.entities;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

import org.cyk.utility.__kernel__.configuration.ConfigurationHelper;
import org.cyk.utility.__kernel__.protocol.http.HttpHelper;
import org.cyk.utility.__kernel__.rest.RestHelper;
import org.cyk.utility.__kernel__.variable.VariableName;
import org.cyk.utility.test.weld.AbstractWeldUnitTest;
import org.junit.jupiter.api.Test;

public class EntitiesUnitTest extends AbstractWeldUnitTest {
	private static final long serialVersionUID = 1L;

	@Override
	protected void __listenBefore__() {
		super.__listenBefore__();
		setProperties(AdministrativeUnit.class, null, "code", "name", "uuid");
	}
	
	@Override
	protected void __listenAfter__() {
		super.__listenAfter__();
		HttpHelper.clear();
		ConfigurationHelper.clear();
	}
	
	@Test
	public void administrativeUnit_get() throws IOException {
		Collection<AdministrativeUnit> administrativeUnits = RestHelper.getMany(AdministrativeUnit.class);
		assertThat(administrativeUnits).isNotNull();
		assertThat(administrativeUnits.stream().map(AdministrativeUnit::getCode).collect(Collectors.toList())).containsAnyOf("22010001","22010002");
		assertThat(administrativeUnits.stream().map(AdministrativeUnit::getName).collect(Collectors.toList())).containsAnyOf("Cabinet du premier ministre","Cabinet du ministre de l'agriculture");
	}
	
	/**/
	
	private void setProperties(Class<?> klass,Object classifier,String code,String name,String link) {		
		System.setProperty(VariableName.buildClassUniformResourceIdentifier(klass,classifier), "http://localhost:10000/"+(classifier == null ? klass.getSimpleName() : classifier).toString().toLowerCase());
		System.setProperty(VariableName.buildFieldName(klass, classifier, code), code);
		System.setProperty(VariableName.buildFieldName(klass, classifier, name), name);
		System.setProperty(VariableName.buildFieldName(klass, classifier, link), link);
	}
}
