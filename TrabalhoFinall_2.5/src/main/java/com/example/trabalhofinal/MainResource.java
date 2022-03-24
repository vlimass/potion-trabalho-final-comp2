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

@Path("/main")
public class MainResource {
    @GET
    @Produces("text/html")
    public String main(@QueryParam("nome_caderno") @DefaultValue("") String nome_caderno) {
        HomeResource.setNomeCaderno(nome_caderno); // Set do nome do caderno colocado pelo usuário na Home

        try {
            if (nome_caderno.equals("")){
                throw new IllegalArgumentException("Por favor, adicione o nome do caderno para começar");
            }
            String html = "<!DOCTYPE html>\n" +
                    "<html lang=\"pt-BR\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Potion</title>\n" +
                    // FAVICON:
                    "   <link rel=\"shortcut icon\" href=\"https://media.discordapp.net/attachments/890312701123895377/949731505540845638/icon_2.png\" type=\"image/x-icon\">"+
                    //  CSS STYLE:
                    "$cssStyle\n" +
                    //FONTS:
                    "<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
                    "<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
                    "<link href=\"https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,400;0,700;1,100;1,400;1,700&family=Sansita+Swashed:wght@400;500;600;700&display=swap\" rel=\"stylesheet\">" +
                    "</head>\n" +
                    "<body>\n" +
                        "$barra_navegacao" +
                        // Conteúdo do caderno:
                        "<main>" +
                        "   $potionapplication" +
                        "</main>" +
                    "</body>\n" +
                    "</html>";

            html = html.replace("$cssStyle", cssStyleMain());
            html = html.replace("$barra_navegacao", barra_de_navegacao());
            html = html.replace("$potionapplication", PotionApplication.blocosToHTML());

            return html;

        } catch (IllegalArgumentException ie){
            String html="<!DOCTYPE html>\n" +
                    "<html lang=\"pt-BR\">\n" +
                    "    <head>\n" +
                    "        <meta charset = \"UTF-8\">\n" +
                    "        <meta http-equiv= \"X-UA-Compatible\" content = \"IE=edge\">\n" +
                    "        <meta name = \"viewport\" content = \"width=device-width, initial-scale=1.0\">\n" +
                    "        <title>Erro! Nome do caderno vazio</title>\n" +
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
                    "        <img src=\"https://images.vexels.com/media/users/3/153978/isolated/preview/483ef8b10a46e28d02293a31570c8c56-icone-de-traco-colorido-do-sinal-de-aviso.png\" alt=\"Símbolo de advertência\">" +
                    "        <p class=\"first-line\">Por favor, insira um nome</p>\n" +
                    "        <p class=\"second-line\">para o caderno</p>\n" +
                    "        <a href = \"home\">Voltar</a>\n" +
                    "    </div>" +
                    "       </main>" +
                    "    </body>\n" +
                    "</html>";

            html = html.replace("$cssStyle", cssStyleErro());
            return html;
        }
    }

    private String barra_de_navegacao() {
        String html = "<header>\n" +
                "        <nav>\n" +
                "            <ul>\n" +
                "                <li><a href=\"home\" class=\"logo\"><img src=\"https://icons.iconarchive.com/icons/chanut/role-playing/1024/Potion-icon.png\" alt=\"Potion Logo\" height=\"17px\" width=\"17px\">Potion</a></li>\n" +
                "                <li class=\"nav-item\"><a href=\"titulo\">Título</a></li>\n" +
                "                <li class=\"nav-item\"><a href=\"subtitulo\">Subtítulo</a></li>\n" +
                "                <li class=\"nav-item\"><a href=\"texto\">Texto</a></li>\n" +
                "                <li class=\"nav-item\"><a href=\"link\">Link</a></li>\n" +
                "                <li class=\"nav-item\"><a href=\"imagem\">Imagem</a></li>\n" +
                "                <li><span>"+ HomeResource.getNomeCaderno() +"'s Potion</span></li>\n" +
                "            </ul>\n" +
                "        </nav>\n" +
                "    </header>";
        return html;
    }

