package br.sofex.com.Biblioteca;

import android.content.Context;

import java.io.File;

public class Arquivo_Imagem {

    Context mContext;
    Arquivo_Imagem(Context context)
    {this.mContext = context;}

    public String Nome_Arquivo(File Nome_do_arquivo){
        return  Nome_do_arquivo.getName();
    }
    public String Arquivo_Caminho(File Nome_do_arquivo){
        return  Nome_do_arquivo.getAbsolutePath();
    }
    public Boolean Check_IfExists(File Nome_do_arquivo){
        if(Nome_do_arquivo.exists()){return true;}
        else{ return  false;}
    }
    public String Arquivo_TotalUsado(File Nome_do_arquivo){
        return  Nome_do_arquivo.getTotalSpace()+" KB";
    }


}
