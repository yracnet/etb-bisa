/**
 *   _   _ _     _         ____         __ _
 *  | | | (_)___| | ____ _/ ___|  ___  / _| |_
 *  | |_| | / __| |/ / _` \___ \ / _ \| |_| __|
 *  |  _  | \__ \   < (_| |___) | (_) |  _| |_
 *  |_| |_|_|___/_|\_\__,_|____/ \___/|_|  \__|
 *
 *  Copyright © 2022 HiskaSoft
 *  http://www.hiskasoft.com/licenses/LICENSE-2.0
 */
package com.github.yracnet.etb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "ETB_PEDIDO")
@ToString(callSuper = false, exclude = {})
@EqualsAndHashCode(of = {"id"})
public class EtbPedido implements Serializable {
   @Id
   @GeneratedValue(generator = "UUID")
   private UUID id;
    @Column(name = "CLIENTE")
    private String cliente;
    @Column(name = "DESCIPCION")
    private String descripcion;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "FECHA_ACTIVACION")
    private Date fecha;
    //@OneToMany(mappedBy="pedido" )
    //private List<EtbPedidoDetalle> detalle;
   @Version
   @Column(name = "AUD_VERSION")
   private long version;
}