package br.ufes.inf.nemo.soplpattern.impl;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import RefOntoUML.Association;
import RefOntoUML.Category;
import RefOntoUML.Classifier;
import RefOntoUML.FormalAssociation;
import RefOntoUML.Generalization;
import RefOntoUML.Package;
import RefOntoUML.Relator;
import RefOntoUML.memberOf;
import RefOntoUML.parser.OntoUMLParser;
import br.ufes.inf.nemo.assistant.util.UtilAssistant;
import br.ufes.inf.nemo.common.ontoumlfixer.ClassStereotype;
import br.ufes.inf.nemo.common.ontoumlfixer.Fix;
import br.ufes.inf.nemo.common.ontoumlfixer.OutcomeFixer;
import br.ufes.inf.nemo.common.ontoumlfixer.RelationStereotype;
import br.ufes.inf.nemo.oled.DiagramManager;
import br.ufes.inf.nemo.soplpattern.dynamic.ui.JanBase;
import br.ufes.inf.nemo.soplpattern.impl.SOPLPattern;

public class EntryPoint extends SOPLPattern{

	private Classifier c = null;
	private int entryPoint = 0;  // 1 = SOffering and 2 = SAgreement 
			
	public EntryPoint(OntoUMLParser parser, double x, double y) {		
		super(parser, x, y, "/resource/SOFFERING.png", "SOFFERING");
	}
	
	public EntryPoint(OntoUMLParser parser, double x, double y, int entrypoint) {		
		super(parser, x, y, "/resource/SOFFERING.png", "SOFFERING");
		this.entryPoint = entrypoint;
	}

	public EntryPoint(OntoUMLParser parser, Classifier c, double x, double y) {		
		super(parser, x, y, "/resource/SOFFERING.png", "SOFFERING");
		this.c = c;
	}	
	public void runPattern(DiagramManager diagramManager) {
		this.diagramManager = diagramManager;	
		janBase = new JanBase(this, entryPoint);
	}
	
