package p1;

/**
 * Klassen fungerar som en stack som använder sig av Noder (ListNode) som element i stacken.
 * @author mikaelhorvath
 *
 */
public class Stack {
	private ListNode first = null; // Referens till ListNode, håller reda på förgående element
	public int nbrOfE = 0; // Egen definierad räknare
	
	/**
	 * Push tar emot data för att skapa en ny nod i stacken. Vi definierar first som som den nya noden så
	 * att nästa push kan definieras som next (first = next (ListNode)) 
	 * @param dataIn
	 */
	public void push(Object dataIn){
		ListNode node = new ListNode(dataIn, first);
		first = node;
		nbrOfE++; // Ökar vår räknare för varje nytt element
	}
	
	/**
	 * Pop tar bort det som ligger överst i vår stack. Skapar ett temp som är first. Om den är null
	 * finns inget att returnera. Om inte null så ska first vara first.next så nästa pop har koll på 
	 * nästa element vid pop, vid returnerar data (överst på stacken)
	 * @return
	 */
	public Object pop(){
		ListNode temp = first;
		if(temp != null){
			first = first.next;
			nbrOfE--; // minskar vår räknare
			return temp.getData();
		}else{
			return null;
		}
	}
	
	/**
	 * med peek kollar vi på det element som ligger överst i stacken. Till skillnad från pop
	 * så tar vi inte bort det elementet ur vår stack. Vi börjar med att skapa en ny referens till
	 * vår nod så att vi kan returnera data om noden inte är null
	 * @return
	 */
	public Object peek(){
		ListNode currentNode = first;
		if(currentNode != null){
			return currentNode.getData();
		}else{
			return null;
		}
	}
	
	/**
	 * Vi har definierat en räknare som ökar vid push och minskar vi pop
	 * här returnerar vi denna räknare på ett simpelt sätt
	 * @return nbrOfE
	 */
	public int count(){
		return nbrOfE;
	}
	
	/**
	 * För att testa skiten såklart
	 * @param args
	 */
	public static void main(String[] args) {
		// Uppgift 1
		Stack s = new Stack();
		s.push("1");
		s.push("2");
		s.push("3");
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.count());		
	}
	
}
