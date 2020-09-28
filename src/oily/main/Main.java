package oily.main;

public class Main {

	public static void main(String[] args) {
		View view = new View();
		Data data = new Data();
		Controller controller = new Controller(view,data);
	}

}
