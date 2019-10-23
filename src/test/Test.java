import java.io.File;

public class Test {
    public static void main(String[] args) {
        File temp = new File("C:\\Users\\azraf\\Downloads\\Test\\tada.txt");

        if (temp.exists()) {
            System.out.println("Deleting " + temp.getName());
            temp.delete();
        }
    }
}
