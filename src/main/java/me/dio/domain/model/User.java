package me.dio.domain.model;

import jakarta.persistence.*;

import java.util.List;
@Entity(name = "tb_user") //add a anotação @Entity para representar uma Entidade, onde name=tb_user, sera o nome da taabela.
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //add anotação para criação automatica do id
    private  Long id; // Foi add um atributo "id" em todas as classes, para cada uma das entidades possuir um Identificador número único


    private String name;

    @OneToOne(cascade = CascadeType.ALL) // add anotação para criar um relacionamento "um para um". O cascade garante que as entidades tenham um relacionamento muito forte.
                                        //quando um usuario foi deletaado, a conta tbm é deletada
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) //// add anotação para criar um relacionamento "um para muitos". Um usuário tem muitas features.
    private List<Feature> features;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // fetch EAGER - significa que toda vez que for buscar um usuario no BD
                                                                  //gostaria que ele trouxe-se a lista de feature dela pois sempre vou delas pra esse constexto da API.
    private List<News> news;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
