package com.neu.hm5.dao;

import com.neu.hm5.pojo.Question;

import java.util.ArrayList;

public class QuestionDao {

    Question q1 = new Question(1, "Which life cycle metod is  called  once in servlet life?",
            "class loading","init()","service()","destroy","B");
    Question q2 = new Question(2,"Which of these life-cycle method you can over-ride in your class?",
            "init()","service()","doGet()","All of these","D");
    Question q3 = new Question(3,"Which interface contain servlet life-cycle methods?",
            "HttpServlet","GenericServlet","Service","Servlet","D");
    Question q4 = new Question(4,"Which tag of DD maps internal name of servlet to public URL pattern?",
            "servlet","servlet-mapping","web-app","servlet-mappings","D");
    Question q5 = new Question(5,"Which method does not exists in HttpServlet Class?",
            "service","init","doGet","doPost","B");


    public ArrayList<Question> getQuestions(){
        return new ArrayList<Question>(){{
            add(q1);
            add(q2);
            add(q3);
            add(q4);
            add(q5);
        }};
    }
}
