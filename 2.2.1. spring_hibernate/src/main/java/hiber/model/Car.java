package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;

    @OneToOne(mappedBy = "car")
    private User user;

    public Car() {}

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getModel() {return model;}
    public void setModel() {this.model = model;}

    public int getSeries() {return series;}
    public void setSeries() {this.series = series;}

    public User getUser() {return user;}
    public void setUser() {this.user = user;}

    @Override
    public String toString() {
        return  "model: '" + model + '\'' +
                " series: " + series;
    }
}
