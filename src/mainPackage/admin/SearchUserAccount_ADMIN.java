/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage.admin;

import mainPackage.admin.AddBookPanel_ADMIN;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Windows8.1
 */
public class SearchUserAccount_ADMIN extends javax.swing.JPanel {

    private static final String DATABSE_URL = "jdbc:derby://localhost:1527/libraryDb";
    private static final String username = "oracle";
    private static final String password = "pass";
    private final String GET_RECORDS = "SELECT * FROM ACCOUNTS WHERE STUDENT_NUMBER = ?";
    private final String GET_STUDREC = "SELECT * FROM ACCOUNTS";
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultset;
    private ResultSetMetaData rsMetadata;

    public SearchUserAccount_ADMIN() {
        initComponents();
        try {
            connection = DriverManager.getConnection(DATABSE_URL, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(SearchUserAccount_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }
        viewStudRecords();
    }
    
    public void viewStudRecords() {
        try {

            statement = connection.prepareStatement(GET_STUDREC);
            resultset = statement.executeQuery();
            rsMetadata = resultset.getMetaData();

            DefaultTableModel dtmPrefix = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            dtmPrefix.addColumn("STUDENT ID");
            dtmPrefix.addColumn("FIRST NAME");
            dtmPrefix.addColumn("LAST NAME");
            dtmPrefix.addColumn("MIDDLE NAME");
            dtmPrefix.addColumn("USERNAME");
            dtmPrefix.addColumn("PASSWORD");
            dtmPrefix.addColumn("BOOK ID");
            dtmPrefix.addColumn("BORROWED");
            dtmPrefix.addColumn("STATUS");

            while (resultset.next()) {

                dtmPrefix.addRow(new Object[]{
                    resultset.getString("STUDENT_NUMBER"),
                    resultset.getString("FIRST_NAME"),
                    resultset.getString("LAST_NAME"),
                    resultset.getString("MIDDLE_NAME"),
                    resultset.getString("USERNAME"),
                    resultset.getString("PASSWORD"),
                    resultset.getString("BOOK_ID"),
                    resultset.getString("DATE_BORROWED"),
                    resultset.getString("ACCT_STATUS")
                });
                displayTable.setModel(dtmPrefix);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllBooksPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int checkRecords(String column, String tblValue) {
        
        String QUERY = "";
        if(column.equals("STUDENT_NUMBER")){
            QUERY = "SELECT * FROM ACCOUNTS WHERE "+ column +" = "+tblValue;
        }else{
            QUERY = "SELECT * FROM ACCOUNTS WHERE "+ column +" LIKE '%"+tblValue+"%'";
        }

        try {
            statement = connection.prepareStatement(QUERY);
            resultset = statement.executeQuery();

            if(resultset.next()){
                return 1;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddBookPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;

    }

    public void viewRecords(String column, String tblValue) {
        try {
            
            if (checkRecords(column, tblValue) == 1) {
                String QUERY = "";
                if(column.equals("STUDENT_NUMBER")){
                    QUERY = "SELECT * FROM ACCOUNTS WHERE "+ column +" = "+tblValue;
                }else{
                    QUERY = "SELECT * FROM ACCOUNTS WHERE "+ column +" LIKE '%"+tblValue+"%'";
                }
                statement = connection.prepareStatement(QUERY);
//                statement.setInt(1, id);
                resultset = statement.executeQuery();
                rsMetadata = resultset.getMetaData();

                DefaultTableModel dtmPrefix = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                dtmPrefix.addColumn("STUDENT ID");
                dtmPrefix.addColumn("FIRST NAME");
                dtmPrefix.addColumn("LAST NAME");
                dtmPrefix.addColumn("MIDDLE NAME");
                dtmPrefix.addColumn("USERNAME");
                dtmPrefix.addColumn("PASSWORD");
                dtmPrefix.addColumn("BOOK ID");
                dtmPrefix.addColumn("BORROWED");
                dtmPrefix.addColumn("STATUS");

                while (resultset.next()) {

                    dtmPrefix.addRow(new Object[]{
                        
                        resultset.getString("STUDENT_NUMBER"),
                        resultset.getString("FIRST_NAME"),
                        resultset.getString("LAST_NAME"),
                        resultset.getString("MIDDLE_NAME"),
                        resultset.getString("USERNAME"),
                        resultset.getString("PASSWORD"),
                        resultset.getString("BOOK_ID"),
                        resultset.getString("DATE_BORROWED"),
                        resultset.getString("ACCT_STATUS")
                    });
                    displayTable.setModel(dtmPrefix);
                }
//                studentNumberField.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Student Number ID Not Found!");
//                studentNumberField.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllBooksPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        studentNumberField = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        columnBox = new javax.swing.JComboBox<String>();

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabel1.setText("Search an Account");

        studentNumberField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentNumberFieldActionPerformed(evt);
            }
        });

        submitButton.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        submitButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/viewAll.png"))); // NOI18N
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        displayTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doubleClick(evt);
            }
        });
        jScrollPane1.setViewportView(displayTable);

        columnBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Student Number", "First Name", "Last Name", "Middle Name", "Username" }));
        columnBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                columnBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(columnBox, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(studentNumberField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(submitButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(studentNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(columnBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        try {
            String tblColumn = "Student Number";
            
            switch(columnBox.getSelectedItem().toString()){
                case "Student Number" :
                    tblColumn = "STUDENT_NUMBER";
                    break;
                case "First Name" :
                    tblColumn = "FIRST_NAME";
                    break;
                case "Last Name" :
                    tblColumn = "LAST_NAME";
                    break;
                case "Middle Name" :
                    tblColumn = "MIDDLE_NAME";
                    break;
                case "Username" :
                    tblColumn = "USERNAME";
                    break;
            }
            
            viewRecords(tblColumn, studentNumberField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please Input a Proper ID Number.");
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void doubleClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doubleClick

        int rowTable = displayTable.getSelectedRow();

        Object sNumber = displayTable.getValueAt(rowTable, 0);
        Object fName = displayTable.getValueAt(rowTable, 1);
        Object lName = displayTable.getValueAt(rowTable, 2);
        Object mName = displayTable.getValueAt(rowTable, 3);
        Object username = displayTable.getValueAt(rowTable, 4);
        Object password = displayTable.getValueAt(rowTable, 5);
        Object book_id = displayTable.getValueAt(rowTable, 6);
        Object date_borrowed = displayTable.getValueAt(rowTable, 7);

        if (evt.getClickCount() == 2) {
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();

            JOptionPane.showMessageDialog(null, "Student Number: " + sNumber + "\n"
                    + "First Name: " + fName + "\n"
                    + "Last Name: " + lName + "\n"
                    + "Middle Name: " + mName + "\n"
                    + "Username: " + username + "\n"
                    + "Password: " + password + "\n"
                    + "Book ID: " + book_id + "\n"
                    + "Date Borrowed: " + date_borrowed + "\n"
            );

        }


    }//GEN-LAST:event_doubleClick

    private void columnBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_columnBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_columnBoxActionPerformed

    private void studentNumberFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentNumberFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentNumberFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> columnBox;
    private javax.swing.JTable displayTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField studentNumberField;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
