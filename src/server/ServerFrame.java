package server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ServerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField searchClientTfd;
	private JList<Object> clientList;
	private JTextField searchClientIPTfd;
	private JComboBox<Object> actionCbb;
	private JTextField dateTfd;
	private JTextField timeTfd;
	private DefaultTableModel dfModel;
	private JTable table;
	private JLabel ipLb;
	private JLabel portLb;
	private JButton startServerBtn;
	private JButton closeServerBtn;
	
	public ServerFrame() {
		super("Server");
		initComponents();
	}

	public void initComponents() {
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		// top panel
		JPanel pTop = new JPanel();
		pTop.setLayout(new BorderLayout());
		
		JPanel pTop1 = new JPanel();
		pTop1.add(ipLb = new JLabel("Server IP"));
		pTop1.add(portLb = new JLabel("Server port"));
		
		JPanel pTop2 = new JPanel();
		Box bTop1 = Box.createHorizontalBox();
		Box bTop2 = Box.createHorizontalBox();
		Box bTop3 = Box.createHorizontalBox();
		Box bTop4 = Box.createHorizontalBox();
		
		bTop1.add(new JLabel("Search: "));
		searchClientIPTfd = new JTextField(10);
		bTop1.add(searchClientIPTfd);

		bTop2.add(new JLabel("Action: "));
		actionCbb = new JComboBox<Object>();
		bTop2.add(actionCbb);
		
		bTop3.add(new JLabel("Date: "));
		dateTfd = new JTextField(10);
		bTop3.add(dateTfd);

		bTop4.add(new JLabel("Time: "));
		timeTfd = new JTextField(10);
		bTop4.add(timeTfd);
		
		pTop2.add(bTop1);
		pTop2.add(bTop2);
		pTop2.add(bTop3);
		pTop2.add(bTop4);
		
		pTop.add(pTop1, BorderLayout.NORTH);
		pTop.add(pTop2, BorderLayout.SOUTH);
		
		// left panel
		JPanel pLeft = new JPanel();
		
		// components align vertical in box
		Box box = Box.createVerticalBox();
		box.setBorder(BorderFactory.createLineBorder(Color.green));
		
		// contain label, textfield
		JPanel pListIP = new JPanel();
		pListIP.setLayout(new BoxLayout(pListIP, BoxLayout.Y_AXIS));
		pListIP.setBorder(BorderFactory.createTitledBorder("IP List"));
		
		Box b1 = Box.createHorizontalBox();
		b1.add(new JLabel("Search IP: "));
		searchClientTfd  = new JTextField(10);
		b1.add(searchClientTfd);
		
		// list client IP
		clientList = new JList<Object>();
		//clientList.setVisibleRowCount(10);
		JScrollPane scroller = new JScrollPane(clientList);
		//scroller.setBounds(36, 11, 161, 345);
		
		pListIP.add(b1);
		pListIP.add(Box.createVerticalStrut(10));
		pListIP.add(scroller);


		JList<Object> l = new JList<Object>();
		JScrollPane scroller1 = new JScrollPane(l);

		box.add(pListIP);
		box.add(Box.createVerticalStrut(10));
		box.add(new JLabel("Directory"));
		box.add(Box.createVerticalStrut(10));
		box.add(scroller1);
		pLeft.add(box);
		
		// Center panel
		
		String[] headers = {"STT", "Date", "Time", "Action", "IP client", "Description"};
		JScrollPane scroll = new JScrollPane(table = new JTable(dfModel = new DefaultTableModel(headers, 0)));
		
		//bottom panel
		JPanel pBottom = new JPanel();
		pBottom.add(startServerBtn = new JButton("Start server"));
		pBottom.add(closeServerBtn = new JButton("Close server"));
		
		contentPane.add(pTop, BorderLayout.NORTH);
		contentPane.add(pLeft, BorderLayout.WEST);
		contentPane.add(scroll, BorderLayout.CENTER);
		contentPane.add(pBottom, BorderLayout.SOUTH);
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		ServerFrame sf = new ServerFrame();
		sf.setSize(800, 620); 
		sf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Set up the content pane.
		sf.initComponents();
		// Use the content pane's default BorderLayout. No need for
		// setLayout(new BorderLayout());
		// Display the window.
		//frame.pack();
		sf.setVisible(true);
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
