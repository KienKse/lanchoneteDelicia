package ws.domore.lanchonetedelicia;

import java.io.Serializable;

public class Produto implements Serializable {

    private Integer _id;
	private String nome;
	private String preco;
	private String descricao;
	private String imagem;

    public Produto() {
        super();
    }

	public Produto(String nome , String preco, String descricao, Integer _id) {
        this._id = _id;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }


    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer get_id() {
        return _id;
    }

    @Override
    public String toString() {
        return nome;
    }

}
