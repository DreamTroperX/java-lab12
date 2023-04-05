package my.lab12.controller;

import lombok.AllArgsConstructor;
import my.lab12.beans.Logic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class TabulationController {

    private Logic logic;

    @PostMapping("/tabulation")
    public String tabulation(@RequestParam double a,@RequestParam  double h,@RequestParam  double begin,@RequestParam  double end, Model model){
        logic.fillGraphic(a,h,begin,end);
        model.addAttribute("maxIndexY",logic.maxIndexY());
        model.addAttribute("maxYNumber",logic.maxYNumber());
        model.addAttribute("maxXNumber",logic.maxXNumber());
        model.addAttribute("minIndexY",logic.minIndexY());
        model.addAttribute("minYNumber",logic.minYNumber());
        model.addAttribute("minXNumber",logic.minXNumber());
        model.addAttribute("sumY",logic.sumY());
        model.addAttribute("middleY",logic.midY());
        return "tabulation";
    }
}
