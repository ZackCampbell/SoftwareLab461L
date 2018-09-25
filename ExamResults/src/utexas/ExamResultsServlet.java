package utexas;


import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExamResultsServlet extends HttpServlet {
    private static final Logger _logger = Logger.getLogger(ExamResultsServlet.class.getName());

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Extract the input parameters
        String idNumber = req.getParameter("idnumber");
        _logger.info("Received a request for id number: " + idNumber);
        try {
            if (idNumber == null) throw new Exception("Must provide id number");
            if (!idNumber.isEmpty()) {
                populateData();

                req.getSession().setAttribute("result", getResult(idNumber));
                resp.sendRedirect("results.jsp");
            } else throw new Exception("Must provide id number");
        } catch (Exception e) {
            String logMsg = "Exception in processing request: " + e.getMessage();
            _logger.log(Level.INFO, logMsg);
            throw new IOException(logMsg);
        }
    }
    private ExamResult getDummyResult(String idNumber) {
        ExamResult toReturn = new ExamResult();
        toReturn.setIdNumber(idNumber);
        toReturn.setStudentName("Mary Eberlein");
        toReturn.setExam1Grade("100");
        toReturn.setExam2Grade("99");
        return toReturn;
    }

    private void populateData() {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Entity result1 = new Entity("ExamResult", "1");
        Entity result2 = new Entity("ExamResult", "2");
        Entity result3 = new Entity("ExamResult", "3");
        result1.setProperty("studentName", "Jim Doe");
        result1.setProperty("exam1Grade", "88");
        result1.setProperty("exam2Grade", "30");
        result2.setProperty("studentName", "Angelina Jolie");
        result2.setProperty("exam1Grade", "79");
        result2.setProperty("exam2Grade", "100");
        result3.setProperty("studentName", "Jane Doe");
        result3.setProperty("exam1Grade", "93");
        result3.setProperty("exam2Grade", "82");
        datastore.put(result1);
        datastore.put(result2);
        datastore.put(result3);
    }

    private ExamResult getResult(String idNumber) throws Exception {
        Key studentKey = KeyFactory.createKey("ExamResult", idNumber);
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Entity result = datastore.get(studentKey);
        return new ExamResult(idNumber, (String)result.getProperty("studentName"),
                (String)result.getProperty("exam1Grade"), (String)result.getProperty("exam2Grade"));
    }
}
