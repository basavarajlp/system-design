package org.example.models;


import org.example.models.enums.SlotStatus;

import java.util.List;
import java.util.Objects;

public class ParkingLot {

    private List<Floor> floors;

    public Slot assignSlot(Vehicle vehicle){
        if(Objects.isNull(vehicle))return null;
        Slot slot = null;
        for(Floor floor:floors){
            if(floor.isVehicleTypeSupported(vehicle.getType())){
                slot = floor.assignSlot(vehicle).orElse(null);
            }
        }
        if(Objects.nonNull(slot)){
            slot.setVehicle(vehicle);
            slot.setStatus(SlotStatus.OCCUPIED);
        }
        return null;
    }

}
