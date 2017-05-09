package br.ufes.inf.nemo.soplpattern.impl.sOfferingGroup;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import RefOntoUML.Association;
import RefOntoUML.Category;
import RefOntoUML.Classifier;
import RefOntoUML.Package;
import RefOntoUML.Relator;
import RefOntoUML.parser.OntoUMLParser;
import br.ufes.inf.nemo.assistant.util.UtilAssistant;
import br.ufes.inf.nemo.common.ontoumlfixer.ClassStereotype;
import br.ufes.inf.nemo.common.ontoumlfixer.Fix;
import br.ufes.inf.nemo.common.ontoumlfixer.OutcomeFixer;
import br.ufes.inf.nemo.common.ontoumlfixer.RelationStereotype;
import br.ufes.inf.nemo.oled.DiagramManager;
import br.ufes.inf.nemo.soplpattern.dynamic.ui.JanBase;
import br.ufes.inf.nemo.soplpattern.impl.SOPLPattern;

public class SODescription extends SOPLPattern{
	
	
	private Classifier c = null;
	private String elements[][] = new String[4][2];
			
	public SODescription(OntoUMLParser parser, double x, double y) {		
		super(parser, x, y, "/resource/SOFFERING.png", "SOFFERING");
	}

	public SODescription(OntoUMLParser parser, Classifier c, double x, double y) {		
		super(parser, x, y, "/resource/SOFFERING.png", "SOFFERING");
		this.c = c;
	}	
	
	
	public void runPattern(DiagramManager diagramManager) {
						
		//Instanciar a Janela Principal SOPL aqui !
		this.diagramManager = diagramManager;
		//JanProviderCustomerSubgroup janPCsubgroup = new JanProviderCustomerSubgroup(this);
		janBase = new JanBase(this);
	}
	
	public void criarTabela(String[][] tabela){
		this.elements = tabela;				
	}
	
	public Fix getSpecificFix() {			
		
		Package root = parser.getModel();
		outcomeFixer = new OutcomeFixer(root);
		fix = new Fix();

		Classifier collectiveB  = this.createClassifier("Person", "kind", x, y);
		Classifier roleA = this.createClassifier("Service Provider ", "RoleMixin", x, y);
		//Classifier collectiveA = this.createClassifier(elements[1][1].toString() , "Collective", x+(verticalDistance/3), y);
		Classifier collectiveA = this.createClassifier("Person", "kind", x+(verticalDistance/3), y);
		Classifier relatorA = this.createClassifier(elements[2][1].toString() , "Relator", x+(verticalDistance/2), y);		
		Classifier roleB = this.createClassifier("Target Customer" , "RoleMixin", x+(verticalDistance/3), y+70);

		Association formal = null;		
		
		if(collectiveA != null && roleB != null){
			fix.addAll(outcomeFixer.createGeneralization(roleB, collectiveA));	
		}
		
		if(collectiveB != null && roleA != null){
			fix.addAll(outcomeFixer.createGeneralization(roleA, collectiveB));	
		}

		if(roleA != null && relatorA != null){
			formal = (Association)outcomeFixer.createAssociationBetween(RelationStereotype.ASSOCIATION, "", roleA, relatorA).getAdded().get(0);
			fix.includeAdded(formal);
		}
		
		if(relatorA != null && collectiveA != null){
			formal = (Association)outcomeFixer.createAssociationBetween(RelationStereotype.ASSOCIATION, "", relatorA, roleB).getAdded().get(0);
			fix.includeAdded(formal);
		}
		
		diagramManager.updateOLED(fix);
		return fix;
	}
	
}
