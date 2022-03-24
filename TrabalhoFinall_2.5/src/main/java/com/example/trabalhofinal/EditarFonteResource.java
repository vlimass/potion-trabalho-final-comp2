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

@Path("/editarfonte")
public class EditarFonteResource {
    @GET
    @Produces("text/html")
    public String editarFonte(@QueryParam("fonte") @DefaultValue("") String fonte, @QueryParam("posicao") @DefaultValue("") String posicao) {
        int int_posicao = Integer.parseInt(posicao);
        try{
            if(PotionApplication.blocos.get(int_posicao).fonte_bloco.equals(fonte)){
                throw new IllegalArgumentException("Fonte já selecionada");
            }
            PotionApplication.blocos.get(int_posicao).recebeFonte(fonte);
            PotionApplication.blocos.get(int_posicao).blocoToHTML(); // Reconstrói o bloco HTML com a nova fonte selecionada

            String html="<!DOCTYPE html>\n" +
                    "<html lang=\"pt-BR\">\n" +
                    "    <head>\n" +
                    "        <meta charset = \"UTF-8\">\n" +
                    "        <meta http-equiv= \"X-UA-Compatible\" content = \"IE=edge\">\n" +
                    "        <meta name = \"viewport\" content = \"width=device-width, initial-scale=1.0\">\n" +
                    "        <title>Fonte editada</title>\n" +
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
                    "    <div class=\"content\">\n" +
                    "        <img src=\"https://cdn.discordapp.com/attachments/890312701123895377/951460523910778880/1200px-Eo_circle_pink_checkmark.svg.png\" alt=\"Símbolo de Check\">" +
                    "        <p class=\"first-line\">Fonte alterada com sucesso!</p>\n" +
                    "        <a href = \"main?nome_caderno=" + HomeResource.getNomeCaderno() + "\">Ir para o caderno</a>" +
                    "    </div>" +
                    "       </main>" +
                    "    </body>\n" +
                    "</html>";

            html = html.replace("$cssStyle", cssStyle());
            return html;

        }catch (IllegalArgumentException e){
            String html = "<!DOCTYPE html>\n" +
                    "<html lang=\"pt-BR\">\n" +
                    "    <head>\n" +
                    "        <meta charset = \"UTF-8\">\n" +
                    "        <meta http-equiv= \"X-UA-Compatible\" content = \"IE=edge\">\n" +
                    "        <meta name = \"viewport\" content = \"width=device-width, initial-scale=1.0\">\n" +
                    "        <title>Erro! Fonte já foi selecionada</title>\n" +
                    //FAVICON:
                    "   <link rel=\"shortcut icon\" href=\"https://media.discordapp.net/attachments/890312701123895377/949731505540845638/icon_2.png\" type=\"image/x-icon\">"+
                    //CSS:
                    "$cssStyle\n" +
                    //FONTS:
                    "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
                    "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
                    "<link href=\"https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,400;0,700;1,100;1,400;1,700&family=Sansita+Swashed:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">" +
                    "    </head>\n" +
                    "    <body>\n" +
                    "       <main>" +
                    "        <div class=\"content\">\n" +
                    "           <img src=\"https://images.vexels.com/media/users/3/153978/isolated/preview/483ef8b10a46e28d02293a31570c8c56-icone-de-traco-colorido-do-sinal-de-aviso.png\" alt=\"Símbolo de advertência\">" +
                    "           <p class=\"first-line\">Essa fonte já está selecionada!</p>\n" +
                    "           <span class=\"buttons\">\n" +
                    "               <a href = \"fonte?posicao="+int_posicao+"\" class=\"first-link\">Voltar</a>" +
                    "               <a href = \"main?nome_caderno=" + HomeResource.getNomeCaderno() + "\" class=\"second-link\">Ir para o caderno</a>" +
                    "           </span>" +
                    "        </div>" +
                    "       </main>" +
                    "    </body>\n" +
                    "</html>";

            html = html.replace("$cssStyle", cssStyleErro());
            return html;
        }
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
                "    justify-content: center;\n" +
                "}\n" +
                "\n" +
                "img {\n" +
                "    text-align: center;\n" +
                "    height: 22.5rem;\n" +
                "    margin-bottom: 4rem;\n" +
                "    margin-top: 2rem;" +
                "}\n" +
                "\n" +
                "p {\n" +
                "    font-size: 1.75rem;\n" +
                "    font-weight: bold;\n" +
                "    color: #f3f3f3;\n" +
                "}\n" +
                "\n" +
                ".first-line {\n" +
                "    margin-bottom: 2.5rem;\n" +
                "}\n" +
                "\n" +
                "a {\n" +
                "    text-align: center;\n" +
                "    background-color: #f3f3f3b4; \n" +
                "    color: rgba(63, 1, 66, 0.827);\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "    font-size: 1.15rem;\n" +
                "    border: solid rgba(54, 54, 54, 0) 2px;\n" +
                "    border-radius: 15px;\n" +
                "    padding: 1rem;\n" +
                "}\n" +
                "\n" +
                "a:hover {\n" +
                "    background-color: rgba(242, 242, 242, 0.9);\n" +
                "    transition: 0.2s all;\n" +
                "    cursor: pointer\n" +
                "}" +
                "</style>";

        return html;
    }

    private String cssStyleErro(){
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
                "    justify-content: center;\n" +
                "}\n" +
                "\n" +
                "img {\n" +
                "    text-align: center;\n" +
                "    height: 22.5rem;\n" +
                "    margin-bottom: 6rem;\n" +
                "}\n" +
                "\n" +
                "p {\n" +
                "    font-size: 1.75rem;\n" +
                "    font-weight: bold;\n" +
                "    color: #f3f3f3;\n" +
                "}\n" +
                "\n" +
                ".first-line {\n" +
                "    margin-bottom: 4rem;\n" +
                "}\n" +
                "\n" +
                ".first-link {\n" +
                "    text-align: center;\n" +
                "    background-color: rgba(63, 1, 66, 0.827);\n" +
                "    color: #f3f3f3b4;\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "    font-size: 1.15rem;\n" +
                "    border: solid rgba(54, 54, 54, 0) 1px;\n" +
                "    border-radius: 15px;\n" +
                "    padding: 1.2rem 2rem;\n" +
                "    margin-right: 3rem;\n" +
                "}\n" +
                "\n" +
                ".second-link {\n" +
                "    text-align: center;\n" +
                "    background-color: #f3f3f3b4; \n" +
                "    color: rgba(63, 1, 66, 0.827);\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "    font-size: 1.15rem;\n" +
                "    border: solid rgba(54, 54, 54, 0) 2px;\n" +
                "    border-radius: 15px;\n" +
                "    padding: 1rem;\n" +
                "}\n" +
                "\n" +
                ".first-link:hover {\n" +
                "    background-color: rgba(63, 1, 66, 0.627);\n" +
                "    transition: 0.2s all;\n" +
                "    cursor: pointer\n" +
                "}\n" +
                "\n" +
                ".second-link:hover {\n" +
                "    background-color: rgba(242, 242, 242, 0.9);\n" +
                "    transition: 0.2s all;\n" +
                "    cursor: pointer\n" +
                "}\n" +
                "</style>";

        return html;
    }
}