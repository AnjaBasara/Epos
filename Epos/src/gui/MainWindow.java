package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JLabel lblQuoteAuthor;
	private JTextField txtQuoteAuthor;
	private JLabel lblQuoteSender;
	private JTextField txtQuoteSender;
	private JButton btnGenerateQuote;
	private JLabel lblQuoteText;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblQuoteLink;
	private JTextField textField;
	private JLabel lblSenderLink;
	private JTextField textField_1;

	
	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/images/images.png")));
		setResizable(false);
		setTitle("Motivation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblQuoteAuthor());
		contentPane.add(getTxtQuoteAuthor());
		contentPane.add(getLblQuoteSender());
		contentPane.add(getTxtQuoteSender());
		contentPane.add(getBtnGenerateQuote());
		contentPane.add(getLblQuoteText());
		contentPane.add(getScrollPane());
		contentPane.add(getLblQuoteLink());
		contentPane.add(getTextField());
		contentPane.add(getLblSenderLink());
		contentPane.add(getTextField_1());
	}
	private JLabel getLblQuoteAuthor() {
		if (lblQuoteAuthor == null) {
			lblQuoteAuthor = new JLabel("Quote author:");
			lblQuoteAuthor.setBounds(12, 13, 162, 16);
		}
		return lblQuoteAuthor;
	}
	private JTextField getTxtQuoteAuthor() {
		if (txtQuoteAuthor == null) {
			txtQuoteAuthor = new JTextField();
			txtQuoteAuthor.setBounds(186, 10, 311, 22);
			txtQuoteAuthor.setColumns(10);
		}
		return txtQuoteAuthor;
	}
	private JLabel getLblQuoteSender() {
		if (lblQuoteSender == null) {
			lblQuoteSender = new JLabel("Quote sender:");
			lblQuoteSender.setBounds(12, 42, 162, 16);
		}
		return lblQuoteSender;
	}
	private JTextField getTxtQuoteSender() {
		if (txtQuoteSender == null) {
			txtQuoteSender = new JTextField();
			txtQuoteSender.setBounds(186, 39, 311, 22);
			txtQuoteSender.setColumns(10);
		}
		return txtQuoteSender;
	}
	private JButton getBtnGenerateQuote() {
		if (btnGenerateQuote == null) {
			btnGenerateQuote = new JButton("Generate quote");
			btnGenerateQuote.setBounds(524, 9, 275, 52);
		}
		return btnGenerateQuote;
	}
	private JLabel getLblQuoteText() {
		if (lblQuoteText == null) {
			lblQuoteText = new JLabel("Quote text:");
			lblQuoteText.setBounds(358, 80, 103, 16);
		}
		return lblQuoteText;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 108, 787, 120);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	private JLabel getLblQuoteLink() {
		if (lblQuoteLink == null) {
			lblQuoteLink = new JLabel("Quote link:");
			lblQuoteLink.setBounds(12, 251, 162, 16);
		}
		return lblQuoteLink;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(186, 248, 613, 22);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblSenderLink() {
		if (lblSenderLink == null) {
			lblSenderLink = new JLabel("Sender link:");
			lblSenderLink.setBounds(12, 280, 162, 16);
		}
		return lblSenderLink;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setBounds(186, 277, 613, 22);
			textField_1.setColumns(10);
		}
		return textField_1;
	}
}
