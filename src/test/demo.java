/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package test;


public class demo extends javax.swing.JPanel {
 public static int[] getColumnOrder(String key) {
        int[] order = new int[key.length()];

        // Gán chỉ số cho từng ký tự trong khóa
        for (int i = 0; i < key.length(); i++) {
            order[i] = i;
        }

        // Sắp xếp thứ tự dựa trên giá trị của các ký tự trong khóa
        for (int i = 0; i < key.length() - 1; i++) {
            for (int j = i + 1; j < key.length(); j++) {
                if (key.charAt(order[i]) > key.charAt(order[j])) {
                    // Hoán đổi chỉ số
                    int temp = order[i];
                    order[i] = order[j];
                    order[j] = temp;
                }
            }
        }

        return order;
    }

    // Hàm mã hóa dịch chuyển cột với khóa chuỗi
    public static String transpositionCipherEncrypt(String text, String key) {
        int[] colOrder = getColumnOrder(key);
        int numRows = (int) Math.ceil((double) text.length() / key.length());
        char[][] grid = new char[numRows][key.length()];

        // Điền các ký tự vào lưới theo hàng
        int index = 0;
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < key.length(); c++) {
                if (index < text.length()) {
                    grid[r][c] = text.charAt(index++);
                } else {
                    grid[r][c] = ' '; // Thêm khoảng trống nếu không đủ ký tự
                }
            }
        }

        // Đọc lưới theo cột dựa trên thứ tự khóa
        StringBuilder encryptedText = new StringBuilder();
        for (int col : colOrder) {
            for (int r = 0; r < numRows; r++) {
                encryptedText.append(grid[r][col]);
            }
        }
      if (text.length() % key.length() != 0) {
        encryptedText.append('x');
    }

        return encryptedText.toString();
    }

    // Hàm giải mã dịch chuyển cột với khóa chuỗi
    public static String transpositionCipherDecrypt(String text, String key) {
        if (text.endsWith("x")) {
        text = text.substring(0, text.length() - 1);
    }
        int[] colOrder = getColumnOrder(key);
        int numRows = (int) Math.ceil((double) text.length() / key.length());
        char[][] grid = new char[numRows][key.length()];

        // Điền các ký tự vào lưới theo thứ tự cột
        int index = 0;
        for (int col : colOrder) {
            for (int r = 0; r < numRows; r++) {
                if (index < text.length()) {
                    grid[r][col] = text.charAt(index++);
                }
            }
        }

        // Đọc lưới theo hàng để tạo văn bản đã giải mã
        StringBuilder decryptedText = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < key.length(); c++) {
                decryptedText.append(grid[r][c]);
            }
        }

        return decryptedText.toString().trim(); // Xóa các khoảng trắng thừa
    }

  
    public demo() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();

        jScrollPane3.setViewportView(jTree1);

        jLabel2.setText("KEY");

        jButton1.setText("Decryption");

        jButton2.setText("Encryption");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(40, 40, 40)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String vanBanCanMaHoa = jTextField1.getText();
        String khoa = jTextField2.getText();

        // Gọi hàm mã hóa
        String vanBanMaHoa = transpositionCipherEncrypt(vanBanCanMaHoa, khoa);

        // Hiển thị văn bản đã mã hóa
        jTextField3.setText(vanBanMaHoa);                          
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
 String vanBanCanGiaiMa = jTextField3.getText();
        String khoa = jTextField2.getText();

        // Gọi hàm giải mã
        String vanBanGiaiMa = transpositionCipherDecrypt(vanBanCanGiaiMa, khoa);

        // Hiển thị văn bản đã giải mã
        jTextField1.setText(vanBanGiaiMa);     
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
