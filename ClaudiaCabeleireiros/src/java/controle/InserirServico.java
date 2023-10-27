package controle;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Servico;
import modelo.ServicoDAO;

public class InserirServico extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InserirServico</title>");
            out.println("</head>");
            out.println("<body>");

            String nome_servico = request.getParameter("nome_servico");
            String descricao = request.getParameter("descricao");
            String duracao = request.getParameter("duracao");
            double valor = Double.parseDouble(request.getParameter("valor"));

            if (nome_servico == null || nome_servico.equals("")) {
                out.print("O campo Nome deve ser preenchido!");
            } if (descricao == null || descricao.equals("")) {
                out.print("O campo Descrição deve ser preenchido!");
            } if (duracao == null || duracao.equals("")) {
                out.print("O campo Duração deve ser preenchido!");
            } if (valor <= 0) {
                out.print("O Valor deve ser acima de zero!");
            } else {
                try {
                    Servico servico = new Servico();
                    servico.setNome_servico(nome_servico);
                    servico.setDescricao(descricao);
                    servico.setDuracao(duracao);
                    servico.setValor(valor);
                    ServicoDAO servicoBD = new ServicoDAO();
                    servicoBD.conectar();
                    servicoBD.inserir(servico);
                    servicoBD.desconectar();
                    out.print("<script language='javascript'>");
                    out.print("alert('Serviço inserido com sucesso.');");
                    out.print("location.href='formInserirServico.jsp';");
                    out.print("</script>");
                } catch (Exception erro) {
                    out.print(erro);
                }

            }

            out.println("</body>");
            out.println("</html>");

        } finally { 
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
