package class_lab;

public class ClassLabClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Create a bunch of ClassLab objects.  This uses both empty constructors
		// and constructors with parameters
		ClassLab classLab = new ClassLab();
		ClassLab classLabJames = new ClassLab("James", 38, "Pro Soccer player");
		ClassLab classLabPenelope = new ClassLab ("Pepe", 4, "Ballerina");
		
		// This is using the accessor methods
		String uncleName = classLabJames.getName();
		
		// This prints out the name set when creating a new object
		System.out.println (uncleName);
		
		// This is using the field variables with an "empty" constructor
		System.out.println (classLab.getName());
		System.out.println (classLab.getAge());
		System.out.println (classLab.getProfession());
		
		// This is using the accessor methods in ClassLab to do some 
		// comparison
		if (classLabPenelope.getAge() > classLabJames.getAge()) {
			System.out.println ("penelope is older?");
		} else {
			System.out.println ("James is " + (classLabJames.getAge() - 
					            classLabPenelope.getAge()) + " years older"); 
		}
		
		// this calls the method getAgeDifference which will return the
		// age difference between me and my niece
		int difference = classLabJames.getAgeDifference(classLabPenelope);
		
		System.out.println ("difference = " + difference);
		
		// This is printing out the object. This calls toString() even though
		// its not called directly.  Try printing without a toString() method 
		// in ClassLab.  What does it print?
		System.out.println (classLabJames);
		
		// This is using static method.  Look that I don't use new to access
		// the object.  I just use the class name and then the variable name.
		String name = ClassLab.relation;
	
		// Print out the name
		System.out.println (name);
		
		// This uses the static accessor method getRelation.  Notice that again
		// I don't need to create an object to access field variables.
		
		String relation = ClassLab.getRelation();
		
		System.out.println (relation);
	}
}
