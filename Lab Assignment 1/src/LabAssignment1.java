
import java.util.*;
/**
 * @author michaelching
 * CECS 277 Phoung Nguyen
 *
 */
public class LabAssignment1 {

	/**
	 * Test student class by creating students
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		Student michael = new Student ("Michael", "123");
		Student jim = new Student ("Jim", "567");
		
		//student copy of Michael
		Student otherMichael = new Student (michael);
		
		System.out.println(michael);
		System.out.println(jim);
		System.out.println(otherMichael);
		
		System.out.println("Does michael equal otherMichael? : " + michael.equals(otherMichael) );
		System.out.println("Does michael equal jim? : " + michael.equals(jim) );
		
		//ArrayList of object Student
		ArrayList <Student> classList = new ArrayList<Student> ();
		
		classList.add(michael);
		classList.add(jim);
		classList.add(otherMichael);
		
		System.out.println(classList + ", ");
		

	}

}
