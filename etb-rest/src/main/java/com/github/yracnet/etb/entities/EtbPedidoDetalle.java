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
import java.util.UUID;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "ETB_PEDIDO_DETALLE")
@ToString(callSuper = false, exclude = {})
@EqualsAndHashCode(of = {"id"})
public class EtbPedidoDetalle implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private EtbPedido pedido;
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private EtbProducto producto;
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Column(name = "TOTAL")
    private int total;
    @Version
    @Column(name = "AUD_VERSION")
    private long version;
}
