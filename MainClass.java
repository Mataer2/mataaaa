package test;

import javax.swing.JFrame;

public class MainClass {
    public static void main(String[] args) {
        // Tạo JFrame để chứa JPanel demo
        JFrame frame = new JFrame("Thuật Toán Dịch Chuyển Dòng" + "");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400); // Đặt kích thước của JFrame

        // Tạo instance của lớp demo và thêm vào JFrame
        demo panel = new demo();
        frame.add(panel);

        // Hiển thị JFrame
        frame.setVisible(true);
    }
}
