package studentgrademanager;

import studentgrademanager.StudentController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudentPanel extends JPanel {
	protected JLabel lblResult;
    public AddStudentPanel(StudentController controller) {
        setLayout(null);

        // Row 1: ID
        JLabel label = new JLabel("Student ID:");
        label.setBounds(42, 35, 116, 46);
        label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
        add(label);
        JTextField txtId = new JTextField();
        txtId.setBounds(207, 40, 220, 38);
        add(txtId);

        // Row 2: Name
        JLabel label_1 = new JLabel("Student Name:");
        label_1.setBounds(42, 91, 116, 51);
        label_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
        add(label_1);
        JTextField txtName = new JTextField();
        txtName.setBounds(207, 101, 220, 38);
        add(txtName);
        JButton btnAdd = new JButton("Add Student");
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String id   = txtId.getText().trim();
                String name = txtName.getText().trim();

                if (id.isEmpty() || name.isEmpty()) {
                    lblResult.setText("Enter both ID and Name.");
                } else if (controller.findStudent(id)) {
                    lblResult.setText("ID already exists.");
                } else {
                    controller.addStudent(id, name);
                    lblResult.setText("Added!");
                    txtId.setText("");
                    txtName.setText("");
                }
        	}
        });
        btnAdd.setBounds(138, 169, 142, 33);
        add(btnAdd);
        lblResult = new JLabel();
        lblResult.setBounds(122, 231, 177, 46);
        add(lblResult);

        
    }
}
