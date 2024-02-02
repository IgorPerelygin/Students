package controllers;

import db.DBManager;
import entity.Mark;
import entity.Student;
import entity.Term;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "StudentProgressController", urlPatterns = "/student-progress")

public class StudentProgressController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStudent = req.getParameter("studentProgressHidden");
        // передаётся при нажатии кнопки "выбрать" внутри страницы
        String idSelectedTerm = req.getParameter("idSelectedTerm");

        Student student = DBManager.getStudentById(idStudent);
        req.setAttribute("student", student);

        List<Term> terms = DBManager.getAllActiveTerms();
        req.setAttribute("terms", terms);

        Term selectedTerm = null;
        if (idSelectedTerm != null){ // отработает еслти нажали выбрать
            selectedTerm = DBManager.getTermById(idSelectedTerm);
        } else { // нажали на успеваемость
            if (terms.size() != 0) {
                selectedTerm = terms.get(0);
            }
        }

        req.setAttribute("selectedTerm", selectedTerm);

        List<Mark> marks = DBManager.getMarksByStudentAndTerm(idStudent, selectedTerm.getId());
        req.setAttribute("marks", marks);

        double summ = 0;
        for(Mark m: marks){
            summ = summ + m.getMark();
        }
        if(marks.size() !=0) {

            req.setAttribute("average", summ / marks.size());
        }

        req.getRequestDispatcher("WEB-INF/student-progress.jsp").forward(req, resp);

    }
}
