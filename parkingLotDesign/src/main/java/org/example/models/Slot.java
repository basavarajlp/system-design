package org.example.models;

import lombok.Data;
import org.example.models.enums.SlotStatus;
import org.example.models.enums.VehicleType;

@Data
public class Slot {

    private int id;
    private SlotStatus status;
    private VehicleType vehicleType;
    private Vehicle vehicle;
}
