package com.app;

import com.app.Interfaces.TriFunction;

import java.util.function.BiFunction;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // BiFunction is used for creating a llambda with 2 args
    BiFunction<Integer, Integer, Integer> add = (t, u) -> t + u;

    TriFunction<Integer, Integer, Integer, Integer> addThree = (t, u, v, r) -> t + u + v;
}