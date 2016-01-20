package p1;

import javax.swing.JOptionPane;
/**
 * Klassen Brackets kollar igenom olika input för att hantera parenteser, måsvingar och klämmor.
 * Vi använder en lång if-sats för att kika på inputsen för att se om starten avslutas med ett korrekt
 * avslut. 
 * @author mikaelhorvath
 *
 */
public class Brackets {
	private Stack s; // Använder stackens metoder
	private static final char L_PAREN = '(';
	private static final char R_PAREN = ')';
	private static final char L_MASVINGE = '{';
	private static final char R_MASVINGE = '}';
	private static final char L_KLAMMA = '[';
	private static final char R_KLAMMA = ']';
	
	/**
	 * Konstruktorn skapar en ny stack utifrån den klass vi redan definierat
	 */
	public Brackets() {
		s = new Stack();
	}

	/**
	 * Metoden kollar igenom våra inputs. Vi skickar hit strängen som vi loopar igenom. 
	 * Vi pushar endast in tecken och inte hela strängar.
	 * @param str
	 */
	public void checkBrackets(String str) {
		
		
		for (int i = 0; i < str.length(); i++) {
			// Pushar in vänster parentes
			if (str.charAt(i) == L_PAREN) {
				s.push(L_PAREN);
			}
			// pushar in vänster måsvinge
			if (str.charAt(i) == L_MASVINGE) {
				s.push(L_MASVINGE);
			}
			// pushar in vänster klämma
			if (str.charAt(i) == L_KLAMMA) {
				s.push(L_KLAMMA);
			}
			
			// Om strängen är på höger parantes och peek inte är null så ska vi popa
			// Om vid popen txt != vänster parentes så har vi ett fel, det finns ingen matchning
			if (str.charAt(i) == R_PAREN) {
				if (s.peek() != null) {
					char txt = (char) s.pop();
					if (txt != L_PAREN) {
						System.out.println("FEL! Orsak: Saknas parantes!");
					}
				} else {
					System.out.println("peek är 0, går ej poppa"); // peek är null
				}

			}
			
			// Kollar höger måsvinge, om txt vid pop inte är vänster måsvinge har ett fel
			// uppstått
			if (str.charAt(i) == R_MASVINGE) {
				if (s.peek() != null) {
					char txt = (char) s.pop();
					if (txt != L_MASVINGE) {
						System.out.println("FEL! Orsak: Saknas måsvinge!");
					}
				} else {
					System.out.println("peek är 0, går ej poppa");
				}
			}
			
			// Kollar höger klämma, om txt vid pop inte är vänster klämma har ett fel uppstått
			if (str.charAt(i) == R_KLAMMA) {
				if (s.peek() != null) {
					char txt = (char) s.pop();
					if (txt != L_KLAMMA) {
						System.out.println("FEL! Orsak: Saknas klämma!");
					}

				} else {
					System.out.println("peek är 0, går ej poppa");
				}
			}
		}
		
		// Vi dividerar här för att kolla ojämna och jämna tecken, för att kunna utesluta att 
		// inte andra fel har inträffat utöver det vi kollar igenom där uppe. Exempel kan vara att
		// vi skriver in {{ som är jämnt tal men vi hamnar aldrig i våra pop metoder vilket kan orsaka
		// märkliga fel. 
		if (s.count() % 2 == 0) {
			if (s.count() != 0) {
				System.out.println("Saknar klamrar efter!!");
			}
		} else {
			System.out.println("Du har skrivit ett ojämnt antal tecken! Rätta till");
		}
	}
	
	/**
	 * Använder metoden för att skriva in text och skicka vidare strängen till
	 * checkBrackets() 
	 */
	public void inputTxt() {
		String str = JOptionPane.showInputDialog("Skriv in text");
		System.out.println("Kollar igenom texten:" + " " + str);
		checkBrackets(str);
	}
	
	/**
	 * Main metod för att testa klassen
	 * @param args
	 */
	public static void main(String[] args) {
		Brackets b = new Brackets();
		b.inputTxt();
	}
}
