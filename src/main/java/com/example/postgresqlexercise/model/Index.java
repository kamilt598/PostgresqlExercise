package com.example.postgresqlexercise.model;


import javax.persistence.*;

@Entity
@Table(name = "tabela_testowa")
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "kolumna1")
    private String column1;
    @Column(name = "kolumna2")
    private String column2;
    @Column(name = "kolumna3")
    private String column3;
    @Column(name = "kolumna4")
    private Long column4;

    public Index() {
    }

    public Index(Long id, String column1, String column2, String column3, Long column4) {
        this.id = id;
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
        this.column4 = column4;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    public String getColumn3() {
        return column3;
    }

    public void setColumn3(String column3) {
        this.column3 = column3;
    }

    public Long getColumn4() {
        return column4;
    }

    public void setColumn4(Long column4) {
        this.column4 = column4;
    }

    public String printAllColumns() {
        return id+";"+getColumn1()+";"+getColumn2()+";"+getColumn3()+";"+getColumn4();
    }
}
