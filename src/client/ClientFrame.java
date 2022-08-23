package client;

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
	private JTextField ipTfd;
	private JTextField portTfd;
	private JButton connectBtn;
	private JButton stopBtn;
	
	
	public ClientFrame() {
		super("Client");
		initComponents();
	}

	public void initComponents() {
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		// top panel
		JPanel pTop = new JPanel();
		Box bTop1 = Box.createHorizontalBox();
		Box bTop2 = Box.createHorizontalBox();
		
		bTop1.add(new JLabel("Server IP: "));
		ipTfd = new JTextField(10);
		bTop1.add(ipTfd);
		
		bTop2.add(new JLabel("Server port: "));
		portTfd = new JTextField(10);
		bTop2.add(portTfd);
		
		pTop.add(bTop1);
		pTop.add(bTop2);
		pTop.add(connectBtn = new JButton("Connect"));
		pTop.add(stopBtn = new JButton("Stop"));
		
		// left panel
		JPanel pLeft = new JPanel();
		Box bCen = Box.createVerticalBox();
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
		
		bCen.add(Box.createVerticalStrut(10));
		bCen.add(bCen1);
		bCen.add(Box.createVerticalStrut(10));
		bCen.add(bCen2);
		bCen.add(Box.createVerticalStrut(10));
		bCen.add(bCen3);
		
		pLeft.add(bCen);
		
		// center
		String[] headers = {"STT", "Date", "Time", "Action", "Description"};
		JScrollPane scroll = new JScrollPane(table = new JTable(dfModel = new DefaultTableModel(headers, 0)));
		
		contentPane.add(pTop, BorderLayout.NORTH);
		contentPane.add(pLeft, BorderLayout.WEST);
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
