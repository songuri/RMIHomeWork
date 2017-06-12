package BOOKSystem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Iterator;

import BOOKSystem.*;

public class Seat  extends UnicastRemoteObject implements SeatInterface{
	private HashMap <Integer , String> seatData;
	
	public Seat() throws RemoteException {
		seatData = new HashMap<Integer , String>();
		for(int i = 0 ; i < 10 ; i ++){ // set Seat;
			seatData.put(i, "BlankSeat");
		}
	}
	public boolean isReserved(int seat_number) throws RemoteException{
		return seatData.get(seat_number).equals("BlankSeat");
	}
	public StringBuffer showSeat() throws RemoteException{
		StringBuffer tmp = new StringBuffer();
		int key;
		Iterator<Integer> iterator = seatData.keySet().iterator();
		while(iterator.hasNext()){
			key = iterator.next();
			tmp.append( "> "+key +" 번 좌석 : "+"사용자 : " + seatData.get(key));
			tmp.append("\n");
		}
		
		return tmp;
	}
	public void setSeat(int seat_number , String name) throws RemoteException{
		seatData.put(seat_number, name);
	}
	
}
