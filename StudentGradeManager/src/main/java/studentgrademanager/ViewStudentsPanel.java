package studentgrademanager;

import studentgrademanager.StudentController;
import studentgrademanager.Students;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ViewStudentsPanel extends JPanel {
    private final DefaultTableModel model;

    public ViewStudentsPanel(StudentController controller) {

        // Table setup
        String[] cols = {"ID", "Name", "Grade"};
        model = new DefaultTableModel(cols, 0);
        setLayout(null);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(63, 58, 350, 207);
        add(scrollPane);

        // Refresh button
        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.setBounds(30, 290, 423, 36);
        btnRefresh.addActionListener(e -> loadData(controller.getAllStudents()));
        add(btnRefresh);
        
        JLabel lblNewLabel = new JLabel("Students");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
        lblNewLabel.setBounds(192, 18, 72, 29);
        add(lblNewLabel);

        // Initial data load
        loadData(controller.getAllStudents());
    }

    private void loadData(List<Students> list) {
        model.setRowCount(0);
        for (Students s : list) {
            model.addRow(new Object[]{s.getId(), s.getName(), s.getGrade()});
        }
    }
}
