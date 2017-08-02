/**
 * Created by Zach on 7/24/17.
 */
public class Main {
    public static void main(String[] args) {

        Smartphone phone1 = new Smartphone();
        Smartphone phone2 = new Smartphone();

        phone1.volumeUp();
        phone2.volumeUp();


        if(phone1.compareTo(phone2) == 1){
            System.out.println("phone 1 wins");
        }else if (phone1.compareTo(phone2) == -1){
            System.out.println("phone 2 wins");
        }else System.out.println("its a tie");
    }
}
