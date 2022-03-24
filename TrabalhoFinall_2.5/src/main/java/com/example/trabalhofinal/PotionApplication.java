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

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.ArrayList;

@ApplicationPath("/api")
public class PotionApplication extends Application {
    protected static ArrayList<Bloco> blocos = new ArrayList<>();

    protected static String blocosToHTML() {
        String html ="";

        if(blocos.size() == 0) {
            html =  "<div class=\"intro\"><h1>Olá, bem vindo ao caderno " + HomeResource.getNomeCaderno() + "!</h1>\n " +
                    "<h2>Seu potion está em branco</h2><p>Adicione um elemento acima e comece a mistura!</p></div>";

            return html;
        }

        html ="";
        for (int i=0; i<blocos.size(); i++) {
            // Indicar posição do bloco:
            html += "<div class=\"block\"> <span class=\"number\">$posicao_bloco.</span>";
            html = html.replace("$posicao_bloco", Integer.toString(i + 1));

            // Editar bloco:
            if(blocos.get(i).html_bloco.contains("<img src=")) { // Pois imagens são apenas redimensionadas e possuem um ícone diferente de edição
                html += "<div class=\"content\" style=\"text-align: center\">" + blocos.get(i).html_bloco  + "</div>" +
                        "<div class=\"links\"><a href = \"tamanhoimagem?posicao=$posicao_bloco\"><img src=\"https://icon-library.com/images/icon-resize/icon-resize-10.jpg\" alt=\"Redimensionar imagem\" width =\"17px\" heigth=\"17px\"></a>";
                html = html.replace("$posicao_bloco", Integer.toString(i));

            } else if(blocos.get(i).conteudo_bloco.equals("")){ // Pois blocos vazios podem ter apenas o conteúdo do texto editado
                html += "<div class=\"content\">" + blocos.get(i).html_bloco  + "</div>" +
                        "<div class=\"links\"><a href = \"textoconteudo?posicao=$posicao_bloco\"><img src=\"http://cdn.onlinewebfonts.com/svg/img_147067.png\" alt=\"Editar anotação\" width =\"17px\" heigth=\"17px\"></a>";
                html = html.replace("$posicao_bloco", Integer.toString(i));

            }else {
                html += "<div class=\"content\">" + blocos.get(i).html_bloco  + "</div>" +
                        "<div class=\"links\"><a href = \"editar?posicao=$posicao_bloco\"><img src=\"http://cdn.onlinewebfonts.com/svg/img_147067.png\" alt=\"Editar anotação\" width =\"17px\" heigth=\"17px\"></a>";
                html = html.replace("$posicao_bloco", Integer.toString(i));
            }

            // Mudar posição do bloco:
            html += "<a href = \"posicao?posicao_inicial=$posicao_bloco\"><img src=\"https://icon-library.com/images/change-an-icon/change-an-icon-18.jpg\" alt=\"Alterar posição da anotação\" width =\"17px\" heigth=\"17px\"></a>";
            html = html.replace("$posicao_bloco", Integer.toString(i));

            // Remover bloco:
            html += "<a href = \"remover?posicao=$posicao_bloco\"><img src=\"http://cdn.onlinewebfonts.com/svg/img_216917.png\" alt=\"Remover anotação\" width =\"17px\" heigth=\"17px\"></a></div></div>";
            html = html.replace("$posicao_bloco", Integer.toString(i));
        }

        return html;
    }
}