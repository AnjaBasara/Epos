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
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class OldQuotes extends JFrame {

	private JPanel contentPane;
	private JLabel lblQuoteAuthor;
	private JTextField txtQuoteAuthor;
	private JLabel lblQuoteSender;
	private JTextField txtQuoteSender;
	private JLabel lblQuoteText;
	private JScrollPane scrollPane;
	private JTextArea areaQuoteText;
	private JLabel lblQuoteLink;
	private JTextField txtQuoteLink;
	private JLabel lblSenderLink;
	private JTextField txtSenderLink;
	private JButton btnPrevious;
	private JButton btnNext;
	private JButton btnNewButton;

	
	/**
	 * Create the frame.
	 */
	public OldQuotes() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewQuotes.class.getResource("/images/images.png")));
		setResizable(false);
		setTitle("Motivation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 826, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblQuoteAuthor());
		contentPane.add(getTxtQuoteAuthor());
		contentPane.add(getLblQuoteSender());
		contentPane.add(getTxtQuoteSender());
		contentPane.add(getLblQuoteText());
		contentPane.add(getScrollPane());
		contentPane.add(getLblQuoteLink());
		contentPane.add(getTxtQuoteLink());
		contentPane.add(getLblSenderLink());
		contentPane.add(getTxtSenderLink());
		contentPane.add(getBtnPrevious());
		contentPane.add(getBtnNext());
		contentPane.add(getBtnNewButton());
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
			txtQuoteAuthor.setEditable(false);
			txtQuoteAuthor.setBounds(186, 13, 311, 22);
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
			txtQuoteSender.setEditable(false);
			txtQuoteSender.setBounds(186, 45, 311, 22);
			txtQuoteSender.setColumns(10);
		}
		return txtQuoteSender;
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
			scrollPane.setViewportView(getAreaQuoteText());
		}
		return scrollPane;
	}
	private JTextArea getAreaQuoteText() {
		if (areaQuoteText == null) {
			areaQuoteText = new JTextArea();
			areaQuoteText.setEditable(false);
		}
		return areaQuoteText;
	}
	private JLabel getLblQuoteLink() {
		if (lblQuoteLink == null) {
			lblQuoteLink = new JLabel("Quote link:");
			lblQuoteLink.setBounds(12, 251, 162, 16);
		}
		return lblQuoteLink;
	}
	private JTextField getTxtQuoteLink() {
		if (txtQuoteLink == null) {
			txtQuoteLink = new JTextField();
			txtQuoteLink.setEditable(false);
			txtQuoteLink.setBounds(186, 248, 613, 22);
			txtQuoteLink.setColumns(10);
		}
		return txtQuoteLink;
	}
	private JLabel getLblSenderLink() {
		if (lblSenderLink == null) {
			lblSenderLink = new JLabel("Sender link:");
			lblSenderLink.setBounds(12, 280, 162, 16);
		}
		return lblSenderLink;
	}
	private JTextField getTxtSenderLink() {
		if (txtSenderLink == null) {
			txtSenderLink = new JTextField();
			txtSenderLink.setEditable(false);
			txtSenderLink.setBounds(186, 277, 613, 22);
			txtSenderLink.setColumns(10);
		}
		return txtSenderLink;
	}
	private JButton getBtnPrevious() {
		if (btnPrevious == null) {
			btnPrevious = new JButton("Previous");
			btnPrevious.setBounds(520, 13, 138, 59);
		}
		return btnPrevious;
	}
	private JButton getBtnNext() {
		if (btnNext == null) {
			btnNext = new JButton("Next");
			btnNext.setBounds(670, 13, 138, 59);
		}
		return btnNext;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Back to Main Window");
			btnNewButton.setBounds(12, 318, 168, 44);
		}
		return btnNewButton;
	}
}
