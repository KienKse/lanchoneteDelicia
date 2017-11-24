package ws.domore.lanchonetedelicia;

import java.io.Serializable;

public class Produto implements Serializable {

    private Integer idImagem;
	private String nome;
	private String valor;
	private String desc;
//	private Imagem imagem;

    public Produto() {
        super();
    }

	public Produto(String nome ,String valor, String desc, Integer idImagem) {
        this.idImagem = idImagem;
        this.nome = nome;
        this.valor = valor;
        this.desc = desc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getIdImagem() {
        return idImagem;
    }

//  public String getImagem(Imagem img) {
//      return img;
//  }

    @Override
    public String toString() {
        return nome;
    }

}
