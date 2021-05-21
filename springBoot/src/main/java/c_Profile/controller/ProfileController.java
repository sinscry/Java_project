package c_Profile.controller;

import c_Profile.date.USLocalDateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class ProfileController {
   @RequestMapping(value = {"/profile","/"},method = RequestMethod.GET)
    public String displayProfile(ProfileForm profileForm){
       return "profile/profilePage";
   }
   @RequestMapping(value = "/profile",method = RequestMethod.POST)
    public String saveProfile(@Valid ProfileForm profileForm, BindingResult bindingResult){
       System.out.println("save ok " + profileForm.getBirthDate());
       if (bindingResult.hasErrors()){
           System.out.println("error");
           return "profile/profilePage";
       }
       System.out.println("save ok" + profileForm.getEmail());
       return "redirect:/profile";
   }
   @ModelAttribute("dateFormat")
    public String localeFormat(Locale locale){
       return USLocalDateFormatter.getPattern(locale);
   }
}
