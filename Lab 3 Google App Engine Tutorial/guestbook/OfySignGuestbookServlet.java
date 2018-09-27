// URL: https://20180926t143216-dot-ee461l-lab3.appspot.com/ofyguestbook.jsp

package guestbook;

import static com.googlecode.objectify.ObjectifyService.ofy;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class OfySignGuestbookServlet extends HttpServlet {



    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        UserService userService = UserServiceFactory.getUserService();

        User user = userService.getCurrentUser();

        // We have one entity group per Guestbook with all Greetings residing
        // in the same entity group as the Guestbook to which they belong.
        // This lets us run a transactional ancestor query to retrieve all
        // Greetings for a given Guestbook.  However, the write rate to each
        // Guestbook should be limited to ~1/second.

        String guestbookName = req.getParameter("guestbookName");
        String content = req.getParameter("content");
        Greeting greeting = new Greeting(user, content, guestbookName);
//        Guestbook g = ofy().load().key(greeting.guestbookName).now();
        Date date = new Date();
//
//        Entity greeting = new Entity("Greeting", guestbookKey);
//        greeting.setProperty("user", user);
//        greeting.setProperty("date", date);
//        greeting.setProperty("content", content);

//        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
//        datastore.put(greeting);
        ofy().save().entity(greeting).now();   // synchronous
        resp.sendRedirect("/ofyguestbook.jsp?guestbookName=" + guestbookName);

    }

}