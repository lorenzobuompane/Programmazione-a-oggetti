package it.polito.oop.tables;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * Represents a restaurant with a set of tables, it allows parties of client
 * to sit and leave tables.
 *
 */
public class Restaurant {
	
	private String openingTime;
	private String closingTime;
	private Map<Integer, Table> t = new TreeMap<>();
	private Map<Integer, Clients> c = new TreeMap<>();
	
    public void defineTables(int... seats) {
    	for (int i : seats) {
    		Table t = new Table(i, this);
    		int n = this.t.size()+1;
    		t.settableID(n);
    		this.t.put(n, t);
    	}
    }
    
    public int getSeats() {
    	List<Integer> l = this.t.values().stream()
        		.map(Table::gettableSize)
        		.collect(Collectors.toList());
    	
    	int sum=0;
    	
    	for (Integer i : l) {
    		sum = sum + i;
    	}
    	
        return sum;
    }

    public int tableSize(int tableId) throws IllegalArgumentException {
    	if (!this.t.containsKey(tableId)) 
    		throw new IllegalArgumentException();
        return this.t.get(tableId).gettableSize();
    }
    
    public String getOpeningTime() {
        return this.openingTime;
    }
    
    public void setOpeningTime(String time) {
    	this.openingTime=time;
    }
    
    public String getClosingTime() {
        return this.closingTime;
    }
    
    public void setClosingTime(String time) {
//    	String split[] = time.split(":");
//    	int ore = Integer.parseInt(split[0]);
//    	int minuti = Integer.parseInt(split[1]);
    	
    	this.closingTime=time;

    }

    public int newParty(String name, int count, String mobile) {
    	Clients c = new Clients(name, count, mobile);
    	int code = this.c.size()+1;
    	c.setCode(code);
    	this.c.put(code, c);
        return code;
    }
    
    public String getPartyName(int partyId) {
    	if (!this.c.containsKey(partyId))
    		throw new IllegalArgumentException();
        return this.c.get(partyId).getName();
    }
    
    public int getPartySize(int partyId) {
    	if (!this.c.containsKey(partyId))
    		throw new IllegalArgumentException();
        return this.c.get(partyId).getCount();
    }
    
    public String getPartyPhone(int partyId) {
    	if (!this.c.containsKey(partyId))
    		throw new IllegalArgumentException();
        return this.c.get(partyId).getMobile();
    }
    
    public int countParties() {
        return this.c.size();
    }
    
    public void takeTable(int table, int partyId,String time) {
    	this.t.get(table).setOccupation(true);
    	this.t.get(table).setOccTable(partyId);
    	this.t.get(table).setnOccTable(this.c.get(partyId).getCount());
    	this.t.get(table).setTimeTable(time);
    	this.t.get(table).setNumClient();
    }
    
    public int leaveTable(int table, String time) {
    	int code = this.t.get(table).getOccTable();
    	this.t.get(table).setOccupation(false);
    	this.t.get(table).setTimeTableLeave(time);;
    	this.c.get(code).setEated(true);
    	this.t.get(table).setTimeEff(this.c.get(code).getCount());
        return code;
    }
    
    public String estimateAvailable(int table) {
    	if (this.t.get(table).isOccupation()) {
    		int i = this.c.get(this.t.get(table).getOccTable()).getCount();
    		i = 40 + (5 * i);
    		int ore = 0;
    		int h=0;
    		for (h=i; h>=60; h=h-60) {
    			ore++;
    		}
    		int min = h;
    		
    		String time = this.t.get(table).getTimeTable();
    		String split[] = time.split(":");
    		int oreA = Integer.parseInt(split[0]);
    		int minA = Integer.parseInt(split[1]);
    		
    		ore = ore + oreA;
    		min = min + minA;
    		
    		return ore + ":" + min;
    	}
        return this.openingTime;
    }
    
    public int timeE(int table) {
    	int i = this.c.get(this.t.get(table).getOccTable()).getCount();
    	i = 40 + (5 * i);
    	return i;
	}
    
    public List<TableOption> estimateWaiting(int partySize){
    	
        return null;
    }
    
    public void bookTable(int table, int partyId, String time) {
    	takeTable(table, partyId, time);
    }
    
    public int countServedCustomers() {
    	List<Integer> n = this.c.values().stream()
    			.filter(x->x.isEated())
    			.map(Clients::getCount)
    			.collect(Collectors.toList());
    	int count = 0;
    	for (int i : n) {
    		count = count + i;
    	}
    	
        return count;
    }
    
    public int countServedParties() {
    	List<Integer> n = this.c.values().stream()
    			.filter(x->x.isEated())
    			.filter(x->x.getCount()>0)
    			.map(Clients::getCount)
    			.collect(Collectors.toList());
        return n.size();
    }

    public Map<Integer,Long> tableTurnover() {
        return this.t.values().stream()
        		.collect(Collectors.toMap(Table::gettableID, Table::getNumClient))
        		;
    }
    
    public int estimationError(int table) {
        return -1;
    }
}
