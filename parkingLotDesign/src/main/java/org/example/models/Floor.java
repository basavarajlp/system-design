package org.example.models;

import org.example.models.enums.SlotStatus;
import org.example.models.enums.VehicleType;

import java.util.List;
import java.util.Optional;

public class Floor {

    private int id;
    private List<Slot> slots;
    private List<VehicleType> vehicleTypes;

    public boolean isVehicleTypeSupported(VehicleType type){
        return slots.stream().anyMatch(slot -> SlotStatus.FREE.equals(slot.getStatus()) && type.equals(slot.getVehicleType()));
    }

    public Optional<Slot> assignSlot(Vehicle vehicle){
        for(Slot slot: slots){
            if(SlotStatus.FREE.equals(slot.getStatus()) && vehicle.getType().equals(slot.getVehicleType())){
                return Optional.of(slot);
            }
        }
        return Optional.empty();
    }

    public long availableSlots(){
        return slots.stream().filter(slot -> SlotStatus.FREE.equals(slot.getStatus())).count();
    }
}
