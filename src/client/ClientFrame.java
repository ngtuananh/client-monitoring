package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ClientFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JComboBox<Object> actionCbb;
	private JTextField dateTfd;
	private JTextField timeTfd;
	private DefaultTableModel dfModel;
	private JTable table;
	
	public ClientFrame() {
		super("Client");
		initComponents();
	}

	public void initComponents() {
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		JPanel pNorth = new JPanel();
		//Box bCen = Box.createVerticalBox();
		Box bCen1 = Box.createHorizontalBox();
		Box bCen2 = Box.createHorizontalBox();
		Box bCen3 = Box.createHorizontalBox();

		bCen1.add(new JLabel("Action: "));
		actionCbb = new JComboBox<Object>();
		bCen1.add(actionCbb);
		
		bCen2.add(new JLabel("Date: "));
		dateTfd = new JTextField(10);
		bCen2.add(dateTfd);
		
		bCen3.add(new JLabel("Time: "));
		timeTfd = new JTextField(10);
		bCen3.add(timeTfd);
		
//		bCen.add(bCen1);
//		bCen.add(Box.createVerticalStrut(5));
//		bCen.add(bCen2);
//		bCen.add(Box.createVerticalStrut(5));
//		bCen.add(bCen3);
		
		pNorth.add(bCen1);
		pNorth.add(bCen2);
		pNorth.add(bCen3);
		
		String[] headers = {"STT", "Date", "Time", "Action", "Description"};
		JScrollPane scroll = new JScrollPane(table = new JTable(dfModel = new DefaultTableModel(headers, 0)));
		
		
		contentPane.add(pNorth, BorderLayout.NORTH);
		contentPane.add(scroll, BorderLayout.CENTER);
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		ClientFrame cf = new ClientFrame();
		cf.setSize(800, 600); 
		cf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set up the content pane.
		cf.initComponents();
		// Use the content pane's default BorderLayout. No need for
		// setLayout(new BorderLayout());
		// Display the window.
		//frame.pack();
		cf.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
