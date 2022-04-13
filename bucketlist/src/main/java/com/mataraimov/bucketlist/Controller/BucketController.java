package com.mataraimov.bucketlist.Controller;



import com.mataraimov.bucketlist.Entity.Target;
import com.mataraimov.bucketlist.Repository.TargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
public class BucketController {

    @Autowired
    private TargetRepository targetRepository;



    @GetMapping({"/main","/"})
    public ModelAndView getMainPage(){
        ModelAndView mav = new ModelAndView("list-targets");
        mav.addObject("targets",targetRepository.findAll());
        return mav;
    }
    @GetMapping("/add")
    public ModelAndView yes(){
        ModelAndView modelAndView = new ModelAndView("form");
        Target target = new Target();
        modelAndView.addObject("target", target);
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("target") Target target){
        targetRepository.save(target);
        return "redirect:/main";
    }
}
