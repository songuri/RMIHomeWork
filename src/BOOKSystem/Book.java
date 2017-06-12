package BOOKSystem;

import java.io.Serializable;

public class Book implements Serializable {

    private static final long serialVersionUID = 1190476516911661470L;
    private String title;
    private String isbn;
    private boolean islend;
    

    public Book(String isbn) {
        this.isbn = isbn;
    }

    public Book(String title, String isbn ) {
        this.title = title;
        this.isbn = isbn;
        islend = true;
        
    }

    public String getTitle() {
        return title;
    }
    public String getIsLendString(){
    	String tmp = "(" +islend+")";
    	return tmp;
    }

    public String getIsbn() {
        return isbn;
    }
    public void bookLend(){
    	islend = false;
    }
    public void bookReturn(){
    	islend = true;
    }
    
    public String toString() {
        return "> " + this.title +" > BookNumber :" + this.isbn +"> Avaiable : " +islend  ;
    }

}