package br.com.projetoescola.escola.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCidade;
    
    @Column(nullable = false, length = 40)
    private String nomeCidade;
    
}
