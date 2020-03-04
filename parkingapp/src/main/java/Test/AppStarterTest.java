package Test;

import org.junit.Test;
import utility.ParkingSystemApp;

import java.io.*;
import java.util.Scanner;


import static org.junit.Assert.assertEquals;

public class AppStarterTest {
    @Test
    public void FileReadFormat() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("E:/inputfile.txt"));
            String st;
            while ((st = br.readLine()) != null) {
                String[] lineTuples = {};
                lineTuples = st.split(" ");
                switch (lineTuples[0]) {
                    case "create_slot":
                        assertEquals(lineTuples.length,2);
                        //assertEquals(lineTuples[1].getClass(),Integer.class);
                        break;
                    case "park":
                        assertEquals(lineTuples.length,2);
                        break;
                    case "leave":
                        assertEquals(lineTuples.length,3);
                        break;
                    case "status":
                        assertEquals(lineTuples.length,1);
                        break;
                    default:
                        System.out.println("Invalid Tuple");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
