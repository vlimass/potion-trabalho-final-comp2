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

@Path("/textoconteudo")
public class TextoConteudoResource {
    @GET
    @Produces("text/html")
    public String textoConteudo(@QueryParam("posicao") @DefaultValue("") String posicao_bloco) {
        int int_posicao = Integer.parseInt(posicao_bloco);

        String html="<!DOCTYPE html>\n" +
                "<html lang=\"pt-BR\">\n" +
                "    <head>\n" +
                "        <meta charset = \"UTF-8\">\n" +
                "        <meta http-equiv= \"X-UA-Compatible\" content = \"IE=edge\">\n" +
                "        <meta name = \"viewport\" content = \"width=device-width, initial-scale=1.0\">\n" +
                "        <title>Edição do conteúdo do texto</title>\n" +
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
                "       <main>" +
                "         <div class=\"content\">\n" +
                "           $htmlForm";

        if(PotionApplication.blocos.get(int_posicao).conteudo_bloco.equals("")) { // Adapatação para o caso especial de um bloco vazio
            html +=  "<a href = \"main?nome_caderno=" + HomeResource.getNomeCaderno() + "\" class=\"voltar\">Voltar</a>";
        } else {
            html += "<a href = \"editar?posicao=$posicao_bloco\"  class=\"voltar\">Voltar</a>";
        }

        html += "</div></main></body></html>";

        html = html.replace("$cssStyle", cssStyle());
        html = html.replace("$htmlForm", htmlForm(posicao_bloco, int_posicao));
        html = html.replace("$posicao_bloco", posicao_bloco);

        return html;
    }

    public String htmlForm(String posicao_bloco, int int_posicao) {
        // Ajuste de texto para que os caracteres não transbordem no CSS:
        String caracter_limite = "";
        if(PotionApplication.blocos.get(int_posicao).tipo_bloco.equals("h1")) caracter_limite = "245";
        if(PotionApplication.blocos.get(int_posicao).tipo_bloco.equals("h2")) caracter_limite = "414";
        if(PotionApplication.blocos.get(int_posicao).tipo_bloco.equals("p")) caracter_limite = "1050";
        if(PotionApplication.blocos.get(int_posicao).tipo_bloco.equals("a")) caracter_limite = "770";

        String formhtml = " <form method=\"GET\" action=\"editartextoconteudo\">\n" +
                "   <input type=\"hidden\" value=\""+ posicao_bloco +"\" name=\"posicao\"> \n" +
                "   <div class=\"text\"> <textarea name=\"novo_texto\" maxlength=\""+ caracter_limite +"\">"+ PotionApplication.blocos.get(int_posicao).conteudo_bloco +"</textarea></div>\n" +
                "   <div class=\"editar-texto\"> <input type=\"submit\" value=\"Editar texto\"> </div>\n" +
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
                "    align-items: center;\n" +
                "    padding: 4rem;\n" +
                "}\n" +
                "\n" +
                ".text {\n" +
                "    border: solid #0000004f 5px;\n" +
                "    width: 40vw;\n" +
                "    padding: 0.75rem;\n" +
                "    border-radius: 10px;" +
                "    background: #f3f3f3;" +
                "    min-height: 40vh;" +
                "    margin-bottom: 3.5rem;" +
                "}\n" +
                ".text textarea{\n" +
                "    width: 100%;\n" +
                "    height: 15.5rem;\n" +
                "    font-size: 1.2rem;\n" +
                "    font-family: \"Arial\";\n" +
                "    padding: 0.5rem;\n" +
                "    resize: none;\n" +
                "    background-color: #f3f3f3;\n" +
                "}\n" +
                ".editar-texto {\n" +
                "    text-align: center;\n" +
                "    margin-bottom: 3.5rem;\n" +
                "}\n" +
                ".editar-texto input{\n" +
                "    text-align: center;\n" +
                "    background-color: #f3f3f3b4; \n" +
                "    color: rgba(63, 1, 66, 0.827);\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "    font-size: 1.5rem;\n" +
                "    border: solid rgba(54, 54, 54, 0) 2px;\n" +
                "    border-radius: 15px;\n" +
                "    padding: 1rem;\n" +
                "    min-width: 18rem;\n" +
                "}\n" +
                "\n" +
                ".editar-texto input:hover {\n" +
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
                ".voltar:hover {\n" +
                "    background-color: rgba(63, 1, 66, 0.627);\n" +
                "    transition: 0.2s all;\n" +
                "    cursor: pointer" +
                "}\n" +
                "</style>";

        return html;
    }
}