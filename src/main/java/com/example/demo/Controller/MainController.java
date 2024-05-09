package com.example.demo.Controller;

import com.example.demo.Service.MusicScale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {

    /*
    @Autowired
    MusicScale musicScale;
     */

    @RequestMapping("/home")
    public String home(){ return "home"; }

    @RequestMapping("/contacts")
    public String contacts(){
        return "contacts";
    }

    @GetMapping("/music")
    public String music(@Autowired MusicScale musicScale, Model model){
        //MusicScale musicScale = new MusicScale();
        //musicScale.verify();

        model.addAttribute("musicScale", musicScale);
        return "music";
    }

    @PostMapping("/music")
    public String addAnswer(@RequestParam("musicNotes") String note,
                            @RequestParam("musicScales")String scale,
                            @ModelAttribute("musicScale") MusicScale musicScale,
                            //@RequestParam("accidental") String accidental,
                            Model model){
        //System.out.println("Accidental is : " + accidental);
        System.out.println("The note chosen was "+ note);
        System.out.println("The scale chosen was " + scale);
        System.out.println("I am sending the argument to the music Scale class.");
        System.out.println("Accidental is : " + musicScale.getAccidental());
        String mode = musicScale.ionian(note, scale);
        model.addAttribute("answer", mode);
        return "/music";
    }

    @ModelAttribute
    public void addNotes(Model model){
        List<String> notes = Arrays.asList( "A♭","A","A#","B♭","B",
                                            "B#","C♭","C","C#","D♭",
                                            "D","D#","E♭","E","E#",
                                            "F♭","F","F#","G♭","G","G#");

        List<String> sharpNotes = Arrays.asList("C","C#","D","D#","E","F","F#","G","G#","A","A#","B");
        List<String> flatNotes  = Arrays.asList("C","D♭","D","E♭","F♭","F","G♭","G","A♭","A","B♭","B");
        model.addAttribute("musicNotes", notes);
        model.addAttribute("flatNotes", flatNotes);
    }

    @ModelAttribute
    public void addScales(Model model){
        String[] musicScales = {"Ionian", "Dorian", "Phrygian", "Lydian", "Mixolydian",
                "Aeolian", "Locrian"};
        model.addAttribute("musicScales", musicScales);
    }

    @ModelAttribute
    public void addAccidental(Model model){

        String accidental = "false";
        model.addAttribute("acc", accidental);
    }
}
