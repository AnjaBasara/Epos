package domain;

public class InspirationQuote {

	//atributi su po uzoru na atribute JSON objekta
	private String quoteText;
	private String quoteAuthor;
	private String senderName;
	private String senderLink;
	private String quoteLink;
	
	//geteri i seteri za atribute
	public String getQuoteText() {
		return quoteText;
	}
	public void setQuoteText(String quoteText) {
		this.quoteText = quoteText;
	}
	public String getQuoteAuthor() {
		return quoteAuthor;
	}
	public void setQuoteAuthor(String quoteAuthor) {
		this.quoteAuthor = quoteAuthor;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderLink() {
		return senderLink;
	}
	public void setSenderLink(String senderLink) {
		this.senderLink = senderLink;
	}
	public String getQuoteLink() {
		return quoteLink;
	}
	public void setQuoteLink(String quoteLink) {
		this.quoteLink = quoteLink;
	}
	//toString metoda za ispis objekta
	@Override
	public String toString() {
		return "InspirationQuote [quoteText=" + quoteText + ", quoteAuthor=" + quoteAuthor + ", senderName="
				+ senderName + ", senderLink=" + senderLink + ", quoteLink=" + quoteLink + "]";
	}
	
	
	
}
