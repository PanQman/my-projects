package com.company;

public class NewJFrame extends javax.swing.JFrame {

    Polisa polisa;
    private Main m;

    public NewJFrame(Main m) {
        super();
        this.m = m;
        initComponents();
        setLocationRelativeTo(null);
        jTextArea.setEditable(false);
        jTextArea.setLineWrap(true);
        jTextArea.append("Wprowadź nr polisy" + "\n");
        wybierz_Button.setEnabled(false);
        zmienAgenta_Button.setEnabled(false);
        twojAgent_Button.setEnabled(false);
        setResizable(false);
    }



    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        twojAgent_Button = new javax.swing.JButton();
        zmienAgenta_Button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        wybierz_Button = new javax.swing.JButton();
        szuakajPolisy_Button = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        powrot_Button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(java.awt.Color.darkGray);
        jPanel1.setToolTipText("");
        setTitle("System Zarządzania Polisami - Adam Paź s15269");

        twojAgent_Button.setBackground(new java.awt.Color(76, 81, 83));
        twojAgent_Button.setForeground(new java.awt.Color(187, 187, 186));
        twojAgent_Button.setText("Agent polisy");
        twojAgent_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoj_Agent(evt);
            }
        });

        zmienAgenta_Button.setBackground(new java.awt.Color(76, 81, 83));
        zmienAgenta_Button.setForeground(new java.awt.Color(187, 187, 186));
        zmienAgenta_Button.setText("Zmien agenta");
        zmienAgenta_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    zmien_Agenta(evt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("System Zarządzania Polisami");

        wybierz_Button.setBackground(new java.awt.Color(76, 81, 83));
        wybierz_Button.setForeground(new java.awt.Color(187, 187, 186));
        wybierz_Button.setText("Wybierz");
        wybierz_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wybierz_Agenta(evt);
            }
        });

        szuakajPolisy_Button.setBackground(new java.awt.Color(76, 81, 83));
        szuakajPolisy_Button.setForeground(new java.awt.Color(187, 187, 186));
        szuakajPolisy_Button.setText("Szukaj polisy");
        szuakajPolisy_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                szukaj_Polisy(evt);
            }
        });

        jTextField2.setBackground(java.awt.Color.darkGray);
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setToolTipText("");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });

        jTextArea.setBackground(java.awt.Color.darkGray);
        jTextArea.setColumns(20);
        jTextArea.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTextArea.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea.setRows(5);
        jTextArea.setToolTipText("");
        jTextArea.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTextArea);

        powrot_Button.setBackground(new java.awt.Color(76, 81, 83));
        powrot_Button.setForeground(new java.awt.Color(187, 187, 186));
        powrot_Button.setText("↵ Powrót do Menu");
        powrot_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(zmienAgenta_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(twojAgent_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(wybierz_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(szuakajPolisy_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(powrot_Button)
                                .addGap(45, 45, 45)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(396, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap(36, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(powrot_Button)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(twojAgent_Button)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(zmienAgenta_Button)
                                                .addGap(15, 15, 15)
                                                .addComponent(szuakajPolisy_Button)
                                                .addGap(73, 73, 73)
                                                .addComponent(wybierz_Button))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(30, 30, 30))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addContainerGap(422, Short.MAX_VALUE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 638, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 521, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }

    private void twoj_Agent(java.awt.event.ActionEvent evt) {
        // Przycisk Twój Agent
        jTextArea.append("Twój Agent to: " + m.twojAgent() + "\n") ;
    }

    private void zmien_Agenta(java.awt.event.ActionEvent evt) throws Exception {
        // Przycisk Zmien Agenta
        m.dostepniAgenci(jTextArea);
        wybierz_Button.setEnabled(true);

        zmienAgenta_Button.setEnabled(false);
        twojAgent_Button.setEnabled(false);
        szuakajPolisy_Button.setEnabled(false);
    }

    private void wybierz_Agenta(java.awt.event.ActionEvent evt) {
         //Przycisk Wybierz
        int newAgent;
//
        try{
            newAgent = Integer.parseInt(jTextField2.getText());
            m.zmienAgenta(newAgent);
            jTextArea.append("Agent został zmieniony! \n Twój nowy agent: \n" + Main.twojAgent() + "\n");
            jTextField2.setText("");

            wybierz_Button.setEnabled(false);
            zmienAgenta_Button.setEnabled(true);
            twojAgent_Button.setEnabled(true);
            szuakajPolisy_Button.setEnabled(true);

        } catch (NumberFormatException e){
            jTextArea.append("Pole nie może być puste!\n");
            jTextField2.setText("");
        } catch (NullPointerException e){
            jTextArea.append("Wpisano niepoprawną wartość! Spróbuj ponownie\n");
            jTextField2.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void szukaj_Polisy(java.awt.event.ActionEvent evt) {
        // Przycisk Szukaj Polisy
        int policyNumber;

        try{
            policyNumber = Integer.parseInt(jTextField2.getText());
            polisa = m.szukajPolisy(policyNumber);
            jTextArea.append("Znaleziono polisę " + polisa.nrPolisy + "\n");
            jTextField2.setText("");

            zmienAgenta_Button.setEnabled(true);
            twojAgent_Button.setEnabled(true);

        } catch (NumberFormatException e){
            jTextArea.append("Pole nie może być puste!\n");
            jTextField2.setText("");

            zmienAgenta_Button.setEnabled(false);
            twojAgent_Button.setEnabled(false);
        } catch (NullPointerException e){
            jTextArea.append("Nie znaleziono takiej polisy! Spróbuj ponownie\n");
            jTextField2.setText("");

            zmienAgenta_Button.setEnabled(false);
            twojAgent_Button.setEnabled(false);
        } catch (IllegalArgumentException e){
            jTextArea.append("Agent nie jest przypisany do tej polisy\n");
            jTextField2.setText("");

            zmienAgenta_Button.setEnabled(false);
            twojAgent_Button.setEnabled(false);
    }



    }

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // Przycisk powrót
        System.exit(0);
    }


/*/      @param args the command line arguments

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Create and display the form
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }
*/

    // Variables declaration - do not modify
    protected static javax.swing.JButton wybierz_Button;
    private javax.swing.JButton szuakajPolisy_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea;
    protected static javax.swing.JTextField jTextField2;
    private javax.swing.JButton twojAgent_Button;
    private javax.swing.JButton zmienAgenta_Button;
    private javax.swing.JButton powrot_Button;
    // End of variables declaration


}
