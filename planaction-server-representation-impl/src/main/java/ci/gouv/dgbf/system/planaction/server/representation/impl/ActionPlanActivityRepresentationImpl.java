package ci.gouv.dgbf.system.planaction.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.planaction.server.representation.api.ActionPlanActivityRepresentation;
import ci.gouv.dgbf.system.planaction.server.representation.entities.ActionPlanActivityDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class ActionPlanActivityRepresentationImpl extends AbstractRepresentationEntityImpl<ActionPlanActivityDto> implements ActionPlanActivityRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}
