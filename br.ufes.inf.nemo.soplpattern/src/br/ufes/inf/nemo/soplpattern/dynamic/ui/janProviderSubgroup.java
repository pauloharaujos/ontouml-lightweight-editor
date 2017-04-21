package br.ufes.inf.nemo.soplpattern.dynamic.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class janProviderSubgroup {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janProviderSubgroup window = new janProviderSubgroup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public janProviderSubgroup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 642, 592);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelPatternProvider = new JPanel();
		panelPatternProvider.setBorder(new TitledBorder(null, "Provider", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPatternProvider.setBounds(10, 11, 291, 146);
		frame.getContentPane().add(panelPatternProvider);
		panelPatternProvider.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("P-Provider");
		rdbtnNewRadioButton.setBounds(6, 22, 109, 23);
		panelPatternProvider.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("O-Provider");
		rdbtnNewRadioButton_1.setBounds(6, 48, 109, 23);
		panelPatternProvider.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("OU-Provider");
		rdbtnNewRadioButton_2.setBounds(6, 72, 109, 23);
		panelPatternProvider.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("O-OU-Provider");
		rdbtnNewRadioButton_3.setBounds(131, 22, 109, 23);
		panelPatternProvider.add(rdbtnNewRadioButton_3);
		
		JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("P-O-Provider");
		rdbtnNewRadioButton_4.setBounds(131, 48, 109, 23);
		panelPatternProvider.add(rdbtnNewRadioButton_4);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("P-OU-Provider");
		rdbtnNewRadioButton_5.setBounds(131, 72, 109, 23);
		panelPatternProvider.add(rdbtnNewRadioButton_5);
		
		JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("P-O-OU-Provider");
		rdbtnNewRadioButton_6.setBounds(6, 98, 109, 23);
		panelPatternProvider.add(rdbtnNewRadioButton_6);
		
		JPanel panelPatternCustomer = new JPanel();
		panelPatternCustomer.setLayout(null);
		panelPatternCustomer.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Target Customer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPatternCustomer.setBounds(325, 11, 291, 146);
		frame.getContentPane().add(panelPatternCustomer);
		
		JRadioButton radioButton = new JRadioButton("P-TCustomer");
		radioButton.setBounds(6, 22, 109, 23);
		panelPatternCustomer.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("O-TCustomer");
		radioButton_1.setBounds(6, 48, 109, 23);
		panelPatternCustomer.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("OU-TCustomer");
		radioButton_2.setBounds(6, 72, 109, 23);
		panelPatternCustomer.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("O-OU-TCustomer");
		radioButton_3.setBounds(131, 22, 109, 23);
		panelPatternCustomer.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("P-O-TCustomer");
		radioButton_4.setBounds(131, 48, 109, 23);
		panelPatternCustomer.add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("P-OU-TCustomer");
		radioButton_5.setBounds(131, 72, 109, 23);
		panelPatternCustomer.add(radioButton_5);
		
		JRadioButton radioButton_6 = new JRadioButton("P-O-OU-TCustomer");
		radioButton_6.setBounds(6, 98, 125, 23);
		panelPatternCustomer.add(radioButton_6);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(527, 510, 89, 32);
		frame.getContentPane().add(btnNext);
		
		JPanel imgPatternProvider = new JPanel();
		imgPatternProvider.setBackground(Color.GRAY);
		imgPatternProvider.setBounds(10, 168, 291, 146);
		frame.getContentPane().add(imgPatternProvider);
		
		JPanel imgPatternCustomer = new JPanel();
		imgPatternCustomer.setBackground(Color.GRAY);
		imgPatternCustomer.setBounds(325, 168, 291, 146);
		frame.getContentPane().add(imgPatternCustomer);
		
		JPanel panelP_Provider = new JPanel();
		panelP_Provider.setBorder(new TitledBorder(null, "P-Provider", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelP_Provider.setBounds(10, 325, 291, 184);
		//frame.getContentPane().add(panelP_Provider);
		panelP_Provider.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Person");
		lblNewLabel.setBounds(10, 24, 46, 14);
		panelP_Provider.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(97, 59, 184, 20);
		panelP_Provider.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Service Provider");
		lblNewLabel_1.setBounds(10, 62, 86, 14);
		panelP_Provider.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 21, 184, 20);
		panelP_Provider.add(textField_1);
		
		JPanel panelP_TCustomer = new JPanel();
		panelP_TCustomer.setLayout(null);
		panelP_TCustomer.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "P-TCustomer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelP_TCustomer.setBounds(325, 325, 291, 184);
		//frame.getContentPane().add(panelP_TCustomer);
		
		JLabel label = new JLabel("Person");
		label.setBounds(10, 24, 76, 14);
		panelP_TCustomer.add(label);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(97, 59, 184, 20);
		panelP_TCustomer.add(textField_2);
		
		JLabel label_1 = new JLabel("Target Customer");
		label_1.setBounds(10, 62, 86, 14);
		panelP_TCustomer.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(97, 21, 184, 20);
		panelP_TCustomer.add(textField_3);
		
		JPanel panelP_O_OU_Provider = new JPanel();
		panelP_O_OU_Provider.setLayout(null);
		panelP_O_OU_Provider.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "P-O-OU-Provider", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelP_O_OU_Provider.setBounds(10, 325, 291, 184);
		frame.getContentPane().add(panelP_O_OU_Provider);
		
		JLabel label_15 = new JLabel("Person Provider");
		label_15.setBounds(10, 24, 76, 14);
		panelP_O_OU_Provider.add(label_15);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(137, 59, 144, 20);
		panelP_O_OU_Provider.add(textField_17);
		
		JLabel label_16 = new JLabel("Service Provider");
		label_16.setBounds(10, 62, 86, 14);
		panelP_O_OU_Provider.add(label_16);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(137, 21, 144, 20);
		panelP_O_OU_Provider.add(textField_18);
		
		JLabel label_17 = new JLabel("Organization Unit Provider");
		label_17.setBounds(10, 93, 126, 14);
		panelP_O_OU_Provider.add(label_17);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(137, 90, 144, 20);
		panelP_O_OU_Provider.add(textField_19);
		
		JLabel label_18 = new JLabel("Organization Provider");
		label_18.setBounds(10, 129, 113, 14);
		panelP_O_OU_Provider.add(label_18);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(137, 126, 144, 20);
		panelP_O_OU_Provider.add(textField_20);
		
		JPanel panelP_O_OU_TCustomer = new JPanel();
		panelP_O_OU_TCustomer.setLayout(null);
		panelP_O_OU_TCustomer.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "P-O-OU-TCustomer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelP_O_OU_TCustomer.setBounds(325, 325, 291, 184);
		frame.getContentPane().add(panelP_O_OU_TCustomer);
		
		JLabel label_33 = new JLabel("Person Target Customer");
		label_33.setBounds(10, 24, 117, 14);
		panelP_O_OU_TCustomer.add(label_33);
		
		textField_35 = new JTextField();
		textField_35.setColumns(10);
		textField_35.setBounds(178, 59, 103, 20);
		panelP_O_OU_TCustomer.add(textField_35);
		
		JLabel label_34 = new JLabel("Target Customer");
		label_34.setBounds(10, 62, 86, 14);
		panelP_O_OU_TCustomer.add(label_34);
		
		textField_36 = new JTextField();
		textField_36.setColumns(10);
		textField_36.setBounds(178, 21, 103, 20);
		panelP_O_OU_TCustomer.add(textField_36);
		
		JLabel label_35 = new JLabel("Organization Unit Target Customer");
		label_35.setBounds(10, 93, 167, 14);
		panelP_O_OU_TCustomer.add(label_35);
		
		textField_37 = new JTextField();
		textField_37.setColumns(10);
		textField_37.setBounds(178, 90, 103, 20);
		panelP_O_OU_TCustomer.add(textField_37);
		
		JLabel label_36 = new JLabel("Organization Target Customer");
		label_36.setBounds(10, 129, 145, 14);
		panelP_O_OU_TCustomer.add(label_36);
		
		textField_38 = new JTextField();
		textField_38.setColumns(10);
		textField_38.setBounds(178, 126, 103, 20);
		panelP_O_OU_TCustomer.add(textField_38);
		
		JPanel panelP_OU_TCustomer = new JPanel();
		panelP_OU_TCustomer.setLayout(null);
		panelP_OU_TCustomer.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "P-OU-TCustomer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelP_OU_TCustomer.setBounds(325, 325, 291, 184);
		//frame.getContentPane().add(panelP_OU_TCustomer);
		
		JLabel label_29 = new JLabel("Person Target Customer");
		label_29.setBounds(10, 24, 117, 14);
		panelP_OU_TCustomer.add(label_29);
		
		textField_31 = new JTextField();
		textField_31.setColumns(10);
		textField_31.setBounds(178, 59, 103, 20);
		panelP_OU_TCustomer.add(textField_31);
		
		JLabel label_30 = new JLabel("Target Customer");
		label_30.setBounds(10, 62, 86, 14);
		panelP_OU_TCustomer.add(label_30);
		
		textField_32 = new JTextField();
		textField_32.setColumns(10);
		textField_32.setBounds(178, 21, 103, 20);
		panelP_OU_TCustomer.add(textField_32);
		
		JLabel label_31 = new JLabel("Organization Unit Target Customer");
		label_31.setBounds(10, 93, 172, 14);
		panelP_OU_TCustomer.add(label_31);
		
		textField_33 = new JTextField();
		textField_33.setColumns(10);
		textField_33.setBounds(178, 90, 103, 20);
		panelP_OU_TCustomer.add(textField_33);
		
		JLabel label_32 = new JLabel("Organization Provider");
		label_32.setBounds(10, 129, 113, 14);
		panelP_OU_TCustomer.add(label_32);
		
		textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBounds(178, 126, 103, 20);
		panelP_OU_TCustomer.add(textField_34);
		
		JPanel panelP_O_TCustomer = new JPanel();
		panelP_O_TCustomer.setLayout(null);
		panelP_O_TCustomer.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "P-O-TCustomer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelP_O_TCustomer.setBounds(325, 325, 291, 184);
		//frame.getContentPane().add(panelP_O_TCustomer);
		
		JLabel label_26 = new JLabel("Person Target Customer");
		label_26.setBounds(10, 24, 117, 14);
		panelP_O_TCustomer.add(label_26);
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setBounds(157, 59, 124, 20);
		panelP_O_TCustomer.add(textField_28);
		
		JLabel label_27 = new JLabel("Target Customer");
		label_27.setBounds(10, 62, 86, 14);
		panelP_O_TCustomer.add(label_27);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setBounds(157, 21, 124, 20);
		panelP_O_TCustomer.add(textField_29);
		
		JLabel label_28 = new JLabel("Organization Target Customer");
		label_28.setBounds(10, 93, 154, 14);
		panelP_O_TCustomer.add(label_28);
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		textField_30.setBounds(157, 90, 124, 20);
		panelP_O_TCustomer.add(textField_30);
		
		JPanel panelO_OU_TCustomer = new JPanel();
		panelO_OU_TCustomer.setLayout(null);
		panelO_OU_TCustomer.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "O-OU-TCustomer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelO_OU_TCustomer.setBounds(325, 325, 291, 184);
		//frame.getContentPane().add(panelO_OU_TCustomer);
		
		JLabel label_23 = new JLabel("Organizational Unit Target Customer");
		label_23.setBounds(61, 21, 197, 14);
		panelO_OU_TCustomer.add(label_23);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBounds(61, 83, 170, 20);
		panelO_OU_TCustomer.add(textField_25);
		
		JLabel label_24 = new JLabel("Target Customer");
		label_24.setBounds(104, 69, 86, 14);
		panelO_OU_TCustomer.add(label_24);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(61, 38, 170, 20);
		panelO_OU_TCustomer.add(textField_26);
		
		JLabel label_25 = new JLabel("Organization Target Customer");
		label_25.setBounds(75, 123, 156, 14);
		panelO_OU_TCustomer.add(label_25);
		
		textField_27 = new JTextField();
		textField_27.setColumns(10);
		textField_27.setBounds(61, 142, 170, 20);
		panelO_OU_TCustomer.add(textField_27);
		
		JPanel panelOU_TCustomer = new JPanel();
		panelOU_TCustomer.setLayout(null);
		panelOU_TCustomer.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "OU-TCustomer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOU_TCustomer.setBounds(325, 325, 291, 184);
		//frame.getContentPane().add(panelOU_TCustomer);
		
		JLabel label_21 = new JLabel("Organizational Unit");
		label_21.setBounds(10, 24, 117, 14);
		panelOU_TCustomer.add(label_21);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(119, 59, 162, 20);
		panelOU_TCustomer.add(textField_23);
		
		JLabel label_22 = new JLabel("Target Customer");
		label_22.setBounds(10, 62, 86, 14);
		panelOU_TCustomer.add(label_22);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(119, 21, 162, 20);
		panelOU_TCustomer.add(textField_24);
		
		JPanel panelO_TCustomer = new JPanel();
		panelO_TCustomer.setLayout(null);
		panelO_TCustomer.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "O-TCustomer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelO_TCustomer.setBounds(325, 325, 291, 184);
		//frame.getContentPane().add(panelO_TCustomer);
		
		JLabel label_19 = new JLabel("Organization");
		label_19.setBounds(10, 24, 76, 14);
		panelO_TCustomer.add(label_19);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(137, 59, 144, 20);
		panelO_TCustomer.add(textField_21);
		
		JLabel label_20 = new JLabel("Target Customer");
		label_20.setBounds(10, 62, 86, 14);
		panelO_TCustomer.add(label_20);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(137, 21, 144, 20);
		panelO_TCustomer.add(textField_22);
		
		JPanel panelP_OU_Provider = new JPanel();
		panelP_OU_Provider.setLayout(null);
		panelP_OU_Provider.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "P-OU-Provider", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelP_OU_Provider.setBounds(10, 325, 291, 184);
		//frame.getContentPane().add(panelP_OU_Provider);
		
		JLabel label_12 = new JLabel("Person Provider");
		label_12.setBounds(10, 24, 76, 14);
		panelP_OU_Provider.add(label_12);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(143, 59, 138, 20);
		panelP_OU_Provider.add(textField_14);
		
		JLabel label_13 = new JLabel("Service Provider");
		label_13.setBounds(10, 62, 86, 14);
		panelP_OU_Provider.add(label_13);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(143, 21, 138, 20);
		panelP_OU_Provider.add(textField_15);
		
		JLabel label_14 = new JLabel("Organization Unit Provider");
		label_14.setBounds(10, 93, 126, 14);
		panelP_OU_Provider.add(label_14);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(143, 90, 138, 20);
		panelP_OU_Provider.add(textField_16);
		
		JPanel panelP_O_Provider = new JPanel();
		panelP_O_Provider.setLayout(null);
		panelP_O_Provider.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "P-O-Provider", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelP_O_Provider.setBounds(10, 325, 291, 184);
		//frame.getContentPane().add(panelP_O_Provider);
		
		JLabel label_9 = new JLabel("Person Provider");
		label_9.setBounds(10, 24, 76, 14);
		panelP_O_Provider.add(label_9);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(117, 59, 164, 20);
		panelP_O_Provider.add(textField_11);
		
		JLabel label_10 = new JLabel("Service Provider");
		label_10.setBounds(10, 62, 86, 14);
		panelP_O_Provider.add(label_10);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(117, 21, 164, 20);
		panelP_O_Provider.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(117, 90, 164, 20);
		panelP_O_Provider.add(textField_13);
		
		JLabel label_11 = new JLabel("Organization Provider");
		label_11.setBounds(10, 93, 109, 14);
		panelP_O_Provider.add(label_11);
		
		JPanel panelO_OU_Provider = new JPanel();
		panelO_OU_Provider.setLayout(null);
		panelO_OU_Provider.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "O-OU-Provider", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelO_OU_Provider.setBounds(10, 325, 291, 184);
		//frame.getContentPane().add(panelO_OU_Provider);
		
		JLabel label_6 = new JLabel("Organization Unit Provider");
		label_6.setBounds(10, 24, 126, 14);
		panelO_OU_Provider.add(label_6);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(146, 59, 135, 20);
		panelO_OU_Provider.add(textField_8);
		
		JLabel label_7 = new JLabel("Service Provider");
		label_7.setBounds(10, 62, 86, 14);
		panelO_OU_Provider.add(label_7);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(146, 21, 135, 20);
		panelO_OU_Provider.add(textField_9);
		
		JLabel label_8 = new JLabel("Organization Provider");
		label_8.setBounds(10, 93, 111, 14);
		panelO_OU_Provider.add(label_8);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(146, 90, 135, 20);
		panelO_OU_Provider.add(textField_10);
		
		JPanel panelOU_Provider = new JPanel();
		panelOU_Provider.setLayout(null);
		panelOU_Provider.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "OU-Provider", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOU_Provider.setBounds(10, 325, 291, 184);
		//frame.getContentPane().add(panelOU_Provider);
		
		JLabel label_4 = new JLabel("Organization Unit");
		label_4.setBounds(10, 24, 107, 14);
		panelOU_Provider.add(label_4);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(102, 59, 179, 20);
		panelOU_Provider.add(textField_6);
		
		JLabel label_5 = new JLabel("Service Provider");
		label_5.setBounds(10, 62, 86, 14);
		panelOU_Provider.add(label_5);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(102, 21, 179, 20);
		panelOU_Provider.add(textField_7);
		
		JPanel panelO_Provider = new JPanel();
		panelO_Provider.setLayout(null);
		panelO_Provider.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "O-Provider", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelO_Provider.setBounds(10, 325, 291, 184);
		//frame.getContentPane().add(panelO_Provider);
		
		JLabel label_2 = new JLabel("Organization");
		label_2.setBounds(10, 24, 76, 14);
		panelO_Provider.add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(97, 59, 184, 20);
		panelO_Provider.add(textField_4);
		
		JLabel label_3 = new JLabel("Service Provider");
		label_3.setBounds(10, 62, 86, 14);
		panelO_Provider.add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(97, 21, 184, 20);
		panelO_Provider.add(textField_5);
	}
}
