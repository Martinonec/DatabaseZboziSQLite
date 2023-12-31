/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package net.codejava.elektrosqlitedatabase;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nitra
 */
public class HlavniSnimek extends javax.swing.JFrame {
    
    
    /**
     * Creates new form HlavniSnimek
     */
    public HlavniSnimek()  {
        initComponents();   
         try{   
        SQLiteOpenHelp.createSqlTable();} catch (Exception e) {System.out.println("Něco špatně při spojení s datab");}
         
        try { ukazZbozi();} catch (SQLException ex) {
            Logger.getLogger(HlavniSnimek.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    ArrayList<DataModel> listZbozi = new ArrayList<>();
    int position = 0;
    
    public void focusRadek(int index){
        
        tx_id.setText(Integer.toString(listZbozi.get(index).getId()));
        tx_nazev.setText(listZbozi.get(index).getNazev());
        tx_znacka.setText(listZbozi.get(index).getZnacka());
        tx_mnozstvi.setText(Integer.toString(listZbozi.get(index).getMnozstvi()));
        tx_nakup.setText(Integer.toString(listZbozi.get(index).getCenaNakup()));
        tx_prodej.setText(Integer.toString(listZbozi.get(index).getCenaProdej()));
        
    }
    
    public ArrayList <DataModel> vytvorResultZSql() {
        ArrayList<DataModel> list = new ArrayList<>();
        try{
        Connection connection = DriverManager.getConnection("jdbc:sqlite:produkty.db");
        
        
        String SELECT_TABLE = "SELECT * FROM produkty";
        
        PreparedStatement ps = connection.prepareStatement(SELECT_TABLE);
        
        ResultSet rs = ps.executeQuery();
       
        while (rs.next()){
         DataModel dm = new DataModel(rs.getInt("id"), rs.getString("nazev"), rs.getString("znacka"), +
                  rs.getInt("mnozstvi"), rs.getInt("cenanakup"), rs.getInt("cenaprodej"));
            list.add(dm);
            
        }  
        } catch (SQLException e) {System.out.println("Něco se nepovedlo s vytvořením resultsetu");}
        listZbozi = list;
        return list;
        
    }
    
    
    public void ukazZbozi () throws SQLException{
        
        ArrayList<DataModel> zbozi = vytvorResultZSql();
        DefaultTableModel def = (DefaultTableModel) Tabulka_zbozi.getModel();
        def.setRowCount(0);
        Object [] row = new Object[6];
        for (int i = 0; i < zbozi.size(); i++){
            row[0]= zbozi.get(i).getId();
            row[1]= zbozi.get(i).getNazev();
            row[2]= zbozi.get(i).getZnacka();
            row[3]= zbozi.get(i).getMnozstvi();
            row[4]= zbozi.get(i).getCenaNakup();
            row[5]= zbozi.get(i).getCenaProdej();
            def.addRow(row);
            
           
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabulka_zbozi = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tx_id = new javax.swing.JTextField();
        tx_znacka = new javax.swing.JTextField();
        tx_nazev = new javax.swing.JTextField();
        tx_mnozstvi = new javax.swing.JTextField();
        tx_nakup = new javax.swing.JTextField();
        tx_prodej = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        but_update = new javax.swing.JButton();
        but_add = new javax.swing.JButton();
        but_del = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        Tabulka_zbozi.setAutoCreateRowSorter(true);
        Tabulka_zbozi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Název", "Značka", "Množství", "Cena nákup", "Cena prodej"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tabulka_zbozi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabulka_zboziMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabulka_zbozi);

        jLabel1.setText("ID");

        jLabel2.setText(" Název");

        jLabel3.setText("Značka");

        jLabel4.setText("Množství");

        jLabel5.setText("Cena nákup");

        tx_znacka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_znackaActionPerformed(evt);
            }
        });

        tx_mnozstvi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_mnozstviActionPerformed(evt);
            }
        });

        tx_nakup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_nakupActionPerformed(evt);
            }
        });

        tx_prodej.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tx_prodejActionPerformed(evt);
            }
        });

        jLabel7.setText("Cena prodej");

        but_update.setText("Uprav Zboží");
        but_update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                but_updateMouseClicked(evt);
            }
        });

        but_add.setText("Přidej Zboží");
        but_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                but_addMouseClicked(evt);
            }
        });

        but_del.setText("Smaž zboží");
        but_del.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                but_delMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136)
                                .addComponent(tx_id, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136)
                                .addComponent(tx_znacka, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136)
                                .addComponent(tx_mnozstvi, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136)
                                .addComponent(tx_nazev, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(136, 136, 136)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tx_prodej, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tx_nakup, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(66, 66, 66)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(but_add, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(but_update, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(but_del, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tx_id, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_nazev, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_znacka, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_mnozstvi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tx_nakup, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tx_prodej, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(but_del, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_update, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(but_add, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tx_znackaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_znackaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tx_znackaActionPerformed

    private void tx_mnozstviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_mnozstviActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tx_mnozstviActionPerformed

    private void tx_nakupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_nakupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tx_nakupActionPerformed

    private void tx_prodejActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tx_prodejActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tx_prodejActionPerformed

    private void Tabulka_zboziMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabulka_zboziMouseClicked
        // TODO add your handling code here:
        int index = Tabulka_zbozi.getSelectedRow();
        focusRadek(index);
        position = index;
        
    }//GEN-LAST:event_Tabulka_zboziMouseClicked

    private void but_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_but_addMouseClicked
        // TODO add your handling code here:
        try{
            
        Connection connection = DriverManager.getConnection("jdbc:sqlite:produkty.db");
        
//        String id = tx_id.getText();
        String nazev = tx_nazev.getText();
        String znacka = tx_znacka.getText();
        Integer mnozstvi = Integer.valueOf(tx_mnozstvi.getText());
        Integer nakup = Integer.valueOf(tx_nakup.getText());
        Integer prodej = Integer.valueOf(tx_prodej.getText());
        
        String VLOZ = "INSERT INTO produkty (nazev,znacka,mnozstvi,cenanakup,cenaprodej) VALUES (?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(VLOZ);
        ps.setString(1, nazev);
        ps.setString(2, znacka);
        ps.setInt(3, mnozstvi);
        ps.setInt(4, nakup);
        ps.setInt(5, prodej);
        
        if(ps.executeUpdate()>0){
        
        
        ukazZbozi();}
        } catch(Exception e) { System.out.println("Něco špatně s přidáním zboží do sql");}
    }//GEN-LAST:event_but_addMouseClicked

    private void but_updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_but_updateMouseClicked
        Integer ID = Integer.parseInt(tx_id.getText());
        String NAZEV = tx_nazev.getText();
        String ZNACKA = tx_znacka.getText();
        Integer MNOZSTVI = Integer.parseInt(tx_mnozstvi.getText());
        Integer CENANAKUP = Integer.parseInt(tx_nakup.getText());
        Integer CENAPRODEJ = Integer.parseInt(tx_prodej.getText());
        
        String UPDATE = "UPDATE produkty SET nazev =?, znacka =?, mnozstvi = ?, cenanakup =?, cenaprodej = ? WHERE id = ? ";
       
        
        
        try{
            Connection connection  = DriverManager.getConnection("jdbc:sqlite:produkty.db");
            PreparedStatement ps = connection.prepareStatement(UPDATE);
            ps.setString(1, NAZEV);
            ps.setString(2, ZNACKA);
            ps.setInt(3, MNOZSTVI);
            ps.setInt(4, CENANAKUP);
            ps.setInt(5, CENAPRODEJ);
            ps.setInt(6, ID);
            
            if(ps.executeUpdate() > 0){
            ukazZbozi();
        }
            
            
            
            
            
        } catch(Exception e){System.out.println("Update se nezdařil!");}
    }//GEN-LAST:event_but_updateMouseClicked

    private void but_delMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_but_delMouseClicked
       String DELETE = "DELETE FROM produkty WHERE id = ?";
       Integer ID = Integer.parseInt(tx_id.getText());
       try{
           Connection connection = DriverManager.getConnection("jdbc:sqlite:produkty.db");
           PreparedStatement ps = connection.prepareStatement(DELETE);
           ps.setInt(1, ID);
           if(ps.executeUpdate()>0){
               ukazZbozi();
           }
           
       }catch (Exception e) {System.out.println("Smazání se nepovedlo");}
    }//GEN-LAST:event_but_delMouseClicked

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
            java.util.logging.Logger.getLogger(HlavniSnimek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HlavniSnimek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HlavniSnimek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HlavniSnimek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        //</editor-fold>
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HlavniSnimek().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabulka_zbozi;
    private javax.swing.JButton but_add;
    private javax.swing.JButton but_del;
    private javax.swing.JButton but_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tx_id;
    private javax.swing.JTextField tx_mnozstvi;
    private javax.swing.JTextField tx_nakup;
    private javax.swing.JTextField tx_nazev;
    private javax.swing.JTextField tx_prodej;
    private javax.swing.JTextField tx_znacka;
    // End of variables declaration//GEN-END:variables
}
