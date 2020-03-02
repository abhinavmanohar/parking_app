package utility;

import pojo.ParkingLot;
import pojo.ParkingSlot;
import pojo.Ticket;
import pojo.Vehicle;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

public class ParkingSystemApp {
    private static final Integer DEFAULTRATE = 10;
    private static final Integer HOURLY_RATE = 10;
    private static final String COLOR_WHITE = "White";
    /**
     * Launch the application.
     */
    private ArrayList<ParkingSlot> slots = null;
    ArrayList<Ticket> ticketList = null;
    ParkingSlot slot = null;

    private long startTimeMilliseconds;
    private long startTime = 0;
    private long endTimeMilliseconds;
    private String durationParked;
    private Date date;

    private static final double fee = 0.5; // Parking fee $0.5 for 15 minutes
    private static final int minimumTime = 15;
    int timeInMinutes = 0;
    private double totalFee = 0;


    public ParkingSystemApp()
    {
        ParkingLot lot = new ParkingLot();
        slots = lot.getParkingSlots();
        ticketList = new ArrayList(); // to save tickets
    }

    /**
     * This method checks for available parking slot and generates a ticket if slot is available
     *
     * @return Ticket object reference if there is a slot available or null if no slots available
     */
    public void park(String registration_number)
    {
        Vehicle vehicle=new Vehicle(registration_number,COLOR_WHITE);
        ParkingSlot slot = checkAvailability(); // check for available slots
        String status="Parking Full";
        if (slot != null)
        {
            Ticket ticket=new Ticket(vehicle,slot);
            ticketList.add(ticket);
            slot.setAvailability(false); // this slot is no more available
            status="Slot no "+slot.getSlotNumber()+" Occupied By vehicle No "+registration_number;
        }
        System.out.println(status);
    }


    /**
     *  This method checks for available slots in the parking lot
     *
     * @return slot if available or null if no slots are available
     */
    public ParkingSlot checkAvailability()
    {
        for(int i = 0; i < slots.size(); i++)
        {
            slot = slots.get(i);

            // check availability
            if(slot.getAvailability() == true)
            {
                return slot;
            }
        }
        return null;
    }
    
    public void leaveSlot(String registration_number_exit,Integer hours)
    {
        String registrationNumber="";
        Ticket ticket;
        for (int i = 0; i < ticketList.size(); i++)
        {
            ticket=ticketList.get(i);
            registrationNumber=ticket.getVehicle().getRegistration_number();

            if (registration_number_exit.equalsIgnoreCase(registrationNumber))
            {
                ticket.getSlot().setAvailability(true);
                ticket.setNumber_hours(hours);
                ticket=calculateAmount(ticket);
                System.out.println("Vehicle no "+ticket.getVehicle().getRegistration_number()+" has left the slot "+ticket.getSlot().getSlotNumber());
                System.out.println("Total Bill "+ticket.getAmount());
                break;
            }

        }
    }
    public void status(){
        ticketList.stream().filter(ticket -> ticket.getActive()==true).collect(Collectors.toList()).
                            forEach(ticket -> {System.out.println("Slot no "+ticket.getSlot().getSlotNumber()+" Occupied By vehicle No "+ticket.getVehicle().getRegistration_number());});
    }
    private Ticket calculateAmount(Ticket ticket) {
        Integer amount=DEFAULTRATE;
        Integer dummy_hours=ticket.getNumber_hours();
        if (ticket.getNumber_hours()>2){
            dummy_hours=dummy_hours-2;
            amount+=dummy_hours*HOURLY_RATE;
        }
        ticket.setAmount(amount);
        ticket.setActive(false);
        return ticket;
    }

}
