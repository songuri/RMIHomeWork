package BOOKSystem;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import BOOKSystem.*;
public interface BookInterface extends Remote {

    List<Book> allBooks() throws RemoteException;
    void lendBook(int bookNumber) throws RemoteException;

}