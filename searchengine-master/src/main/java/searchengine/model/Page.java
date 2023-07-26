package searchengine.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "page", indexes = @Index(name = "index",columnList = "path", unique = true))
@Data
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "site_id")
    private Site siteId;

    @Column(name = "path", columnDefinition = "TEXT", nullable = false)
    private String path;
    @Column(name = "code" , columnDefinition = "INT", nullable = false)
    private int code;
    @Column(name = "content", columnDefinition = "MEDIUMTEXT", nullable = false)
    private String content;

}
