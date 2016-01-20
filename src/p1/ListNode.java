package p1;
/**
 * Klassen agerar som en nod i en lista (stack). Klassen håller i ett objekt som vi kallar
 * för data och refererar även till sig själv med next där en nod med data representeras.
 * @author mikaelhorvath
 */

public class ListNode {
	public Object data; // Data av typen object
	public ListNode next; // referens till ListNode, håller i en hel nod
	
	/**
	 * Konstruktorn tar emot data och även förgående nod så att vi har kvar den referensen.
	 * Next kommer vara null vid första pushen (första datan som skickas in till stack).
	 * @param dataValue
	 * @param nextValue
	 */
	public ListNode(Object dataValue, ListNode nextValue){
		data = dataValue;
		next = nextValue;
	}
	
	/**
	 * get-metod för att hämta data som pushats in.
	 * @return object (data)
	 */
	public Object getData(){
		return data;
	}
	
	/**
	 * set-metod för att sätta ny data, används ej! finns tillgänglig. 
	 * @param dataValue
	 */
	public void setData(Object dataValue){
		data = dataValue;
	}
}
