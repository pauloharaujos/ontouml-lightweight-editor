package br.ufes.inf.nemo.ocl2swrl.factory.ocl.uml.impl;

import java.util.Set;

import org.eclipse.uml2.uml.internal.impl.NamedElementImpl;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.SWRLAtom;
import org.semanticweb.owlapi.model.SWRLDArgument;
import org.semanticweb.owlapi.model.SWRLVariable;

import br.ufes.inf.nemo.ocl2swrl.factory.uml2.uml.internal.impl.TypedElementImplFactory;



/**
 * @author fredd_000
 * @version 1.0
 * @created 24-set-2013 09:16:13
 */
public class OCLExpressionImplFactory extends TypedElementImplFactory {

	public OCLExpressionImplFactory(NamedElementImpl m_NamedElementImpl){
		super(m_NamedElementImpl);
	}
	
	public void finalize() throws Throwable {
		super.finalize();
	}
	
	@Override
	public SWRLDArgument solve(String nameSpace, OWLOntologyManager manager, OWLDataFactory factory, OWLOntology ontology, Set<SWRLAtom> antecedent, Set<SWRLAtom> consequent) {
		return null;
		
	}

}