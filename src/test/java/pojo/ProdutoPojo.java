package pojo;

import java.util.List;

public class ProdutoPojo {
    private String produtoNome;
    private double produtoValor;
    private List<String> produtoCores;
    private String produtoUrl;
    private List<ComponentePojo> componenteProduto;

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public double getProdutoValor() {
        return produtoValor;
    }

    public void setProdutoValor(double produtoValor) {
        this.produtoValor = produtoValor;
    }

    public List<String> getProdutoCores() {
        return produtoCores;
    }

    public void setProdutoCores(List<String> produtoCores) {
        this.produtoCores = produtoCores;
    }

    public String getProdutoUrl() {
        return produtoUrl;
    }

    public void setProdutoUrl(String produtoUrl) {
        this.produtoUrl = produtoUrl;
    }

    public List<ComponentePojo> getComponenteProduto() {
        return componenteProduto;
    }

    public void setComponenteProduto(List<ComponentePojo> componenteProduto) {
        this.componenteProduto = componenteProduto;
    }
}
