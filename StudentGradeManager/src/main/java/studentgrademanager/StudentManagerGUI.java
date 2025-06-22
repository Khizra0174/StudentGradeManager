package studentgrademanager;

import studentgrademanager.AddStudentPanel;
import studentgrademanager.ViewStudentsPanel;
import studentgrademanager.RemoveStudentPanel;
import studentgrademanager.UpdateStudentMarksPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class StudentManagerGUI {

    private JFrame frame;
    private JLayeredPane layeredPane;
    private StudentController controller;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                StudentManagerGUI window = new StudentManagerGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public StudentManagerGUI() {
        controller = new StudentController();
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Student Management");
        frame.setBounds(100, 100, 832, 546);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Card container
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(171, 0, 645, 507);
        frame.getContentPane().add(layeredPane);
        layeredPane.setLayout(new CardLayout(0, 0));

        // Panels
        AddStudentPanel addPanel = new AddStudentPanel(controller);
        ViewStudentsPanel viewPanel = new ViewStudentsPanel(controller);
        RemoveStudentPanel removePanel = new RemoveStudentPanel(controller);
        UpdateStudentMarksPanel updatePanel = new UpdateStudentMarksPanel(controller);

        layeredPane.add(addPanel, "Add");
        layeredPane.add(viewPanel, "View");
        layeredPane.add(removePanel, "Remove");
        layeredPane.add(updatePanel, "Update");

   
        JPanel sidebar = new JPanel();
        sidebar.setBackground(new Color(64, 0, 64));
        sidebar.setBounds(0, 0, 172, 507);
        frame.getContentPane().add(sidebar);
        sidebar.setLayout(null);

        sidebar.add(createNavButton("Add Student", 10, e -> switchPanel("Add")));
        sidebar.add(createNavButton("Remove Student", 65, e -> switchPanel("Remove")));
        sidebar.add(createNavButton("Update Marks", 120, e -> switchPanel("Update")));
        sidebar.add(createNavButton("View Students", 175, e -> switchPanel("View")));
    }

    private JButton createNavButton(String text, int y, ActionListener action) {
        JButton button = new JButton(text);
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(64, 0, 64));
        button.setBounds(0, y, 172, 48);
        button.addActionListener(action);
        return button;
    }

    private void switchPanel(String name) {
        CardLayout layout = (CardLayout) layeredPane.getLayout();
        layout.show(layeredPane, name);
    }

    @SuppressWarnings("unused")
    private static void addPopup(Component component, final JPopupMenu popup) {
        component.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) showMenu(e);
            }
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) showMenu(e);
            }
            private void showMenu(MouseEvent e) {
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        });
    }
}
