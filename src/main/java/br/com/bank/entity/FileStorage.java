package br.com.bank.entity;

import br.com.bank.enumeration.FileTypeEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "file_storage")
public class FileStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private Long id;
    @Column(name = "doc_type")
    private String docType;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "path")
    private String path;
    @Column(name = "file_type")
    private FileTypeEnum fileType;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
