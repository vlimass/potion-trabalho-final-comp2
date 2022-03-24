/*
Tema 6 - Editor de texto e outros conteúdos.
Integrantes:

        Igor Queiroz de Oliveira
        DRE:121066452
        Vinícius Lima da Silva Santos
        DRE: 121051334
        Rayane Domingos Bernardino
        DRE: 121094489

  /!\   ATENÇÃO, PROFESSOR!!!  /!\
      Se o CSS da página estiver bugado é só MEXER NO ZOOM DO NAVEGADOR. Esse problema é devido
      à diferença da resolução de tela dos nossos computadores e não conseguimos achar nenhuma solução cabível
      para tal empecilho.

      Espero que entenda...

      Gratidão.
 */
package com.example.trabalhofinal;

import javax.ws.rs.*;

@Path("/fonte")
public class FonteResource {
    @GET
    @Produces("text/html")
    public String fonte(@QueryParam("posicao") @DefaultValue("") String posicao_bloco) {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"pt-BR\">\n" +
                "    <head>\n" +
                "        <meta charset = \"UTF-8\">\n" +
                "        <meta http-equiv= \"X-UA-Compatible\" content = \"IE=edge\">\n" +
                "        <meta name = \"viewport\" content = \"width=device-width, initial-scale=1.0\">\n" +
                "        <title>Selecione a fonte</title>\n" +
                //FAVICON:
                "   <link rel=\"shortcut icon\" href=\"https://media.discordapp.net/attachments/890312701123895377/949731505540845638/icon_2.png\" type=\"image/x-icon\">"+
                // CSS:
                "$cssStyle\n" +
                //FONTS:
                "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
                "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
                "<link href=\"https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,400;0,700;1,100;1,400;1,700&family=Sansita+Swashed:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">" +
                "    </head>\n" +
                "    <body>\n" +
                "    <main>\n" +
                "    <div class=\"content\">\n" +
                "        <div>$htmlForm</div>\n" +
                "        <a href = \"editar?posicao=$posicao_bloco\" class=\"voltar\">Voltar</a>" +
                "    </div>" +
                "    </main>\n" +
                "    </body>\n" +
                "</html>";

        html = html.replace("$cssStyle", cssStyle());
        html = html.replace("$htmlForm", htmlForm(posicao_bloco));
        html = html.replace("$posicao_bloco", posicao_bloco);

        return html;
    }

    public String htmlForm(String posicao_bloco) {
        String formhtml = " <form method=\"GET\" action=\"editarfonte\">\n" +
                "   <input type=\"hidden\" value=\""+ posicao_bloco +"\" name=\"posicao\"> \n" +
                "   <div class=\"label\"> <label for=\"fonte\">Selecione a fonte desejada: </label> </div>\n" +
                "   <div class=\"buttons\">" +
                "   <div class=\"buttons-block\"> <button type=\"submit\" id=\"fonte\" name=\"fonte\" value=\"Arial\" style=\"font-family: Arial\">Sans-serif (padrão)</button>\n" +
                "   <button type=\"submit\" id=\"fonte\" name=\"fonte\" value=\"Georgia\" style=\"font-family: Georgia\">Serif</button> </div>\n" +
                "   <div class=\"buttons-block\"> <button type=\"submit\" id=\"fonte\" name=\"fonte\" value=\"Courier New\" style=\"font-family: Courier New\">Monospace</button>\n" +
                "   <button type=\"submit\" id=\"fonte\" name=\"fonte\" value=\"Brush Script MT\" style=\"font-family: Brush Script MT\">Cursive</button> </div>\n" +
                "   </div>" +
                "   </form>";
        return formhtml;
    }

    private String cssStyle() {
        String html = "<style>\n" +
                "* {\n" +
                "    margin: 0;\n" +
                "    padding: 0;\n" +
                "    border: none;\n" +
                "    text-decoration: none;\n" +
                "    box-sizing: border-box;\n" +
                "}\n" +
                "\n" +
                "body {\n" +
                "    background-color: #e85f63ab;\n" +
                "}\n" +
                "\n" +
                "main {\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "    background-color: rgba(63, 1, 66, 0.76);\n" +
                "\n" +
                "    height: 90vh;\n" +
                "    width: 50vw;\n" +
                "    margin: auto;\n" +
                "    margin-top: 1.25rem;\n" +
                "    border-radius: 8px;\n" +
                "}\n" +
                "\n" +
                ".content {\n" +
                "    display: flex;\n" +
                "    flex-direction: column;\n" +
                "    align-items: center;" +
                "    padding: 2.5rem" +
                "}\n" +
                ".buttons-block {\n" +
                "    display: flex;\n" +
                "    align-items: center;" +
                "    justify-content: space-between;" +
                "    margin-bottom: 2.75rem;" +
                "}\n" +
                ".buttons {\n" +
                "    margin-bottom: 9rem;\n" +
                "    width: 40vw;\n" +
                "}\n" +
                ".label {\n" +
                "    font-size: 2rem;\n" +
                "    color: #f3f3f3;\n" +
                "    margin-bottom: 4.5rem;\n" +
                "    text-align: center;" +
                "}\n" +
                "button {\n" +
                "    text-align: center;\n" +
                "    background-color: #f3f3f3b4; \n" +
                "    color: rgba(63, 1, 66, 0.827);\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "    font-size: 1.75rem;\n" +
                "    border: solid rgba(54, 54, 54, 0) 2px;\n" +
                "    border-radius: 15px;\n" +
                "    padding: 1.75rem 1rem;\n" +
                "    min-width: 17rem;\n" +
                "}\n" +
                "button:hover {\n" +
                "    background-color: rgba(242, 242, 242, 0.9);\n" +
                "    transition: 0.2s all;\n" +
                "    cursor: pointer\n" +
                "}" +
                ".voltar {\n" +
                "    text-align: center;\n" +
                "    background-color: rgba(63, 1, 66, 0.827);\n" +
                "    color: #f3f3f3b4;\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "    border: solid rgba(54, 54, 54, 0) 1px;\n" +
                "    border-radius: 15px;\n" +
                "    padding: 1rem 2rem;" +
                "    font-size: 1.5rem;\n" +
                "}" +
                ".voltar:hover{\n" +
                "    background-color: rgba(63, 1, 66, 0.627);\n" +
                "    transition: 0.2s all;\n" +
                "    cursor: pointer" +
                "}\n" +
                "</style>";
        return html;
    }
}