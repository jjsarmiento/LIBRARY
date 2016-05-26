/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainPackage;

import mainPackage.admin.ViewAllBooksPanel_ADMIN;
import mainPackage.admin.ViewAllAccountsPanel_ADMIN;
import mainPackage.admin.DeleteAccountPanel_ADMIN;
import mainPackage.admin.SearchUserAccount_ADMIN;
import mainPackage.admin.UpdateUserPanel_ADMIN;
import mainPackage.admin.AddUserPanel_ADMIN;
import mainPackage.admin.SearchByStatus_ADMIN;
import mainPackage.admin.SearchByGenre_ADMIN;
import mainPackage.admin.SearchByAuthor_ADMIN;
import mainPackage.admin.SearchByTitle_ADMIN;
import mainPackage.admin.SearchBookByID_ADMIN;
import mainPackage.admin.DeleteBookPanel_ADMIN;
import mainPackage.admin.UpdateBookPanel_ADMIN;
import mainPackage.admin.AddBookPanel_ADMIN;
import java.awt.BorderLayout;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Windows8.1
 */
public class AdminFrame extends javax.swing.JFrame {

    private ObjectOutputStream output; // output stream to client
    private ObjectInputStream input; // input stream from client
    private ServerSocket server; // server socket
    private Socket socketConnection; // connection to client
    private int counter = 1; // counter of number of connections
    
    public static String EDIT_ID;
    public static String DELETE_ID;
    public static String USER_EDIT_ID;
    public static String USER_DELETE_ID;
    
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultset;
    private ResultSetMetaData rsMetadata;
    private final String DATABSE_URL = "jdbc:derby://localhost:1527/libraryDb";
    private final String username = "oracle";
    private final String password = "pass";
    
//    public class AdminThread implements Runnable{
//        public AdminThread(){
//        }
//        @Override
//        public void run() {
////            while(true){                
//                runServer();
////            }
//        }
//    }
    
