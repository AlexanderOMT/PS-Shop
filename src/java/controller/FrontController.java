
package controller;

import controller.command.FrontCommand;
import controller.command.UnknownCommand;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.UnavailableException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Catalog;
import model.Persistence.ProductArchiveLoader;
import model.Product;


@WebServlet(name = "FrontController", 
            urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    private Catalog catalog;
    
    @Override
    public void init() {
        
        catalog = new Catalog();
        ProductArchiveLoader loader = new ProductArchiveLoader("C:\\Users\\oscar\\Documents\\Projects\\Netbeans\\Shop\\books_ulr.json");
        catalog.setListProduct(loader.loadAllProduct());
        
    }


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
 
        request.setAttribute("catalog", catalog.getCatalog());
        RequestDispatcher dispatcher = request.getRequestDispatcher("CatalogView.jsp");
        dispatcher.forward(request, response);
        
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
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
