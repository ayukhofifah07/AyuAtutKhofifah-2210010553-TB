import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ui.MahasiswaUI;
import ui.KRSUI;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
    
    private static void createAndShowGUI() {
        // Set Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JFrame frame = new JFrame("Sistem Informasi KRS Mahasiswa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Main panel with gradient background
        JPanel mainPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth(), h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, new Color(30, 144, 255), w, h, new Color(135, 206, 250));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 0, 5, 0);
        
        // Title
        JLabel titleLabel = new JLabel("SISTEM INFORMASI KRS", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        gbc.insets = new Insets(0, 0, 30, 0);
        mainPanel.add(titleLabel, gbc);
        
       // Menu buttons
JButton[] buttons = {
    createStyledButton("Kelola Mahasiswa", e -> {
        try {
            // Membuat dan menampilkan JFrame MahasiswaUI
            MahasiswaUI mahasiswaUI = new MahasiswaUI();
            mahasiswaUI.setVisible(true);  // Menampilkan JFrame MahasiswaUI
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }),
    createStyledButton("Kelola KRS", e -> {
        try {
            // Membuat dan menampilkan JFrame KRSUI
            KRSUI krsUI = new KRSUI();
            krsUI.setVisible(true);  // Menampilkan JFrame KRSUI
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }),
    createStyledButton("Keluar", e -> System.exit(0))
};
        
        gbc.insets = new Insets(5, 0, 5, 0);
        for (JButton button : buttons) {
            mainPanel.add(button, gbc);
        }
        
        frame.add(mainPanel);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private static JButton createStyledButton(String text, ActionListener action) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(new Color(30, 144, 255));
        button.setBackground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(30, 144, 255), 2),
            BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(30, 144, 255));
                button.setForeground(Color.WHITE);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.WHITE);
                button.setForeground(new Color(30, 144, 255));
            }
        });
        
        button.addActionListener(action);
        return button;
    }
}