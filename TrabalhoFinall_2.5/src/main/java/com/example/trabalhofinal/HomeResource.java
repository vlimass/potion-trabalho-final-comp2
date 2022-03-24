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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/home")
public class HomeResource {
    @GET
    @Produces("text/html")
    public String home() {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"pt-BR\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Potion</title>\n" +
                // FAVICON:
                "   <link rel=\"shortcut icon\" href=\"https://media.discordapp.net/attachments/890312701123895377/949731505540845638/icon_2.png\" type=\"image/x-icon\">" +
                "\n" +
                //  CSS STYLE:
                "$cssStyle\n" +
                //FONTS:
                "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
                "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
                "<link href=\"https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,400;0,700;1,100;1,400;1,700&family=Sansita+Swashed:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "    <main>\n" +
                "    <div class=\"section-left\">\n" +
                "    </div>\n" +
                "    <div class=\"content\">\n" +
                "    <div>\n" +
                "        <img src=\"https://media.discordapp.net/attachments/890312701123895377/949731504991395940/Home.jpg?width=816&height=612\" alt=\"Potion logo\">\n" +
                "    </div>\n" +
                "        <h1>Potion</h1>\n" +
                "        <h2>Bem vindo ao Potion: seu caderno, sua mistura!</h2>\n" +
                "\n" +
                "    <div class=\"form\">\n" +
                "        <p>Insira o nome do seu caderno e comece a aventura:</p>\n" +
                "        <div class=\"input-box\">&htmlForm</div>" +
                "    </div>\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"section-right\">\n" +
                "    </div>\n" +
                "    </main>\n" +
                "</body>\n" +
                "</html>";

        html = html.replace("$cssStyle", cssStyle());
        html = html.replace("&htmlForm", htmlForm());
        return html;
    }

    private static String nome_caderno;

    public static void setNomeCaderno(String n_caderno) { nome_caderno = n_caderno; }

    public static String getNomeCaderno(){ return nome_caderno; }

        public String htmlForm () {
        String formhtml = "<form method=\"GET\" action=\"main\">\n" +
                "   <input type=\"text\" name=\"nome_caderno\" class=\"text\" maxlength=\"41\"> \n" +
                "   <input type=\"submit\" value=\"Criar caderno\" class=\"button\">\n" +
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
                "main {\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "\n" +
                "    height: 100vh;\n" +
                "    display: flex;\n" +
                "}\n" +
                "\n" +
                ".section-left, .section-right {\n" +
                "    width: 50rem;\n" +
                "}\n" +
                "\n" +
                ".section-left {\n" +
                "    background-image: linear-gradient(to left, #f3f3f3, rgba(146,64,146,1));\n" +
                "}\n" +
                "\n" +
                ".section-right {\n" +
                "    background-image: linear-gradient(to right, #f3f3f3, rgba(146,64,146,1));\n" +
                "}\n" +
                "\n" +
                ".content {\n" +
                "    background-color: #f3f3f3;\n" +
                "    width: 125rem;\n" +
                "    \n" +
                "    display: flex;\n" +
                "    flex-direction: column;\n" +
                "    align-items: center;\n" +
                "}\n" +
                "\n" +
                "img {\n" +
                "    height: 25rem;\n" +
                "}\n" +
                "\n" +
                "h1 {\n" +
                "    font-family: 'Sansita Swashed', cursive;\n" +
                "    font-weight: 700;\n" +
                "    font-size: 4.5rem;\n" +
                "\n" +
                "    margin-bottom: 3.5rem;\n" +
                "}\n" +
                "\n" +
                "h2 {\n" +
                "    font-size: 1.5rem;\n" +
                "    margin-bottom: 1.25rem;\n" +
                "}\n" +
                "\n" +
                ".form {\n" +
                "    display: flex;\n" +
                "    flex-direction: column;\n" +
                "    align-items: center;\n" +
                "}\n" +
                "\n" +
                ".input-box {\n" +
                "    margin-top: 0.25rem;\n" +
                "}\n" +
                "\n" +
                ".text {\n" +
                "    background-color: #f3f3f3;\n" +
                "    border: solid #0000004f 0.5px;\n" +
                "    border-radius: 7px;\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "\n" +
                "    margin-right: 1rem;\n" +
                "    margin-top: 0.5rem;\n" +
                "    padding: 0.4rem 0.5rem;\n" +
                "}\n" +
                "\n" +
                ".button {\n" +
                "    text-align: center;\n" +
                "    background-color: rgba(63, 1, 66, 0.827);\n" +
                "    color: #f3f3f3b4;\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "    border: solid rgba(54, 54, 54, 0) 1px;\n" +
                "    border-radius: 15px;\n" +
                "    padding: 0.4rem 0.75rem;\n" +
                "}\n" +
                "\n" +
                ".button:hover {\n" +
                "    background-color: rgba(63, 1, 66, 0.727);\n" +
                "    transition: 0.2s all;\n" +
                "    cursor: pointer\n" +
                "}" +
                "    </style>";

        return html;
    }
}