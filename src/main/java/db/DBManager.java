package db;

import constants.Constants;
import entity.Discepline;
import entity.Mark;
import entity.Student;
import entity.Term;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    public static List<Student> getAllActiveStudents(){
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student where status = '1'");

            while (rs.next()){
                Student st = new Student();
                st.setId(rs.getInt("id"));
                st.setSurname(rs.getString("surname"));
                st.setName(rs.getString("mane"));
                st.setGroup(rs.getString("groupe"));
                st.setDate(rs.getDate("date"));
                students.add(st);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return students;
    }

    public static List<Term> getAllActiveTerms(){
        ArrayList<Term> terms = new ArrayList<Term>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM term where status = '1'");

            while (rs.next()){
              Term term = new Term();
              term.setId(rs.getInt("id"));
              term.setTerm(rs.getString("name_of_tern"));
              terms.add(term);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return terms;
    }

    public static List<Mark> getMarksByStudentAndTerm(String idStudent, int idTerm){
        ArrayList<Mark> marks = new ArrayList<Mark>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT d.id, d.disciplina, m.mark FROM mark as m\n" +
                    "left join tern_disciplina as td on id_term_disciplina = td.id\n" +
                    "left join disciplina as d on td.id_disciplina = d.id\n" +
                    "where m.id_student = "+idStudent+" and td.id_term = "+idTerm);

            while (rs.next()){
             Mark mark = new Mark();
             mark.setMark(rs.getInt("mark"));
                Discepline discepline = new Discepline();
                discepline.setId(rs.getInt("id"));
                discepline.setDiscipline(rs.getString("disciplina"));
                mark.setDiscepline(discepline);

                marks.add(mark);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return marks;
    }


    public static void createStudent(String surname, String name, String group, String date){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute("INSERT INTO `student` (`surname`, `mane`, `groupe`, `date`) VALUES ('"+surname+"', '"+name+"', '"+group+"', '"+date+"');");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteStudent(String id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE `student` SET `status` = '0' WHERE (`id` = '"+id+"');");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Student getStudentById(String id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student where status = '1' and id = " + id);

            while (rs.next()){
                Student st = new Student();
                st.setId(rs.getInt("id"));
                st.setSurname(rs.getString("surname"));
                st.setName(rs.getString("mane"));
                st.setGroup(rs.getString("groupe"));
                st.setDate(rs.getDate("date"));
                return st;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static Term getTermById(String id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM term where status = '1' and id = " + id);

            while (rs.next()){
                Term term = new Term();
                term.setId(rs.getInt("id"));
                term.setTerm(rs.getString("name_of_tern"));
                return term;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    public static void modifyStudent(String id, String surname, String name, String group, String dateToDB) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
                Statement stmt = conn.createStatement();
                stmt.execute("UPDATE `student` SET `surname` = '"+surname+"', `mane` = '"+name+"', `groupe` = '"+group+"', `date` = '"+dateToDB+"' WHERE (`id` = '"+id+"');\n");
            }catch (Exception e){
                e.printStackTrace();

        }
    }

    public static boolean canLogin(String login, String password, String role){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(Constants.URL_TO_DB);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM user_role as ur\n" +
                    "left join user as u on ur.id_user = u.id\n" +
                    "where ur.id_role = "+role+" and u.login = '"+login+"' and u.password = '"+password+"'");

            while (rs.next()){
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

}
