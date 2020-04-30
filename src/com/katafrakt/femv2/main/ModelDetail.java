package com.katafrakt.femv2.main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.katafrakt.femv2.elements.Element;
import com.katafrakt.femv2.models.Model;
import com.katafrakt.femv2.models.Question2;

import javax.swing.JSlider;

public class ModelDetail extends JPanel implements ChangeListener{
	int width;
	int height;
	JList list;
	private JLabel lblLocal1;
	private JLabel lblGlobal1;
	private JLabel lbldefX1;
	private JLabel lbldefY1;
	private JLabel lbldeltaX1;
	private JLabel lbldeltaY1;
	private JLabel lblLocal2;
	private JLabel lblGlobal2;
	private JLabel lbldefX2;
	private JLabel lbldefY2;
	private JLabel lbldeltaX2;
	private JLabel lbldeltaY2;
	private JComboBox comboModel;
	private DefaultListModel<Element> dataModel;
	private JLabel lblforceX1;
	private JLabel lblforceX2;
	private JLabel lblforceY1;
	private JLabel lblforceY2;
	private JLabel lblStress;
	private JLabel lblElongation;
	private JLabel lblArea;
	private JLabel lblLenght;
	private JLabel lblMm;
	private JLabel lblMm_1;
	private JLabel lblMm_2;
	private JLabel lblNmm;
	private JLabel textStressR;
	private JLabel textElonR;
	private JLabel textAreaR;
	private JLabel textLenghtR;
	private JLabel textIndexR;
	private JLabel lblElement;
	private JLabel lblNodes;
	private JLabel lblMm_3;
	private JLabel lblMm_4;
	private JLabel lblMm_5;
	private JLabel lblMm_6;
	private JLabel lblN;
	private JLabel lblN_1;
	private JLabel lblTensile;
	private JLabel lblBuckling;
	private JLabel lblBucklingR;
	private JLabel lblTensileR;
	private JLabel lbldeltaQ1;
	private JLabel lbldeltaQ2;
	private JPanel panel_1;
	private JPanel panel_2;
	public Element selectedE;
	private JLabel lblMomentR1;
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("serial")
	public ModelDetail(int width,int height) {
		setLayout(null);
		this.width=width;
		this.height=height;
		setPreferredSize(new Dimension(600, 750));
		
		
		dataModel=new DefaultListModel<Element>();
		for(Element e:Model.currentModel.elementList)
			dataModel.addElement(e);
		list = new JList(dataModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//list.setBounds(12, 48, 200, 195);
		//add(list);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setLocation(12, 48);
		scrollPane.setSize(258, 130);
		scrollPane.setViewportView(list);
		add(scrollPane);
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(282, 48, 306, 393);

		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {40, 100, 100, 40};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblElement = new JLabel("Element");
		lblElement.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblElement = new GridBagConstraints();
		gbc_lblElement.anchor = GridBagConstraints.WEST;
		gbc_lblElement.insets = new Insets(0, 0, 5, 5);
		gbc_lblElement.gridx = 0;
		gbc_lblElement.gridy = 0;
		panel.add(lblElement, gbc_lblElement);
		
		textIndexR = new JLabel("-");
		GridBagConstraints gbc_textIndexR = new GridBagConstraints();
		gbc_textIndexR.insets = new Insets(0, 0, 5, 5);
		gbc_textIndexR.gridx = 1;
		gbc_textIndexR.gridy = 0;
		panel.add(textIndexR, gbc_textIndexR);
		
		lblLenght = new JLabel("Lenght");
		lblLenght.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLenght = new GridBagConstraints();
		gbc_lblLenght.anchor = GridBagConstraints.WEST;
		gbc_lblLenght.insets = new Insets(0, 0, 5, 5);
		gbc_lblLenght.gridx = 0;
		gbc_lblLenght.gridy = 1;
		panel.add(lblLenght, gbc_lblLenght);
		
		textLenghtR = new JLabel("-");
		GridBagConstraints gbc_textLenghtR = new GridBagConstraints();
		gbc_textLenghtR.insets = new Insets(0, 0, 5, 5);
		gbc_textLenghtR.gridx = 1;
		gbc_textLenghtR.gridy = 1;
		panel.add(textLenghtR, gbc_textLenghtR);
		
		lblMm = new JLabel("mm");
		lblMm.setHorizontalAlignment(SwingConstants.LEFT);
		lblMm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMm = new GridBagConstraints();
		gbc_lblMm.anchor = GridBagConstraints.WEST;
		gbc_lblMm.insets = new Insets(0, 0, 5, 5);
		gbc_lblMm.gridx = 2;
		gbc_lblMm.gridy = 1;
		panel.add(lblMm, gbc_lblMm);
		
		lblArea = new JLabel("Area");
		lblArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblArea = new GridBagConstraints();
		gbc_lblArea.anchor = GridBagConstraints.WEST;
		gbc_lblArea.insets = new Insets(0, 0, 5, 5);
		gbc_lblArea.gridx = 0;
		gbc_lblArea.gridy = 2;
		panel.add(lblArea, gbc_lblArea);
		
		textAreaR = new JLabel("-");
		GridBagConstraints gbc_textAreaR = new GridBagConstraints();
		gbc_textAreaR.insets = new Insets(0, 0, 5, 5);
		gbc_textAreaR.gridx = 1;
		gbc_textAreaR.gridy = 2;
		panel.add(textAreaR, gbc_textAreaR);
		
		lblMm_1 = new JLabel("mm^2");
		lblMm_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMm_1 = new GridBagConstraints();
		gbc_lblMm_1.anchor = GridBagConstraints.WEST;
		gbc_lblMm_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblMm_1.gridx = 2;
		gbc_lblMm_1.gridy = 2;
		panel.add(lblMm_1, gbc_lblMm_1);
		
		lblElongation = new JLabel("Elongation");
		lblElongation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblElongation = new GridBagConstraints();
		gbc_lblElongation.anchor = GridBagConstraints.WEST;
		gbc_lblElongation.insets = new Insets(0, 0, 5, 5);
		gbc_lblElongation.gridx = 0;
		gbc_lblElongation.gridy = 3;
		panel.add(lblElongation, gbc_lblElongation);
		
		textElonR = new JLabel("-");
		GridBagConstraints gbc_textElonR = new GridBagConstraints();
		gbc_textElonR.insets = new Insets(0, 0, 5, 5);
		gbc_textElonR.gridx = 1;
		gbc_textElonR.gridy = 3;
		panel.add(textElonR, gbc_textElonR);
		
		lblMm_2 = new JLabel("mm");
		lblMm_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMm_2 = new GridBagConstraints();
		gbc_lblMm_2.anchor = GridBagConstraints.WEST;
		gbc_lblMm_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblMm_2.gridx = 2;
		gbc_lblMm_2.gridy = 3;
		panel.add(lblMm_2, gbc_lblMm_2);
		
		lblStress = new JLabel("MaxStress");
		lblStress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblStress = new GridBagConstraints();
		gbc_lblStress.anchor = GridBagConstraints.WEST;
		gbc_lblStress.insets = new Insets(0, 0, 5, 5);
		gbc_lblStress.gridx = 0;
		gbc_lblStress.gridy = 4;
		panel.add(lblStress, gbc_lblStress);
		
		textStressR = new JLabel("-");
		GridBagConstraints gbc_textStressR = new GridBagConstraints();
		gbc_textStressR.insets = new Insets(0, 0, 5, 5);
		gbc_textStressR.gridx = 1;
		gbc_textStressR.gridy = 4;
		panel.add(textStressR, gbc_textStressR);
		
		lblNmm = new JLabel("N/mm^2");
		lblNmm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNmm = new GridBagConstraints();
		gbc_lblNmm.anchor = GridBagConstraints.WEST;
		gbc_lblNmm.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmm.gridx = 2;
		gbc_lblNmm.gridy = 4;
		panel.add(lblNmm, gbc_lblNmm);
		
		lblTensile = new JLabel("TensileTest");
		GridBagConstraints gbc_lblTensile = new GridBagConstraints();
		gbc_lblTensile.anchor = GridBagConstraints.WEST;
		gbc_lblTensile.insets = new Insets(0, 0, 5, 5);
		gbc_lblTensile.gridx = 0;
		gbc_lblTensile.gridy = 5;
		panel.add(lblTensile, gbc_lblTensile);
		
		lblTensileR = new JLabel("-");
		GridBagConstraints gbc_lblTensileR = new GridBagConstraints();
		gbc_lblTensileR.gridwidth = 2;
		gbc_lblTensileR.insets = new Insets(0, 0, 5, 5);
		gbc_lblTensileR.gridx = 1;
		gbc_lblTensileR.gridy = 5;
		panel.add(lblTensileR, gbc_lblTensileR);
		
		lblBuckling = new JLabel("BucklingTest");
		GridBagConstraints gbc_lblBuckling = new GridBagConstraints();
		gbc_lblBuckling.anchor = GridBagConstraints.WEST;
		gbc_lblBuckling.insets = new Insets(0, 0, 5, 5);
		gbc_lblBuckling.gridx = 0;
		gbc_lblBuckling.gridy = 6;
		panel.add(lblBuckling, gbc_lblBuckling);
		
		lblBucklingR = new JLabel("-");
		GridBagConstraints gbc_lblBucklingR = new GridBagConstraints();
		gbc_lblBucklingR.gridwidth = 2;
		gbc_lblBucklingR.insets = new Insets(0, 0, 5, 5);
		gbc_lblBucklingR.gridx = 1;
		gbc_lblBucklingR.gridy = 6;
		panel.add(lblBucklingR, gbc_lblBucklingR);
		
		lblNodes = new JLabel("Nodes");
		lblNodes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNodes = new GridBagConstraints();
		gbc_lblNodes.gridwidth = 2;
		gbc_lblNodes.insets = new Insets(0, 0, 5, 5);
		gbc_lblNodes.gridx = 1;
		gbc_lblNodes.gridy = 7;
		panel.add(lblNodes, gbc_lblNodes);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLocal = new GridBagConstraints();
		gbc_lblLocal.anchor = GridBagConstraints.WEST;
		gbc_lblLocal.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocal.gridx = 0;
		gbc_lblLocal.gridy = 8;
		panel.add(lblLocal, gbc_lblLocal);
		
		lblLocal1 = new JLabel("1");
		lblLocal1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLocal1 = new GridBagConstraints();
		gbc_lblLocal1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocal1.gridx = 1;
		gbc_lblLocal1.gridy = 8;
		panel.add(lblLocal1, gbc_lblLocal1);
		
		lblLocal2 = new JLabel("2");
		lblLocal2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblLocal2 = new GridBagConstraints();
		gbc_lblLocal2.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocal2.gridx = 2;
		gbc_lblLocal2.gridy = 8;
		panel.add(lblLocal2, gbc_lblLocal2);
		
		JLabel lblGlobal = new JLabel("Global");
		lblGlobal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblGlobal = new GridBagConstraints();
		gbc_lblGlobal.anchor = GridBagConstraints.WEST;
		gbc_lblGlobal.insets = new Insets(0, 0, 5, 5);
		gbc_lblGlobal.gridx = 0;
		gbc_lblGlobal.gridy = 9;
		panel.add(lblGlobal, gbc_lblGlobal);
		
		lblGlobal1 = new JLabel("-");
		GridBagConstraints gbc_lblGlobal1 = new GridBagConstraints();
		gbc_lblGlobal1.insets = new Insets(0, 0, 5, 5);
		gbc_lblGlobal1.gridx = 1;
		gbc_lblGlobal1.gridy = 9;
		panel.add(lblGlobal1, gbc_lblGlobal1);
		
		lblGlobal2 = new JLabel("-");
		GridBagConstraints gbc_lblGlobal2 = new GridBagConstraints();
		gbc_lblGlobal2.insets = new Insets(0, 0, 5, 5);
		gbc_lblGlobal2.gridx = 2;
		gbc_lblGlobal2.gridy = 9;
		panel.add(lblGlobal2, gbc_lblGlobal2);
		
		JLabel lblDefaultx = new JLabel("defaultX");
		lblDefaultx.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDefaultx = new GridBagConstraints();
		gbc_lblDefaultx.anchor = GridBagConstraints.WEST;
		gbc_lblDefaultx.insets = new Insets(0, 0, 5, 5);
		gbc_lblDefaultx.gridx = 0;
		gbc_lblDefaultx.gridy = 10;
		panel.add(lblDefaultx, gbc_lblDefaultx);
		
		lbldefX1 = new JLabel("-");
		GridBagConstraints gbc_lbldefX1 = new GridBagConstraints();
		gbc_lbldefX1.insets = new Insets(0, 0, 5, 5);
		gbc_lbldefX1.gridx = 1;
		gbc_lbldefX1.gridy = 10;
		panel.add(lbldefX1, gbc_lbldefX1);
		
		lbldefX2 = new JLabel("-");
		GridBagConstraints gbc_lbldefX2 = new GridBagConstraints();
		gbc_lbldefX2.insets = new Insets(0, 0, 5, 5);
		gbc_lbldefX2.gridx = 2;
		gbc_lbldefX2.gridy = 10;
		panel.add(lbldefX2, gbc_lbldefX2);
		
		lblMm_3 = new JLabel("mm");
		lblMm_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMm_3 = new GridBagConstraints();
		gbc_lblMm_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblMm_3.gridx = 3;
		gbc_lblMm_3.gridy = 10;
		panel.add(lblMm_3, gbc_lblMm_3);
		
		JLabel lblDefaulty = new JLabel("defaultY");
		lblDefaulty.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDefaulty = new GridBagConstraints();
		gbc_lblDefaulty.anchor = GridBagConstraints.WEST;
		gbc_lblDefaulty.insets = new Insets(0, 0, 5, 5);
		gbc_lblDefaulty.gridx = 0;
		gbc_lblDefaulty.gridy = 11;
		panel.add(lblDefaulty, gbc_lblDefaulty);
		
		lbldefY1 = new JLabel("-");
		GridBagConstraints gbc_lbldefY1 = new GridBagConstraints();
		gbc_lbldefY1.insets = new Insets(0, 0, 5, 5);
		gbc_lbldefY1.gridx = 1;
		gbc_lbldefY1.gridy = 11;
		panel.add(lbldefY1, gbc_lbldefY1);
		
		lbldefY2 = new JLabel("-");
		GridBagConstraints gbc_lbldefY2 = new GridBagConstraints();
		gbc_lbldefY2.insets = new Insets(0, 0, 5, 5);
		gbc_lbldefY2.gridx = 2;
		gbc_lbldefY2.gridy = 11;
		panel.add(lbldefY2, gbc_lbldefY2);
		
		lblMm_4 = new JLabel("mm");
		lblMm_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMm_4 = new GridBagConstraints();
		gbc_lblMm_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblMm_4.gridx = 3;
		gbc_lblMm_4.gridy = 11;
		panel.add(lblMm_4, gbc_lblMm_4);
		
		JLabel lblDeltax = new JLabel("deltaX");
		lblDeltax.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDeltax = new GridBagConstraints();
		gbc_lblDeltax.anchor = GridBagConstraints.WEST;
		gbc_lblDeltax.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeltax.gridx = 0;
		gbc_lblDeltax.gridy = 12;
		panel.add(lblDeltax, gbc_lblDeltax);
		
		lbldeltaX1 = new JLabel("-");
		GridBagConstraints gbc_lbldeltaX1 = new GridBagConstraints();
		gbc_lbldeltaX1.insets = new Insets(0, 0, 5, 5);
		gbc_lbldeltaX1.gridx = 1;
		gbc_lbldeltaX1.gridy = 12;
		panel.add(lbldeltaX1, gbc_lbldeltaX1);
		
		lbldeltaX2 = new JLabel("-");
		GridBagConstraints gbc_lbldeltaX2 = new GridBagConstraints();
		gbc_lbldeltaX2.insets = new Insets(0, 0, 5, 5);
		gbc_lbldeltaX2.gridx = 2;
		gbc_lbldeltaX2.gridy = 12;
		panel.add(lbldeltaX2, gbc_lbldeltaX2);
		
		lblMm_5 = new JLabel("mm");
		lblMm_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMm_5 = new GridBagConstraints();
		gbc_lblMm_5.insets = new Insets(0, 0, 5, 0);
		gbc_lblMm_5.gridx = 3;
		gbc_lblMm_5.gridy = 12;
		panel.add(lblMm_5, gbc_lblMm_5);
		
		JLabel lblDeltay = new JLabel("deltaY");
		lblDeltay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblDeltay = new GridBagConstraints();
		gbc_lblDeltay.anchor = GridBagConstraints.WEST;
		gbc_lblDeltay.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeltay.gridx = 0;
		gbc_lblDeltay.gridy = 13;
		panel.add(lblDeltay, gbc_lblDeltay);
		
		lbldeltaY1 = new JLabel("-");
		GridBagConstraints gbc_lbldeltaY1 = new GridBagConstraints();
		gbc_lbldeltaY1.insets = new Insets(0, 0, 5, 5);
		gbc_lbldeltaY1.gridx = 1;
		gbc_lbldeltaY1.gridy = 13;
		panel.add(lbldeltaY1, gbc_lbldeltaY1);
		
		lbldeltaY2 = new JLabel("-");
		GridBagConstraints gbc_lbldeltaY2 = new GridBagConstraints();
		gbc_lbldeltaY2.insets = new Insets(0, 0, 5, 5);
		gbc_lbldeltaY2.gridx = 2;
		gbc_lbldeltaY2.gridy = 13;
		panel.add(lbldeltaY2, gbc_lbldeltaY2);
		
		lblMm_6 = new JLabel("mm");
		lblMm_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMm_6 = new GridBagConstraints();
		gbc_lblMm_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblMm_6.gridx = 3;
		gbc_lblMm_6.gridy = 13;
		panel.add(lblMm_6, gbc_lblMm_6);
		
		JLabel lblDeltaq = new JLabel("deltaQ");
		lblDeltaq.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GridBagConstraints gbc_lblDeltaq = new GridBagConstraints();
		gbc_lblDeltaq.anchor = GridBagConstraints.WEST;
		gbc_lblDeltaq.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeltaq.gridx = 0;
		gbc_lblDeltaq.gridy = 14;
		panel.add(lblDeltaq, gbc_lblDeltaq);
		
		lbldeltaQ1 = new JLabel("-");
		GridBagConstraints gbc_lbldeltaQ1 = new GridBagConstraints();
		gbc_lbldeltaQ1.insets = new Insets(0, 0, 5, 5);
		gbc_lbldeltaQ1.gridx = 1;
		gbc_lbldeltaQ1.gridy = 14;
		panel.add(lbldeltaQ1, gbc_lbldeltaQ1);
		
		lbldeltaQ2 = new JLabel("-");
		GridBagConstraints gbc_lbldeltaQ2 = new GridBagConstraints();
		gbc_lbldeltaQ2.insets = new Insets(0, 0, 5, 5);
		gbc_lbldeltaQ2.gridx = 2;
		gbc_lbldeltaQ2.gridy = 14;
		panel.add(lbldeltaQ2, gbc_lbldeltaQ2);
		
		JLabel lblForceX = new JLabel("ForceX");
		lblForceX.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblForceX = new GridBagConstraints();
		gbc_lblForceX.anchor = GridBagConstraints.WEST;
		gbc_lblForceX.insets = new Insets(0, 0, 5, 5);
		gbc_lblForceX.gridx = 0;
		gbc_lblForceX.gridy = 15;
		panel.add(lblForceX, gbc_lblForceX);
		
		lblforceX1 = new JLabel("-");
		GridBagConstraints gbc_lblforceX1 = new GridBagConstraints();
		gbc_lblforceX1.insets = new Insets(0, 0, 5, 5);
		gbc_lblforceX1.gridx = 1;
		gbc_lblforceX1.gridy = 15;
		panel.add(lblforceX1, gbc_lblforceX1);
		
		lblforceX2 = new JLabel("-");
		GridBagConstraints gbc_lblforceX2 = new GridBagConstraints();
		gbc_lblforceX2.insets = new Insets(0, 0, 5, 5);
		gbc_lblforceX2.gridx = 2;
		gbc_lblforceX2.gridy = 15;
		panel.add(lblforceX2, gbc_lblforceX2);
		
		lblN = new JLabel("N");
		lblN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblN = new GridBagConstraints();
		gbc_lblN.insets = new Insets(0, 0, 5, 0);
		gbc_lblN.gridx = 3;
		gbc_lblN.gridy = 15;
		panel.add(lblN, gbc_lblN);
		
		JLabel lblForceY = new JLabel("ForceY");
		lblForceY.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblForceY = new GridBagConstraints();
		gbc_lblForceY.anchor = GridBagConstraints.WEST;
		gbc_lblForceY.insets = new Insets(0, 0, 5, 5);
		gbc_lblForceY.gridx = 0;
		gbc_lblForceY.gridy = 16;
		panel.add(lblForceY, gbc_lblForceY);
		
		lblforceY1 = new JLabel("-");
		GridBagConstraints gbc_lblforceY1 = new GridBagConstraints();
		gbc_lblforceY1.insets = new Insets(0, 0, 5, 5);
		gbc_lblforceY1.gridx = 1;
		gbc_lblforceY1.gridy = 16;
		panel.add(lblforceY1, gbc_lblforceY1);
		
		lblforceY2 = new JLabel("-");
		GridBagConstraints gbc_lblforceY2 = new GridBagConstraints();
		gbc_lblforceY2.insets = new Insets(0, 0, 5, 5);
		gbc_lblforceY2.gridx = 2;
		gbc_lblforceY2.gridy = 16;
		panel.add(lblforceY2, gbc_lblforceY2);
		
		lblN_1 = new JLabel("N");
		lblN_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblN_1 = new GridBagConstraints();
		gbc_lblN_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblN_1.gridx = 3;
		gbc_lblN_1.gridy = 16;
		panel.add(lblN_1, gbc_lblN_1);
		
		JLabel lblMoment = new JLabel("Moment");
		GridBagConstraints gbc_lblMoment = new GridBagConstraints();
		gbc_lblMoment.anchor = GridBagConstraints.WEST;
		gbc_lblMoment.insets = new Insets(0, 0, 0, 5);
		gbc_lblMoment.gridx = 0;
		gbc_lblMoment.gridy = 17;
		panel.add(lblMoment, gbc_lblMoment);
		
		lblMomentR1 = new JLabel("-");
		GridBagConstraints gbc_lblMomentR1 = new GridBagConstraints();
		gbc_lblMomentR1.insets = new Insets(0, 0, 0, 5);
		gbc_lblMomentR1.gridx = 1;
		gbc_lblMomentR1.gridy = 17;
		panel.add(lblMomentR1, gbc_lblMomentR1);
		
		JLabel lblMomentR2 = new JLabel("-");
		GridBagConstraints gbc_lblMomentR2 = new GridBagConstraints();
		gbc_lblMomentR2.insets = new Insets(0, 0, 0, 5);
		gbc_lblMomentR2.gridx = 2;
		gbc_lblMomentR2.gridy = 17;
		panel.add(lblMomentR2, gbc_lblMomentR2);
		
		JLabel lblNmm_1 = new JLabel("Nmm");
		GridBagConstraints gbc_lblNmm_1 = new GridBagConstraints();
		gbc_lblNmm_1.gridx = 3;
		gbc_lblNmm_1.gridy = 17;
		panel.add(lblNmm_1, gbc_lblNmm_1);
		
		JButton btnSelectItem = new JButton("Select Element");
		btnSelectItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				print();
			}
		});
		btnSelectItem.setBounds(12, 191, 200, 25);	
		add(btnSelectItem);
		
		comboModel = new JComboBox(Model.modelList.toArray());

		comboModel.setBounds(12, 13, 200, 22);
		comboModel.setSelectedItem(Model.currentModel);
		add(comboModel);
		
		JButton btnSelectModel = new JButton("Select Model");
		btnSelectModel.setBounds(224, 12, 146, 25);
		btnSelectModel.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				changeModel();
			}
		});
		add(btnSelectModel);
		
		panel_2 = new XPlot(12, 461, 576, 226,this);
		panel_2.setBounds(12, 511, 576, 226);
		add(panel_2);}
	public void stateChanged(ChangeEvent e) {
		System.out.println("FF");
		//panel_1.repaint();
    }
	public void print(){
		selectedE=(Element) list.getSelectedValue();
		if(selectedE==null)
			selectedE=Model.currentModel.elementList.get(0);
		textIndexR.setText(Integer.toString(selectedE.index));
		textLenghtR.setText(String.format("%.3f",selectedE.lenght));
		textElonR.setText(String.format("%.3e",selectedE.elongation));

		textAreaR.setText(String.format("%.3f",selectedE.shape.area));
		textStressR.setText(String.format("%.3f",selectedE.stress));
		
		lblGlobal1.setText(""+selectedE.node1);
		lblGlobal2.setText(""+selectedE.node2);
		
		lbldefX1.setText(""+selectedE.node1.x);
		lbldefX2.setText(""+selectedE.node2.x);
		
		lbldefY1.setText(""+selectedE.node1.y);
		lbldefY2.setText(""+selectedE.node2.y);

		lbldeltaX1.setText(String.format("%.3e", selectedE.node1.dx));
		lbldeltaX2.setText(String.format("%.3e", selectedE.node2.dx));
		
		lbldeltaY1.setText(String.format("%.3e", selectedE.node1.dy));
		lbldeltaY2.setText(String.format("%.3e", selectedE.node2.dy));

		lbldeltaQ1.setText(String.format("%.3e", selectedE.node1.dq));
		lbldeltaQ2.setText(String.format("%.3e", selectedE.node2.dq));
		//panel_2.repaint();
		
		/*lblforceX1.setText(String.format("%.3f", selectedE.node1.getElementForceX(selectedE)));
		lblforceX2.setText(String.format("%.3f", selectedE.node2.getElementForceX(selectedE)));
		
		lblforceY1.setText(String.format("%.3f", selectedE.node1.getElementForceY(selectedE)));
		lblforceY2.setText(String.format("%.3f", selectedE.node2.getElementForceY(selectedE)));*/
		
		if(Model.currentModel instanceof Question2){
			lblTensile.setText("TensileTest");
			if(selectedE.tensileTest()<1)
				lblTensileR.setText("Safe "+String.format("%.3f",selectedE.tensileTest()));
			else
				lblTensileR.setText("NOT Safe "+String.format("%.3f",selectedE.tensileTest()));
			lblBuckling.setText("BucklingTest");
			if(selectedE.bucklingTest()<1)
				lblBucklingR.setText("Safe "+String.format("%.3f",selectedE.bucklingTest()));
			else
				lblBucklingR.setText("NOT Safe "+String.format("%.3f",selectedE.bucklingTest()));
		}
		else{
			lblTensile.setText(" ");
			lblTensileR.setText(" ");
			lblBuckling.setText(" ");
			lblBucklingR.setText(" ");
		}
	}

	public void changeModel(){
		Model.currentModel=((Model)comboModel.getSelectedItem());

		dataModel.removeAllElements();
		for(Element e:Model.currentModel.elementList)
			dataModel.addElement(e);
		ModelVisualization.setScale();
		System.out.println(ModelVisualization.scale);
		Main.visual.repaint();
		panel_2.repaint();
	}
}
