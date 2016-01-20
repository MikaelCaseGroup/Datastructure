package p2;

import java.util.Iterator;
import java.util.LinkedList;
/**
 * Klassen hanterar två LinkedLists där insertionOrder hanterar våra värden medan table av typen
 * Entry hanterar hela Entry objekt.
 * @author mikaelhorvath
 *
 */
public class Hashtable {
	private LinkedList<Object> insertionOrder = new LinkedList<Object>();
	private LinkedList<Entry>[] table;
	
	/**
	 * Konstruktorn tar emot en storlek när en ny Hashtable skapas
	 * För varje "Size" skapar vi ett utrymme i table där våra Entry obj kan sättas in
	 * @param size
	 */
	public Hashtable(int size) {
		table = (LinkedList<Entry>[]) new LinkedList<?>[size];
		for (int i = 0; i < size; i++) {
			table[i] = new LinkedList<Entry>();
		}
	}
	
	/**
	 * Vi kollar igenom objektets hashvärde och gör en modulus operation på det. Vi kollar om 
	 * det inte är negativt, om så är fallet ska vi göra det positivt. 
	 * @param key
	 * @return
	 */
	private int hashIndex(Object key) {
		int hashCode = key.hashCode();
		hashCode = hashCode %= table.length;
		return (hashCode < 0) ? -hashCode : hashCode;
	}
	
	/**
	 * Get metoden hämtar vårt värde med hjälp av nyckeln som skickas in till metoden.
	 * Vi itererar igenom våra entries för att returnera alla, om inga finns ska null 
	 * returneras.
	 * @param key
	 * @return
	 */
	public Object get(Object key) {

		int hashIndex = hashIndex(key); // r‰kna nyckel index
		LinkedList<Entry> entries = table[hashIndex];
		Iterator<Entry> it = entries.listIterator();

		while (it.hasNext()) {
			Entry entry = it.next();
			if (entry.equals(key)) {
				return entry.getValue();
			}
		}

		return null;
	}
	
	/**
	 * Metoden put lägger in nya objekt till både table och insertionOrder. Table hanterar hela 
	 * Entry objektet medan insertionOrder lägger till value sist i listan. 
	 * @param key
	 * @param value
	 */
	public void put(Object key, Object value){
		if(get(key) == null){
			Entry ent = new Entry(key, value);
			table[hashIndex(key)].add(ent);
			insertionOrder.addLast(value);
		}
	}
	
	/**
	 * Returnerar storlek på insertionOrder
	 * @return insertionOrder.size() 
	 */
	public int count(){
		return insertionOrder.size();
	}
	
	/**
	 * Returnerar samtliga värden i insertionOrder
	 * @return insertionOrder
	 */
	public LinkedList<Object> getInsertionOrder(){
		return insertionOrder;
	}
		
	/**
	 * Metoden raderar vårt värde med hjälp av nyckeln. För att ta bort den helt och hållet
	 * loopar vi igenom table också där värdet med nyckeln raderas. När vi tar bort värdet i insertionOrder
	 * Anropar vi get-metoden för att hämta ut objektet för att på så sätt avgöra vilket värde det är som ska 
	 * tas bort. 
	 * @param key
	 */
	public void remove(Object key) {
		insertionOrder.remove(get(key));
		for(int i = 0; i < table[hashIndex(key)].size(); i++){
			table[hashIndex(key)].remove();
		}
	}
}
