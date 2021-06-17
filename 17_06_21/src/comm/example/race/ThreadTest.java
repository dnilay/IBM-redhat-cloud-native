package comm.example.race;

public class ThreadTest {

	public static void main(String[] args) {
		TwoString twoString=new TwoString();
		new PrintStringThread("Hello", "There",twoString);
		new PrintStringThread("How Are", "You?",twoString);
		new PrintStringThread("Thank You", "Very Much",twoString);

	}

}
