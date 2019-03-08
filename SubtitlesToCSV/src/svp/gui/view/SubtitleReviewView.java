package svp.gui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import svp.data.main.ConfigurationTable;
import svp.data.main.SubtitleDataholder;
import svp.data.main.SubtitleTableModel;
import svp.data.main.SubtitleType;
import svp.gui.controller.IConfigurationViewController;
import svp.gui.controller.ISubtitleReviewViewController;
import javax.swing.JTable;
import javax.swing.JScrollPane;


public class SubtitleReviewView extends AbstractView<ISubtitleReviewViewController> implements ISubtitleReviewView {
	private JTable table;

	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public SubtitleReviewView(ISubtitleReviewViewController controller) {
    	super(controller);
    	setBackground(new Color(47, 79, 79));
		//This will contain a JTable to check the created CSV File
    	setBackground(new Color(47, 79, 79));
		//Themes ;)
		Color buttonColor = new Color(255, 250, 205);
		
		  ///////////////////////////
		 //		   Top Menu 	  //
		///////////////////////////
		
		//------ Subtitle ------//
		JLabel lblSubtitleReview = new JLabel("Subtitle Review View");
		lblSubtitleReview.setForeground(new Color(128, 128, 0));
		lblSubtitleReview.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		
		  ///////////////////////////
		 //			Button Bar	  //
		///////////////////////////
		JButton btnNext = new JButton("Next");
		btnNext.setBackground(new Color(192, 192, 192));
		//btnNewButton.setBackground(new Color(255, 255, 255));
		btnNext.addActionListener((ActionEvent e) -> {
        	getViewController().nextHasBeenClicked();
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(192, 192, 192));
		btnCancel.addActionListener((ActionEvent e) -> {
        	getViewController().cancelHasBeenClicked();
		});
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.LIGHT_GRAY);
		btnBack.addActionListener((ActionEvent e) -> {
            	getViewController().backHasBeenClicked();
        });
		
		JScrollPane scrollPane = new JScrollPane();
		//SubtitleTableModel stm = SubtitleDataholder.getSubtitleDataholder().createTableModel();
		//table.setModel(stm);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("SimHei", Font.PLAIN, 15));
		
		  ///////////////////////////
		 //		Layout Setting	  //
		///////////////////////////		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblSubtitleReview)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED))
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSubtitleReview)
					.addGap(16)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 315, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNext)
						.addComponent(btnBack)
						.addComponent(btnCancel))
					.addContainerGap())
		);
		
		setLayout(groupLayout);
		
	}
}
