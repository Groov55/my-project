package searchengine.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "site")
@Data
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "status", columnDefinition = "ENUM('INDEXING', 'INDEXED', 'FAILED')", nullable = false)
    private String status;
    @Column(name = "status_time", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime statusTime;
    @Column(name = "last_error", columnDefinition = "TEXT")
    private String last_error;

    @Column(name = "url", columnDefinition = "VARCHAR(255)", nullable = false)
    private String url;
    @Column(name = "name", columnDefinition = "VARCHAR(255)", nullable = false)
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "siteId")
    private List<Page> pageList;
}
