package com.example.demo.Service;
/*
   Reynaldo Silva
   Music Theory Application
   March 2024
*/

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MusicScale {

    private String[] notes     = {"A", "A#", "B", "C", "C#", "D",
                                  "D#", "E", "F", "F#", "G", "G#"};
    private String[] sharps2   = {"A", "A#", "B", "C", "C#", "D",
                                  "D#", "E", "E#", "F#", "G", "G#"};
    private String[] sharps3   = {"A", "A#", "B", "B#", "C#", "D",
                                  "D#", "E", "E#", "F#", "G", "G#"};
    private String[] notesFlat1 = {"A", "B♭", "C♭","C", "D♭", "D",
                                   "E♭", "E", "F", "G♭", "G", "A♭"};
    private String[] notesFlat2 = {"A", "B♭", "B/C♭","C", "D♭", "D",
                                   "E♭", "E/F♭", "F", "G♭", "G", "A♭"};
    private String[] notesFlat3 = {"A", "B♭", "B/C♭","C", "D♭", "D",
                                   "E♭", "E/F♭", "F", "G♭", "G", "A♭"};
    // need to resolve double sharp issue.
    // fixing git account
    // changed user name

    private final int W = 2;
    private final int H = 1;

    private boolean isSharp = true;

    // 7 MODES IN MUSIC             -- BELOW --
    private final int[] ionian     = {W, W, H, W, W, W, H}; // 1st Mode -
    private final int[] dorian     = {W, H, W, W, W, H, W}; // 2nd Mode -
    private final int[] phrygian   = {H, W, W, W, H, W, W}; // 3rd Mode -
    private final int[] lydian     = {W, W, W, H, W, W, H}; // 4th Mode -
    private final int[] mixolydian = {W, W, H, W, W, H, W}; // 5th Mode -
    private final int[] aeolian    = {W, H, W, W, H, W, W}; // 6th Mode -
    private final int[] locrian    = {H, W, W, H, W, W, W}; // 7th Mode -
    //private int root;
    //private String result;
    private int[] mode;
    private String accidental;
    //----------------------------------------------------------------------------------------------------------------//
    //                                  METHODS LISTED BELOW || FIELDS LISTED ABOVE
    //----------------------------------------------------------------------------------------------------------------//
    public String ionian(String key, String scale){
        int root = -1;
        mode = matchScale(scale);

        if(key.contains("#")){
            //then use sharp list
            accidental = "SHARP";
        }
        else if(key.contains("♭")){
            // then use flat array
            accidental = "FLAT";
            notes = notesFlat1;
        }
        else{
            // its unknown
            accidental = "UNKNOWN";
        }

        List<String> list = Arrays.asList(notes);
        root = list.indexOf(key);

        return verifyNotes(getNotes(mode,root), root, accidental);
    }

    public String verifyNotes(String s, int root, String accidental){

        if(accidental.equals("SHARP")) {
            if (s.contains("C") & s.contains("F")) {
                notes = sharps3;
                return getNotes(mode, root);
            } else if (s.contains("F") & s.contains("A#")) {
                notes = sharps2;
                return getNotes(mode, root);
            }
            else{
                return s;
            }
        } else if (accidental.equals("FLAT")) {
            return getNotes(mode, root);
        }
        return s;
    }
    public String getNotes(int[] mode, int root) {

        String results = notes[root];
        results += " - ";

        for (int i = 0; i < 6; i++) {
            System.out.println("result is " + results + "before the loop.");
            results += notes[(root + mode[i]) % 12];
            if (i != 5) {
                results += " - ";
            }
            root = (root + mode[i]) % 12;
            System.out.println("result is " + results + "after the loop.");
        }
        return results;
    }

    public int[] matchScale(String scale){

        scale = scale.toUpperCase();

        switch(scale){
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
        return mode;
    }

    @Override
    public String toString() {
        return "MusicScale{" +
                "isSharp=" + isSharp +
                '}';
    }
}
