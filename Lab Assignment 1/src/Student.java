/**
 * 
 */

/**
 * @author michaelching
 *	Class of object Student containing their name and ID
 */
public class Student 
	{
		
		private String name;
		private String id;
		
		/**
		 * Sets name and ID of student
		 * @param name String name of the student
		 * @param id String ID of the student
		 */
		public Student(String name, String id)
		{
			
			this.name = name;
			this.id = id;
			
		}
		
		/**
		 * Sets current student to another student properties
		 * @param other A student
		 */
		public Student(Student other)
		{
			
			this.name = other.name;
			this.id = other.id;
			
		}
		
		/**
		 * Getter method for name
		 * @return String name of student
		 */
		public String getName()
		{
			
			return name;
			
		}
		
		/**
		 * Getter method of ID
		 * @return String ID of student
		 */
		public String getID()
		{
			
			return id;
			
		}
		
		/**
		 * Prints student info in format
		 * @return String format of the student name and ID
		 */
		@Override
		public String toString()
		{
			
			return ("Name: " + name + " ID: " + id);
			
		}
		
		/**
		 * Compare student ID to see if they are same student
		 * @return boolean value if same student or not 
		 */
		public boolean equals (Object other)
		{
			
			boolean result = false;
			
			//checks if passed in object is Student
			if(other instanceof Student)
			{
				
				Student otherStudent = (Student) other;
				result = id.contentEquals(otherStudent.id);
				
			}
			
			return result;
			
		}
	
	}
