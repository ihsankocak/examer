package com.bekdik.examer.service.domain.exam;

import com.bekdik.examer.service.domain.solvable.QuestionDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600, methods = {RequestMethod.HEAD, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController("defaultExamController")
@RequestMapping("exam")
public class ExamController {
    private Logger logger = Logger.getLogger(this.getClass().getName());

    private ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping("/questions")
    public List<ExamDTO> createExamList(@RequestBody List<ExamDTO> examList, @RequestHeader("owner") String owner) throws Exception {

        return examService.createExamList(examList, owner);
    }

    @GetMapping("/custom/questions/{username}")
    public Collection<ExamDTO> getExamsByUsername(@PathVariable String username) throws Exception {
        return examService.getExamByUsername(username);
    }
}
