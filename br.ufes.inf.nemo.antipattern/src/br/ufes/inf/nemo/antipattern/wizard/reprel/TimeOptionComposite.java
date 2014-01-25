package br.ufes.inf.nemo.antipattern.wizard.reprel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import RefOntoUML.Mediation;
import RefOntoUML.Type;
import br.ufes.inf.nemo.antipattern.reprel.RepRelOccurrence;

public class TimeOptionComposite extends Composite {

	public SameTimeComposite sameTimeComposite;
	public LifeTimeComposite throughtTimeOptComposite;
	public Button btnAtTheSame;
	public Button btnThroughoutTime;
	public Label lblType;
	
	public TimeOptionComposite(Composite arg0, int arg1, RepRelOccurrence repRel, Mediation m) {
		super(arg0, arg1);		
		
		Type source = m.getMemberEnd().get(0).getType();
		Type target = m.getMemberEnd().get(1).getType();
		String upperSource = "*";
		if(m.getMemberEnd().get(0).getUpper() != -1) upperSource = Integer.toString(m.getMemberEnd().get(0).getUpper());
		String lowerSource = "*";
		if (m.getMemberEnd().get(0).getLower() != -1) lowerSource = Integer.toString(m.getMemberEnd().get(0).getLower());	
		
		setSize(560,157);
		
		lblType = new Label(this,SWT.NONE);
		lblType.setBounds(10, 10, 540, 15);
		lblType.setText(target.getName()+" -> ["+lowerSource+","+upperSource+"] "+source.getName());
		
		SelectionAdapter listener = new SelectionAdapter() {
	      public void widgetSelected(SelectionEvent e) {
	        if(btnAtTheSame.getSelection()){
	        	throughtTimeOptComposite.disableAll();
	        	sameTimeComposite.enableAll();
	        }
	        if(btnThroughoutTime.getSelection()){
	        	sameTimeComposite.disableAll();
	        	throughtTimeOptComposite.enableAll();
	        }
	      }
	    };
		    
		btnAtTheSame = new Button(this, SWT.RADIO);
		btnAtTheSame.setBounds(10, 62, 109, 25);
		btnAtTheSame.setText("at the same time");
		btnAtTheSame.addSelectionListener(listener);
		
		btnThroughoutTime = new Button(this, SWT.RADIO);
		btnThroughoutTime.setBounds(10, 31, 109, 25);
		btnThroughoutTime.setText("throughout time");		
		btnThroughoutTime.addSelectionListener(listener);
		
		throughtTimeOptComposite = new LifeTimeComposite(this, SWT.NONE);
		throughtTimeOptComposite.setBounds(125, 31, 425, 31);
		
		sameTimeComposite = new SameTimeComposite(this, SWT.NONE, repRel.getRelator(), target);
		sameTimeComposite.setBounds(125, 62, 425, 86);
		
		sameTimeComposite.disableAll();
		throughtTimeOptComposite.disableAll();
		
	}
	
	public boolean isSame()
	{
		return btnAtTheSame.getSelection();
	}
	
	public boolean isLifeTime()
	{
		return btnThroughoutTime.getSelection();
	}
	
	public boolean isYes(){
		return sameTimeComposite.isYes();
	}
	
	public int getN()
	{
		return throughtTimeOptComposite.getN();
	}
	
	public boolean isNo(){
		return sameTimeComposite.isNo();
	}
		
	public void setColor(Color swtColor)
	{
		throughtTimeOptComposite.setColor(swtColor);
		sameTimeComposite.setColor(swtColor);
		lblType.setBackground(swtColor);
		btnAtTheSame.setBackground(swtColor);
		btnThroughoutTime.setBackground(swtColor);
		setBackground(swtColor);
	}
}