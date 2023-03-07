package it.polito.oop.tables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table implements TableOption{

	private int tableID;
	private int tableSize;
	private Restaurant restaurant;
	private boolean occupation = false;		//true occupato 
	private int occTable;					//clientID
	private int nOccTable;					//numero di clienti
	private String timeTable;
	private String timeTableLeave;
	private long numClient=0;
	private Map<Integer, ArrayList<Integer>> listTime = new HashMap<>();		//codice, minuti effettivo
	private List<Integer> tmed = new ArrayList<>();
	
	public Table(Integer tableSize, Restaurant restaurant) {
		this.tableSize=tableSize;
		this.restaurant=restaurant;
	}

	public int gettableID() {
		return tableID;
	}

	public void settableID(int tableID) {
		this.tableID = tableID;
	}

	public int gettableSize() {
		return tableSize;
	}

	public boolean isOccupation() {
		return occupation;
	}

	public void setOccupation(boolean occupation) {
		this.occupation = occupation;
	}

	public int getOccTable() {
		return occTable;
	}

	public void setOccTable(int occTable) {
		this.occTable = occTable;
	}

	public String getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(String timeTable) {
		this.timeTable = timeTable;
	}

	public long getNumClient() {
		return numClient;
	}

	public void setNumClient() {
		this.numClient++;
	}

	public String getTimeTableLeave() {
		return timeTableLeave;
	}

	public void setTimeTableLeave(String timeTableLeave) {
		this.timeTableLeave = timeTableLeave;
	}
	
	public int timeEff() {
		String timeA = this.timeTable;
		String splitA[] = timeA.split(":");
		int oreA = Integer.parseInt(splitA[0]);
		int minA = Integer.parseInt(splitA[1]);
		String timeB = this.timeTableLeave;
		String splitB[] = timeB.split(":");
		int oreB = Integer.parseInt(splitB[0]);
		int minB = Integer.parseInt(splitB[1]);
		int min = (oreB-oreA)*60 + (minB-minA);
		return min;
	}

	public void setTimeEff(int count) {
		ArrayList<Integer> time = new ArrayList<>();
		time.add(40+5*count);
		time.add(timeEff());
		this.tmed.add((40+5*count)-(timeEff()));
		this.listTime.put(occTable, time);
	}
	
	public List<Integer> getTMed() {
		return tmed;
	}

	@Override
	public String getTime() {
		return this.restaurant.estimateAvailable(this.gettableID());
	}

	@Override
	public int getTable() {
		return this.tableID;
	}

	@Override
	public double getOccupation() {
		if (this.occupation==false)
			return 0.0;
		return (double) nOccTable/tableSize;
	}

	public int getnOccTable() {
		return nOccTable;
	}

	public void setnOccTable(int nOccTable) {
		this.nOccTable = nOccTable;
	}
}
