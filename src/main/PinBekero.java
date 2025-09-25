package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modell.PinModell;

public class PinBekero extends javax.swing.JFrame {

    private final PinModell modell = new PinModell();
    
    public PinBekero() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        chbMutat = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.GridLayout(0, 3));

        jButton1.setText("jButton1");
        jPanel1.add(jButton1);

        jButton4.setText("jButton4");
        jPanel1.add(jButton4);

        jButton3.setText("jButton3");
        jPanel1.add(jButton3);

        jButton2.setText("jButton2");
        jPanel1.add(jButton2);

        jButton7.setText("jButton7");
        jPanel1.add(jButton7);

        jButton6.setText("jButton6");
        jPanel1.add(jButton6);

        jButton5.setText("jButton5");
        jPanel1.add(jButton5);

        jButton8.setText("jButton8");
        jPanel1.add(jButton8);

        jButton9.setText("jButton9");
        jPanel1.add(jButton9);

        jButton10.setText("jButton10");
        jPanel1.add(jButton10);

        chbMutat.setText("mutat");
        chbMutat.setEnabled(false);
        chbMutat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbMutatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chbMutat, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chbMutat)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (int i = 0; i < jPanel1.getComponentCount(); i++) {
            JButton btn = (JButton) jPanel1.getComponent(i);
            btn.setText(i + "");
            btn.addActionListener((ActionEvent e) -> {
                if (modell.hozzaadSzamjegy(e.getActionCommand()) && modell.keszVan()) {
                    chbMutat.setEnabled(true);
                    JOptionPane.showMessageDialog(rootPane, "Pin mentve!");
                    try {
                        modell.mentes();
                    } catch (java.io.IOException ex) {
                        JOptionPane.showMessageDialog(rootPane, "Hiba a mentésnél: " + ex.getMessage());
                    }
                }
            });
        }
    }//GEN-LAST:event_formWindowOpened

    private void chbMutatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbMutatActionPerformed
        boolean mutat = chbMutat.isSelected();
        Color szin = mutat ? Color.red : Color.LIGHT_GRAY;
        int[] indexek = modell.getGombIndexek();
        for (int gomb : indexek) {
            jPanel1.getComponent(gomb).setBackground(szin);
        }
        if (!mutat) {
            chbMutat.setEnabled(false);
            modell.alaphelyzetbeAllit();
        }
    }//GEN-LAST:event_chbMutatActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(PinBekero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PinBekero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PinBekero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PinBekero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PinBekero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox chbMutat;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
