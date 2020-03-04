package pojo;

import java.util.ArrayList;

public class ParkingLot
{
    private int numberOfSlots;

    private ArrayList<ParkingSlot> listOfSlots = null;

    public ParkingLot(Integer numberOfSlots)
    {
        this.numberOfSlots=numberOfSlots;
        listOfSlots = new ArrayList();
    }

    /**
     * This method returns list of all the parking slots
     *
     * @return list of the slots in the parking lot
     */
    public ArrayList<ParkingSlot> getParkingSlots()
    {
        for (int i = 1; i <= this.numberOfSlots; i++)
        {
            ParkingSlot slot = new ParkingSlot(i, true);
            listOfSlots.add(slot);
        }
        return listOfSlots;
    }

}