package br.ufes.inf.nemo.move.ui.ocl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 * @author John Guerson
 */

public class OCLEditorBar extends JPanel {
	
	private static final long serialVersionUID = -115797584019893402L;
	
	public JTextField textPath;	
	public JButton btnOpen;
	public JButton btnSave;
	public JButton btnNew;
	public JButton btnParse;
	private JPanel panel;
	
	public OCLEditorBar() 
	{
		setBorder(null);
		textPath = new JTextField();
		textPath.setToolTipText("");
		textPath.setBackground(Color.WHITE);
		textPath.setEditable(false);
		textPath.setColumns(10);		
		setPreferredSize(new Dimension(360, 61));
		
		JToolBar toolBar = new JToolBar();
		
		btnNew = new JButton("New");
		btnNew.setFocusable(false);
		toolBar.add(btnNew);
		btnNew.setToolTipText("New OCL Textual Document (*.ocl)");
		btnNew.setIcon(new ImageIcon(OCLEditorBar.class.getResource("/resources/icon/doc-16x16.png")));
		
		btnOpen = new JButton("Open");
		btnOpen.setFocusable(false);
		toolBar.add(btnOpen);
		btnOpen.setToolTipText("Open OCL textual Document (*.ocl)");
		btnOpen.setIcon(new ImageIcon(OCLEditorBar.class.getResource("/resources/icon/open-16x16.png")));
		
		btnSave = new JButton("Save");
		btnSave.setFocusable(false);
		toolBar.add(btnSave);
		btnSave.setToolTipText("Save Rules to the OCL Textual Document (*.ocl)");
		btnSave.setIcon(new ImageIcon(OCLEditorBar.class.getResource("/resources/icon/save-16x16.png")));
		
		btnParse = new JButton("Parse");
		btnParse.setFocusable(false);
		toolBar.add(btnParse);
		btnParse.setToolTipText("Verify Syntactically the Domain Rules ");
		btnParse.setIcon(new ImageIcon(OCLEditorBar.class.getResource("/resources/icon/check-16x16.png")));
		setLayout(new BorderLayout(0, 0));
		add(textPath, BorderLayout.CENTER);
		add(toolBar, BorderLayout.NORTH);
		
		panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
	}	
}