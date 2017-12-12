package com.ricardococati.model;

import javax.persistence.*;

/**
 * Created by joao on 12/12/17.
 */
@Entity
public class CustoNodeGrafo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_custo_node_grafo")
    private Integer id;

    @Column(name = "node_origem")
    private String nodeOrigem;

    @Column(name = "node_destino")
    private String nodeDestino;

    @Column(name = "custo")
    private Integer custo;

    public CustoNodeGrafo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNodeOrigem() {
        return nodeOrigem;
    }

    public void setNodeOrigem(String nodeOrigem) {
        this.nodeOrigem = nodeOrigem;
    }

    public String getNodeDestino() {
        return nodeDestino;
    }

    public void setNodeDestino(String nodeDestino) {
        this.nodeDestino = nodeDestino;
    }

    public Integer getCusto() {
        return custo;
    }

    public void setCusto(Integer custo) {
        this.custo = custo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustoNodeGrafo that = (CustoNodeGrafo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nodeOrigem != null ? !nodeOrigem.equals(that.nodeOrigem) : that.nodeOrigem != null) return false;
        if (nodeDestino != null ? !nodeDestino.equals(that.nodeDestino) : that.nodeDestino != null) return false;
        return custo != null ? custo.equals(that.custo) : that.custo == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nodeOrigem != null ? nodeOrigem.hashCode() : 0);
        result = 31 * result + (nodeDestino != null ? nodeDestino.hashCode() : 0);
        result = 31 * result + (custo != null ? custo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustoNodeGrafo{" +
                "id=" + id +
                ", nodeOrigem='" + nodeOrigem + '\'' +
                ", nodeDestino='" + nodeDestino + '\'' +
                ", custo=" + custo +
                '}';
    }
}
