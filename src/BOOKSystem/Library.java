package BOOKSystem;


import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import BOOKSystem.*;

public class Library extends UnicastRemoteObject implements BookInterface , SeatInterface {

    private static final long serialVersionUID = 1L;
    private List<Book> bookList;
    private Seat st;

    protected Library(List<Book> list) throws RemoteException {
        super();
        this.bookList = list;
        st = new Seat();
    }

	@Override
	public void lendBook(int BookNumber) throws RemoteException {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < bookList.size(); i++){
			if(Integer.parseInt(bookList.get(i).getIsbn()) == BookNumber){
				bookList.get(i).bookLend();
			}
		}
	}

    @Override
    public List<Book> allBooks() throws RemoteException {
        return bookList;
    }

    private static List<Book> initializeList() {
        List<Book> list = new ArrayList<>();
        list.add(new Book("Software Architecture", "100"));
        list.add(new Book("OOAD", "200"));
        list.add(new Book("Software Engineering", "300"));
        list.add(new Book("BigData Engineering", "400"));
        list.add(new Book("Embeded System", "500"));
        return list;
    }

	@Override
	public boolean isReserved(int seat_number) throws RemoteException {
		// TODO Auto-generated method stub
		return this.st.isReserved(seat_number);
	}

	@Override
	public StringBuffer showSeat() throws RemoteException {
		// TODO Auto-generated method stub
		return this.st.showSeat();
	}

	@Override
	public void setSeat(int seat_number, String name) throws RemoteException {
		// TODO Auto-generated method stub
		this.st.setSeat(seat_number, name);
	}


    public static void main(String[] args) {
        try {
            Naming.rebind("//localhost/Library", new Library(initializeList()));
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
        }
    }




}