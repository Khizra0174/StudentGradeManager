package studentgrademanager;

import studentgrademanager.StudentController;
import studentgrademanager.Students;
import studentgrademanager.Subjects;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudentPanel extends JPanel {
    private JTextField txtId, txtName;
    private JTextField txtSubId, txtSubName, txtTotal, txtObtained;
    private DefaultTableModel subjModel;
    private JLabel lblResult;

    public AddStudentPanel(StudentController controller) {
        setLayout(null);

        JLabel lblId = new JLabel("Student ID:");
        lblId.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblId.setBounds(20, 46, 100, 25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(147, 46, 230, 25);
        add(txtId);

        JLabel lblName = new JLabel("Student Name:");
        lblName.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblName.setBounds(20, 87, 100, 25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(147, 87, 230, 25);
        add(txtName);

        
        JLabel lblSubId = new JLabel("Subject ID:");
        lblSubId.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblSubId.setBounds(20, 135, 80, 25);
        add(lblSubId);

        txtSubId = new JTextField();
        txtSubId.setBounds(100, 135, 60, 25);
        add(txtSubId);

        JLabel lblSubName = new JLabel("Name:");
        lblSubName.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblSubName.setBounds(198, 135, 40, 25);
        add(lblSubName);

        txtSubName = new JTextField();
        txtSubName.setBounds(257, 135, 120, 25);
        add(txtSubName);

        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblTotal.setBounds(22, 183, 50, 25);
        add(lblTotal);

        txtTotal = new JTextField();
        txtTotal.setBounds(100, 183, 60, 25);
        add(txtTotal);

        JLabel lblObtained = new JLabel("Obtained:");
        lblObtained.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lblObtained.setBounds(198, 183, 70, 25);
        add(lblObtained);

        txtObtained = new JTextField();
        txtObtained.setBounds(257, 183, 120, 25);
        add(txtObtained);

  
        JButton btnAddSub = new JButton("Add Subject");
        btnAddSub.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
                    int sid  = Integer.parseInt(txtSubId.getText().trim());
                    String sname = txtSubName.getText().trim();
                    double total = Double.parseDouble(txtTotal.getText().trim());
                    double obtained = Double.parseDouble(txtObtained.getText().trim());

                    if (sname.isEmpty()) {
                        throw new IllegalArgumentException("Please, Enter subject name");
                    }
                    else if (total <= 0) {
                        throw new IllegalArgumentException("Subject total must be greater than zero");
                    }
                    else if (obtained < 0) {
                        throw new IllegalArgumentException("Subject total must be greater than zero");
                    } 
                    else if (obtained > total) {
                        throw new IllegalArgumentException("Subject total must be greater than obtained marks");
                    }
                    subjModel.addRow(new Object[]{sid, sname, total, obtained});

                    
                    txtSubId.setText("");
                    txtSubName.setText("");
                    txtTotal.setText("");
                    txtObtained.setText("");

                } catch (IllegalArgumentException ex) {
                    javax.swing.JOptionPane.showMessageDialog(null,
                        "Invalid subject data:\n\n" + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
        	}
        });
        btnAddSub.setBounds(421, 135, 120, 25);
        add(btnAddSub);

       
        String[] cols = {"Sub ID", "Name", "Total", "Obtained"};
        subjModel = new DefaultTableModel(cols, 0);
        JTable tblSubs = new JTable(subjModel);
        JScrollPane sp = new JScrollPane(tblSubs);
        sp.setBounds(20, 239, 390, 120);
        add(sp);

        
        

        
        JButton btnAddStudent = new JButton("Add Student");
        btnAddStudent.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                String id   = txtId.getText().trim();
                String name = txtName.getText().trim();

                if (id.isEmpty() || name.isEmpty()) {
                    lblResult.setText("Please, Enter student ID & name.");
                    return;
                }
                if (controller.findStudent(id)) {
                    lblResult.setText("Warning! Student ID exists.");
                    return;
                }
                if (subjModel.getRowCount() == 0) {
                    lblResult.setText("Warning! Add at least one subject.");
                    return;
                }

                controller.addStudent(id, name);
                Students s = controller.getStudentById(id);

                // For each row in subject table we are calling setSubject() function
                for (int i = 0; i < subjModel.getRowCount(); i++) {
                    int   sid  = (int) subjModel.getValueAt(i, 0);
                    String sname = (String) subjModel.getValueAt(i, 1);
                    double total = (double) subjModel.getValueAt(i, 2);
                    double obtained = (double) subjModel.getValueAt(i, 3);
                    s.setSubject(sid, sname, total, obtained);
                }

                
                s.calculateAverageAndGrade();

                lblResult.setText("Student & subjects added!");
                
                txtId.setText("");
                txtName.setText("");
                
                
                subjModel.setRowCount(0);
        	}
        });
        btnAddStudent.setBounds(20, 381, 150, 30);
        add(btnAddStudent);
        
        JLabel lblNewLabel = new JLabel("Add Students");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel.setBounds(218, 10, 120, 26);
        add(lblNewLabel);
        lblResult = new JLabel();
        lblResult.setBounds(180, 381, 250, 30);
        add(lblResult);
    }
}
