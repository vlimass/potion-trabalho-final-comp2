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

@Path("/editar")
public class EditarResource {
    @GET
    @Produces("text/html")
    public String editar(@QueryParam("posicao") @DefaultValue("") String posicao_bloco) {
        int int_posicao = Integer.parseInt(posicao_bloco);

        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"pt-BR\">\n" +
                "    <head>\n" +
                "        <meta charset = \"UTF-8\">\n" +
                "        <meta http-equiv= \"X-UA-Compatible\" content = \"IE=edge\">\n" +
                "        <meta name = \"viewport\" content = \"width=device-width, initial-scale=1.0\">\n" +
                "        <title>Editar anotação</title>\n" +
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
                "    <main>" +
                "    <div class=\"content\">\n" +
                "        <div class=\"display\">"+ PotionApplication.blocos.get(int_posicao).html_bloco +"</div>" +
                "        <p class=\"first-line\">Selecione o que deseja editar:</p>\n" +
                "        <div class=\"buttons\">\n" +
                "               <a href=\"textoconteudo?posicao="+posicao_bloco+"\">Texto</a>\n" +
                "               <a href=\"cor?posicao="+posicao_bloco+"\">Cor da fonte</a>\n" +
                "               <a href=\"corbackground?posicao="+posicao_bloco+"\">Cor de fundo</a>\n" +
                "               <a href=\"fonte?posicao="+posicao_bloco+"\">Fonte</a>\n" +
                "        </div>" +
                "        <div> <a href = \"main?nome_caderno="+ HomeResource.getNomeCaderno() +"\" class=\"voltar\">Voltar</a> </div>" +
                "    </div>" +
                "    </main>" +
                "    </body>\n" +
                "</html>";

        html = html.replace("$cssStyle", cssStyle());
        return html;
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
                "    width: 80vw;\n" +
                "    margin: auto;\n" +
                "    margin-top: 1.25rem;\n" +
                "    border-radius: 8px;\n" +
                "}\n" +
                "\n" +
                ".content {\n" +
                "    display: flex;\n" +
                "    flex-direction: column;\n" +
                "    align-items: center;" +
                "    padding: 2.5rem;" +
                "}\n" +
                ".display {\n" +
                "    border: solid #0000004f 5px;\n" +
                "    overflow-wrap: anywhere;\n" +
                "    width: 60vw;\n" +
                "    padding: 0.75rem;\n" +
                "    border-radius: 10px;" +
                "    background: #f3f3f3;" +
                "    min-height: 40vh;" +
                "    margin-bottom: 2rem;" +
                "}\n" +
                "\n" +
                ".first-line {\n" +
                "    font-size: 2.25rem;\n" +
                "    color: #f3f3f3;\n" +
                "    margin-bottom: 2rem;" +
                "}\n" +
                ".buttons{\n" +
                "    display: flex;\n" +
                "    align-items: center;\n" +
                "    justify-content: space-between;\n" +
                "    width: 67vw;\n" +
                "    margin-bottom: 3.25rem;" +
                "}\n" +
                ".buttons a {\n" +
                "    text-align: center;\n" +
                "    background-color: #f3f3f3b4;\n" +
                "    color: rgba(63, 1, 66, 0.827);\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "    font-size: 1.60rem;\n" +
                "    border: solid rgba(54, 54, 54, 0) 2px;\n" +
                "    border-radius: 15px;\n" +
                "    padding: 0.75rem;\n" +
                "    min-width: 14rem;" +
                "}\n" +
                ".buttons a:hover{\n" +
                "    background-color: rgba(242, 242, 242, 0.9);\n" +
                "    transition: 0.2s all;\n" +
                "    cursor: pointer;\n" +
                "}\n" +
                ".voltar {\n" +
                "    text-align: center;\n" +
                "    background-color: rgba(63, 1, 66, 0.827);\n" +
                "    color: #f3f3f3b4;\n" +
                "    font-family: 'Poppins', sans-ser/if;\n" +
                "    border: solid rgba(54, 54, 54, 0) 1px;\n" +
                "    border-radius: 15px;\n" +
                "    padding: 1rem 2rem;\n" +
                "    font-size: 1.5rem;" +
                "}\n" +
                ".voltar:hover {\n" +
                "    background-color: rgba(63, 1, 66, 0.627);\n" +
                "    transition: 0.2s all;\n" +
                "    cursor: pointer;" +
                "}\n" +
                "</style>";

        return html;
    }
}