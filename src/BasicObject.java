import java.util.HashSet;
import java.util.Set;


public class BasicObject {
	private String value;
	
	public String toString() {
		return getClass().getName() + value;
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 128;
		int b = 128;
		if(a == b) {
			System.out.println("b = a = " + a);
		} else {
			System.out.println("b != a ");
		}
		
		BasicObject b1  = new BasicObject();
		BasicObject b2  = new BasicObject();
		if(b1.equals(b2)) {
			System.out.println("b2 = b1  " + b2);
			
		}else {
			System.out.println("b2 != b1  ");
		}
		System.out.println("b1 = " + b1.toString());
		System.out.println("b2 = " + b2.toString());
		System.out.println("b1 = " + b1.hashCode());
		System.out.println("b2 = " + b2.hashCode());
		//b1.hashCode();
		/**
		 * 
		 */
		
		HashTest ab = new HashTest();
		HashTest bhash = new HashTest();
		ab.setI(1);
		bhash.setI(1);
		Set<HashTest> set = new HashSet<HashTest>();
		set.add(ab);
		set.add(bhash);
		System.out.println(ab.hashCode() == bhash.hashCode());
		System.out.println(ab.equals(bhash));
		System.out.println(set); 

	}

}



class HashTest {
	private int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int hashCode() {
		return i % 10;
	}
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		if (object == this) {
			return true;
		}
		if (!(object instanceof HashTest)) {
			return false;
		}
		HashTest other = (HashTest) object;
		if (other.getI() == this.getI()) {
			return true;
		}
		return false;
	}

}
