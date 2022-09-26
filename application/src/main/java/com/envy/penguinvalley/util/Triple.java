package com.envy.penguinvalley.util;


import lombok.Data;

@Data
public class Triple <T1, T2, T3>{

    private T1 first;
    private T2 second;
    private T3 third;

    public Triple(T1 first, T2 second, T3 third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

}