	public Fix getSpecificFixSOffering(int patternProviderSelected, int patternCustomerSelected, boolean yes_no, int pattern_yes_no_selecionado) {			
		
		Package root = parser.getModel();
		outcomeFixer = new OutcomeFixer(root);
		fix = new Fix();
	
		Association association = null;
		
		Classifier collectiveA = null;
		Classifier roleServiceProvider = null;
		Classifier roleOrgTC = null;
		Classifier roleOrgUnitProvider = null;
		Classifier roleOrgUnitTC = null;
		Classifier rolePersonProvider = null;
		Classifier rolePersonTC = null;
		Classifier roleOrganizationProvider = null;
		Classifier collectiveB = null;
		Classifier collectiveC = null;
		Classifier roleTargetCustomer = null;
		Classifier relatorOffering = null;
		Classifier relatorAgreement = null; 
		Classifier relatorNegotiation = null; 
		Classifier roleServiceCustomer = null;
		Classifier roleHiredServiceProvider = null;
		Classifier categorySODescription = null;
		Classifier categorySOCommitment = null; 
		Classifier categorySADescription = null;
		Classifier modeServiceCustomerCommit = null;
		Classifier modeHPCommitments = null;
		Classifier eventSDelivery = null;
		Classifier eventHPAction = null;
		Classifier eventHPActionMotivation = null;
		Classifier eventSCAction = null;
		Classifier eventSCActionMotivation = null;
		Classifier eventHPCI= null;

		if(patternProviderSelected == 1){ //Pattern P-Provider
			//Create Person
			String person = janBase.getTxtPerson_P_Provider().getText();			
			collectiveA  = this.createClassifier(person, "kind", 0, 50);
			
			//Create Service Provider
			String serviceProvider = janBase.getTxtServiceProvider_P_Provider().getText();
			roleServiceProvider = this.createClassifier(serviceProvider, "RoleMixin", 0, 150);	
			
			fix.addAll(outcomeFixer.createGeneralization(roleServiceProvider, collectiveA));
		}else if(patternProviderSelected == 2){// Pattern O-Provider
			//Create Organization
			String organization = janBase.getTxtOrganization_O_Provider().getText();			
			collectiveA  = this.createClassifier(organization, "kind", 200, 150);
			
			//Create Service Provider
			String serviceProvider = janBase.getTxtServiceProvider_O_Provider().getText();
			roleServiceProvider = this.createClassifier(serviceProvider, "RoleMixin", 200, 300);	
			
			fix.addAll(outcomeFixer.createGeneralization(roleServiceProvider, collectiveA));
		}else if(patternProviderSelected == 3){// Pattern OU-Provider
			//Create Organization Unit
			String orgUnit = janBase.getTxtOrgUnit_OU_Provider().getText();			
			collectiveA  = this.createClassifier(orgUnit, "kind", 200, 150);
			
			//Create Service Provider
			String serviceProvider = janBase.getTxtServiceProvider_OU_Provider().getText();
			roleServiceProvider = this.createClassifier(serviceProvider, "RoleMixin", 200, 300);
			
			fix.addAll(outcomeFixer.createGeneralization(roleServiceProvider, collectiveA));
		}else if(patternProviderSelected == 4){// Pattern P-O-OU-Provider
			
			//Create Person Provider
			String personProvider = janBase.getTxtPersonProvider_P_O_OU_Provider().getText();			
			collectiveB  = this.createClassifier(personProvider, "role", 200, 100);
			
			//Create Organization Unit Provider
			String orgUnitProvider = janBase.getTxtOrgUnitProvider_P_O_OU_Provider().getText();			
			collectiveC  = this.createClassifier(orgUnitProvider, "role", 200, 50);
			
			//Create Service Provider
			String serviceProvider = janBase.getTxtServiceProvider_P_O_OU_Provider().getText();
			roleServiceProvider = this.createClassifier(serviceProvider, "RoleMixin", 200, 300);
			
			//Create Organization Provider
			String orgProvider = janBase.getTxtOrgProvider_P_O_OU_Provider().getText();			
			collectiveA  = this.createClassifier(orgProvider, "role", 200, 150);
			
			fix.addAll(outcomeFixer.createGeneralization(collectiveC, roleServiceProvider ));
			fix.addAll(outcomeFixer.createGeneralization(collectiveB, roleServiceProvider ));
			fix.addAll(outcomeFixer.createGeneralization(collectiveA, roleServiceProvider ));
			
		}else if(patternProviderSelected == 5){// Pattern O-OU-Provider
			//Create Organization Unit Provider
			String orgUnitProvider = janBase.getTxtOrgUnitProvider_O_OU_Provider().getText();			
			roleOrgUnitProvider  = this.createClassifier(orgUnitProvider, "role", 150, 450);
			
			//Create Service Provider
			String serviceProvider = janBase.getTxtServiceProvider_O_OU_Provider().getText();
			roleServiceProvider = this.createClassifier(serviceProvider, "RoleMixin", 200, 300);
			
			//Create Organization Provider
			String organizationProvider = janBase.getTxtOrganizationProvider_O_OU_Provider().getText();
			roleOrganizationProvider = this.createClassifier(organizationProvider, "role", 250, 450);
		
			fix.addAll(outcomeFixer.createGeneralization(roleOrgUnitProvider, roleServiceProvider));	
			fix.addAll(outcomeFixer.createGeneralization(roleOrganizationProvider, roleServiceProvider));	
			
		}else if(patternProviderSelected == 6){// Pattern P-O-Provider
			//Create Organization Unit Provider
			String personProvider = janBase.getTxtPersonProvider_P_O_Provider().getText();			
			rolePersonProvider  = this.createClassifier(personProvider, "role", 150, 450);
			
			//Create Service Provider
			String serviceProvider = janBase.getTxtServiceProvider_P_O_Provider().getText();
			roleServiceProvider = this.createClassifier(serviceProvider, "RoleMixin", 200, 300);
			
			//Create Organization Provider
			String organizationProvider = janBase.getTxtOrganizationProvider_P_O_Provider().getText();
			roleOrganizationProvider = this.createClassifier(organizationProvider, "role", 250, 450); 
		
			fix.addAll(outcomeFixer.createGeneralization(rolePersonProvider, roleServiceProvider));	
			fix.addAll(outcomeFixer.createGeneralization(roleOrganizationProvider, roleServiceProvider));	
		}else if(patternProviderSelected == 7){// Pattern P-OU-Provider
			
			//Create Person Provider
			String personProvider = janBase.getTxtPersonProvider_P_OU_Provider().getText();			
			collectiveB  = this.createClassifier(personProvider, "role", 200, 100);
			
			//Create Organization Unit Provider
			String orgUnitProvider = janBase.getTxtOrgUnitProvider_P_OU_Provider().getText();			
			collectiveC  = this.createClassifier(orgUnitProvider, "role", 200, 50);
			
			//Create Service Provider
			String serviceProvider = janBase.getTxtServiceProvider_P_OU_Provider().getText();
			roleServiceProvider = this.createClassifier(serviceProvider, "RoleMixin", 200, 300);
			
			fix.addAll(outcomeFixer.createGeneralization(collectiveC, roleServiceProvider ));
			fix.addAll(outcomeFixer.createGeneralization(collectiveB, roleServiceProvider ));
			
		}
		
		if(patternCustomerSelected == 1){ //Pattern P-TCustomer
			//Create Person
			String person = janBase.getTxtPerson_P_TCustomer().getText();			
			collectiveB  = this.createClassifier(person, "kind",900, 00);
			
			//Create Target Customer
			String targetCustomer = janBase.getTxtTargetCustomer_P_TCustomer().getText();
			roleTargetCustomer = this.createClassifier(targetCustomer, "RoleMixin", 900, 100);
			
			fix.addAll(outcomeFixer.createGeneralization(roleTargetCustomer, collectiveB));
		}else if(patternCustomerSelected == 2){// Pattern O-TCustomer
			//Create Organization
			String organization = janBase.getTxtOrganization_O_TCustomer().getText();			
			collectiveB  = this.createClassifier(organization, "kind",600, 150);
			
			//Create Target Customer
			String targetCustomer = janBase.getTxtTargetCustomer_O_TCustomer().getText();
			roleTargetCustomer = this.createClassifier(targetCustomer, "RoleMixin", 600, 300);
			
			fix.addAll(outcomeFixer.createGeneralization(roleTargetCustomer, collectiveB));	
		}else if(patternCustomerSelected == 3){// Pattern OU-TCustomer
			//Create Organization Unit
			String orgUnit = janBase.getTxtOrgUnit_OU_TCustomer().getText();			
			collectiveB  = this.createClassifier(orgUnit, "kind",600, 150);
			
			//Create Target Customer
			String targetCustomer = janBase.getTxtTargetCustomer_OU_TCustomer().getText();
			roleTargetCustomer = this.createClassifier(targetCustomer, "RoleMixin", 600, 300);
			
			fix.addAll(outcomeFixer.createGeneralization(roleTargetCustomer, collectiveB));	
			
		}else if(patternCustomerSelected == 4){// Pattern P-O-OU-TCustomer
			
			//Create Person Target Customer
			String personTC = janBase.getTxtPersonTC_P_O_OU_TCustomer().getText();			
			rolePersonTC  = this.createClassifier(personTC, "role", 550, 450);
			
			//Create Organization Unit Target Customer
			String orgUnitTC = janBase.getTxtOrgUnitTC_P_O_OU_TCustomer().getText();			
			roleOrgUnitTC  = this.createClassifier(orgUnitTC, "role", 550, 450);
			
			//Create Target Customer
			String targetCustomer = janBase.getTxtTargetCustomer_P_O_OU_TCustomer().getText();
			roleTargetCustomer = this.createClassifier(targetCustomer, "RoleMixin", 600, 300);
			
			//Create Organization Target Customer
			String organizationTC = janBase.getTxtOrgTC_P_O_OU_TCustomer().getText();
			roleOrgTC = this.createClassifier(organizationTC, "role", 650, 450);
			
			fix.addAll(outcomeFixer.createGeneralization(roleOrgUnitTC, roleTargetCustomer ));
			fix.addAll(outcomeFixer.createGeneralization(rolePersonTC, roleTargetCustomer ));
			fix.addAll(outcomeFixer.createGeneralization(roleOrgTC, roleTargetCustomer ));
		
		}else if(patternCustomerSelected == 5){// Pattern O-OU-TCustomer
			//Create Organization Unit Target Customer
			String orgUnitTC = janBase.getTxtOrgUnitTC_O_OU_TCustomer().getText();			
			roleOrgUnitTC  = this.createClassifier(orgUnitTC, "role", 550, 450);
			
			//Create Target Customer
			String targetCustomer = janBase.getTxtTargetCustomer_O_OU_TCustomer().getText();
			roleTargetCustomer = this.createClassifier(targetCustomer, "RoleMixin", 600, 300);
			
			//Create Organization Target Customer
			String organizationTC = janBase.getTxtOrgTC_O_OU_TCustomer().getText();
			roleOrgTC = this.createClassifier(organizationTC, "role", 650, 450);
			
			fix.addAll(outcomeFixer.createGeneralization(roleOrgUnitTC, roleTargetCustomer));				
			fix.addAll(outcomeFixer.createGeneralization(roleOrgTC, roleTargetCustomer));	
		}else if(patternCustomerSelected == 6){// Pattern P-O-TCustomer
			//Create Person Target Customer
			String personTC = janBase.getTxtPersonTC_P_O_TCustomer().getText();			
			rolePersonTC  = this.createClassifier(personTC, "role", 550, 450);
			
			//Create Target Customer
			String targetCustomer = janBase.getTxtTargetCustomer_P_O_TCustomer().getText();
			roleTargetCustomer = this.createClassifier(targetCustomer, "RoleMixin", 600, 300);
			
			//Create Organization Target Customer
			String organizationTC = janBase.getTxtOrgTC_P_O_TCustomer().getText();
			roleOrgTC = this.createClassifier(organizationTC, "role", 650, 450);
			
			fix.addAll(outcomeFixer.createGeneralization(rolePersonTC, roleTargetCustomer));				
			fix.addAll(outcomeFixer.createGeneralization(roleOrgTC, roleTargetCustomer));	
		}else if(patternCustomerSelected == 7){// Pattern P-OU-TCustomer
			
			//Create Person Target Customer
			String personTC = janBase.getTxtPersonTC_P_OU_TCustomer().getText();			
			rolePersonTC  = this.createClassifier(personTC, "role", 550, 450);
			
			//Create Organization Unit Target Customer
			String orgUnitTC = janBase.getTxtOrgUnitTC_P_OU_TCustomer().getText();			
			roleOrgUnitTC  = this.createClassifier(orgUnitTC, "role", 550, 450);
			
			//Create Target Customer
			String targetCustomer = janBase.getTxtTargetCustomerTC_P_OU_TCustomer().getText();
			roleTargetCustomer = this.createClassifier(targetCustomer, "RoleMixin", 600, 300);
			
			fix.addAll(outcomeFixer.createGeneralization(rolePersonTC, roleTargetCustomer ));
			fix.addAll(outcomeFixer.createGeneralization(roleOrgUnitTC, roleTargetCustomer ));
		}
		
		String offering = janBase.getTxtServiceOffering().getText(); //Offering		
		relatorOffering = this.createClassifier(offering , "Relator",  800, 100);		
		
		String soDescription = janBase.getTxtServiceOfferingDescription().getText(); //SODescription
		if(!soDescription.equals("")) {			
			categorySODescription = this.createClassifier(soDescription, "Category", 800, 0);
			
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "describes", categorySODescription, relatorOffering, 0,-1,1,1).getAdded().get(0);
			fix.includeAdded(association);	
		}	
		
