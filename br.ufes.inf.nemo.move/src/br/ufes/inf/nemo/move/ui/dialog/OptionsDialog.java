package br.ufes.inf.nemo.move.ui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.ufes.inf.nemo.move.mvc.model.OCLOptionsModel;
import br.ufes.inf.nemo.move.mvc.model.OntoUMLOptionsModel;
import br.ufes.inf.nemo.move.mvc.view.OCLOptionsView;
import br.ufes.inf.nemo.move.mvc.view.OntoUMLOptionsView;
import br.ufes.inf.nemo.move.ui.TheFrame;
import br.ufes.inf.nemo.ocl2alloy.OCLOptions;
import br.ufes.inf.nemo.ontouml2alloy.options.OntoUMLOptions;

/**
 * @author John Guerson
 */

public class OptionsDialog extends JDialog {
	
	private static final long serialVersionUID = 7877781445149017806L;
		
	private OCLOptionsModel oclOptModel;
	private OCLOptionsView oclOptView;	
	private OntoUMLOptionsModel ontoumlOptModel;
	private OntoUMLOptionsView ontoumlOptView;	
	
	private TheFrame frame;
	private JButton btnOk;	
	private JButton btnCancel;	
	private JPanel btnpanel;
	private JTabbedPane tabbedPane;
	
	/**
	 * Launch the Dialog.
	 */
	public static void open(OntoUMLOptionsModel ontoumlOptModel, OCLOptionsModel oclOptModel, TheFrame frame)
	{
		try {
			
			OptionsDialog dialog = new OptionsDialog(ontoumlOptModel,oclOptModel,frame);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(frame);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Constructor.
	 * 
	 * @param ontoumlOptModel
	 * @param oclOptModel
	 * @param frame
	 */
	public OptionsDialog(OntoUMLOptionsModel ontoumlOptModel, OCLOptionsModel oclOptModel, TheFrame frame)
	{
		this(frame);
		
		this.ontoumlOptModel = ontoumlOptModel;		
		this.oclOptModel = oclOptModel;
		this.frame = frame;		
					
		setOptionDialog(ontoumlOptModel,oclOptModel);
	}
	
	/**
	 * Set Options Dialog.
	 * 
	 * @param ontoumlOptModel
	 * @param oclOptModel
	 */
	public void setOptionDialog (OntoUMLOptionsModel ontoumlOptModel, OCLOptionsModel oclOptModel)
	{
		ontoumlOptView.setOntoUMLOptionsView(ontoumlOptModel);				
		oclOptView.setOCLOptionView(oclOptModel);
		
		validate();
		repaint();
	}
	
	/**
	 * Constructor
	 */
	public OptionsDialog(TheFrame frame) 
	{
		super(frame);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(OptionsDialog.class.getResource("/resources/icon/options.png")));
		setTitle("Options");
		setSize(new Dimension(611, 400));
		
		btnOk = new JButton("OK");	
		btnOk.setPreferredSize(new Dimension(100, 25));
		btnOk.addActionListener(new ActionListener() 
		{
       		public void actionPerformed(ActionEvent event) 
       		{
       			OkActionPerformed(event);
       		}
       	});
		
		btnCancel = new JButton("Cancel");
		btnCancel.setPreferredSize(new Dimension(100, 25));
		btnCancel.addActionListener(new ActionListener() 
		{
       		public void actionPerformed(ActionEvent event) 
       		{
       			dispose();
       		}
       	});
		
		btnpanel = new JPanel();
		btnpanel.setPreferredSize(new Dimension(100, 40));
		btnpanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		btnpanel.add(btnOk);
		btnpanel.add(btnCancel);
		
		ontoumlOptView = new OntoUMLOptionsView();		
		ontoumlOptView.setBorder(new EmptyBorder(0, 0, 0, 0));
		oclOptView = new OCLOptionsView();
		
		tabbedPane = new JTabbedPane();		
		tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.setBackground(UIManager.getColor("Panel.background"));
		tabbedPane.add(ontoumlOptView,"OntoUML Conceptual Model");
		tabbedPane.add(oclOptView,"OCL Domain Rules");
		
		getContentPane().setLayout(new BorderLayout(0, 0));		
		getContentPane().add(btnpanel, BorderLayout.SOUTH);		
		getContentPane().add(tabbedPane, BorderLayout.CENTER);				
	}
			
	public void OkActionPerformed(ActionEvent event)
	{
		OntoUMLOptions ontoumlOptions = new OntoUMLOptions();
		ontoumlOptions.antiRigidity = ontoumlOptView.isSelectedAntirigidity(); 
		ontoumlOptions.identityPrinciple = ontoumlOptView.isSelectedIdentityPrinciple();
		ontoumlOptions.weakSupplementationConstraint = ontoumlOptView.isSelectedWeakSupplementation();
		ontoumlOptions.relatorConstraint = ontoumlOptView.isSelectedRelatorConstraint();			    	
		ontoumlOptModel.setOptions(ontoumlOptions);
		
		OCLOptions oclOptions = new OCLOptions(frame.getManager().getOCLModel().getOCLParser());		
		oclOptions.setTransformationType(oclOptView.getTransformationsTypesListSelected());
    	oclOptions.setCommandScope(oclOptView.getScopesListSelected());    			
		oclOptions.setConstraintList(oclOptView.getConstraintListSelected());
    	oclOptModel.setOCLOptions(oclOptions);
		  
    	String message = new String(); int i=1;
    	
    	String text = ontoumlOptions.getIdentityValidityMessage(frame.getManager().getOntoUMLModel().getOntoUMLParser());
    	if (!text.isEmpty())  { message = "W"+String.format("%02d", i)+". "+text+"\n\n"; i++; }
    	    	
    	text = ontoumlOptions.getAntirigityValidityMessage();
    	if (!text.isEmpty())  { message = "W"+String.format("%02d", i)+". "+text+"\n\n"; i++; }    	
    	
    	String finalquestion = "Do you want to continue?"+"\n\n";
    	
    	if (!text.isEmpty())
    	{
			// open warning dialog...
			boolean option = JOptionPane.showConfirmDialog(
					this, message+finalquestion, "Please, Read This...",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE,
					new ImageIcon(OptionsDialog.class.getResource("/resources/icon/warning-36x36.png"))
			) == JOptionPane.YES_OPTION;		
    	
			if (option)
			{
		    	// do the action in the case of continuation...
				dispose();			
				
				frame.getManager().doSimulation();
			}
    	}else{
    		
    		dispose();
    		frame.getManager().doSimulation();
    	}
    	
	}
	
	public TheFrame getTheFrame()
	{
		return frame;
	}
}
