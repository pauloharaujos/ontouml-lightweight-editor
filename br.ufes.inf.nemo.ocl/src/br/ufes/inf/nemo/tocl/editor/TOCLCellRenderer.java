package br.ufes.inf.nemo.tocl.editor;

import javax.swing.ImageIcon;
import javax.swing.JList;

import org.fife.ui.autocomplete.Completion;
import org.fife.ui.autocomplete.FunctionCompletion;
import org.fife.ui.autocomplete.MarkupTagCompletion;
import org.fife.ui.autocomplete.TemplateCompletion;
import org.fife.ui.autocomplete.VariableCompletion;

import br.ufes.inf.nemo.ocl.editor.OCLCellRenderer;

/**
 * @author John Guerson
 */

public class TOCLCellRenderer extends OCLCellRenderer {

	private static final long serialVersionUID = 1L;
	
	@Override
	@SuppressWarnings("rawtypes")
	protected void prepareForTemplateCompletion(JList list, TemplateCompletion tc, int index, boolean selected, boolean hasFocus) 
	{
		super.prepareForTemplateCompletion(list, tc, index, selected, hasFocus);
		
		if (tc.getDefinitionString().equals("oclIsTypeOf(w)")||
			tc.getDefinitionString().equals("oclIsKindOf(w)")||
			tc.getDefinitionString().equals("allInstances(w)")
		   ){
			setIcon(new ImageIcon(TOCLCellRenderer.class.getResource("/br/ufes/inf/nemo/tocl/editor/icons/operation.gif")));
			
		}else if (tc.getDefinitionString().contains("Property") && tc.getDefinitionString().contains("[w]"))
		{
			setIcon(new ImageIcon(OCLCellRenderer.class.getResource("/br/ufes/inf/nemo/tocl/editor/icons/property.gif")));
		}
	}

	@Override
	@SuppressWarnings("rawtypes")
	protected void prepareForMarkupTagCompletion(JList list,MarkupTagCompletion mc, int index, boolean selected,boolean hasFocus) 
	{
		super.prepareForMarkupTagCompletion(list, mc, index, selected, hasFocus);		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	@Override
	protected void prepareForOtherCompletion(JList list,Completion c, int index, boolean selected, boolean hasFocus) 
	{
		super.prepareForOtherCompletion(list, c, index, selected, hasFocus);		
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	protected void prepareForVariableCompletion(JList list, VariableCompletion vc, int index, boolean selected, boolean hasFocus) 
	{
		super.prepareForVariableCompletion(list, vc, index, selected, hasFocus);		
	}


	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("rawtypes")
	protected void prepareForFunctionCompletion(JList list, FunctionCompletion fc, int index, boolean selected, boolean hasFocus) 
	{
		super.prepareForFunctionCompletion(list, fc, index, selected, hasFocus);		
	}


}