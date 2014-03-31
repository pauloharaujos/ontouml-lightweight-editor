package br.ufes.inf.nemo.oled.popupmenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import RefOntoUML.Association;
import RefOntoUML.Generalization;
import RefOntoUML.Property;
import RefOntoUML.Relationship;
import RefOntoUML.Type;
import br.ufes.inf.nemo.oled.AppCommandListener;
import br.ufes.inf.nemo.oled.draw.Connection;
import br.ufes.inf.nemo.oled.draw.DiagramElement;
import br.ufes.inf.nemo.oled.ui.diagram.DiagramEditor;
import br.ufes.inf.nemo.oled.ui.diagram.commands.DiagramNotification.ChangeType;
import br.ufes.inf.nemo.oled.ui.diagram.commands.DiagramNotification.NotificationType;
import br.ufes.inf.nemo.oled.umldraw.shared.UmlConnection;
import br.ufes.inf.nemo.oled.umldraw.structure.AssociationElement;
import br.ufes.inf.nemo.oled.umldraw.structure.AssociationElement.ReadingDirection;
import br.ufes.inf.nemo.oled.umldraw.structure.GeneralizationElement;
import br.ufes.inf.nemo.oled.util.ApplicationResources;
import br.ufes.inf.nemo.oled.util.IconLoader;