		String soCommitment = janBase.getTxtServiceOfferingCommitment().getText();
		if(!soCommitment.equals("")) {			
			categorySOCommitment = this.createClassifier(soCommitment, "Mode", 700, 00);
			
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.COMPONENTOF, "", relatorOffering, categorySOCommitment,1,1,1,-1).getAdded().get(0);
			fix.includeAdded(association);	
		}	
		if(yes_no) { // SNegAgree or SOfferAgree or SNegotiation
			if (pattern_yes_no_selecionado == 1) { //If SNegAgree
				
				String agreement = janBase.getTextServiceAgreement().getText();
				relatorAgreement= this.createClassifier(agreement , "Relator",  550, 200);	
				
				String negotiation = janBase.getTxtServiceNegotiation().getText();
				relatorNegotiation= this.createClassifier(negotiation , "Relator",  400, 400);	
				
				association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "", relatorOffering, relatorNegotiation, 1,1,0,-1).getAdded().get(0);
				fix.includeAdded(association);	
				association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "", relatorOffering, relatorAgreement,1,1,0,-1).getAdded().get(0);
				fix.includeAdded(association);	
				
				//Theses elements was defined in the Offering. So, Target Customer is now the Hired Service Customer
				// and the Service Provider is now the Hired Service Provider
				roleServiceCustomer = this.createClassifier("Service Customer", "RoleMixin", 900, 200);		
				roleHiredServiceProvider = this.createClassifier("Hired Service Provider", "RoleMixin", 0, 300);	
				
				fix.addAll(outcomeFixer.createGeneralization(roleServiceCustomer, roleTargetCustomer));
				fix.addAll(outcomeFixer.createGeneralization(roleHiredServiceProvider, roleServiceProvider));
				
				association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "is bound to", roleHiredServiceProvider, relatorAgreement,1,1,1,-1).getAdded().get(0);
				fix.includeAdded(association);	
				
				association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "is bound to", roleServiceCustomer, relatorAgreement, 1,-1, 1,-1).getAdded().get(0);
				fix.includeAdded(association);	
				
			}else if (pattern_yes_no_selecionado == 2) { // If SOfferAgree
				
				String agreement = janBase.getTextServiceAgreement_1().getText();
				relatorAgreement= this.createClassifier(agreement , "Relator",  550, 200);	
				
				//Theses elements was defined in the Offering. So, Target Customer is now the Hired Service Customer
				// and the Service Provider is now the Hired Service Provider
				roleServiceCustomer = this.createClassifier("Service Customer", "RoleMixin", 900, 200);		
				roleHiredServiceProvider = this.createClassifier("Hired Service Provider", "RoleMixin", 0, 300);	
				
				fix.addAll(outcomeFixer.createGeneralization(roleServiceCustomer, roleTargetCustomer));
				fix.addAll(outcomeFixer.createGeneralization(roleHiredServiceProvider, roleServiceProvider));
			
				association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "conforms to", relatorAgreement, relatorOffering, 0, -1, 1, 1).getAdded().get(0);
				fix.includeAdded(association);	
				
				association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "is bound to", roleHiredServiceProvider, relatorAgreement,1,1,1,-1).getAdded().get(0);
				fix.includeAdded(association);	
				
				association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "is bound to", roleServiceCustomer, relatorAgreement, 1,-1, 1,-1).getAdded().get(0);
				fix.includeAdded(association);	
			}else if (pattern_yes_no_selecionado == 3) { //If SNegotiation
				String negotiation = janBase.getTextServiceNegotiation_1().getText();
				relatorNegotiation= this.createClassifier(negotiation , "Relator",  400, 400);	
	
				association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "regards to", relatorOffering, relatorNegotiation, 1, 1, 1, -1).getAdded().get(0);
				fix.includeAdded(association);	
			}
		}
				
		// If SNegAgree
		if( (yes_no) && (pattern_yes_no_selecionado != 2) ) { // When we have a Negotiation, the Service Customer and Target Customer will be linked to the Negotiation, not the Offering.
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "participates in", roleServiceProvider, relatorNegotiation, 1, 1, 0, -1).getAdded().get(0);
			fix.includeAdded(association);	
			
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "participates in", roleTargetCustomer, relatorNegotiation, 1,1,0,-1).getAdded().get(0);
			fix.includeAdded(association);
		}
		
		if( (pattern_yes_no_selecionado == 3) || (!yes_no) ) {// If SNegotiation, the workflow ends here
			
			// Create relation between provider, target customer and offering
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "is bound to", roleServiceProvider, relatorOffering,1,1,1,-1).getAdded().get(0);
			fix.includeAdded(association);	
			
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "is bound to", roleTargetCustomer, relatorOffering, 1,-1, 1,-1).getAdded().get(0);
			fix.includeAdded(association);	
			
			diagramManager.updateOLED(fix);
			return fix; 
		}
		
		//Create SADescription
		String saDescription = janBase.getSADescription_txt().getText();
		if(!saDescription.equals("")) {			
			categorySADescription = this.createClassifier(saDescription, "Category", 450, 350);
			
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "", categorySADescription, relatorAgreement, 0,-1,1,-1).getAdded().get(0);
			fix.includeAdded(association);	
		}	
		
		//Create SCCommitments
		String SCCommitments = janBase.getSCCommitments_txt().getText(); 
		if(!SCCommitments.equals("")) {			
			modeServiceCustomerCommit = this.createClassifier(SCCommitments, "Mode", 450, 600);
			
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.COMPONENTOF, "", relatorAgreement, modeServiceCustomerCommit, 1,1,0,-1).getAdded().get(0);
			fix.includeAdded(association);	
			
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "", modeServiceCustomerCommit, roleHiredServiceProvider, 0,-1,1,-1).getAdded().get(0);
			fix.includeAdded(association);
			
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "", modeServiceCustomerCommit, roleServiceCustomer, 0,-1,1,1).getAdded().get(0);
			fix.includeAdded(association);
		}	
		//Create HPCommitments
		String HPCommitments = janBase.getHPCommitments_txt().getText(); 
		if(!HPCommitments.equals("")) {			
			modeHPCommitments = this.createClassifier(HPCommitments, "Mode", 600, 350);
			
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.COMPONENTOF, "", relatorAgreement, modeHPCommitments, 1,1,1,-1).getAdded().get(0);
			fix.includeAdded(association);	
			
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "inheres in", modeHPCommitments, roleHiredServiceProvider, 1,-1,1,1).getAdded().get(0);
			fix.includeAdded(association);
			
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "externally dependent on", modeHPCommitments, roleServiceCustomer, 1,-1,1,-1).getAdded().get(0);
			fix.includeAdded(association);
		}	
		
		//Check where button Create Diagram was pressed	
		if( janBase.getPainelSelecionado() == 7) { // button Create Diagram was pressed on HPCommitments Panel...
			diagramManager.updateOLED(fix);
			return fix;
		}	
		
		//Create SDelivery
		String delivery = janBase.getSDelivery_txt().getText();		
		eventSDelivery = this.createClassifier(delivery , "Role",  520, 100	); //Change to <<Event>>
		
		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "aims to fulfill", eventSDelivery, relatorAgreement, 0,-1,1,1).getAdded().get(0);
		fix.includeAdded(association);
		
		//Create HPActions
		String HPAction = janBase.getHPActions_txt().getText();		
		eventHPAction = this.createClassifier(HPAction , "Role",  250, 50);  //Change to <<Event>>
		
		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "performed by", eventHPAction, roleHiredServiceProvider, 0,-1,1,1).getAdded().get(0);
		fix.includeAdded(association);
		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.COMPONENTOF, "", eventSDelivery, eventHPAction, 1,1,0,-1).getAdded().get(0);
		fix.includeAdded(association);	
		
		//Create HPActionMotivation
