package com.bekdik.examer.service.domain.exam;

import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600, methods = {RequestMethod.HEAD, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController("defaultExamController")
@RequestMapping("exams")
public class ExamController {
    private Logger logger = Logger.getLogger(this.getClass().getName());

private  ExamService examService;
    public ExamController(ExamService examService){
        this.examService=examService;

    }

    @PostMapping

    public ExamDTO createExam(@RequestBody ExamDTO examDTO) {
        try {
            return examService.createExam(examDTO);
        } catch (Exception e) {
            System.out.println("create exam failed");
            e.printStackTrace();
        }
        return null;

    }


}
