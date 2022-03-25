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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "ETB_PRODUCTO")
@ToString(callSuper = false, exclude = {})
@EqualsAndHashCode(of = {"id"})
public class EtbProducto implements Serializable {
   @Id
   @GeneratedValue(generator = "UUID")
   private UUID id;
   @Column(name = "CODIGO")
   private String codigo;
   @Column(name = "NOMBRE")
   private String nombre;
   @Column(name = "COSTO")
   private int costo;
   @Version
   @Column(name = "AUD_VERSION")
   private long version;
}