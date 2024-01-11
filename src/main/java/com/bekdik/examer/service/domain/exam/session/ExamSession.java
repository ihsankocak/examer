package com.bekdik.examer.service.domain.exam.session;

import com.bekdik.examer.application.auth.client.user.ApplicationUser;
import com.bekdik.examer.service.domain.solvable.BaseSolvable;
import com.bekdik.examer.service.domain.solvable.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.data.util.Pair;

import java.util.Collection;
import java.util.List;
import java.util.Map;
@Entity
@Getter
@Setter
public class ExamSession<P,S> {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(
            name="examsession_student_junction",
            joinColumns = {@JoinColumn(name="exam_session_id")},
            inverseJoinColumns = {@JoinColumn(name="student_id")}
    )
    @Getter
    @Setter
    private Collection<ApplicationUser> students;
    private ApplicationUser teacher;

}
