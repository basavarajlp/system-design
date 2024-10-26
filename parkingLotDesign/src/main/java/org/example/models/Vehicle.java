package org.example.models;

import lombok.Data;
import org.example.models.enums.VehicleType;

@Data
public class Vehicle {
    private int id;
    private int regNo;
    private VehicleType type;
}
