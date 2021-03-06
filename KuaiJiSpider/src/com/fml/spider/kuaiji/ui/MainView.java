/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fml.spider.kuaiji.ui;

import com.fml.spider.kuaiji.model.City;
import com.fml.spider.kuaiji.CityManager;
import com.fml.spider.kuaiji.UserManager;
import com.fml.spider.kuaiji.framework.impl.SoundPlay;
import com.fml.spider.kuaiji.WorkThread;
import com.fml.spider.kuaiji.framework.Sound;
import com.fml.spider.kuaiji.model.User;
import com.fml.spider.kuaiji.spider.Spider;
import com.fml.spider.kuaiji.spider.impl.KuaijiSpider;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author ky
 */
public class MainView extends javax.swing.JFrame {

    private CityManager am = null;
    private UserManager um = null;
    private Spider spider = null;
    private Sound sound = null;
    private String soundPath = "sound.wav";

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        spider = new KuaijiSpider();

        initList();
        initUI();
        sound = new SoundPlay(soundPath);
    }

    private void initList() {

        am = new CityManager(spider) {
            @Override
            public void onCityStatusUpdate(int index) {

                City city = this.getACity(index);

                if (city != null) {

                    updataCityTable(index, city);

                }
            }

            @Override
            public void onAddNewCity(City city) {
                addCityToTableItem(city);
            }

        };

        um = new UserManager() {

            @Override
            public void onUserListUpdata() {
                updateUserTable();
            }
        };

        am.work();

        um.work();

    }

    void addCityToTableItem(City city) {

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        Object o[] = new Object[]{city.needTest, city.cityName, (city.enableReq ? "可报名" : "不可报名"), city.reqStatus, city.netInfo};
        model.addRow(o);

        this.jComboBox1.addItem(city.cityName);

    }

    private void initUI() {

        this.jTable1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                jTable1.getModel();

                if (e.getClickCount() == 1) {
                    int columnIndex = jTable1.columnAtPoint(e.getPoint()); //获取点击的列
                    int rowIndex = jTable1.rowAtPoint(e.getPoint()); //获取点击的行

                    if (columnIndex == 0) {//第0列时，执行代码

                        Boolean b = (Boolean) jTable1.getModel().getValueAt(rowIndex, columnIndex);

                        if (b == true) { //原来选中
                            jTable1.getModel().setValueAt(false, rowIndex, 0);
                            System.out.println("");
                        } else {//原来未选中
                            jTable1.getModel().setValueAt(true, rowIndex, 0);

                        }
                    }
                }
                jTable1.updateUI();
            }
        }
        );

        this.jSpinner1.setValue(10);
        this.jLabel3.setText(soundPath);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jDesktopPane2 = new javax.swing.JDesktopPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel4 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jDesktopPane2.setBackground(new java.awt.Color(240, 240, 240));
        jDesktopPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("城市列表"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "是否测试", "城市名称", "状态", "详情", "网页详情"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jRadioButton1.setText("全选");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton1);

        jButton1.setText("开始");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setText("停止");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jLabel1.setText("频率");
        jPanel2.add(jLabel1);

        jSpinner1.setPreferredSize(new java.awt.Dimension(100, 22));
        jSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner1StateChanged(evt);
            }
        });
        jPanel2.add(jSpinner1);

        jLabel2.setText("秒");
        jPanel2.add(jLabel2);

        jButton3.setText("提示音");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jButton4.setText("试听");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        jLabel3.setText("无提示音");
        jPanel2.add(jLabel3);

        org.jdesktop.layout.GroupLayout jDesktopPane2Layout = new org.jdesktop.layout.GroupLayout(jDesktopPane2);
        jDesktopPane2.setLayout(jDesktopPane2Layout);
        jDesktopPane2Layout.setHorizontalGroup(
            jDesktopPane2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );
        jDesktopPane2Layout.setVerticalGroup(
            jDesktopPane2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane2Layout.createSequentialGroup()
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .add(13, 13, 13))
        );
        jDesktopPane2.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane2.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel1.add(jDesktopPane2);

        jTabbedPane1.addTab("测试", jPanel1);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jDesktopPane1.setBackground(new java.awt.Color(240, 240, 240));
        jDesktopPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("报名账户列表"));

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jButton6.setText("删除");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton6);

        jComboBox1.setLightWeightPopupEnabled(false);
        jComboBox1.setMaximumSize(new java.awt.Dimension(100, 32767));
        jComboBox1.setMinimumSize(new java.awt.Dimension(100, 21));
        jComboBox1.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel4.add(jComboBox1);

        jLabel4.setText("姓名");
        jPanel4.add(jLabel4);

        jTextField1.setText("tets");
        jTextField1.setMinimumSize(new java.awt.Dimension(80, 30));
        jTextField1.setPreferredSize(new java.awt.Dimension(80, 25));
        jPanel4.add(jTextField1);

        jLabel6.setText("密码");
        jPanel4.add(jLabel6);

        jTextField2.setText("123456");
        jTextField2.setMinimumSize(new java.awt.Dimension(80, 30));
        jTextField2.setPreferredSize(new java.awt.Dimension(80, 25));
        jPanel4.add(jTextField2);

        jLabel5.setText("身份证");
        jPanel4.add(jLabel5);

        jTextField3.setText("131314257654543456");
        jTextField3.setMinimumSize(new java.awt.Dimension(140, 30));
        jTextField3.setPreferredSize(new java.awt.Dimension(140, 25));
        jPanel4.add(jTextField3);

        jButton5.setText("添加");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "报名", "姓名", "考区", "报名状态", "执行状态", "身份证", "密码"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable2);

        org.jdesktop.layout.GroupLayout jDesktopPane1Layout = new org.jdesktop.layout.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
            .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jDesktopPane1Layout.createSequentialGroup()
                .add(jPanel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE))
        );
        jDesktopPane1.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanel3.add(jDesktopPane1);

        jTabbedPane1.addTab("报名", jPanel3);

        getContentPane().add(jTabbedPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        sound.play();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        fileChooser.showSaveDialog(null);
        File fout = fileChooser.getSelectedFile();
        if (fout != null) {
            soundPath = fout.getAbsolutePath();
        }
        this.jLabel3.setText(soundPath);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner1StateChanged

        changeThreadSleep();
    }//GEN-LAST:event_jSpinner1StateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        for (Thread threadList1 : threadList) {
            try {
                threadList1.stop();
            } catch (Exception ex) {
                Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        threadList.clear();

        onThreadChage(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (threadList.isEmpty()) {
            for (int i = 0; i < 5; i++) {
                WorkThread t = new WorkThread(am, spider);
                threadList.add(t);
                t.start();
            }

            changeThreadSleep();

        } else {

        }

        onThreadChage(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed

        boolean select = this.jRadioButton1.isSelected();

        TableModel model = this.jTable1.getModel();

        int rowCount = model.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            model.setValueAt(select, i, 0);
        }

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    //加入用户
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        String name = jTextField1.getText().trim();
        String pass = jTextField2.getText().trim();
        String carCode = jTextField3.getText().trim();
        String cityCode = "";
        int index = jComboBox1.getSelectedIndex();

        if (index == -1) {
            return;
        }

        City city = am.getACity(index);

        if (city != null) {
            cityCode = city.cityCode;
        }

        if (name.isEmpty() || pass.isEmpty() || carCode.isEmpty() || cityCode.isEmpty()) {
            return;
        }

        User user = new User(name, pass, cityCode, carCode);

        boolean add = um.addUser(user);

        System.out.println(add);

    }//GEN-LAST:event_jButton5ActionPerformed

    //删除用户
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private List<WorkThread> threadList = new ArrayList<>();

    void changeThreadSleep() {

        int parseInt = Integer.parseInt(this.jSpinner1.getValue().toString());

        for (WorkThread threadList1 : threadList) {
            threadList1.setSleepTime(parseInt);
        }

    }

    void onThreadChage(boolean start) {

        this.jButton1.setEnabled(!start);
        this.jButton2.setEnabled(start);

    }

    private void updataCityTable(int index, City city) {

        TableModel model = this.jTable1.getModel();
        model.setValueAt((city.enableReq ? "可报名" : "不可报名"), index, 2);
        model.setValueAt(city.reqStatus, index, 3);
        model.setValueAt(city.netInfo, index, 4);

        if (city.enableReq == true) {
            sound.play();
        }

    }

    private void updateUserTable() {

        List<User> us = um.getUserList();

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(us.size());

        int i = 0;
        for (User u : us) {

            City city = am.getACity(u.getCityCode());
            String cityName = (city != null) ? city.cityName : "";

            model.setValueAt(false, i, 0);
            model.setValueAt(u.getUserName(), i, 1);
            model.setValueAt(cityName, i, 2);
            model.setValueAt((u.isSuccess() ? "报名成功" : "未报名"), i, 3);
            model.setValueAt("", i, 4);
            model.setValueAt(u.getCardCode(), i, 5);
            model.setValueAt(u.getPassWord(), i, 6);

            ++i;
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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JDesktopPane jDesktopPane2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
