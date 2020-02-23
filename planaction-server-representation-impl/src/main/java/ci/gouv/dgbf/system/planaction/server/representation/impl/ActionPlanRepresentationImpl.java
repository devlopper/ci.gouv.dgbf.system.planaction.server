package ci.gouv.dgbf.system.planaction.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.representation.api.ActionPlanRepresentation;
import ci.gouv.dgbf.system.planaction.server.representation.entities.ActionPlanDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class ActionPlanRepresentationImpl extends AbstractRepresentationEntityImpl<ActionPlanDto> implements ActionPlanRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}
