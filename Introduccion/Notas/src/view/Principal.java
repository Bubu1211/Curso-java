package view;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 300, 600));
        setMaximumSize(new java.awt.Dimension(300, 2147483647));
        getContentPane().setLayout(new java.awt.GridLayout(0, 1));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);

        jPanel1.setBackground(new java.awt.Color(51, 255, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 20));
        jPanel1.setLayout(null);
        getContentPane().add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 51, 102));
        jPanel2.setLayout(null);
        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for(int i = 250; i<255; i++){
            javax.swing.JPanel panel = new javax.swing.JPanel();
            panel.setLayout(null);
            panel.setPreferredSize(new java.awt.Dimension(300, 50));
            panel.setBackground(new java.awt.Color(i, i-200, i-250));
            getContentPane().add(panel);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Principal principal = new Principal();
                principal.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
