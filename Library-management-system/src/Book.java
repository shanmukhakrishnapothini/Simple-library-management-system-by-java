public class Book extends Object {
    private int id;
    private String title;
    private String author;
    private boolean isAvailable;
    private Borrower borrower;
    
	public Book(int id, String title, String author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isAvailable = true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public void setBorrower(Borrower borrower) {
		this.borrower = borrower;
	}
	
	public Borrower getBorrower() {
		return borrower;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isAvailable=" + isAvailable + "]";
	}

    
}