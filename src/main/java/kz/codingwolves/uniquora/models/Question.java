package kz.codingwolves.uniquora.models;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sagynysh on 12/30/16.
 */
@Entity
@Table(name="questions", uniqueConstraints={@UniqueConstraint(columnNames = {"title_", "course_"})})
public class Question extends PersistentUnit {

    @Column(name="title_")
    private String title;

    @Column(name="text_", columnDefinition="TEXT")
    private String text;

    @Column(name="rating_")
    private Integer rating;

    @ManyToOne
    @JoinColumn(name="creator_")
    private User creator;

    @ManyToOne
    @JoinColumn(name="course_")
    private Course course;

    @Column(name="is_anonymous_")
    private Boolean isAnonymous;

    @Transient
    private List<Answer> answers;

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        isAnonymous = anonymous;
    }
}
