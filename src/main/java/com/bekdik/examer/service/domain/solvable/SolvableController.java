package com.bekdik.examer.service.domain.solvable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.bekdik.examer.service.domain.exam.ExamDTO;
import com.bekdik.examer.service.domain.exam.ExamService;
import com.bekdik.examer.service.domain.solvable.*;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static org.springframework.boot.logging.LogLevel.ERROR;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600, methods = {RequestMethod.HEAD, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController("defaultSolvableController")
@RequestMapping("solvables")
public class SolvableController {
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private SolvableProvider solvableProvider;
    private SolvableService solvableService;
    private ExamService examService;
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

    @GetMapping
    public Collection<QuestionDTO> getDefaultSolvables() {
        try {
            return solvableService.getQuestionsOfExam();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

	/* @PostMapping

	public QuestionDTO createExam(@RequestBody QuestionDTO question) {
	try{
		return solvableService.createQuestion(question);
	}catch (Exception e){
		System.out.println("create exam failed");
		e.printStackTrace();
	}
return null;

	}*/

    @PostMapping

    public ExamDTO createExam(@RequestBody Collection<QuestionDTO> questionDTOLists, String owner) {
        try {
            return examService.createExam(questionDTOLists,owner);
        } catch (Exception e) {
            System.out.println("create exam failed");
            e.printStackTrace();
        }
        return null;

    }

}
