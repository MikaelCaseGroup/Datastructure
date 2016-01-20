package p2;

/**
 * Klassen Entry fungerar som data i vår Hashtable. Varje element i vår länkade lista är av
 * typen Entry. Entry kan hålla i en nyckel och ett värde.
 * @author mikaelhorvath
 *
 */
public class Entry {
	public Object key; // Nyckel
	public Object value; // Värde
	
	/**
	 * Konstruktorn tar emot nyckel och värde när vi skapar nya Entryn
	 * @param key
	 * @param value
	 */
	public Entry(Object key, Object value){
		this.key = key;
		this.value = value;
	}
	
	/**
	 * equals jämför våra object. Vi tar emot ett värde som object som sedan jämförs och
	 * returneras. 
	 */
	@Override
	public boolean equals(Object obj) {
		Entry keyToCompare = new Entry(obj, null);
		return key.equals(obj);
	}
	
	/**
	 * Returnerar värdet 
	 * @return value
	 */
	public Object getValue() {
		// TODO Auto-generated method stub
		return value;
	}
}
