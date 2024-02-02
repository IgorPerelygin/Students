package entity;

import java.util.ArrayList;
import java.util.List;

public class Term {
    private int id;
    private String term;
    private String duration;
    private int status = 1;

    private List<Discepline>disceplines = new ArrayList<Discepline>();

    public Term() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Discepline> getDisceplines() {
        return disceplines;
    }

    public void setDisceplines(List<Discepline> disceplines) {
        this.disceplines = disceplines;
    }

    public Term(int id, String term, String duration, int status, List<Discepline> disceplines) {
        this.id = id;
        this.term = term;
        this.duration = duration;
        this.status = status;
        this.disceplines = disceplines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Term term1 = (Term) o;

        if (id != term1.id) return false;
        if (status != term1.status) return false;
        if (term != null ? !term.equals(term1.term) : term1.term != null) return false;
        if (duration != null ? !duration.equals(term1.duration) : term1.duration != null) return false;
        return disceplines != null ? disceplines.equals(term1.disceplines) : term1.disceplines == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (term != null ? term.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + (disceplines != null ? disceplines.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Term{" +
                "id=" + id +
                ", term='" + term + '\'' +
                ", duration='" + duration + '\'' +
                ", status=" + status +
                ", disceplines=" + disceplines +
                '}';
    }
}
