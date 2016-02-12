package com.coderedrobotics.pidtuner;

import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author michael
 */
public class GUI extends javax.swing.JFrame implements Runnable {

    private Socket connection;
    private InputStream input;
    private OutputStream output;

    private final HashMap<String, PIDData> controllerData;

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        controllerData = new HashMap<>();
    }

    private void updateList() {
        this.list.setListData(controllerData.keySet().toArray(new String[]{}));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        address = new javax.swing.JTextField();
        graph1 = new com.coderedrobotics.pidtuner.Graph();
        es = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        s = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        d = new javax.swing.JTextField();
        i = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        p = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        jLabel6 = new javax.swing.JLabel();
        connectionButton = new javax.swing.JButton();
        connectionDisplay = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PID Tuner");

        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout graph1Layout = new javax.swing.GroupLayout(graph1);
        graph1.setLayout(graph1Layout);
        graph1Layout.setHorizontalGroup(
            graph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        graph1Layout.setVerticalGroup(
            graph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        es.setText("10");
        es.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                esActionPerformed(evt);
            }
        });

        jLabel5.setText("ErrorScale:");

        s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        s.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sKeyReleased(evt);
            }
        });

        jLabel4.setText("Setpoint:");

        d.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        d.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dKeyReleased(evt);
            }
        });

        i.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        i.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                iKeyReleased(evt);
            }
        });

        jLabel3.setText("D:");

        jLabel2.setText("I:");

        p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        p.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pKeyReleased(evt);
            }
        });

        jLabel1.setText("P:");

        list.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(list);

        jLabel6.setText("Robot IP Address:");

        connectionButton.setText("Connect");
        connectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionButtonActionPerformed(evt);
            }
        });

        connectionDisplay.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        connectionDisplay.setText("Not Connected");

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(graph1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(p, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(d, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(es, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updateButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(connectionButton)
                        .addGap(286, 286, 286)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(connectionDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(connectionButton))
                    .addComponent(connectionDisplay, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(graph1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(es, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(updateButton))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)
                                .addComponent(s, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(i, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        start();
    }//GEN-LAST:event_addressActionPerformed

    private void connectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionButtonActionPerformed
        if (connectionButton.getText().equals("Connect")) {
            start();
        } else {
            connectionButton.setText("Connect");
            if (connection != null) {
                try {
                    connection.close();
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            connection = null;
            input = null;
            output = null;
            controllerData.clear();
            list.setListData(new String[]{});
            address.setText("");
        }
    }//GEN-LAST:event_connectionButtonActionPerformed

    private void listValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listValueChanged
        updateGraph();
        displayRobotValues(controllerData.get(list.getSelectedValue()));
    }//GEN-LAST:event_listValueChanged

    private void esActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_esActionPerformed
        updateGraph();
    }//GEN-LAST:event_esActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (list.getSelectedIndex() != -1) {

            PIDData data = controllerData.get(list.getSelectedValue());

            if (p.getText().equals("")) {
                data.pc = false;
            }
            if (i.getText().equals("")) {
                data.ic = false;
            }
            if (d.getText().equals("")) {
                data.dc = false;
            }
            if (s.getText().equals("")) {
                data.sc = false;
            }

            displayRobotValues(data);

            try {
                data.p = Double.parseDouble(p.getText());
                data.i = Double.parseDouble(i.getText());
                data.d = Double.parseDouble(d.getText());
                data.setpoint = Double.parseDouble(s.getText());
                sendUpdate(data);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Not a number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void pKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pKeyReleased
        controllerData.get(list.getSelectedValue()).pc = true;
    }//GEN-LAST:event_pKeyReleased

    private void iKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iKeyReleased
        controllerData.get(list.getSelectedValue()).ic = true;
    }//GEN-LAST:event_iKeyReleased

    private void dKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dKeyReleased
        controllerData.get(list.getSelectedValue()).dc = true;
    }//GEN-LAST:event_dKeyReleased

    private void sKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sKeyReleased
        controllerData.get(list.getSelectedValue()).sc = true;
    }//GEN-LAST:event_sKeyReleased

    private void displayRobotValues(PIDData data) {
        boolean[] controls = {data.pc, data.ic, data.dc, data.sc};
        JTextField[] forms = {p, i, d, s};
        double[] robotVars = {data.robotP, data.robotI, data.robotD, data.robotSetpoint};
        for (int i = 0; i < 4; i++) {
            if (controls[i]) {
                forms[i].setForeground(new Color(60, 60, 60));
            } else {
                forms[i].setForeground(new Color(160, 160, 160));
                if (!forms[i].isFocusOwner()) {
                    forms[i].setText(String.valueOf(robotVars[i]));
                }
            }
        }
    }

    private void sendUpdate(PIDData data) {
        String p = data.pc ? String.valueOf(data.p) : "-";
        String i = data.ic ? String.valueOf(data.i) : "-";
        String d = data.dc ? String.valueOf(data.d) : "-";
        String setpoint = data.sc ? String.valueOf(data.setpoint) : "-";

        try {
            byte[] dataBytes = PrimitiveSerializer.toByteArray(list.getSelectedValue() + ":" + p + ":" + i + ":" + d + ":" + setpoint);
            short length = (short) dataBytes.length;
            System.out.println("Sending: " + PrimitiveSerializer.bytesToShort(PrimitiveSerializer.toByteArray(length)));
            output.write(PrimitiveSerializer.toByteArray(length));
            output.write(dataBytes);
            flush();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void updateGraph() {
        try {
            graph1.removeAllStreams();
            graph1.addStream(controllerData.get(list.getSelectedValue()).result,
                    Color.GREEN, 0.5, 0.4, false);
            graph1.addStream(controllerData.get(list.getSelectedValue()).error,
                    Color.RED, 0.5,
                    0.5 / Double.parseDouble(es.getText()), true);
        } catch (NullPointerException ex) {

        }
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    public void start() {
        Thread t = new Thread(this);
        t.setDaemon(true);
        t.setName("Network Thread");
        t.start();
    }

    private void reconnect() {
        connectionDisplay.setText("Attempting Connection...");
        boolean retry = true;
        while (retry) {
            retry = false;
            try {
                if (input != null) {//close if open
                    input.close();
                }
                if (output != null) {//close if open
                    output.close();
                }
                if (connection != null) {//close if open
                    connection.close();
                }
            } catch (IOException ex) {
            }
            connection = null;
            while (connection == null) {//keeps trying to connect
                System.out.println("Attempting Connection...");
                try {
                    if (!"".equals(address.getText())) {
                        connection = new Socket(address.getText(), 5800);
                    } else {
                        throw new IOException();
                    }

                    System.out.println("Dashboard Connected!");
                } catch (IOException ex) {
                    connection = null;
                    System.out.println("No Dashboard Connection!");
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException ex1) {
                    }
                }
            }
            //setup the reader and writer objects
            try {
                output = connection.getOutputStream();
                input = connection.getInputStream();
                connectionDisplay.setText("Connected");
                connectionButton.setText("Reset");
                System.out.println("OpenedDataStreams");
            } catch (IOException ex) {
                retry = true;
            }
        }
    }

    void flush() {
        if (connection == null) {
            reconnect();
        }
        try {
            output.flush();
        } catch (IOException ex) {
            reconnect();
        }
    }

    @Override
    public void run() {
        reconnect();
        while (true) {
            try {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                }

                flush();

                while (input.available() > 0 || input.available() > 0) {
                    // name, result, error, robotP, robotI, robotD, robotS
                    byte one = (byte) input.read();
                    byte two = (byte) input.read();

                    short length = PrimitiveSerializer.bytesToShort(new byte[]{one, two});

                    byte[] data = new byte[length];
                    for (int i = 0; i < length; i++) {
                        data[i] = (byte) input.read();
                    }

                    String pidUpdateData = PrimitiveSerializer.bytesToString(data);
//                    System.out.println(pidUpdateData);
                    String[] stringData = pidUpdateData.split(":");
                    String name = stringData[0];
                    double result = Double.parseDouble(stringData[1]);
                    double error = Double.parseDouble(stringData[2]);
                    double robotP = Double.parseDouble(stringData[3]);
                    double robotI = Double.parseDouble(stringData[4]);
                    double robotD = Double.parseDouble(stringData[5]);
                    double robotSetpoint = Double.parseDouble(stringData[6]);

                    if (!controllerData.containsKey(name)) {
                        PIDData pidData = new PIDData();
                        controllerData.put(name, pidData);
                        pidData.error = new DataStream(name + "Error");
                        pidData.result = new DataStream(name + "Result");
                        updateList();
                    }
                    PIDData pidData = controllerData.get(name);
                    pidData.robotP = robotP;
                    pidData.robotI = robotI;
                    pidData.robotD = robotD;
                    pidData.robotSetpoint = robotSetpoint;
                    pidData.result.addPacket(result);
                    pidData.error.addPacket(error);

                    if (controllerData.get(list.getSelectedValue()) == pidData) {
                        displayRobotValues(pidData);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                reconnect();
            } catch (NumberFormatException ex) {
                // ignore
            }
        }
    }

    private static class PIDData {

        DataStream error;
        DataStream result;
        boolean pc, ic, dc, sc;
        double robotP, robotI, robotD, robotSetpoint;
        double p, i, d, setpoint;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JButton connectionButton;
    private javax.swing.JLabel connectionDisplay;
    private javax.swing.JTextField d;
    private javax.swing.JTextField es;
    private com.coderedrobotics.pidtuner.Graph graph1;
    private javax.swing.JTextField i;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list;
    private javax.swing.JTextField p;
    private javax.swing.JTextField s;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}