//		String HPActionMotivation = janBase.getHPActionMotivation_txt().getText();		
//		eventHPActionMotivation = this.createClassifier(HPActionMotivation , "Role",  0, 600);
//		
//		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "performed by", eventHPActionMotivation, roleHiredServiceProvider, 0,-1,1,1).getAdded().get(0);
//		fix.includeAdded(association);
//		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "motivated by", eventHPActionMotivation, modeHPCommitments, 0,-1,1,-1).getAdded().get(0);
//		fix.includeAdded(association);
		
		//Create SCActions
		String SCAction = janBase.getSCActions_txt().getText();		
		eventSCAction = this.createClassifier(SCAction , "Role",  500, 0);
		
		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "performed by", eventSCAction, roleServiceCustomer, 0,-1,1,1).getAdded().get(0);
		fix.includeAdded(association);
		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.COMPONENTOF, "", eventSDelivery, eventSCAction, 1,1,0,-1).getAdded().get(0);
		fix.includeAdded(association);	
		
		//Create SCActionMotivation
//		String SCActionMotivation = janBase.getSCActionMotivation_txt().getText();		
//		eventSCActionMotivation = this.createClassifier(SCActionMotivation , "Role",  750, 600);
//		
//		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "performed by", eventSCActionMotivation, roleServiceCustomer, 0,-1,1,1).getAdded().get(0);
//		fix.includeAdded(association);
//		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "motivated by", eventSCActionMotivation, modeServiceCustomerCommit, 0,-1,1,-1).getAdded().get(0);
//		fix.includeAdded(association);
		
        //Create Interations
		String HPCI = janBase.getInteractions_txt().getText();		
		eventHPCI = this.createClassifier(HPCI , "Role",  255, 600);
		
		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "participates in", eventHPCI, roleHiredServiceProvider, 0,-1,1,1).getAdded().get(0);
		fix.includeAdded(association);
		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "participates in", eventHPCI, roleServiceCustomer, 0,-1,1,-1).getAdded().get(0);
		fix.includeAdded(association);
		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.COMPONENTOF, "", eventSDelivery, eventHPCI, 1,1,0,-1).getAdded().get(0);
		fix.includeAdded(association);
		
		//Create InteractionMotivation
		
			
		diagramManager.updateOLED(fix);
		return fix; 
		
	}

	public Fix getSpecificFixSAgreement(int patternHiredProviderSelected, int patternServiceCustomerSelected ) {			
	
		Package root = parser.getModel();
		outcomeFixer = new OutcomeFixer(root);
		fix = new Fix();
		Association association = null;
		Classifier collectiveA = null;
		Classifier collectiveB = null;
		Classifier collectiveC = null;
		Classifier relatorAgreement = null;
		Classifier roleServiceCustomer = null;
		Classifier roleHiredServiceProvider = null;
		Classifier roleOrgUnitProvider = null;
		Classifier roleOrganizationProvider = null;
		Classifier rolePersonProvider = null;
		Classifier rolePersonTC = null;  
		Classifier roleOrgUnitTC= null;
		Classifier roleOrgTC= null;
		Classifier categorySADescription = null;
		Classifier modeServiceCustomerCommit = null;
		Classifier modeHPCommitments = null;
		Classifier eventSDelivery = null;
		Classifier eventHPAction = null;
		Classifier eventHPActionMotivation = null;
		Classifier eventSCAction = null;
		Classifier eventSCActionMotivation = null;
		Classifier eventHPCI= null;
		
		if(patternHiredProviderSelected == 1){ //Pattern P-HProvider
			//Create Person	
			String person = janBase.getTxtPerson_P_HProvider().getText(); 
			collectiveA  = this.createClassifier(person, "kind", 0, 50);
			
			//Create Hired Service Provider
			String hiredserviceProvider = janBase.getTxtServiceProvider_P_HProvider().getText();
			roleHiredServiceProvider = this.createClassifier(hiredserviceProvider, "RoleMixin", 0, 150);	
			
			fix.addAll(outcomeFixer.createGeneralization(roleHiredServiceProvider, collectiveA));
		}else if(patternHiredProviderSelected == 2){// Pattern O-HProvider
			//Create Organization
			String organization = janBase.getTxtOrganization_O_HProvider().getText();			
			collectiveA  = this.createClassifier(organization, "kind", 200, 150);
			
			//Create Hired Service Provider
			String serviceProvider = janBase.getTxtServiceProvider_O_HProvider().getText();
			roleHiredServiceProvider = this.createClassifier(serviceProvider, "Role", 200, 300);	
			
			fix.addAll(outcomeFixer.createGeneralization(roleHiredServiceProvider, collectiveA));
		}else if(patternHiredProviderSelected == 3){// Pattern OU-HProvider
			//Create Organization Unit
			String orgUnit = janBase.getTxtOrgUnit_OU_HProvider().getText();			
			collectiveA  = this.createClassifier(orgUnit, "kind", 200, 150);
			
			//Create Service Provider
			String serviceProvider = janBase.getTxtServiceProvider_OU_HProvider().getText();
			roleHiredServiceProvider = this.createClassifier(serviceProvider, "Role", 200, 300);
			
			fix.addAll(outcomeFixer.createGeneralization(roleHiredServiceProvider, collectiveA));
		}else if(patternHiredProviderSelected == 4){// Pattern P-O-OU-HProvider
			
			//Create Person Provider
			String personProvider = janBase.getTxtPersonProvider_P_O_OU_HProvider().getText();			
			collectiveB  = this.createClassifier(personProvider, "role", 200, 100);
			
			//Create Organization Unit Provider
			String orgUnitProvider = janBase.getTxtOrgUnitProvider_P_O_OU_HProvider().getText();			
			collectiveC  = this.createClassifier(orgUnitProvider, "role", 200, 50);
			
			//Create Hired Service Provider
			String serviceProvider = janBase.getTxtServiceProvider_P_O_OU_HProvider().getText();
			roleHiredServiceProvider = this.createClassifier(serviceProvider, "RoleMixin", 200, 300);
			
			//Create Organization Hired Provider
			String orgProvider = janBase.getTxtOrgProvider_P_O_OU_HProvider().getText();			
			collectiveA  = this.createClassifier(orgProvider, "role", 200, 150);
			
			fix.addAll(outcomeFixer.createGeneralization(collectiveC, roleHiredServiceProvider ));
			fix.addAll(outcomeFixer.createGeneralization(collectiveB, roleHiredServiceProvider ));
			fix.addAll(outcomeFixer.createGeneralization(collectiveA, roleHiredServiceProvider ));	
		}else if(patternHiredProviderSelected == 5){// Pattern O-OU-HProvider
			//Create Organization Unit Provider
			String orgUnitProvider = janBase.getTxtOrgUnitProvider_O_OU_HProvider().getText();			
			roleOrgUnitProvider  = this.createClassifier(orgUnitProvider, "role", 150, 450);
			
			//Create Service Provider
			String serviceProvider = janBase.getTxtServiceProvider_O_OU_HProvider().getText();
			roleHiredServiceProvider = this.createClassifier(serviceProvider, "RoleMixin", 200, 300);
			
			//Create Organization Hired Provider
			String organizationProvider = janBase.getTxtOrganizationProvider_O_OU_HProvider().getText();
			roleOrganizationProvider = this.createClassifier(organizationProvider, "role", 250, 450);
		
			fix.addAll(outcomeFixer.createGeneralization(roleOrgUnitProvider, roleHiredServiceProvider));	
			fix.addAll(outcomeFixer.createGeneralization(roleOrganizationProvider, roleHiredServiceProvider));	
		}else if(patternHiredProviderSelected == 6){// Pattern P-O-HProvider
			//Create Organization Unit Hired Provider
			String personProvider = janBase.getTxtPersonProvider_P_O_HProvider().getText();			
			rolePersonProvider  = this.createClassifier(personProvider, "role", 150, 450);
			
			//Create Service Provider
			String serviceProvider = janBase.getTxtServiceProvider_P_O_HProvider().getText();
			roleHiredServiceProvider = this.createClassifier(serviceProvider, "RoleMixin", 200, 300);
			
			//Create Organization Hired Provider
			String organizationProvider = janBase.getTxtOrganizationProvider_P_O_HProvider().getText();
			roleOrganizationProvider = this.createClassifier(organizationProvider, "role", 250, 450); 
		
			fix.addAll(outcomeFixer.createGeneralization(rolePersonProvider, roleHiredServiceProvider));	
			fix.addAll(outcomeFixer.createGeneralization(roleOrganizationProvider, roleHiredServiceProvider));	
		}else if(patternHiredProviderSelected == 7){// Pattern P-OU-HProvider
			
			//Create Person Provider
			String personProvider = janBase.getTxtPersonProvider_P_OU_HProvider().getText();			
			collectiveB  = this.createClassifier(personProvider, "role", 200, 100);
			
			//Create Organization Unit Provider
			String orgUnitProvider = janBase.getTxtOrgUnitProvider_P_OU_HProvider().getText();			
			collectiveC  = this.createClassifier(orgUnitProvider, "role", 200, 50);
			
			//Create Service Provider
			String serviceProvider = janBase.getTxtServiceProvider_P_OU_HProvider().getText();
			roleHiredServiceProvider = this.createClassifier(serviceProvider, "RoleMixin", 200, 300);
			
			fix.addAll(outcomeFixer.createGeneralization(collectiveC, roleHiredServiceProvider ));
			fix.addAll(outcomeFixer.createGeneralization(collectiveB, roleHiredServiceProvider ));
			
		}
		
		
		if(patternServiceCustomerSelected == 1){ //Pattern P-Customer
			//Create Person
			String person = janBase.getTxtPerson_P_Customer().getText();			
			collectiveB  = this.createClassifier(person, "kind",900, 00);
			
			//Create Target Customer
			String customer = janBase.getTxtTargetCustomer_P_Customer().getText();
			roleServiceCustomer = this.createClassifier(customer, "RoleMixin", 900, 100);
			fix.addAll(outcomeFixer.createGeneralization(roleServiceCustomer, collectiveB));
		}else if(patternServiceCustomerSelected == 2){// Pattern O-TCustomer
			//Create Organization
			String organization = janBase.getTxtOrganization_O_Customer().getText();			
			collectiveB  = this.createClassifier(organization, "kind",600, 150);
			
			//Create Customer
			String targetCustomer = janBase.getTxtTargetCustomer_O_Customer().getText();
			roleServiceCustomer = this.createClassifier(targetCustomer, "Role", 600, 300);
			
			fix.addAll(outcomeFixer.createGeneralization(roleServiceCustomer, collectiveB));	
		}else if(patternServiceCustomerSelected == 3){// Pattern OU-Customer
			//Create Organization Unit
			String orgUnit = janBase.getTxtOrgUnit_OU_Customer().getText();			
			collectiveB  = this.createClassifier(orgUnit, "kind",600, 150);
			
			//Create Customer
			String targetCustomer = janBase.getTxtTargetCustomer_OU_Customer().getText();
			roleServiceCustomer = this.createClassifier(targetCustomer, "Role", 600, 300);
			
			fix.addAll(outcomeFixer.createGeneralization(roleServiceCustomer, collectiveB));	
			
		}else if(patternServiceCustomerSelected == 4){// Pattern P-O-OU-Customer
			
			//Create Person Target Customer
			String personTC = janBase.getTxtPersonTC_P_O_OU_Customer().getText();			
			rolePersonTC  = this.createClassifier(personTC, "role", 550, 450); 
			
			//Create Organization Unit  Customer
			String orgUnitTC = janBase.getTxtOrgUnitTC_P_O_OU_Customer().getText();			
			roleOrgUnitTC  = this.createClassifier(orgUnitTC, "role", 550, 450);
			
			//Create  Customer
			String targetCustomer = janBase.getTxtTargetCustomer_P_O_OU_Customer().getText();
			roleServiceCustomer = this.createClassifier(targetCustomer, "RoleMixin", 600, 300);
			
			//Create Organization  Customer
			String organizationTC = janBase.getTxtOrgTC_P_O_OU_Customer().getText();
			roleOrgTC = this.createClassifier(organizationTC, "role", 650, 450);
			
			fix.addAll(outcomeFixer.createGeneralization(roleOrgUnitTC, roleServiceCustomer ));
			fix.addAll(outcomeFixer.createGeneralization(rolePersonTC, roleServiceCustomer ));
			fix.addAll(outcomeFixer.createGeneralization(roleOrgTC, roleServiceCustomer ));
		
		}else if(patternServiceCustomerSelected == 5){// Pattern O-OU-Customer
			//Create Organization Unit  Customer
			String orgUnitTC = janBase.getTxtOrgUnitTC_O_OU_Customer().getText();			
			roleOrgUnitTC  = this.createClassifier(orgUnitTC, "role", 550, 450);
			
			//Create  Customer
			String targetCustomer = janBase.getTxtTargetCustomer_O_OU_Customer().getText();
			roleServiceCustomer = this.createClassifier(targetCustomer, "RoleMixin", 600, 300);
			
			//Create Organization  Customer
			String organizationTC = janBase.getTxtOrgTC_O_OU_Customer().getText();
			roleOrgTC = this.createClassifier(organizationTC, "role", 650, 450);
			
			fix.addAll(outcomeFixer.createGeneralization(roleOrgUnitTC, roleServiceCustomer));				
			fix.addAll(outcomeFixer.createGeneralization(roleOrgTC, roleServiceCustomer));	
		}else if(patternServiceCustomerSelected == 6){// Pattern P-O-Customer
			//Create Person Target Customer
			String personTC = janBase.getTxtPersonTC_P_O_Customer().getText();			
			rolePersonTC  = this.createClassifier(personTC, "role", 550, 450);
			
			//Create  Customer
			String targetCustomer = janBase.getTxtTargetCustomer_P_O_Customer().getText();
			roleServiceCustomer = this.createClassifier(targetCustomer, "RoleMixin", 600, 300);
			
			//Create Organization Customer
			String organizationTC = janBase.getTxtOrgTC_P_O_Customer().getText();
			roleOrgTC = this.createClassifier(organizationTC, "role", 650, 450);
			
			fix.addAll(outcomeFixer.createGeneralization(rolePersonTC, roleServiceCustomer));				
			fix.addAll(outcomeFixer.createGeneralization(roleOrgTC, roleServiceCustomer));	
		}else if(patternServiceCustomerSelected == 7){// Pattern P-OU-Customer
			
			//Create Person Customer
			String personTC = janBase.getTxtPersonTC_P_OU_Customer().getText();			
			rolePersonTC  = this.createClassifier(personTC, "role", 550, 450);
			
			//Create Organization Unit Customer
			String orgUnitTC = janBase.getTxtOrgUnitTC_P_OU_Customer().getText();			
			roleOrgUnitTC  = this.createClassifier(orgUnitTC, "role", 550, 450);
			
			//Create Customer
			String targetCustomer = janBase.getTxtTargetCustomerTC_P_OU_Customer().getText();
			roleServiceCustomer = this.createClassifier(targetCustomer, "RoleMixin", 600, 300);
			
			fix.addAll(outcomeFixer.createGeneralization(rolePersonTC, roleServiceCustomer ));
			fix.addAll(outcomeFixer.createGeneralization(roleOrgUnitTC, roleServiceCustomer ));
		} 

		
		//SAgreement
		String agreement = janBase.getSAgreement_txtt().getText(); //Agreement		
		relatorAgreement = this.createClassifier(agreement , "Relator",  800, 100);
		
		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "is bound to", roleHiredServiceProvider, relatorAgreement,1,1,1,-1).getAdded().get(0);
		fix.includeAdded(association);	
		
		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "is bound to", roleServiceCustomer, relatorAgreement, 1,-1, 1,-1).getAdded().get(0);
		fix.includeAdded(association);	
		
		//Create SADescription
		String saDescription = janBase.getSADescription_txt().getText();
		if(!saDescription.equals("")) {			
			categorySADescription = this.createClassifier(saDescription, "Category", 450, 350);
			
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "", categorySADescription, relatorAgreement, 0,-1,1,-1).getAdded().get(0);
			fix.includeAdded(association);	
		}	
		
		//Create SCCommitments
		String SCCommitments = janBase.getSCCommitments_txt().getText(); 
		if(!SCCommitments.equals("")) {			
			modeServiceCustomerCommit = this.createClassifier(SCCommitments, "Mode", 450, 600);
			
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.COMPONENTOF, "", relatorAgreement, modeServiceCustomerCommit, 1,1,0,-1).getAdded().get(0);
			fix.includeAdded(association);	
			
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "", modeServiceCustomerCommit, roleHiredServiceProvider, 0,-1,1,-1).getAdded().get(0);
			fix.includeAdded(association);
			
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "", modeServiceCustomerCommit, roleServiceCustomer, 0,-1,1,1).getAdded().get(0);
			fix.includeAdded(association);
		}	
		//Create HPCommitments
		String HPCommitments = janBase.getHPCommitments_txt().getText(); 
		if(!HPCommitments.equals("")) {			
			modeHPCommitments = this.createClassifier(HPCommitments, "Mode", 600, 350);
			
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.COMPONENTOF, "", relatorAgreement, modeHPCommitments, 1,1,1,-1).getAdded().get(0);
			fix.includeAdded(association);	
			
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "inheres in", modeHPCommitments, roleHiredServiceProvider, 1,-1,1,1).getAdded().get(0);
			fix.includeAdded(association);
			
			association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "externally dependent on", modeHPCommitments, roleServiceCustomer, 1,-1,1,-1).getAdded().get(0);
			fix.includeAdded(association);
		}	
		
		//Check where button Create Diagram was pressed	
		if( janBase.getPainelSelecionado() == 4) { // button Create Diagram was pressed on HPCommitments Panel...
			diagramManager.updateOLED(fix);
			return fix;
		}
		
		//Create SDelivery
		String delivery = janBase.getSDelivery_txt().getText();		
		eventSDelivery = this.createClassifier(delivery , "Role",  520, 100	);
		
		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "aims to fulfill", eventSDelivery, relatorAgreement, 0,-1,1,1).getAdded().get(0);
		fix.includeAdded(association);
		
		//Create HPActions
		String HPAction = janBase.getHPActions_txt().getText();		
		eventHPAction = this.createClassifier(HPAction , "Role",  250, 50);
		
		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "performed by", eventHPAction, roleHiredServiceProvider, 0,-1,1,1).getAdded().get(0);
		fix.includeAdded(association);
		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.COMPONENTOF, "", eventSDelivery, eventHPAction, 1,1,0,-1).getAdded().get(0);
		fix.includeAdded(association);	
		
		//Create HPActionMotivation
