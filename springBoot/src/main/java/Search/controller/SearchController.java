package Search.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collections;

@Controller
public class SearchController {
    @RequestMapping("/")
    public String home(){
        return "searchPage";
    }

    @RequestMapping("/result")
    public String hello(@RequestParam(value = "search",defaultValue = "master") String search, Model model){
        model.addAttribute("search",search);
        return "resultPage";
    }
    @RequestMapping(value = "/postSearch", method = RequestMethod.POST)
    public String postSearch(HttpServletRequest request, RedirectAttributes redirectAttributes){
        String search = request.getParameter("search");
        redirectAttributes.addAttribute("search",search);
        return "redirect:result";


    }
}
