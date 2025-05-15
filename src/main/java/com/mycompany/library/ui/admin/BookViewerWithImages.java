package com.mycompany.library.ui.admin;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;

public class BookViewerWithImages extends JFrame {

    private static final String JDBC_URL = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12774281?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String DB_USER = "sql12774281";
    private static final String DB_PASSWORD = "ANA1SUkuem";

    public BookViewerWithImages() {
        setTitle("Library Book Viewer (with Images)");
        setSize(1200, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTable table = new JTable() {
            // Set row height for image display
            public Class<?> getColumnClass(int column) {
                if (column == 8) return ImageIcon.class;
                return getValueAt(0, column).getClass();
            }
        };
        table.setRowHeight(150);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{
                "ISBN", "Title", "Edition", "Author", "Publisher",
                "Year", "Pages", "Description", "Cover"
        });

        try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Books")) {

            while (rs.next()) {
                byte[] imageBytes = rs.getBytes("book_cover");
                ImageIcon icon = new ImageIcon(imageBytes);
                // Optionally scale the image to fit
                Image scaledImage = icon.getImage().getScaledInstance(100, 140, Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaledImage);

                Vector<Object> row = new Vector<>();
                row.add(rs.getString("ISBN"));
                row.add(rs.getString("book_title"));
                row.add(rs.getString("edition"));
                row.add(rs.getString("book_author"));
                row.add(rs.getString("publisher"));
                row.add(rs.getInt("year_published"));
                row.add(rs.getInt("pages"));
                row.add(rs.getString("description"));
                row.add(icon);

                model.addRow(row);
            }

            table.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BookViewerWithImages().setVisible(true));
    }
}