//		String HPActionMotivation = janBase.getHPActionMotivation_txt().getText();		
//		eventHPActionMotivation = this.createClassifier(HPActionMotivation , "Role",  0, 600);
//		
//		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "performed by", eventHPActionMotivation, roleHiredServiceProvider, 0,-1,1,1).getAdded().get(0);
//		fix.includeAdded(association);
//		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "motivated by", eventHPActionMotivation, modeHPCommitments, 0,-1,1,-1).getAdded().get(0);
//		fix.includeAdded(association);
		
		//Create SCActions
		String SCAction = janBase.getSCActions_txt().getText();		
		eventSCAction = this.createClassifier(SCAction , "Role",  500, 0);
		
		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "performed by", eventSCAction, roleHiredServiceProvider, 0,-1,1,1).getAdded().get(0);
		fix.includeAdded(association);
		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.COMPONENTOF, "", eventSDelivery, eventSCAction, 1,1,0,-1).getAdded().get(0);
		fix.includeAdded(association);	
		
		//Create SCActionMotivation
//		String SCActionMotivation = janBase.getSCActionMotivation_txt().getText();		
//		eventSCActionMotivation = this.createClassifier(SCActionMotivation , "Role",  750, 600);
//		
//		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "performed by", eventSCActionMotivation, roleServiceCustomer, 0,-1,1,1).getAdded().get(0);
//		fix.includeAdded(association);
//		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "motivated by", eventSCActionMotivation, modeServiceCustomerCommit, 0,-1,1,-1).getAdded().get(0);
//		fix.includeAdded(association);
		
        //Create Interations
		String HPCI = janBase.getInteractions_txt().getText();		
		eventHPCI = this.createClassifier(HPCI , "Role",  255, 600);
		
		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "participates in", eventHPCI, roleHiredServiceProvider, 0,-1,1,1).getAdded().get(0);
		fix.includeAdded(association);
		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.ASSOCIATION, "participates in", eventHPCI, roleServiceCustomer, 0,-1,1,-1).getAdded().get(0);
		fix.includeAdded(association);
		association = (Association)outcomeFixer.createAssociationBetweenUsingMultiplicity(RelationStereotype.COMPONENTOF, "", eventSDelivery, eventHPCI, 1,1,0,-1).getAdded().get(0);
		fix.includeAdded(association);
		
		//Create InteractionMotivation
		
		
		diagramManager.updateOLED(fix);
		return fix;
	}
}