public class SingleConnectionPopupMenu extends JPopupMenu implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Set<AppCommandListener> commandListeners = new HashSet<AppCommandListener>();
	private DiagramEditor editor;
	//connection items
	private Connection con;
	final JMenuItem showRolesItem;
	final JMenuItem showNameItem;
	final JMenuItem showMultiplicitiesItem;
	final JMenuItem showStereotypeItem;
	final JMenuItem rectMenuItem;
	final JMenuItem readToSourceItem;
	final JMenuItem readToDestinationItem;
	final JMenuItem readNoIndicatorItem;
	final JMenu visibilityMenu;
	final JMenu readingDirectionMenu;
	// end-point items
	private boolean isSource;
	private Property property;
	private JMenu multiplicityMenu;
	private JRadioButtonMenuItem zerooneItem;
	private JRadioButtonMenuItem zeromanyItem;
	private JRadioButtonMenuItem oneItem;
	private JRadioButtonMenuItem onemanyItem;
	private JRadioButtonMenuItem twomanyItem;
	private JRadioButtonMenuItem twoItem;
	private JRadioButtonMenuItem otherItem;	
	private JMenuItem endNameItem;
	
	public SingleConnectionPopupMenu()
	{		
		JMenuItem propertyItem = createMenuItem(this, "editproperties");
		propertyItem.setAccelerator(KeyStroke.getKeyStroke("F9"));		
		
		addSeparator();
		
		createMenuItem(this, "resetpoints");
		createMenuItem(this, "recttodirect");
		rectMenuItem = createMenuItem(this, "directtorect");
		
		addSeparator();
		
		createEndPointItems();
		
		visibilityMenu = new JMenu(ApplicationResources.getInstance().getString("submenu.visibility.name"));
		add(visibilityMenu);
			
		showRolesItem = createCheckBoxMenuItem(visibilityMenu, "visibility.showroles");
		showRolesItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (con instanceof AssociationElement) {	
					ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
					((AssociationElement)con).setShowRoles(showRolesItem.isSelected());
					list.add(con);
					editor.notifyChange(list, ChangeType.ELEMENTS_CHANGED, NotificationType.DO);
				}
			}
		});
		
		showMultiplicitiesItem = createCheckBoxMenuItem(visibilityMenu, "visibility.showmultiplicities");
		showMultiplicitiesItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				
				if (con instanceof AssociationElement) {					
					ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
					((AssociationElement)con).setShowMultiplicities(showMultiplicitiesItem.isSelected());
					list.add(con);
					editor.notifyChange(list, ChangeType.ELEMENTS_CHANGED, NotificationType.DO);
				}								
			}
		});
		
		showNameItem = createCheckBoxMenuItem(visibilityMenu, "visibility.showname");
		showNameItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
				if (con instanceof AssociationElement) {					
					((AssociationElement)con).setShowName(showNameItem.isSelected());					
				}else{
					((GeneralizationElement)con).setShowName(showNameItem.isSelected());
				}
				list.add(con);
				editor.notifyChange(list, ChangeType.ELEMENTS_CHANGED, NotificationType.DO);
			}
		});
			
		showStereotypeItem = createCheckBoxMenuItem(visibilityMenu, "visibility.showstereotype");
		showStereotypeItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (con instanceof AssociationElement) {	
					ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
					((AssociationElement)con).setShowOntoUmlStereotype(showStereotypeItem.isSelected());
					list.add(con);
					editor.notifyChange(list, ChangeType.ELEMENTS_CHANGED, NotificationType.DO);
				}				
			}
		});
		
		readingDirectionMenu = new JMenu(ApplicationResources.getInstance().getString("submenu.readingdirection.name"));
		add(readingDirectionMenu);
		
		ButtonGroup group = new ButtonGroup();
		
		readToSourceItem = createRadioMenuItem(readingDirectionMenu, "readingdirection.source");
		group.add(readToSourceItem);
		readToSourceItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (con instanceof AssociationElement) {	
					ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
					((AssociationElement)con).setNameReadingDirection(ReadingDirection.RIGHT_LEFT);
					list.add(con);
					editor.notifyChange(list, ChangeType.ELEMENTS_CHANGED, NotificationType.DO);
				}
			}
		});

		readToDestinationItem = createRadioMenuItem(readingDirectionMenu, "readingdirection.destination");
		group.add(readToDestinationItem);
		readToDestinationItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (con instanceof AssociationElement) {	
					ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();
					((AssociationElement)con).setNameReadingDirection(ReadingDirection.LEFT_RIGHT);
					list.add(con);
					editor.notifyChange(list, ChangeType.ELEMENTS_CHANGED, NotificationType.DO);
				}							
			}
		});
		
		readNoIndicatorItem = createRadioMenuItem(readingDirectionMenu, "readingdirection.none");
		readNoIndicatorItem.setSelected(true);
		group.add(readNoIndicatorItem);
		readNoIndicatorItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				if (con instanceof AssociationElement) {	
					ArrayList<DiagramElement> list = new ArrayList<DiagramElement>();					
					((AssociationElement)con).setNameReadingDirection(ReadingDirection.UNDEFINED);
					list.add(con);
					editor.notifyChange(list, ChangeType.ELEMENTS_CHANGED, NotificationType.DO);
				}														
			}
		});
		
		addSeparator();
		
		createMenuItem(this, "exclude");
		
		addSeparator();
		
		createMenuItem(this, "delete");
	}
	
	public void createEndPointItems()
	{	
		endNameItem = new JMenuItem("Set End-Point Name...");
		add(endNameItem);
		endNameItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {			
				 String name = (String)JOptionPane.showInputDialog(editor.getDiagramManager().getFrame(), 
					     "Specify the end-point name: ",
					     "Set end-point name",
						 JOptionPane.PLAIN_MESSAGE,
						 null,
						 null,
						 property.getType().getName().toLowerCase().trim()
				 );
				 if(name!=null){
					 property.setName(name);
					 ((AssociationElement)con).setShowRoles(true);
					 editor.getDiagramManager().refreshDiagramElement(property.getAssociation());
				 }
			}
		});
		
		multiplicityMenu = new JMenu(ApplicationResources.getInstance().getString("submenu.multiplicity.name"));
		add(multiplicityMenu);
				
		ButtonGroup group = new ButtonGroup();
		
		zerooneItem = createRadioMenuItem(multiplicityMenu, "multiplicity.zeroone");
		group.add(zerooneItem);
		zerooneItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {			
				editor.getDiagramManager().changeMultiplicity(property, 0, 1);
			}
		});
		
		zeromanyItem = createRadioMenuItem(multiplicityMenu, "multiplicity.zeromany");
		group.add(zeromanyItem);
		zeromanyItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {			
				editor.getDiagramManager().changeMultiplicity(property, 0, -1);
			}
		});
		
		oneItem = createRadioMenuItem(multiplicityMenu, "multiplicity.one");
		group.add(oneItem);
		oneItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {			
				editor.getDiagramManager().changeMultiplicity(property, 1, 1);
			}
		});
		
		onemanyItem = createRadioMenuItem(multiplicityMenu, "multiplicity.onemany");
		group.add(onemanyItem);
		onemanyItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {			
				editor.getDiagramManager().changeMultiplicity(property, 1, -1);
			}
		});
		
		twoItem = createRadioMenuItem(multiplicityMenu, "multiplicity.two");
		group.add(twoItem);
		twoItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {			
				editor.getDiagramManager().changeMultiplicity(property, 2, 2);
			}
		});		
		
		twomanyItem = createRadioMenuItem(multiplicityMenu, "multiplicity.twomany");
		group.add(twomanyItem);
		twomanyItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {			
				editor.getDiagramManager().changeMultiplicity(property, 2, -1);
			}
		});		
		
		multiplicityMenu.addSeparator();
		
		otherItem = createRadioMenuItem(multiplicityMenu, "multiplicity.other");
		group.add(otherItem);
		otherItem.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {			
				 String multiplicity = (String)JOptionPane.showInputDialog(editor.getDiagramManager().getFrame(), 
				     "Specify the new multiplicity: ",
				     "Set multiplicity",
					 JOptionPane.PLAIN_MESSAGE,
					 null,
					 null,
					 "0..2"
				);
				 if(multiplicity!=null){
					 try{
						 editor.getDiagramManager().changeMultiplicity(property, multiplicity);
					 }catch(Exception e){
						 editor.getDiagramManager().getFrame().showErrorMessageDialog("Parsing multiplicity string", e.getLocalizedMessage());
					 }
				 }
			}
		});
	}
	
	public void setConnection(Connection con, DiagramEditor editor)
	{
		this.con = con;
		this.editor = editor;
		if (con instanceof AssociationElement){
			visibilityMenu.setEnabled(true);
			readingDirectionMenu.setEnabled(true);
			showMultiplicitiesItem.setSelected(((AssociationElement)con).showMultiplicities());
			showRolesItem.setSelected(((AssociationElement)con).showRoles());
			showNameItem.setSelected(((AssociationElement)con).showName());
			showStereotypeItem.setSelected(((AssociationElement)con).showOntoUmlStereotype());
		}else{			
			showNameItem.setSelected(((GeneralizationElement)con).showName());
			readingDirectionMenu.setEnabled(false);
			showMultiplicitiesItem.setEnabled(false);
			showRolesItem.setEnabled(false);			
			showStereotypeItem.setEnabled(false);
		}
		
		rectMenuItem.setEnabled(true);
		
		if((con.getConnection1()!=null || con.getConnection2()!=null))
		{
			if (con instanceof AssociationElement){
				Relationship rel = ((AssociationElement)con).getRelationship();
				if (rel instanceof Association){
					Type source = ((Association)rel).getMemberEnd().get(0).getType();
					Type target = ((Association)rel).getMemberEnd().get(1).getType();
					if (source instanceof Relationship || target instanceof Relationship) rectMenuItem.setEnabled(false);
				}
			}
			if (con instanceof GeneralizationElement){
				Relationship rel = ((GeneralizationElement)con).getRelationship();
				if (rel instanceof Generalization){
					Type source = ((Generalization)rel).getGeneral();
					Type target = ((Generalization)rel).getSpecific();
					if (source instanceof Relationship || target instanceof Relationship) rectMenuItem.setEnabled(false);
				}	
			}			
		}
		
		multiplicityMenu.setVisible(false);
		endNameItem.setVisible(false);
	}		
	
	public void setConnection (UmlConnection con, DiagramEditor editor, boolean isSourceEndPoint)
	{		
		setConnection(con,editor);
		
		this.editor = editor;	
		this.con=con;
		this.isSource = isSourceEndPoint;	
		
		Association assoc = (Association)con.getRelationship();		
		if (this.isSource) property = assoc.getMemberEnd().get(0);
		else property = assoc.getMemberEnd().get(1);
		
		if (property.getLower()==0 && property.getUpper()==-1) zeromanyItem.setSelected(true); 
		if (property.getLower()==0 && property.getUpper()==1) zerooneItem.setSelected(true);
		if (property.getLower()==1 && property.getUpper()==1) oneItem.setSelected(true);
		if (property.getLower()==1 && property.getUpper()==-1) onemanyItem.setSelected(true);
		if (property.getLower()==2 && property.getUpper()==-1) twomanyItem.setSelected(true);
		
		multiplicityMenu.setVisible(true);
		endNameItem.setVisible(true);
	}	
	
	/**
	 * Adds the navigability setting menu.
	 * 
	 * @param menu
	 *            the parent menu
	 * @param conn
	 *            the connection
	 */
	//private void addNavigabilityMenu(JPopupMenu menu, UmlConnection conn) {
	//	Relationship relationship = (Relationship) conn.getClassifier();
	//	if (relationship == null)
	//		return; // e.g. NoteConnection has no relation
		//JMenu submenu = null;
		// TODO Uncomment me if used
		/*
		 * if (relationship.canSetElement1Navigability() ||
		 * relationship.canSetElement2Navigability()) { submenu = new
		 * JMenu(ApplicationResources.getInstance().getString(
		 * "submenu.navigableto.name")); menu.add(submenu); } if
		 * (relationship.canSetElement1Navigability()) { JCheckBoxMenuItem
		 * nav2Elem1 = createCheckBoxMenuItem(submenu, "navigabletosource");
		 * nav2Elem1.setSelected(relationship.isNavigableToElement1()); } if
		 * (relationship.canSetElement2Navigability()) { JCheckBoxMenuItem
		 * nav2Elem2 = createCheckBoxMenuItem(submenu, "navigabletotarget");
		 * nav2Elem2.setSelected(relationship.isNavigableToElement2()); }
		 */
	//}
	
	/**
	 * Adds the specified AppCommandListener.
	 * 
	 * @param l
	 *            the AppCommandListener to add
	 */
	public void addAppCommandListener(AppCommandListener l) {
		commandListeners.add(l);
	}
	
	/**
	 * Generic helper method to construct a menu according to the resource
	 * strings.
	 * 
	 * @param menu
	 *            the menu to create the item in
	 * @param name
	 *            the menu item name
	 * @return the JMenuItem
	 */
	public JMenuItem createMenuItem(JComponent menu, String name) {
		String prefix = "menuitem." + name;
		JMenuItem menuitem = new JMenuItem(getResourceString(prefix + ".name"));

		// Command
		String actionCommand = getResourceString(prefix + ".command");
		menuitem.setActionCommand(actionCommand);
		menuitem.addActionListener(this);

		// icon
		String iconType = getResourceString(prefix + ".icon");
		if (iconType != null) {
			menuitem.setIcon(IconLoader.getInstance().getIcon(iconType));
		}
		menu.add(menuitem);
		return menuitem;
	}
	
	/**
	 * Returns the specified resource as a String object.
	 * 
	 * @param property
	 *            the property name
	 * @return the property value or null if not found
	 */
	private String getResourceString(String property) {
		return ApplicationResources.getInstance().getString(property);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void actionPerformed(ActionEvent e) {
		for (AppCommandListener l : commandListeners) {
			l.handleCommand(e.getActionCommand());
		}
	}
	
	/**
	 * Helper method to construct a check box menu item according to resource
	 * strings.
	 * 
	 * @param menu
	 *            the parent menu
	 * @param name
	 *            the menuitem name
	 * @return the menu item
	 */
	private JCheckBoxMenuItem createCheckBoxMenuItem(JComponent menu,
			String name) {
		String prefix = "menuitem." + name;
		JCheckBoxMenuItem menuitem = new JCheckBoxMenuItem(getResourceString(prefix + ".name"));
		// Command
		String actionCommand = getResourceString(prefix + ".command");
		menuitem.setActionCommand(actionCommand);
		menuitem.addActionListener(this);
		
		menu.add(menuitem);
		return menuitem;
	}
	
	private JRadioButtonMenuItem createRadioMenuItem(JMenu menu, String name) {
		String prefix = "menuitem." + name;
		JRadioButtonMenuItem menuitem = new JRadioButtonMenuItem(
				getResourceString(prefix + ".name"));
		// Command
		String actionCommand = getResourceString(prefix + ".command");
		menuitem.setActionCommand(actionCommand);
		menuitem.addActionListener(this);
		
		menu.add(menuitem);
		return menuitem;
	}

}