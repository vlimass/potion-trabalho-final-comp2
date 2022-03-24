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

public class Bloco {
    protected String conteudo_bloco;
    protected String tipo_bloco;
    protected String html_bloco;
    protected String cor_bloco = "black";
    protected String cor_background_bloco = "#f3f3f3";
    protected String fonte_bloco = "Arial";
    protected String tamanho_imagem_bloco = "350px";

    protected Bloco(String bloco, String tipo_bloco){
        this.conteudo_bloco = bloco; // Armazena o conteúdo do bloco sem as tags HTML
        this.tipo_bloco = tipo_bloco; // Armazena o tipo de tag HTML do bloco
    }

    protected void recebeNovoTexto(String novo_texto){ conteudo_bloco = novo_texto; }

    protected void recebeCor(String cor){ cor_bloco = cor; }

    protected void recebeCorBackground(String cor){ cor_background_bloco = cor; }

    protected void recebeFonte(String fonte){ fonte_bloco = fonte; }

    protected void recebeTamanhoImagem(String tamanho){ tamanho_imagem_bloco = tamanho; }

    protected void blocoToHTML(){
        if(tipo_bloco.equals("h1")) this.html_bloco = "<h1 style=\"display: inline-block ; color: "+ cor_bloco +"; background-color:"+ cor_background_bloco +"; font-family: "+ fonte_bloco +"\">" + this.conteudo_bloco + "</h1>";
        if(tipo_bloco.equals("h2")) this.html_bloco = "<h2 style=\"display: inline-block; color: "+ cor_bloco +"; background-color:"+ cor_background_bloco +"; font-family: "+ fonte_bloco +"\">" + this.conteudo_bloco + "</h2>";
        if(tipo_bloco.equals("p")) this.html_bloco = "<p style=\"display: inline-block; color: "+ cor_bloco +"; background-color:"+ cor_background_bloco +"; font-family: "+ fonte_bloco +"\">" + this.conteudo_bloco + "</p>";
        if(tipo_bloco.equals("a")) this.html_bloco = "<a href="+ this.conteudo_bloco +" target=\"_blank\" style=\"color:"+ cor_bloco +"; background-color:"+ cor_background_bloco +"; font-family: "+ fonte_bloco +"; text-decoration: underline\">"+ this.conteudo_bloco +"</a>";
        if(tipo_bloco.equals("img")) this.html_bloco ="<img src=\""+ this.conteudo_bloco +"\" alt=\""+ this.conteudo_bloco +"\" height=\""+ tamanho_imagem_bloco +"\">";
    }

}
