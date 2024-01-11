package com.bekdik.examer.service.domain.solvable;

import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600, methods = {RequestMethod.HEAD, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController("defaultSolvableController")
@RequestMapping("solvables")
public class SolvableController {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private SolvableProvider solvableProvider;
    private SolvableService solvableService;

    public SolvableController(SolvableProvider solvableProvider, SolvableService solvableService) {
        super();
        this.solvableProvider = solvableProvider;
        this.solvableService = solvableService;
    }

    public static void main(String[] args) {
        List<String> s1 = new ArrayList<>();
        s1.add("a");
        s1.add("b");
        List<String> s2 = new ArrayList<>(s1);
        System.out.println(s2.size());
        s2.set(0, "c");
        System.out.println(s1);
        System.out.println(s2);
    }



    @PutMapping("{solvableId}/answer/{answer}")

    public boolean answer(@PathVariable("solvableId") long solvableId, @PathVariable("answer") @NotNull String answer) {
        try {
            String solution = solvableService.getQuestionById(solvableId).getSolution();
            return answer.equals(solution);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }





}