    public void process() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                 runServer();
            }
        }).start();
    }
    
    public AdminFrame() {
        initComponents();
        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new ViewAllBooksPanel_ADMIN(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);
             
        try {
            connection = DriverManager.getConnection(DATABSE_URL, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(AdminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        process();
//        runServer();
    }

    public int checkRecord(String sNumber, String column, String dbase) {

        int count = 0;

        try {
            String CHECKQUERY = "SELECT * FROM "+dbase+" WHERE "+ column +" = "+sNumber;
            statement = connection.prepareStatement(CHECKQUERY);
//            statement.setString(1, sNumber);
//            statement.setString(2, username);
            resultset = statement.executeQuery();

            if(resultset.next()){
                return 1;
            }

        } catch (SQLException ex) {
//            Logger.getLogger(AddBookPanel_ADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }

        return count;

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        delUserBtn = new javax.swing.JButton();
        viewAllUserBtn = new javax.swing.JButton();
        serverPanel = new javax.swing.JPanel();
        viewAllBtn = new javax.swing.JButton();
        addBookBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        addUserBtn = new javax.swing.JButton();
        editBookBtn = new javax.swing.JButton();
        delBookBtn = new javax.swing.JButton();
        editUserBtn = new javax.swing.JButton();
        searchUserBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        enterField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");

        delUserBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/deleteicon.png"))); // NOI18N
        delUserBtn.setText("Disable User");
        delUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delUserBtnActionPerformed(evt);
            }
        });

        viewAllUserBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/viewAll.png"))); // NOI18N
        viewAllUserBtn.setText("View All User Accounts");
        viewAllUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllUserBtnActionPerformed(evt);
            }
        });

        serverPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout serverPanelLayout = new javax.swing.GroupLayout(serverPanel);
        serverPanel.setLayout(serverPanelLayout);
        serverPanelLayout.setHorizontalGroup(
            serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        serverPanelLayout.setVerticalGroup(
            serverPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 557, Short.MAX_VALUE)
        );

        viewAllBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/viewAll.png"))); // NOI18N
        viewAllBtn.setText("View All Books");
        viewAllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewAllBtnActionPerformed(evt);
            }
        });

        addBookBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/add-icon.png"))); // NOI18N
        addBookBtn.setText("Add Book");
        addBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel7.setText("Account Management");

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 36)); // NOI18N
        jLabel1.setText("Book Rental System : Admin");

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel10.setText("Book Management");

        addUserBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/add-icon.png"))); // NOI18N
        addUserBtn.setText("Add User");
        addUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserBtnActionPerformed(evt);
            }
        });

        editBookBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/editicon.png"))); // NOI18N
        editBookBtn.setText("Edit Book");
        editBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBookBtnActionPerformed(evt);
            }
        });

        delBookBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/deleteicon.png"))); // NOI18N
        delBookBtn.setText("Delete Book");
        delBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBookBtnActionPerformed(evt);
            }
        });

        editUserBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/editicon.png"))); // NOI18N
        editUserBtn.setText("Edit User");
        editUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editUserBtnActionPerformed(evt);
            }
        });

        searchUserBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mainPackage/assets/view.png"))); // NOI18N
        searchUserBtn.setText("Search User");
        searchUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUserBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(serverPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(117, 117, 117))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(delBookBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                    .addComponent(addBookBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(viewAllBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addUserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(searchUserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(editUserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(delUserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))
                            .addComponent(viewAllUserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(viewAllUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(viewAllBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addUserBtn)
                            .addComponent(addBookBtn)
                            .addComponent(editBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchUserBtn)
                    .addComponent(delUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serverPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Manage Books", jPanel1);

        enterField.setEditable(false);
        enterField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Enter a message:");

        displayArea.setEditable(false);
        displayArea.setColumns(20);
        displayArea.setRows(5);
        jScrollPane1.setViewportView(displayArea);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                    .addComponent(enterField)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addComponent(enterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Book Transaction Logs", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookBtnActionPerformed
        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new AddBookPanel_ADMIN(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);
    }//GEN-LAST:event_addBookBtnActionPerformed

    private void viewAllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllBtnActionPerformed
        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new ViewAllBooksPanel_ADMIN(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);
    }//GEN-LAST:event_viewAllBtnActionPerformed

    private void editBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBookBtnActionPerformed
        EDIT_ID = JOptionPane.showInputDialog("Enter Book ID");
        if(checkRecord(EDIT_ID, "ID", "TBLBOOKS") != 0){
            serverPanel.removeAll();
            serverPanel.setVisible(false);
            serverPanel.setLayout(new BorderLayout());
            serverPanel.add(new UpdateBookPanel_ADMIN(), BorderLayout.CENTER);
            serverPanel.repaint();
            serverPanel.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(new JFrame(), "Please input a valid Book ID", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editBookBtnActionPerformed

    private void delBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBookBtnActionPerformed
        DELETE_ID = JOptionPane.showInputDialog("Enter Book ID");
        if(checkRecord(DELETE_ID, "ID", "TBLBOOKS") > 0){
            serverPanel.removeAll();
            serverPanel.setVisible(false);
            serverPanel.setLayout(new BorderLayout());
            serverPanel.add(new DeleteBookPanel_ADMIN(), BorderLayout.CENTER);
            serverPanel.repaint();
            serverPanel.setVisible(true);  
        }else{
            JOptionPane.showMessageDialog(new JFrame(), "Please input a valid Book ID", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_delBookBtnActionPerformed

    private void viewAllUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewAllUserBtnActionPerformed
        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new ViewAllAccountsPanel_ADMIN(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);
    }//GEN-LAST:event_viewAllUserBtnActionPerformed

    private void addUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserBtnActionPerformed
        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new AddUserPanel_ADMIN(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);
    }//GEN-LAST:event_addUserBtnActionPerformed

    private void editUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editUserBtnActionPerformed
        USER_EDIT_ID = JOptionPane.showInputDialog("Input Student Number");
        if(checkRecord(USER_EDIT_ID, "STUDENT_NUMBER", "ACCOUNTS") > 0){
            serverPanel.removeAll();
            serverPanel.setVisible(false);
            serverPanel.setLayout(new BorderLayout());
            serverPanel.add(new UpdateUserPanel_ADMIN(), BorderLayout.CENTER);
            serverPanel.repaint();
            serverPanel.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(new JFrame(), "Student Number does not exist", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_editUserBtnActionPerformed

    private void searchUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchUserBtnActionPerformed
        serverPanel.removeAll();
        serverPanel.setVisible(false);
        serverPanel.setLayout(new BorderLayout());
        serverPanel.add(new SearchUserAccount_ADMIN(), BorderLayout.CENTER);
        serverPanel.repaint();
        serverPanel.setVisible(true);
    }//GEN-LAST:event_searchUserBtnActionPerformed

    private void delUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delUserBtnActionPerformed
        USER_DELETE_ID = JOptionPane.showInputDialog("Input Student Number");
        if(checkRecord(USER_DELETE_ID, "STUDENT_NUMBER", "ACCOUNTS") > 0){
            serverPanel.removeAll();
            serverPanel.setVisible(false);
            serverPanel.setLayout(new BorderLayout());
            serverPanel.add(new DeleteAccountPanel_ADMIN(), BorderLayout.CENTER);
            serverPanel.repaint();
            serverPanel.setVisible(true);   
        }else{   
            JOptionPane.showMessageDialog(new JFrame(), "Please input valid Student Number", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_delUserBtnActionPerformed

    private void enterFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterFieldActionPerformed
        sendData(evt.getActionCommand());
        enterField.setText("");
    }//GEN-LAST:event_enterFieldActionPerformed

    // set up and run server
    public void runServer() {
        try // set up server to receive connections; process connections
        {
            server = new ServerSocket(12345, 100); // create ServerSocket
            while (true) {
                try {
                    waitForConnection(); // wait for a connection
                    getStreams(); // get input & output streams
                    processConnection(); // process connection

                } catch (EOFException eofException) {
                    displayMessage("\nServer terminated connection");
                } finally {
                    closeConnection(); // close connection
                    ++counter;
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    // wait for connection to arrive, then display connection info
    private void waitForConnection() throws IOException {
        displayMessage("Waiting for connection\n");
        socketConnection = server.accept(); // allow server to accept connection
        displayMessage("Connection " + counter + " received from: "
                + socketConnection.getInetAddress().getHostName());
    }

    // get streams to send and receive data
    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(socketConnection.getOutputStream());
        output.flush(); // flush output buffer to send header information
        // set up input stream for objects
        input = new ObjectInputStream(socketConnection.getInputStream());
        displayMessage("\nGot I/O streams\n");
    }

    // process connection with client
    private void processConnection() throws IOException {
        String message = "Connection successful";
        sendData(message); // send connection successful message
        // enable enterField so server user can send messages
        setTextFieldEditable(true);
        do // process messages sent from client
        {
            try // read message and display it
            {
                message = (String) input.readObject(); // read new message
                displayMessage("\n" + message); // display message
            } catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown object type received");
            }
        } while (!message.equals("CLIENT>>> TERMINATE"));
    }

    private void closeConnection() {
        displayMessage("\nTerminating connection\n");
        setTextFieldEditable(false); // disable enterField
        try {
            output.close(); // close output stream
            input.close(); // close input stream
            socketConnection.close(); // close socket
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void sendData(String message) {
        try {
            output.writeObject("SERVER>>> " + message);
            output.flush(); // flush output to client
            displayMessage("\nSERVER>>> " + message);
        } catch (IOException ioException) {
            displayArea.append("\nError writing object");
        }
    }

    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
            public void run() // updates displayArea
            {
                displayArea.append(messageToDisplay); // append message
            }
        });
    }

    // manipulates enterField in the event-dispatch thread
    private void setTextFieldEditable(final boolean editable) {
        SwingUtilities.invokeLater(
                new Runnable() {
            public void run() // sets enterField's editability
            {
                enterField.setEditable(editable);
            }
        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminFrame().setVisible(true); 
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookBtn;
    private javax.swing.JButton addUserBtn;
    private javax.swing.JButton delBookBtn;
    private javax.swing.JButton delUserBtn;
    private javax.swing.JTextArea displayArea;
    private javax.swing.JButton editBookBtn;
    private javax.swing.JButton editUserBtn;
    private javax.swing.JTextField enterField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton searchUserBtn;
    public static javax.swing.JPanel serverPanel;
    private javax.swing.JButton viewAllBtn;
    private javax.swing.JButton viewAllUserBtn;
    // End of variables declaration//GEN-END:variables
}