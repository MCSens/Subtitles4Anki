package svp.gui.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import svp.gui.controller.ISubtitleReviewViewController;
import javax.swing.JTable;
import javax.swing.JScrollPane;


public class SubtitleReviewView extends AbstractView<ISubtitleReviewViewController> implements ISubtitleReviewView {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7765690033116179248L;
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
		//Color buttonColor = new Color(255, 250, 205);
		
		  ///////////////////////////
		 //		   Top Menu 	  //
		///////////////////////////
		
		//------ Subtitle ------//
		JLabel lblSubtitleReview = new JLabel("Subtitle Review View");
		lblSubtitleReview.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSubtitleReview.setForeground(new Color(128, 128, 0));
		
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
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(30);
		//Font f = table.getFont().deriveFont(40.0f);
		table.setFont(table.getFont().deriveFont(15.0f));
		//System.out.println(table.getFont());
		//table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		//table.setFont(new Font("SimHei", Font.PLAIN, 15));
		//table.setFont(pinyinFont.deriveFont(16.0f));
		
		  ///////////////////////////
		 //		Layout Setting	  //
		///////////////////////////		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblSubtitleReview))
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
						.addComponent(btnCancel)
						.addComponent(btnNext)
						.addComponent(btnBack))
					.addContainerGap())
		);
		
		setLayout(groupLayout);
		
	}
}
