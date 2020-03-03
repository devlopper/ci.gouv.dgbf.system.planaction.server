package ci.gouv.dgbf.system.planaction.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.representation.api.CostUnitRepresentation;
import ci.gouv.dgbf.system.planaction.server.representation.entities.CostUnitDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class CostUnitRepresentationImpl extends AbstractRepresentationEntityImpl<CostUnitDto> implements CostUnitRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}
