package com.example.demo.Service;
/*
   Reynaldo Silva
   Music Theory Application
   March 2024
*/

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MusicScale {

    private String[] notes     = {"A", "A#", "B", "C", "C#", "D",
                                  "D#", "E", "F", "F#", "G", "G#"};
    private String[] notesFlat = {"A", "B♭", "B", "C", "D♭", "D",
                                  "E♭", "E", "F", "G♭", "G", "A♭"};
    private final int W = 2;
    private final int H = 1;
    private String accidental;
    private boolean isSharp;

    public String getAccidental() {
        return accidental;
    }

    public void setAccidental(String accidental) {
        this.accidental = accidental;
    }

    public void verify(){
        System.out.println("Verified bean");
    }


    public boolean isSharp() {
        return isSharp;
    }

    public void setSharp(boolean sharp) {
        isSharp = sharp;
    }

    // 7 MODES IN MUSIC             -- BELOW --
    private final int[] ionian     = {W, W, H, W, W, W, H}; // 1st Mode - Major
    private final int[] dorian     = {W, H, W, W, W, H, W}; // 2nd Mode - Minor
    private final int[] phrygian  = {H, W, W, W, H, W, W}; // 3rd Mode - Minor
    private final int[] lydian     = {W, W, W, H, W, W, H}; // 4th Mode - Major
    private final int[] mixolydian = {W, W, H, W, W, H, W}; // 5th Mode - Major
    private final int[] aeolian    = {W, H, W, W, H, W, W}; // 6th Mode - Minor
    private final int[] locrian    = {H, W, W, H, W, W, W}; // 7th Mode - Minor
    private int root;
    private String result;
    private int[] mode;
    public String ionian(String key, String scales){

        root = Arrays.binarySearch(notes, key);
        result = notes[root];
        result += " - ";


        scales = scales.toUpperCase();

        switch(scales){
            case "IONIAN":
                System.out.println("MODE IONIAN");
                mode = ionian;
                break;
            case "DORIAN":
                System.out.println("MODE DORIAN");
                mode = dorian;
                break;
            case "PHRYGIAN":
                System.out.println("MODE PHRYGIAN");
                mode = phrygian;
                break;
            case "LYDIAN":
                System.out.println("MODE LYDIAN");
                mode = lydian;
                break;
            case "MIXOLYDIAN":
                System.out.println("MODE MIXOLYDIAN");
                mode = mixolydian;
                break;
            case "AEOLIAN":
                System.out.println("MODE AEOLIAN");
                mode = aeolian;
                break;
            case "LOCRIAN":
                System.out.println("MODE LOCRIAN");
                mode = locrian;
                break;
            default:
                System.out.println("MODE UNKNOWN -> USE MAJOR KEY");
                mode = ionian;
                break;
        }


        for(int i = 0; i < 6; i++){
            System.out.println("result is " + result + "before the loop.");
            result += notes[(root + mode[i])%12];
            if(i !=5){result += " - ";}
            root = (root + mode[i]) % 12;
            System.out.println("result is " + result + "after the loop.");
        }

        System.out.println("Starting note is : " + notes[root]);


        return result;
    }

    @Override
    public String toString() {
        return "MusicScale{" +
                "isSharp=" + isSharp +
                '}';
    }
}
