package BOOKSystem;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;

import BOOKSystem.*;


public class Student {

    private static BookInterface look_up;
    private static SeatInterface look_up2;

    public static void main(String[] args) throws
            MalformedURLException, RemoteException, NotBoundException { 
        boolean findmore;
        do {

            String[] options = { "Show Book", "Lend a book" ,"Show seat","Reserve seat" ,"Exit" , };

            int choice = JOptionPane.showOptionDialog(null, "Choose an action", "Option dialog",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, options, options[0]);

            switch (choice) {
                case 0:
                	look_up = (BookInterface) Naming.lookup("//localhost/Library");
                    List<Book> list = look_up.allBooks();
                    StringBuilder message = new StringBuilder();
                    list.forEach(x -> {
                        message.append(x.toString() + "\n");
                    });
                    JOptionPane.showMessageDialog(null, new String(message));
                    break;
                case 1:
                	look_up = (BookInterface) Naming.lookup("//localhost/Library");
                    String isbn = JOptionPane.showInputDialog("Input the booknumber of the book you want to lend.");
                    look_up.lendBook(Integer.parseInt(isbn));
                    /*try {
                        Book response = look_up.findBook(new Book(isbn));
                        JOptionPane.showMessageDialog(null, "Title: " +
                                        response.getTitle() + "\n",
                                response.getIsbn(), JOptionPane.INFORMATION_MESSAGE);
                    } catch (NoSuchElementException ex) {
                        JOptionPane.showMessageDialog(null, "Not found");
                    }*/
                    break;
              
                case 2:
                	look_up2 = (SeatInterface) Naming.lookup("//localhost/Library");
                	StringBuffer seatMessage = new StringBuffer();
                	seatMessage = look_up2.showSeat();
                	JOptionPane.showMessageDialog(null, new String(seatMessage.toString()));
                	break;
                case 3:
                	look_up2 = (SeatInterface) Naming.lookup("//localhost/Library");
                	String seat_number = JOptionPane.showInputDialog("Input Seat Number");
                	String user_name = JOptionPane.showInputDialog("Input User Name");
                	look_up2.setSeat(Integer.parseInt(seat_number), user_name);
                	JOptionPane.showMessageDialog(null, "Reserve Complete");
                	
                	break;
                default:
                    System.exit(0);
                    break;

            }
            findmore = (JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION);
        } while (findmore);
    }
}