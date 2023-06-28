import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CurrencyConversionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double amount = Double.parseDouble(request.getParameter("amount"));
        String sourceCurrency = request.getParameter("sourceCurrency");
        String targetCurrency = request.getParameter("targetCurrency");

        // Perform currency conversion logic here
        double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);

        // Prepare the response
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.write(String.valueOf(convertedAmount));
        out.close();
    }

    private double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        // Implement your currency conversion logic here using exchange rates
        // You can fetch exchange rates from an external API or database
        // For simplicity, we'll use a static conversion rate
        double conversionRate = 1.5; // Sample conversion rate
        return amount * conversionRate;
    }
}
