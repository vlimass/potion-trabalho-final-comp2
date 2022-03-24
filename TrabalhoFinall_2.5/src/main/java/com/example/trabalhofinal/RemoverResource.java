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

@Path("/remover")
public class RemoverResource {
    @GET
    @Produces("text/html")
    public String remover(@QueryParam("posicao") @DefaultValue("") String posicao_bloco) {
        int int_posicao = Integer.parseInt(posicao_bloco);

        // Ajuste de imagem -> redimensiona a imagem para um tamanho menor a fim de não transbordar o CSS:
        String tamanho_imagem_bloco_inicial = PotionApplication.blocos.get(int_posicao).tamanho_imagem_bloco;
        if(PotionApplication.blocos.get(int_posicao).tipo_bloco.equals("img")){
            PotionApplication.blocos.get(int_posicao).tamanho_imagem_bloco = "250px";
            PotionApplication.blocos.get(int_posicao).blocoToHTML(); // Reconstrói o bloco HTML com o ajuste de imagem
        }

        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"pt-BR\">\n" +
                "    <head>\n" +
                "        <meta charset = \"UTF-8\">\n" +
                "        <meta http-equiv= \"X-UA-Compatible\" content = \"IE=edge\">\n" +
                "        <meta name = \"viewport\" content = \"width=device-width, initial-scale=1.0\">\n" +
                "        <title>Remover anotação</title>\n" +
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
                "       <main>\n" +
                "        <div class=\"content\">\n" +
                "           <div class=\"display\">"+ PotionApplication.blocos.get(int_posicao).html_bloco +"</div>" +
                "           <div class=\"text\"> <p><strong>Tem certeza de que deseja remover anotação?</strong></p> </div>" +
                "           <div class=\"buttons\">\n" +
                "               <a href=\"main?nome_caderno="+ HomeResource.getNomeCaderno() +"\" class=\"cancelar\">Cancelar</a>" +
                "               $htmlForm\n" +
                "           </div>\n" +
                "        </div>\n" +
                "       </main>\n" +
                "    </body>\n" +
                "</html>";

        html = html.replace("$cssStyle", cssStyle(int_posicao));
        html = html.replace("$htmlForm", htmlForm(posicao_bloco));

        // Ajuste de imagem -> redimensiona a imagem para o seu tamanho original:
        if(PotionApplication.blocos.get(int_posicao).tipo_bloco.equals("img")){
            PotionApplication.blocos.get(int_posicao).tamanho_imagem_bloco = tamanho_imagem_bloco_inicial;
            PotionApplication.blocos.get(int_posicao).blocoToHTML(); // Reconstrói o bloco HTML com o ajuste de imagem
        }

        return html;
    }

    public String htmlForm(String posicao_bloco) {
        String formhtml =
                "   <form method=\"GET\" action=\"blocoremovido\" style=\"display: inline-block; margin-left: 1.5rem\">\n" +
                "   <input type=\"hidden\" value=\""+ posicao_bloco +"\" name=\"posicao\"> \n" +
                "   <input type=\"submit\" value=\"Remover\" class=\"remover\">\n" +
                "   </form>" ;
        return formhtml;
    }

    private String cssStyle(int int_posicao) {
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
                "    padding: 2.5rem" +
                "}\n" +
                ".display {\n" +
                "    border: solid #0000004f 5px;\n" +
                "    overflow-wrap: anywhere;\n" +
                "    width: 60vw;\n" +
                "    padding: 0.75rem;\n" +
                "    border-radius: 10px;\n" +
                "    background: #f3f3f3;\n" +
                "    min-height: 40vh;\n" +
                "    margin-bottom: 2.25rem;";
        if(PotionApplication.blocos.get(int_posicao).tipo_bloco.equals("img")) { // Ajuste para centralizar a imagem
            html += "text-align: center;";
        }
        html += "}\n" +
                ".text {\n" +
                "    font-size: 2rem;\n" +
                "    color: #f3f3f3;\n" +
                "    margin-bottom: 3rem;" +
                "}\n" +
                ".buttons {\n" +
                "    display: flex;\n" +
                "    align-items: center;" +
                "    justify-content: space-between;" +
                "    width: 37vw;" +
                "}\n" +
                ".cancelar {\n" +
                "    text-align: center;\n" +
                "    background-color: rgba(63, 1, 66, 0.827);\n" +
                "    color: #f3f3f3b4;\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "    border: solid rgba(54, 54, 54, 0) 1px;\n" +
                "    border-radius: 15px;\n" +
                "    padding: 1.85rem 1.75rem;" +
                "    font-size: 1.75rem;\n" +
                "    min-width: 14rem;\n" +
                "}\n" +
                ".cancelar:hover{\n" +
                "    background-color: rgba(63, 1, 66, 0.627);\n" +
                "    transition: 0.2s all;\n" +
                "    cursor: pointer" +
                "}\n" +
                ".remover {\n" +
                "    text-align: center;\n" +
                "    background-color: #f3f3f3b4; \n" +
                "    color: rgb(236 6 6 / 90%);\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "    font-size: 1.75rem;\n" +
                "    border: solid rgba(54, 54, 54, 0) 2px;\n" +
                "    border-radius: 15px;\n" +
                "    padding: 1.75rem;\n" +
                "    min-width: 14rem;\n" +
                "}\n" +
                ".remover:hover {\n" +
                "    color: #f3f3f3b4; \n" +
                "    background-color: rgb(243 4 4 / 75%);\n" +
                "    transition: 0.2s all;\n" +
                "    cursor: pointer;\n" +
                "}" +
                "</style>";

        return html;
    }
}