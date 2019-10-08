package app.entity;

import java.io.*;
import javax.persistence.*;
import java.util.*;
import javax.xml.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonFilter;
import cronapi.rest.security.CronappSecurity;


/**
 * Classe que representa a tabela NOTICIA
 * @generated
 */
@Entity
@Table(name = "\"NOTICIA\"")
@XmlRootElement
@CronappSecurity
@JsonFilter("app.entity.Noticia")
public class Noticia implements Serializable {

  /**
   * UID da classe, necessário na serialização
   * @generated
   */
  private static final long serialVersionUID = 1L;

  /**
   * @generated
   */
  @Id
  @Column(name = "id", nullable = false, insertable=true, updatable=true)
  private java.lang.String id = UUID.randomUUID().toString().toUpperCase();

  /**
  * @generated
  */
  @Column(name = "noticia", nullable = true, unique = false, insertable=true, updatable=true)
  
  private java.lang.String noticia;

  /**
  * @generated
  */
  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "publicadaEm", nullable = true, unique = false, insertable=true, updatable=true, columnDefinition = "TIMESTAMP")
  
  private java.util.Date publicadaEm;

  /**
   * Construtor
   * @generated
   */
  public Noticia(){
  }


  /**
   * Obtém id
   * return id
   * @generated
   */
  
  public java.lang.String getId(){
    return this.id;
  }

  /**
   * Define id
   * @param id id
   * @generated
   */
  public Noticia setId(java.lang.String id){
    this.id = id;
    return this;
  }

  /**
   * Obtém noticia
   * return noticia
   * @generated
   */
  
  public java.lang.String getNoticia(){
    return this.noticia;
  }

  /**
   * Define noticia
   * @param noticia noticia
   * @generated
   */
  public Noticia setNoticia(java.lang.String noticia){
    this.noticia = noticia;
    return this;
  }

  /**
   * Obtém publicadaEm
   * return publicadaEm
   * @generated
   */
  
  public java.util.Date getPublicadaEm(){
    return this.publicadaEm;
  }

  /**
   * Define publicadaEm
   * @param publicadaEm publicadaEm
   * @generated
   */
  public Noticia setPublicadaEm(java.util.Date publicadaEm){
    this.publicadaEm = publicadaEm;
    return this;
  }

  /**
   * @generated
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    Noticia object = (Noticia)obj;
    if (id != null ? !id.equals(object.id) : object.id != null) return false;
    return true;
  }

  /**
   * @generated
   */
  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

}
