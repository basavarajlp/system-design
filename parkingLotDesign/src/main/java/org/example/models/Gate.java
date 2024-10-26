package org.example.models;

import lombok.Data;

@Data
public abstract class Gate {

    private int id;
    private Operator operator;

}