    private String cssStyleMain() {
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
                "    background-color: #f3f3f3;\n" +
                "}\n" +
                "\n" +
                "header nav {\n" +
                "    background-color: rgb(134, 106, 137);\n" +
                "    position: fixed;\n" +
                "    top: 0;\n" +
                "    width: 100%;\n" +
                "\n" +
                "    border-bottom:rgba(0, 0, 0, 0.466) solid 0.5px;\n" +
                "}\n" +
                "\n" +
                "header nav ul {\n" +
                "    display: flex;\n" +
                "    align-items: center;\n" +
                "    justify-content: space-between;\n" +
                "    margin: 0 5rem;\n" +
                "}\n" +
                "\n" +
                "header nav ul li {\n" +
                "    list-style: none;\n" +
                "    padding: 1.5rem;\n" +
                "\n" +
                "    display: flex;\n" +
                "    align-items: center;\n" +
                "    justify-content: center;\n" +
                "}\n" +
                "\n" +
                "header nav ul li a{\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "    font-size: 1.2rem;\n" +
                "    color: rgba(0, 0, 0, 0.68);\n" +
                "    text-decoration: none;\n" +
                "}\n" +
                "\n" +
                "header nav ul li span{\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "    font-size: 1.2rem;\n" +
                "    text-decoration: none;\n" +
                "}\n" +
                "\n" +
                ".logo {\n" +
                "    font-family: 'Sansita Swashed', cursive;\n" +
                "    color: #000000b8;\n" +
                "    font-weight: 700;\n" +
                "    font-size: 1.5rem;\n" +
                "\n" +
                "    display: flex;\n" +
                "    gap: 0.5rem;\n" +
                "    align-items: center;\n" +
                "    justify-content: center;\n" +
                "}\n" +
                "\n" +
                ".logo img {\n" +
                "    height: 1.5rem;\n" +
                "    width: 1.5rem;\n" +
                "}\n" +
                "\n" +
                ".logo:hover {\n" +
                "    color:rgba(0, 0, 0, 0.9);\n" +
                "    transition: 0.15s\n" +
                "}\n" +
                "\n" +
                ".nav-item:hover {\n" +
                "    background-color: rgb(198, 191, 199);\n" +
                "    color: rgb(134, 106, 137);\n" +
                "    transition: 0.3s all;\n" +
                "}\n" +
                "\n" +
                "main {\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "    background-color: #f3f3f3;\n" +
                "    margin-top: 7.5rem;\n" +
                "}\n" +
                "\n" +
                ".intro {\n" +
                "    margin-left: 2rem;\n" +
                "}\n" +
                "\n" +
                ".intro h1 {\n" +
                "    font-size: 2.5rem;\n" +
                "    margin-bottom: 1.5rem;\n" +
                "}\n" +
                "\n" +
                ".intro h2 {\n" +
                "    font-size: 2rem;\n" +
                "    margin-bottom: 0.5rem;\n" +
                "}\n" +
                "\n" +
                ".intro p { \n" +
                "    font-size: 1.3rem;\n" +
                "}\n" +
                "\n" +
                ".block {\n" +
                "    display: flex;\n" +
                "    align-items: center;\n" +
                "    justify-content: space-between;\n" +
                "    margin: 0 3rem 1.75rem 3rem;\n" +
                "}\n" +
                "\n" +
                ".block .number {\n" +
                "    font-size: 1.25rem;\n" +
                "    color: rgba(0, 0, 0, 0.68);\n" +
                "}\n" +
                "\n" +
                ".block .content {\n" +
                "    border: solid #0000004f 1px;\n" +
                "    overflow-wrap: anywhere;\n" +
                "    width: 80vw;\n" +
                "    padding: 0.75rem;\n" +
                "    border-radius: 10px;\n" +
                "}\n" +
                "\n" +
                ".block .links {\n" +
                "    display: flex;\n" +
                "    gap: 0.5rem;\n" +
                "    align-items: center;\n" +
                "    justify-content: center;\n" +
                "}\n" +
                "\n" +
                ".block .links a:hover {\n" +
                "    opacity: 0.7;\n" +
                "}\n" +
                "    </style>";
        return html;
    }

    private String cssStyleErro() {
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
                "    margin-bottom: 5rem;\n" +
                "}\n" +
                "\n" +
                "p {\n" +
                "    font-size: 1.75rem;\n" +
                "    font-weight: bold;\n" +
                "    color: #f3f3f3;\n" +
                "}\n" +
                "\n" +
                ".first-line {\n" +
                "    margin-bottom: -0.25rem;\n" +
                "}\n" +
                "\n" +
                ".second-line {\n" +
                "    margin-bottom: 2.5rem;\n" +
                "}\n" +
                "\n" +
                "a {\n" +
                "    text-align: center;\n" +
                "    background-color: rgba(63, 1, 66, 0.827);\n" +
                "    color: #f3f3f3b4;\n" +
                "    font-family: 'Poppins', sans-serif;\n" +
                "    font-size: 1.15rem;\n" +
                "    border: solid rgba(54, 54, 54, 0) 1px;\n" +
                "    border-radius: 15px;\n" +
                "    padding: 1rem;\n" +
                "    width: 7rem;\n" +
                "}\n" +
                "\n" +
                "a:hover {\n" +
                "    background-color: rgba(63, 1, 66, 0.627);\n" +
                "    transition: 0.2s all;\n" +
                "    cursor: pointer\n" +
                "}" +
                "</style>";
        return html;
    }
}