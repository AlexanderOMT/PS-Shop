
package controller;

import controller.command.FrontCommand;
import controller.command.UnknownCommand;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Catalog;
import model.Persistence.ProductArchiveLoader;


@WebServlet(name = "FrontController", 
            urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    private Catalog catalog;
    
    @Override
    public void init() {
        
        catalog = new Catalog();
        // TODO String url = context.getRealPath("books_url.json"); <- jsp ¿?
        // String url = this.getServletContext().getRealPath("books_url.json");
        String url = "C:\\Users\\oscar\\Documents\\NetBeansProjects\\Shop\\books_ulr.json";
        ProductArchiveLoader loader = new ProductArchiveLoader(url);
        catalog.setListProduct(loader.loadAllProduct());
        
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        
        response.setContentType("text/html;charset=UTF-8");
 
        request.setAttribute("catalog", catalog.getCatalog());
        RequestDispatcher dispatcher = request.getRequestDispatcher("CatalogView.jsp");
        dispatcher.forward(request, response);
        
        FrontCommand command = getCommand(request);
        command.init(this.getServletContext(), request, response);
        command.process();
        
    }

    
    
    private FrontCommand getCommand(HttpServletRequest request) throws Exception{
        
        try{                    
            FrontCommand frontCommand = (FrontCommand) getCommandClass(request).newInstance();
            return frontCommand;
        } catch (IllegalAccessException | InstantiationException e) {
            throw new Exception(e);
        }
        
    }
    
    
    private Class getCommandClass(HttpServletRequest request){
    
        Class result;
        final String command = "controller.command."+(String)request.getParameter("command");
        try {
            result = Class.forName(command);
        } catch(ClassNotFoundException e) {
            result = UnknownCommand.class;
        }
        return result;
    
    }

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
