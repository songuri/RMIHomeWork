package BOOKSystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SeatInterface extends Remote{

	public boolean isReserved(int seat_number) throws RemoteException;
	public StringBuffer showSeat() throws RemoteException;
	public void setSeat(int seat_number , String name) throws RemoteException;
}
