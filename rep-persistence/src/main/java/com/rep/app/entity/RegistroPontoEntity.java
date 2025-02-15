package com.rep.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@NamedQueries({
        @NamedQuery(name = RegistroPontoEntity.QUERY_FIND_MAX_NUMERO_SEQUENCIAL,
        query = "SELECT COALESCE(MAX(rp.numSeqRegistro), 0) FROM RegistroPontoEntity rp"),

        @NamedQuery(name = RegistroPontoEntity.QUERY_FIND_MAX_ES_NUMERO_SEQUENCIAL,
        query = "SELECT COALESCE(MAX(rp.numSeqEsRegistro), 0) FROM RegistroPontoEntity rp"),

        @NamedQuery(name = RegistroPontoEntity.QUERY_FIND_LAST_REGISTRO_PONMTO_ENTITY_BY_FUNCIONARIO,
        query = "SELECT rp FROM RegistroPontoEntity rp WHERE rp.empregado.idEmpregado = :id_empregado ORDER BY rp.numSeqRegistro DESC"),

        @NamedQuery(name = RegistroPontoEntity.QUERY_FIND_BY_DATA_INICIO_AND_DATA_FIM,
        query = "SELECT rp FROM RegistroPontoEntity rp WHERE rp.dataMarcacaoPonto >= :dataInicio AND rp.dataMarcacaoPonto <= :dataFim"),

        @NamedQuery(name = RegistroPontoEntity.QUERY_FIND_BY_MES,
        query = "SELECT rp FROM RegistroPontoEntity rp WHERE MONTH(rp.dataMarcacaoPonto) = :mes"),

        @NamedQuery(name = RegistroPontoEntity.QUERY_FIND_BY_NUMERO_SEQUENCIAL,
        query = "SELECT rp FROM RegistroPontoEntity rp WHERE rp.numSeqRegistro = :numeroSequencial")
})
@Table(name = "TBL_REGISTRO_PONTO")
public class RegistroPontoEntity {

    public static final String QUERY_FIND_MAX_NUMERO_SEQUENCIAL = "QUERY_FIND_MAX_NUMERO_SEQUENCIAL";
    public static final String QUERY_FIND_MAX_ES_NUMERO_SEQUENCIAL = "QUERY_FIND_MAX_ES_NUMERO_SEQUENCIAL";
    public static final String QUERY_FIND_LAST_REGISTRO_PONMTO_ENTITY_BY_FUNCIONARIO = "QUERY_FIND_LAST_REGISTRO_PONMTO_ENTITY_BY_FUNCIONARIO";
    public static final String QUERY_FIND_BY_DATA_INICIO_AND_DATA_FIM = "QUERY_FIND_BY_DATA_INICIO_AND_DATA_FIM";
    public static final String QUERY_FIND_BY_MES = "QUERY_FIND_BY_MES";
    public static final String QUERY_FIND_BY_NUMERO_SEQUENCIAL = "QUERY_FIND_BY_NUMERO_SEQUENCIAL";

    @Id
    @Column(name = "id_registro_ponto")
    private String idRegistroPonto;

    @Column(name = "num_seq_registro")
    private int numSeqRegistro;

    @Column(name = "num_seq_es_registro")
    private int numSeqEsRegistro;

    @Column(name = "data_marcacao_ponto")
    private LocalDate dataMarcacaoPonto;

    @Column(name = "hora_marcacao_ponto")
    private LocalTime horaMarcacaoPonto;

    @Column(name = "fuso_horario_marcacao")
    private String fusoHorarioMarcacao;

    @Column(name = "fuso_horario_registro")
    private String fusoHorarioRegistro;

    @Column(name = "data_hora_inclusao_registro")
    private LocalDateTime dataHoraInclusaoRegistro;

    @Column(name = "marcacao_online")
    private boolean marcacaoOnline;

    @Column(name = "cpf_funcionario")
    private String cpfFuncionario;

    @Column(name = "hash_registro")
    private byte[] hashRegistro;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @Column(name = "motivo_marcacao")
    private String motivoMarcacao;

    @ManyToOne
    @JoinColumn(name = "cod_idef_coletor")
    private ColetorRegistroEntity coletorRegistro;

    @ManyToOne
    @JoinColumn(name = "cod_tipo_marcao")
    private TipoMarcacaoEntity tipoMarcacao;

    @ManyToOne
    @JoinColumn(name = "cod_fonte_marcacao")
    private FonteMarcacaoEntity fonteMarcacao;

    @ManyToOne
    @JoinColumn(name = "id_empregado")
    private EmpregadoEntity empregado;

    @Column(name = "registro_alterado")
    private Boolean registroAlterado;

    @Column(name = "registro_alterado_aprovacao")
    private Boolean registroAlteradoAprovacao;

    @Column(name = "hora_marcacao_ponto_original")
    private LocalTime horaMarcacaoPontoOriginal;

    @Column(name = "excluido")
    private boolean excluido;

    @Column(name = "registro_excluido_aprovacao")
    private boolean registroExcluidoAprovacao;

    @PrePersist
    public void generateId() {
        idRegistroPonto = UUID.randomUUID().toString();
    }

}
