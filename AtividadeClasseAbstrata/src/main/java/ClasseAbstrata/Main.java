package ClasseAbstrata;

public class Main {
    public static void main(String[] args) {
        pessoaFisica();
        pessoaJuridica();
    }

    public static void pessoaFisica() {
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("João");
        pf.setCpf("1235698774");
        pf.setEndereco("Rua 1");
        pf.setTelefone("21985452354");

        System.out.println(pf.getNome() + " com CPF " + pf.getCpf() +
                " mora na " + pf.getEndereco() + " e pode ser contatado(a) pelo telefone " + pf.getTelefone() + ".");

    }

    public static void pessoaJuridica() {
        PessoaJuridica pj = new PessoaJuridica();
        pj.setNome("EbacJava");
        pj.setCnpj("1235698774");
        pj.setEndereco("Rua 2");
        pj.setTelefone("219854525555");

        System.out.println("A empresa " + pj.getNome() + " com CNPJ " + pj.getCnpj() +
                " está localizada na " + pj.getEndereco() + " e pode ser contatada pelo telefone " + pj.getTelefone() + ".");
    }
}
