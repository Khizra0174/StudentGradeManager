package studentgrademanager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class StudentManagerGUI {

	private JFrame frame;
	private JLayeredPane layeredPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManagerGUI window = new StudentManagerGUI();
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
	public StudentManagerGUI() {
		initialize();
	}
	
	public void switchPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 832, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(171, 0, 645, 507);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel AddNewStudentPanel = new JPanel();
		layeredPane.add(AddNewStudentPanel, "name_13706243350800");
		
		JLabel lblNewLabel = new JLabel("Add Students");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		AddNewStudentPanel.add(lblNewLabel);
		
		JPanel DisplayAllStudentPanel = new JPanel();
		layeredPane.add(DisplayAllStudentPanel, "name_13810113034700");
		
		JLabel lblNewLabel_1 = new JLabel("Students");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		DisplayAllStudentPanel.add(lblNewLabel_1);
		
		JPanel RemoveStudentPanel = new JPanel();
		layeredPane.add(RemoveStudentPanel, "name_13882132468800");
		
		JLabel lblNewLabel_2 = new JLabel("Remove Student");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		RemoveStudentPanel.add(lblNewLabel_2);
		
		JPanel UpdateStudentMarksPanel = new JPanel();
		layeredPane.add(UpdateStudentMarksPanel, "name_13909379475100");
		
		JLabel lblNewLabel_3 = new JLabel("Marks Updater");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		UpdateStudentMarksPanel.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 0, 64));
		panel.setBounds(0, 0, 172, 507);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton addStudent = new JButton("Add Student");
		addStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(AddNewStudentPanel);
			}
		});
		addStudent.setBounds(0, 0, 172, 43);
		panel.add(addStudent);
		
		JButton removeStudent = new JButton("Remove Student");
		removeStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(RemoveStudentPanel);
			}
		});
		removeStudent.setBounds(0, 42, 172, 43);
		panel.add(removeStudent);
		
		JButton UpdateStudentMarks = new JButton("Update Marks");
		UpdateStudentMarks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(UpdateStudentMarksPanel);
			}
		});
		UpdateStudentMarks.setBounds(0, 85, 172, 43);
		panel.add(UpdateStudentMarks);
		
		JButton ViewAllStudents = new JButton("View Student");
		ViewAllStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(DisplayAllStudentPanel);
			}
		});
		ViewAllStudents.setBounds(0, 127, 172, 43);
		panel.add(ViewAllStudents);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
