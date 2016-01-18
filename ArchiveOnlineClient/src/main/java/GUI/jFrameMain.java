package GUI;

import DispatcherServices.GetServersService;
import DispatcherServices.RESTService;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.ws.rs.core.MultivaluedHashMap;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author minel
 */
public class jFrameMain extends javax.swing.JFrame {

    private JFileChooser fileChooser;

    private String getServersServiceUrl = "http://localhost:50713";
    private GetServersService getServersService;

    /**
     * Creates new form jFrameMain
     */
    public jFrameMain() {

        initComponents();
        fileChooser = new JFileChooser();
        getServersService = new GetServersService(getServersServiceUrl);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ActionsGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonLoadFile = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabeChooseAction = new javax.swing.JLabel();
        jRadioButtonArchive = new javax.swing.JRadioButton();
        jRadioButtonUnArchive = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabelArchiveMethod = new javax.swing.JLabel();
        jComboBoxArchiveMethod = new javax.swing.JComboBox<>();
        jButtonArchive = new javax.swing.JButton();
        jLabelUnArchiveMethod = new javax.swing.JLabel();
        jComboBoxUnArchiveMethod = new javax.swing.JComboBox<>();
        jButtonUnArchive = new javax.swing.JButton();
        jTextFieldFilePath = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Архиватор Онлайн");
        setResizable(false);

        jLabel1.setLabelFor(jTextFieldEmail);
        jLabel1.setText("Электронная почта");

        jLabel2.setText("Выберите файл");

        jButtonLoadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadFileActionPerformed(evt);
            }
        });

        jLabeChooseAction.setText("Выберите желаемое действие");
        jLabeChooseAction.setEnabled(false);

        ActionsGroup.add(jRadioButtonArchive);
        jRadioButtonArchive.setText("Архивировация");
        jRadioButtonArchive.setEnabled(false);
        jRadioButtonArchive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonArchiveActionPerformed(evt);
            }
        });

        ActionsGroup.add(jRadioButtonUnArchive);
        jRadioButtonUnArchive.setText("Разархивировать");
        jRadioButtonUnArchive.setEnabled(false);
        jRadioButtonUnArchive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonUnArchiveActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabelArchiveMethod.setText("Способ сжатия");
        jLabelArchiveMethod.setEnabled(false);

        jComboBoxArchiveMethod.setEnabled(jRadioButtonArchive.isSelected());

        jButtonArchive.setText("Сжать");
        jButtonArchive.setToolTipText("");
        jButtonArchive.setEnabled(false);

        jLabelUnArchiveMethod.setText("Способ разархивации");
        jLabelUnArchiveMethod.setEnabled(false);

        jComboBoxUnArchiveMethod.setEnabled(false);

        jButtonUnArchive.setText("Разархивировать");
        jButtonUnArchive.setEnabled(false);

        jTextFieldFilePath.setEditable(false);
        jTextFieldFilePath.setBackground(new java.awt.Color(220, 220, 220));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLoadFile))
                    .addComponent(jTextFieldEmail))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonArchive)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelArchiveMethod)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxArchiveMethod, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonArchive)
                        .addGap(62, 62, 62)))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButtonUnArchive)
                                .addGap(61, 61, 61))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelUnArchiveMethod)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxUnArchiveMethod, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButtonUnArchive))))
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addComponent(jLabeChooseAction)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButtonLoadFile, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabeChooseAction)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonArchive)
                            .addComponent(jRadioButtonUnArchive))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelArchiveMethod)
                                    .addComponent(jComboBoxArchiveMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonArchive))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelUnArchiveMethod)
                                    .addComponent(jComboBoxUnArchiveMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonUnArchive))))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jRadioButtonArchiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonArchiveActionPerformed

        //Включаем/выключаем контролы
        enableArchivate(jRadioButtonArchive.isSelected());
        enableUnArchivate(jRadioButtonUnArchive.isSelected());

        //Загружаем доступные методы сжатия
        if (jRadioButtonArchive.isSelected()) {
            try {
                loadItems(jComboBoxArchiveMethod, getServersService.getArchiveMethods());
            } catch (Exception ex) {
                Logger.getLogger(jFrameMain.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Удаленный сервер в данны момент не доступен, повторите попытку позднее.",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jRadioButtonArchiveActionPerformed

    private void jRadioButtonUnArchiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonUnArchiveActionPerformed

        //Включаем/выключаем контролы
        enableUnArchivate(jRadioButtonUnArchive.isSelected());
        enableArchivate(jRadioButtonArchive.isSelected());

        //Загружаем доступные методы расжатия
        if (jRadioButtonUnArchive.isSelected()) {
            try {
                loadItems(jComboBoxUnArchiveMethod, getServersService.getUnArchiveMethods());
            } catch (Exception ex) {
                Logger.getLogger(jFrameMain.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Удаленный сервер в данны момент не доступен, повторите попытку позднее.",
                        "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jRadioButtonUnArchiveActionPerformed

    private void jButtonLoadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadFileActionPerformed

        //Показываем диалог открытия файла
        int returnValue = fileChooser.showOpenDialog(this);

        //Если был выбран файл
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            jTextFieldFilePath.setText(file.getAbsolutePath());
            enableActions(true);
        } else {
            enableActions(false);
            enableArchivate(false);
            enableUnArchivate(false);
        }
    }//GEN-LAST:event_jButtonLoadFileActionPerformed

    //Загружает элементы списка в комбобокс
    private void loadItems(JComboBox<String> comboBox, ArrayList<String> items) {
        comboBox.removeAllItems();
        for (String methodName : items) {
            comboBox.addItem(methodName);
        }
        comboBox.setSelectedIndex(-1);
    }

    //Включает/выключает контролы архивации
    private void enableArchivate(boolean mode) {
        jButtonArchive.setEnabled(mode);
        jComboBoxArchiveMethod.setEnabled(mode);
        jLabelArchiveMethod.setEnabled(mode);
    }

    //Включает/выключает контролы разархивации
    private void enableUnArchivate(boolean mode) {
        jButtonUnArchive.setEnabled(mode);
        jComboBoxUnArchiveMethod.setEnabled(mode);
        jLabelUnArchiveMethod.setEnabled(mode);
    }

    //Включает/выключает контролы действий
    private void enableActions(boolean mode) {
        jLabeChooseAction.setEnabled(mode);
        jRadioButtonArchive.setEnabled(mode);
        jRadioButtonUnArchive.setEnabled(mode);
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
            java.util.logging.Logger.getLogger(jFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrameMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ActionsGroup;
    private javax.swing.JButton jButtonArchive;
    private javax.swing.JButton jButtonLoadFile;
    private javax.swing.JButton jButtonUnArchive;
    private javax.swing.JComboBox<String> jComboBoxArchiveMethod;
    private javax.swing.JComboBox<String> jComboBoxUnArchiveMethod;
    private javax.swing.JLabel jLabeChooseAction;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelArchiveMethod;
    private javax.swing.JLabel jLabelUnArchiveMethod;
    private javax.swing.JRadioButton jRadioButtonArchive;
    private javax.swing.JRadioButton jRadioButtonUnArchive;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFilePath;
    // End of variables declaration//GEN-END:variables

}
