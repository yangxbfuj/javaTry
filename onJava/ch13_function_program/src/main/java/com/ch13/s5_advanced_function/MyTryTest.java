import java.util.function.Function;

public class MyTryTest{
	public static class Father{

		public String name;

		public Father(String name){
			this.name = name;
		}

		@Override 
		public String toString(){
			return "I'm Father, Name is " + name;
		}
	}

	public static class Mother{

		public String name;

		public Mother(String name){
			this.name = name;
		}

		@Override public String toString(){
			return "I'm Mother, Name is " + name;
		}	
	}

	public static class Kid{
		public String name;
		public Father father;
		public Mother mother;

		public Kid(String name, Father father, Mother mother){
			this.name = name;
			this.father = father;
			this.mother = mother;
		}

		@Override public String toString(){
			return String.format("I'm Kid, Name is %s, my father is %s, my mother is %s",name, father.name, mother.name);
		}	
	}

	static Function<Mother,Kid> myTry(Father father){
		return (mother) -> new Kid("HU", father, mother); 
	}

	public static void main(String[] args){
		Father father = new Father("Jack");
		Mother mother = new Mother("Rose");
		Function<Mother,Kid> justFather = myTry(father);
		Kid kid = justFather.apply(mother);
		System.out.println(kid);
		System.out.println("Father change his name to 'Ned'!");
		father.name = "Ned";
		System.out.println(kid);
		System.out.println("Mother change her name to 'Caitlin'!");
		mother.name = "Caitlin";
		System.out.println(kid);
	}
}