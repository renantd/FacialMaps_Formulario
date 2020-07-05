package br.sofex.com.facialmaps_formulario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.sofex.com.Biblioteca.ComboBox;
import br.sofex.com.facialmaps_formulario.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    EditText cp_nome,cp_doc_value,cp_data_nasc,cp_tel_fixo,cp_tel_cel,
    cp_email,cp_cep,cp_end,cp_comp,cp_num,cp_bairro,cp_mun,cp_estado,cp_file_name;

    Spinner  spin_documento,spin_pais,spin_etnia;
    RadioGroup  RadioGrouprg_sexo;
    RadioButton rb_masculino,rb_feminino,rb_transgenero,rb_nao_binario;
    Button Btnsalvar;

    TableRow tr_img_escolhido;

    ComboBox combobox = new ComboBox(MainActivity.this);

    //TODO : É este cara que vai guardar a referencia para tudo do seu layout.
    ActivityMainBinding conteudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //Inicializando o nosso conteúdo.
        conteudo = DataBindingUtil.setContentView(this, R.layout.activity_main);

        List<String> List_Documento = new ArrayList<>();
        List_Documento.add("Selecione o Documento");
        List_Documento.add("CPF");
        List_Documento.add("CNH");
        List_Documento.add("Carteira de Trabalho");
        List_Documento.add("Título de Eleitor");
        List_Documento.add("Passaporte");

        List<String> List_Pais = new ArrayList<>();
        List_Pais.add("Selecione a Nacionalidade");
        List_Pais.add("Brasil");
        List_Pais.add("Estados Unidos");
        List_Pais.add("Canadá");
        List_Pais.add("Inglaterra");

        List<String> List_Etnia = new ArrayList<>();
        List_Etnia.add("Selecione a Etnia");
        List_Etnia.add("Caucasiano(a)");
        List_Etnia.add("Afro-Descendente");
        List_Etnia.add("Latino/Hispânico(a)");
        List_Etnia.add("Asiático(a)");
        List_Etnia.add("Pardo(a)/Mulato(a)");
        List_Etnia.add("Cafuzo(a)");

        combobox.ComboBox(List_Documento,conteudo.spinDocumento,0);
        combobox.ComboBox(List_Pais,conteudo.spinPais,0);
        combobox.ComboBox(List_Etnia,conteudo.spinEtnia,0);
        conteudo.trImgEscolhido.setVisibility(View.GONE);
        disableEditText(conteudo.cpFileName);


        final String[] checkedBox = {""};
        conteudo.rgSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
           // TODO Auto-generated method stub
           int checkedRadio = conteudo.rgSexo.getCheckedRadioButtonId();
           RadioButton checkedRadioButton = findViewById(checkedRadio);
           checkedBox[0] = checkedRadioButton.getText().toString();
            }
        });

        conteudo.BtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            formulario_part1(conteudo.cpNome.getText().toString(),conteudo.spinDocumento.getSelectedItem().toString(),conteudo.cpDocValue.getText().toString(),
            conteudo.cpDataNasc.getText().toString(),conteudo.spinPais.getSelectedItem().toString(),conteudo.spinEtnia.getSelectedItem().toString(), checkedBox[0],
            conteudo.cpTelFixo.getText().toString(),conteudo.cpTelCel.getText().toString(),conteudo.cpEmail.getText().toString(),conteudo.cpCep.getText().toString(),
            conteudo.cpEnd.getText().toString(),conteudo.cpComp.getText().toString(),conteudo.cpNum.getText().toString(),conteudo.cpBairro.getText().toString(),
            conteudo.cpMun.getText().toString(),conteudo.cpEstado.getText().toString());
            }
        });

    }

    public void formulario_part1(String nome, final String documento, String valor_documento, String data_nascimento, final String pais, final String etnia,String Sexo,
    String fixo, final String celular, String email, String cep, final String endereco, final String complemento,String numero,String bairro, final String municipio, String estado){

        if(!nome.isEmpty()  && documento != "Selecione o Documento" && !valor_documento.isEmpty()
           && !data_nascimento.isEmpty() && pais != "Selecione a Nacionalidade" && etnia!= "Selecione a Etnia" && !Sexo.isEmpty() &&
           !fixo.isEmpty()  && !celular.isEmpty() && !email.isEmpty() && !cep.isEmpty()  && !endereco.isEmpty() && !complemento.isEmpty()&&
           !numero.isEmpty()  && !bairro.isEmpty() && !municipio.isEmpty() && !estado.isEmpty()){

           conteudo.cpNome.setHintTextColor(Color.parseColor("#FFFFFF"));  conteudo.cpNome.setCursorVisible(false);
           Toast.makeText(MainActivity.this, "Dados OK", Toast.LENGTH_SHORT).show();

        }
        else {

            if(nome.isEmpty()){
                Toast.makeText(MainActivity.this, "Nome inválido !", Toast.LENGTH_SHORT).show();
                conteudo.cpNome.setHintTextColor(Color.parseColor("#F40628"));
                conteudo.cpNome.requestFocus();
            }
            else if(documento == "Selecione o Documento"){Toast.makeText(MainActivity.this, "Tipo de Documento inválido !", Toast.LENGTH_SHORT).show();}
            else if(valor_documento.isEmpty()){Toast.makeText(MainActivity.this, "Valor do Documento inválido !", Toast.LENGTH_SHORT).show();}
            else if(data_nascimento.isEmpty()){Toast.makeText(MainActivity.this, "Data de Nascimento inválida !", Toast.LENGTH_SHORT).show();}
            else if(pais == "Selecione a Nacionalidade"){Toast.makeText(MainActivity.this, "País inválido !", Toast.LENGTH_SHORT).show();}
            else if(etnia == "Selecione a Etnia"){Toast.makeText(MainActivity.this, "Etnia inválido !", Toast.LENGTH_SHORT).show();}
            else if(Sexo.isEmpty()){System.out.println("Nenhum sexo Selecionado !");}

            else if(fixo.isEmpty()){Toast.makeText(MainActivity.this, "Telefone Fixo inválido !", Toast.LENGTH_SHORT).show();}
            else if(celular.isEmpty()){Toast.makeText(MainActivity.this, "Telefone Celular inválido !", Toast.LENGTH_SHORT).show();}
            else if(email.isEmpty()){Toast.makeText(MainActivity.this, "Email inválida !", Toast.LENGTH_SHORT).show();}


            else if(cep.isEmpty()){Toast.makeText(MainActivity.this, "Cep inválido !", Toast.LENGTH_SHORT).show();}
            else if(endereco.isEmpty()){Toast.makeText(MainActivity.this, "Endereço inválido !", Toast.LENGTH_SHORT).show();}
            else if(complemento.isEmpty()){Toast.makeText(MainActivity.this, "Complemento inválido !", Toast.LENGTH_SHORT).show();}
            else if(numero.isEmpty()){Toast.makeText(MainActivity.this, "número inválido !", Toast.LENGTH_SHORT).show();}
            else if(bairro.isEmpty()){Toast.makeText(MainActivity.this, "Bairro inválido !", Toast.LENGTH_SHORT).show();}
            else if(municipio.isEmpty()){Toast.makeText(MainActivity.this, "Município inválido !", Toast.LENGTH_SHORT).show();}
            else if(estado.isEmpty()){Toast.makeText(MainActivity.this, "Estado inválido !", Toast.LENGTH_SHORT).show();}

        }

    }

    private void disableEditText(EditText editText) {
        editText.setFocusable(false);
        editText.setEnabled(false);
        editText.setCursorVisible(false);
        editText.setKeyListener(null);
    }
    public String SexoSelecionado(){
        final String[] checkedBox = {""};
        conteudo.rgSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                int checkedRadio = conteudo.rgSexo.getCheckedRadioButtonId();
                RadioButton checkedRadioButton = findViewById(checkedRadio);
                checkedBox[0] = checkedRadioButton.getText().toString();
                //Toast.makeText(MainActivity.this, "Teste : "+ checkedBox[0], Toast.LENGTH_SHORT).show();
            }
        });
        return checkedBox[0];
    }

}
