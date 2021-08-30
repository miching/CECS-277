/**
 * 
 * @author Mika Wong, Nicolas Guardado, Gem Balagtas, Michael Ching
 * Due Date: December 7, 2020
 * Purpose: This class demonstrates our knowledge of the Singleton Pattern where there is only one RoachMotel.
 *
 */
import java.lang.reflect.Array;
import java.util.*;

public class RoachMotel
{

	private static RoachMotel instance;
	private MotelRoom r;
	private RoachColony rc;
	private WaitListRC wlrc = new WaitListRC();
	private String motelName = "Hotel Hell >:D";

	private Queue<Integer> roomList;
	private Queue<Integer> tempTaken = new LinkedList<Integer>();
	private static ArrayList<MotelRoom> takenRooms = new ArrayList<MotelRoom>();
	private Map<Integer, String> details = new TreeMap<Integer, String>();
	private static ArrayList<String> roomDeets = new ArrayList<>();

	/**
	 * Private RoachMotel constructor
	 */
	private RoachMotel()
	{
	
	}

	/**
	 * Method that creates only one instance of the RoachMotel
	 * 
	 * @return RoachMotel instance of the RoachMotel
	 */
	public static RoachMotel getInstance()
	{
		if (instance == null) {
			instance = new RoachMotel();
		}

		return instance;
	}

	/**
	 * Method that creates a list of room numbers available in the RoachMotel
	 */
	public void createRooms()
	{
		roomList = new LinkedList<Integer>();
		roomList.add(101);
		roomList.add(102);
		roomList.add(103);
		roomList.add(104);

	}

	/**
	 * Method that allows a RoachColony check in and get a specific room with
	 * specific amenities
	 * 
	 * @param type RoachColony roachcol is the roach colony checking in
	 * @param type String s is the type of room the colony wants
	 * @param type ArrayList<String> a is the list of amenities the colony wants in
	 *             their room
	 * @return MotelRoom the specified MotelRoom
	 */
	public MotelRoom checkIn(RoachColony roachcol, String s, ArrayList<String> a)
	{
		try {
			rc = roachcol;
			String amenities = "";
			String room = "";
			int cost = 0;

			/** Checks in the roachcolony to the Basic Room */
			if (s.equalsIgnoreCase("basic")) {
				r = new BasicRoom();
				MotelRoom copy = r;
				/** Creates the proper list of amenities associated with the basic room */
				for (String amen : a) {
					copy = Amenities.createAmenity(amen, copy);
					amenities += ", " + amen;
				}
				/** takes care of formatting room details and room number */
				room = s + amenities + ", $" + String.format("%.2f", copy.cost()) + " | Guest Details: " + rc.getColony();
				takenRooms.add(r);
				roomDeets.add(room);
			}
			/** Checks in the roachcolony to the Deluxe Room */
			else if (s.equalsIgnoreCase("deluxe")) {
				r = new DeluxeRoom();
				MotelRoom copy = r;
				/** Creates the proper list of amenities associated with the Deluxe room */
				for (String amen : a) {
					copy = Amenities.createAmenity(amen, copy);
					amenities += ", " + amen;
				}
				/** takes care of formatting room details and room number */
				room = s + amenities + ", $" + String.format("%.2f", copy.cost()) + " | Guest Details: " + rc.getColony();
				takenRooms.add(r);
				roomDeets.add(room);
			}
			/** Checks in the roachcolony to the Suite Room */
			else if (s.equalsIgnoreCase("suite")) {
				r = new SuiteRoom();
				MotelRoom copy = r;
				/** Creates the proper list of amenities associated with the Suite room */
				for (String amen : a) {
					copy = Amenities.createAmenity(amen, copy);
					amenities += ", " + amen;
				}
				/** takes care of formatting room details and room number */
				room = s + amenities + ", $" + String.format("%.2f", copy.cost()) + " | Guest Details: " + rc.getColony();
				takenRooms.add(r);
				roomDeets.add(room);
			}
			/**
			 * If there are no more rooms available, then add the roachcolony to the
			 * waitlist
			 */
			if (roomList.size() == 0) 
			{
				
				wlrc.addToWL(rc);
				
			} 
			else 
			{
				/** If there are still rooms available, continute checking them in */
				int temp = roomList.remove();
				tempTaken.add(temp);
				details.put(temp, room);
			}

		} catch (NoSuchElementException e) {
			System.out.println(e.toString() + "No more elements. Please check any lists you're pulling from.");
		}

		return r;
	}

