import java.util.UUID;

public class Split {
    public static void main(String[] args) {
        String string = "0,0,4-0,3,4-5,5,6";
        String[] parts = string.split("-");
        String[] number = parts[0].split(",");
        for (int i = 0; i < number.length; i++) {
            System.out.println(number[i]);
        }


        System.out.println(UUID.randomUUID().toString().length());
    }
}
