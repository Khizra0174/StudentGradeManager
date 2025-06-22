package studentgrademanager;

import studentgrademanager.StudentController;
import studentgrademanager.Students;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateStudentMarksPanel extends JPanel {
	protected JLabel lblResult;
    public UpdateStudentMarksPanel(StudentController controller) {
        setLayout(null);

        JLabel label = new JLabel("Student ID:");
        label.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
        label.setBounds(31, 26, 102, 52);
        add(label);
        JTextField txtId = new JTextField();
        txtId.setBounds(190, 32, 220, 41);
        add(txtId);

        JLabel label_1 = new JLabel("Grade:");
        label_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
        label_1.setBounds(31, 91, 114, 41);
        add(label_1);
        JTextField txtGrade = new JTextField();
        txtGrade.setBounds(190, 91, 220, 41);
        add(txtGrade);
        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String id    = txtId.getText().trim();
                String grade = txtGrade.getText().trim();
                Students s   = controller.getStudentById(id);

                if (id.isEmpty() || grade.isEmpty()) {
                    lblResult.setText("Fill both fields.");
                } else if (s == null) {
                    lblResult.setText("Not found.");
                } else {
                    s.setGrade(grade);
                    lblResult.setText("Updated!");
                    txtId.setText("");
                    txtGrade.setText("");
                }
        	}
        });
        btnUpdate.setBounds(103, 174, 172, 46);
        add(btnUpdate);
        lblResult = new JLabel();
        lblResult.setBounds(156, 223, 138, 52);
        add(lblResult);

        
    }
}