	/**
	 * Method that checks out the RoachColony
	 * 
	 * @param type MotelRoom room is the room that was stayed in
	 * @param type int days is the number of days stayed
	 * @param type Payment p is the type of card the Colony will use to pay
	 * @return Amount due
	 */
	public Double checkOut(MotelRoom room, int days, Payment p)
	{
		r = room;
		double cost = r.cost() * days;
		int temp = tempTaken.remove();
		details.remove(temp);
		roomList.add(temp);
		
		//notify roach colony that a room has opened up
		wlrc.notifyRoaches(motelName);
		
		return cost;
	}

	/**
	 * Method that retrieves a roach's colony and room information
	 * 
	 * @param type RoachColony roachColony is the colony we want to retrieve
	 * @return a String that contains the information associated with the roach
	 *         colony
	 */
	public static String getRoachColony(RoachColony roachColony)
	{
		String s = "";
		for (String string : roomDeets) {
			if (string.contains(roachColony.getName())) {
				s = string;
			}
		}
		return s;
	}

	/**
	 * Void method that Updates the roach colony population once a party ensues
	 */
	public void updateParty() {
		String[] test;
		String pTest;
		StringBuffer sBuffer = new StringBuffer();
		Set<Map.Entry<Integer, String>> roomDeets = details.entrySet();
		
		/**Look through the room detail map data structure in order to find the correct colony to update*/
		for (Map.Entry<Integer, String> entry : roomDeets) 
		{
			
			test = entry.getValue().split(" ");
			pTest = test[test.length-3] + " " + test[test.length-2];
			/**Once it finds the right colony to update, perform the following:*/
			if (pTest.equalsIgnoreCase(rc.getName())) {
				Array.set(test, test.length-1, String.valueOf(rc.getPop()));
				/**Updates the new string with the new population value*/
				for (int i=0; i < test.length; i++) {
					sBuffer.append(test[i] + " ");
				}
				/**Update the original room detail hashmap*/
				details.put(entry.getKey(),sBuffer.toString());
			}
		}
	}
	
	/**
	 * Method that allows the rooms to be cleaned if theres no Do Not Disturb sign
	 * on
	 */
	public void cleanRooms()
	{
		for (MotelRoom r : takenRooms) {
			/** Makes sure to check DoNotDisturb status is on before entering the room */
			if (r.doNotDisturbStatus != true) {
				System.out.println("In this room: " + r.getDescription());
				/**
				 * Takes each MotelRoom instance and casts it to their proper Basic/Deluxe/Suite
				 * instance for proper accepting of Cleaning Visitor
				 */
				if (r instanceof BasicRoom) {
					((BasicRoom) r).accept(new CleaningVisitor());
				} else if (r instanceof DeluxeRoom) {
					((DeluxeRoom) r).accept(new CleaningVisitor());
				} else if (r instanceof SuiteRoom) {
					((SuiteRoom) r).accept(new CleaningVisitor());
				}
			} else {
				System.out.println("DoNotDisturb sign displayed. Skipping this room: " + r.getDescription());
			}
		}

	}

	/**
	 * Method that returns the Roach Colonies currently on the WaitList
	 * 
	 * @return WaitListRC the waitlist
	 */
	public WaitListRC currentWaitList()
	{
		return wlrc;
	}

	/**
	 * This method overrides the object's toString method
	 * 
	 * @return String displays Roach Motel characteristics
	 * @Override toString method
	 */
	/**
	 *
	 */
	public String toString()
	{
		StringBuffer sBuffer = new StringBuffer();
		/**
		 * If the roach motel has no more space, tell the user there's no more spaces
		 */
		if (roomList.size() == 0) 
		{
			sBuffer.append("----- NO VACANCY -----\nRooms Filled: " + tempTaken + " Available: " + roomList + "\n"
					+ "--------Guest Book---------");
			
			/** This displays the breakdown of each motel room */
			Set<Map.Entry<Integer, String>> roomDeets = details.entrySet();
			
			for (Map.Entry<Integer, String> entry : roomDeets) 
			{
				
				sBuffer.append("\nRoom " + entry.getKey() + " Details: " + entry.getValue());
				
			}
			
		} 
		else 
		{
			
			/** The string buffer introduces the basic stats of the roachmotel */
			sBuffer.append("\n\n----- Motel Vacancies ----- \nRooms Filled: " + tempTaken + " Available: "
					+ roomList + "\n" + "--------Guest Book---------");
			
			/** This displays the breakdown of each motel room */
			Set<Map.Entry<Integer, String>> roomDeets = details.entrySet();
			
			for (Map.Entry<Integer, String> entry : roomDeets) 
			{
				
				sBuffer.append("\nRoom " + entry.getKey() + " Details: " + entry.getValue());
				
			}
		}
		return sBuffer.toString();

	}
	
}
