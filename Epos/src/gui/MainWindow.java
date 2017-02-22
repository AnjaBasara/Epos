package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.controller.GuiController;


import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JButton btnNewQuotes;
	private JButton btnOldQuotes;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					GuiController.exitApp();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/images/images.png")));
		setTitle("Motivation");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 320, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnNewQuotes());
		contentPane.add(getBtnOldQuotes());
	}

	private JButton getBtnNewQuotes() {
		if (btnNewQuotes == null) {
			btnNewQuotes = new JButton("New quotes");
			btnNewQuotes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GuiController.showNewQuotes();
				}
			});
			btnNewQuotes.setBounds(12, 13, 275, 40);
		}
		return btnNewQuotes;
	}
	private JButton getBtnOldQuotes() {
		if (btnOldQuotes == null) {
			btnOldQuotes = new JButton("Old quotes");
			btnOldQuotes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GuiController.showOldQuotes();
				}
			});
			btnOldQuotes.setBounds(12, 72, 275, 40);
		}
		return btnOldQuotes;
	}
}
