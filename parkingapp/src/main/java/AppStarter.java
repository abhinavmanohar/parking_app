import pojo.Ticket;
import utility.ParkingSystemApp;

import java.io.*;
import java.util.Scanner;

public class AppStarter {
    public static void main(String args[]){
        /*ParkingSystemApp parkingSystemApp=new ParkingSystemApp();
        parkingSystemApp.park("MH12 LD 2350");
        parkingSystemApp.park("MH12 LD 2351");
        parkingSystemApp.park("MH12 LD 2352");
        parkingSystemApp.park("MH12 LD 2353");
        parkingSystemApp.park("MH12 LD 2354");
        parkingSystemApp.leaveSlot("MH12 LD 2351",5);
        parkingSystemApp.leaveSlot("MH12 LD 2354",2);
        parkingSystemApp.status();
        parkingSystemApp.park("MH12 LD 2300");*/
        try {
            System.out.println("Please Enter file name");
            Scanner q = new Scanner(System.in);
            BufferedReader br = new BufferedReader(new FileReader(q.next()));
            String st;
            ParkingSystemApp parkingSystemApp=new ParkingSystemApp();
            while ((st = br.readLine()) != null)
            {
                String []lineTuples={};
                lineTuples=st.split(" ");
                switch (lineTuples[0]){
                    case "create_slot" :System.out.println(lineTuples[1]);
                        break;
                    case "park" :
                        System.out.println(lineTuples[1]);
                       parkingSystemApp.park(lineTuples[1]);
                       break;
                    case "leave" :
                        parkingSystemApp.park(lineTuples[1]);
                        parkingSystemApp.leaveSlot(lineTuples[1],Integer.parseInt(lineTuples[2]));
                        break;
                    case "status" :
                        System.out.println(lineTuples[0]);
                        parkingSystemApp.status();
                        break;
                    default:System.out.println("Invalid Tuple");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

