package main.utils;

import main.capturetheflag.Map;
import org.bukkit.Color;

public class Variables {

    // In this class global variables will be stored that will be used in multiple different classes and methods

    public static Map currentMap; // Map object of the currently active map
    public static Map[] maps = new Map[0]; // All the maps there are

    // The following variables are set via a command and will be used to create a map.
    public static int[] pos1 = new int[3]; // Selectable position 1
    public static int[] pos2 = new int[3]; // Selectable position 2

}
