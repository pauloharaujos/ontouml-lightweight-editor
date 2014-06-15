package br.ufes.inf.nemo.oled.meronymicvalidation;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.ufes.inf.nemo.common.ontoumlfixer.Fix;
import br.ufes.inf.nemo.common.ontoumlparser.OntoUMLParser;
import br.ufes.inf.nemo.oled.AppFrame;

public class ValidationFrame extends JFrame {

	private static final long serialVersionUID = -5936280584643585555L;
	
	private JTabbedPane tabbedPane;

	private JPanel contentPane;
	private PreConditionPanel prePanel;
	private ForbiddenPanel forbiddenPanel;
	private DerivedPanel derivedPanel; 
	
	private JTextPane consoleTextPane;

	private JButton saveButton;

	private JButton closeButton;
	private JButton applyButton;


	/**
	 * Create the frame.
	 */
	public ValidationFrame(OntoUMLParser parser) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JLabel lblOutputConsole = new JLabel("Output Console:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		closeButton = new JButton("Close");
		
		saveButton = new JButton("Save");
		
		applyButton = new JButton("Apply");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(483, Short.MAX_VALUE)
					.addComponent(applyButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(saveButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(closeButton))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblOutputConsole)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblOutputConsole)
					.addGap(3)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(closeButton)
						.addComponent(saveButton)
						.addComponent(applyButton)))
		);
		
		prePanel = new PreConditionPanel(parser);
		tabbedPane.addTab("Pre-Condition", null, prePanel, null);
		
		forbiddenPanel = new ForbiddenPanel(parser);
		tabbedPane.addTab("Forbidden", null, forbiddenPanel, null);
		tabbedPane.setEnabledAt(1, true);
		
		derivedPanel = new DerivedPanel(parser);
		tabbedPane.addTab("Derived", null, derivedPanel, null);
		tabbedPane.setEnabledAt(2, false);
		
		consoleTextPane = new JTextPane();
		consoleTextPane.setBackground(new Color(255, 248, 220));
		scrollPane.setViewportView(consoleTextPane);
		contentPane.setLayout(gl_contentPane);
	}

	
	
	 /** Open the Dialog.
	 */
	public static void open(OntoUMLParser parser, AppFrame parent)
	{
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
			ValidationFrame frame = new ValidationFrame( parser/*parent*/);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
			frame.setLocationRelativeTo(parent);
			
			MessageConsole mc = new MessageConsole(frame.consoleTextPane);
			mc.redirectOut();
			mc.setMessageLines(100);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 /** Open the Dialog.
		 */
		public static void open(OntoUMLParser parser)
		{
			try {
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				
				ValidationFrame frame = new ValidationFrame( parser/*parent*/);
				frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				frame.setVisible(true);
				
				MessageConsole mc = new MessageConsole(frame.consoleTextPane);
				mc.redirectOut();
				mc.setMessageLines(100);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public Fix fixAllPanels(){
		Fix fix = new Fix();
		fix.addAll(prePanel.runFixes());
		
		if(tabbedPane.isEnabledAt(1))
			fix.addAll(forbiddenPanel.runFixes());
		
		if(tabbedPane.isEnabledAt(2))
			fix.addAll(derivedPanel.runFixes());
		
		return fix;
	}
	
}