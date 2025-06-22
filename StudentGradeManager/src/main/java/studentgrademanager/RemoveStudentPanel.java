package studentgrademanager;

import studentgrademanager.StudentController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveStudentPanel extends JPanel {
	protected JLabel lblResult;
    public RemoveStudentPanel(StudentController controller) {
        setLayout(null);

        JLabel label = new JLabel("Student ID to remove:");
        label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
        label.setBounds(34, 69, 126, 41);
        add(label);
        JTextField txtId = new JTextField(15);
        txtId.setBounds(209, 72, 214, 35);
        add(txtId);

        JButton btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String id = txtId.getText().trim();
                if (id.isEmpty()) {
                    lblResult.setText("Enter an ID.");
                } else if (!controller.findStudent(id)) {
                    lblResult.setText("Not found.");
                } else {
                    controller.removeStudent(id);
                    lblResult.setText("Removed!");
                    txtId.setText("");
                }
        	}
        });
        btnRemove.setBounds(148, 151, 103, 41);
        add(btnRemove);

        lblResult = new JLabel();
        lblResult.setBounds(171, 227, 46, 13);
        add(lblResult);

        
    }
}
