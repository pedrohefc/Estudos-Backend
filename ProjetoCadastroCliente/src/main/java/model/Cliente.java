package model;

import java.util.Objects;

public class Cliente {

    // ---------- Campos do cliente ----------
    private String nome;    // Imutável: não precisa de setter
    private final Long cpf;       // Imutável: CPF não deve mudar
    private Long tel;             // Telefone pode mudar → setter permitido
    private String end;           // Endereço pode mudar → setter permitido
    private Integer numero;       // Número da casa pode mudar → setter permitido
    private String cidade;        // Cidade pode mudar → setter permitido
    private String estado;        // Estado pode mudar → setter permitido

    // ---------- Construtor ----------
    // Recebe Strings e converte para Long/Integer se necessário
    public Cliente(String nome, String cpf, String tel, String end, String numero, String cidade, String estado) {
        this.nome = nome;
        this.cpf = Long.valueOf(cpf.trim());       // transforma String em Long
        this.tel = Long.valueOf(tel.trim());
        this.end = end;
        this.numero = Integer.valueOf(numero.trim());
        this.cidade = cidade;
        this.estado = estado;
    }

    // ---------- Getters ----------
    public String getNome() { return nome; }      // Sempre usar getter para ler
    public Long getCpf() { return cpf; }          // Sempre usar getter para ler
    public Long getTel() { return tel; }
    public String getEnd() { return end; }
    public Integer getNumero() { return numero; }
    public String getCidade() { return cidade; }
    public String getEstado() { return estado; }

    // ---------- Setters (para campos que podem mudar) ----------
    public void setTel(Long tel) { this.tel = tel; }
    public void setEnd(String end) { this.end = end; }
    public void setNumero(Integer numero) { this.numero = numero; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setNome(String nome) { this.nome = nome; }

    // ---------- equals e hashCode ----------
    // Dois clientes são iguais se tiverem o mesmo CPF
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                    // mesma referência → igual
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);                      // hash baseado no CPF
    }

    // ---------- toString (opcional, útil para debug) ----------
    @Override
    public String toString() {
        return "model.Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                '}';
    }
}

