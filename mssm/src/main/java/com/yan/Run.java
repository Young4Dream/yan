package com.yan;

import com.yan.model.MainFrame;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Run {
    static MainFrame mainFrame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> mainFrame = new MainFrame());
//        ActionListener
    }
}
