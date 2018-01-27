package com.yan.model;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        super("nepsd micro server start manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1250, 773);
        setLayout(new FlowLayout());
        setLocation(300, 300);

        JButton wsdButton = new JButton("wsd");
        JButton wndButton = new JButton("wnd");
        JButton diyButton = new JButton("diy");
        wsdButton.setSize(168, 100);
        wndButton.setSize(168, 100);
        diyButton.setSize(168, 100);

        add(wsdButton);
        add(wndButton);
        add(diyButton);

        JPanel panel = new JPanel();
        JTextArea textArea = new JTextArea("root path");
        panel.setSize(200, 100);
        panel.setLocation(500, 500);
        panel.add(textArea, new BorderLayout(1,1));
        add(panel);
    }
}
