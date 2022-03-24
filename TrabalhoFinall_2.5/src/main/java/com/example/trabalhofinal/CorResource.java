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

@Path("/cor")
public class CorResource {
    @GET
    @Produces("text/html")
    public String cor(@QueryParam("posicao") @DefaultValue("") String posicao_bloco) {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"pt-BR\">\n" +
                "    <head>\n" +
                "        <meta charset = \"UTF-8\">\n" +
                "        <meta http-equiv= \"X-UA-Compatible\" content = \"IE=edge\">\n" +
                "        <meta name = \"viewport\" content = \"width=device-width, initial-scale=1.0\">\n" +
                "        <title>Selecione a cor da fonte</title>\n" +
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
        String formhtml = " <form method=\"GET\" action=\"editarcor\">\n" +
                "   <input type=\"hidden\" value=\""+ posicao_bloco +"\" name=\"posicao\"> \n" +
                "   <div class=\"label\"> <label for=\"cor\">Selecione a cor desejada: </label> </div>\n" +
                "   <div class=\"buttons\">" +
                "   <div class=\"buttons-block\"> <button type=\"submit\" id=\"cor\" name=\"cor\" value=\"red\" style=\"color: red\">Vermelho</button>\n" +
                "   <button type=\"submit\" id=\"cor\" name=\"cor\" value=\"pink\" style=\"color: pink\">Rosa</button> </div>\n" +
                "   <div class=\"buttons-block\"> <button type=\"submit\" id=\"cor\" name=\"cor\" value=\"purple\" style=\"color: purple\">Roxo</button>\n" +
                "   <button type=\"submit\" id=\"cor\" name=\"cor\" value=\"blue\" style=\"color: blue\">Azul</button> </div>\n" +
                "   <div class=\"buttons-block\"> <button type=\"submit\" id=\"cor\" name=\"cor\" value=\"green\" style=\"color: green\">Verde</button>\n" +
                "   <button type=\"submit\" id=\"cor\" name=\"cor\" value=\"yellow\" style=\"color: yellow\">Amarelo</button> </div>\n" +
                "   <div class=\"buttons-block\"> <button type=\"submit\" id=\"cor\" name=\"cor\" value=\"orange\" style=\"color: orange\">Laranja</button>\n" +
                "   <button type=\"submit\" id=\"cor\" name=\"cor\" value=\"brown\" style=\"color: brown\">Marrom</button> </div>\n" +
                "   <div class=\"buttons-block\"> <button type=\"submit\" id=\"cor\" name=\"cor\" value=\"gray\" style=\"color: gray\">Cinza</button>\n" +
                "   <button type=\"submit\" id=\"cor\" name=\"cor\" value=\"black\">Preto (padrão)</button> </div>\n" +
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
                "    margin-bottom: 0.75rem;" +
                "}\n" +
                ".buttons {\n" +
                "    margin-bottom: 2rem;\n" +
                "    width: 35vw;\n" +
                "}\n" +
                ".label {\n" +
                "    font-size: 2rem;\n" +
                "    color: #f3f3f3;\n" +
                "    margin-bottom: 1.5rem;\n" +
                "    text-align: center;" +
                "}\n" +
                "button {\n" +
                "    text-align: center;\n" +
                "    background-color: #f3f3f3b4; \n" +
                "    color: rgba(63, 1, 66, 0.827);\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "    font-size: 1.5rem;\n" +
                "    border: solid rgba(54, 54, 54, 0) 2px;\n" +
                "    border-radius: 15px;\n" +
                "    padding: 1rem;\n" +
                "    min-width: 14rem;\n" +
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