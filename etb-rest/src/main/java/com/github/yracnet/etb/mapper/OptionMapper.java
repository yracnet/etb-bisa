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
package com.github.yracnet.etb.mapper;

import com.github.yracnet.etb.entities.EtbPedido;
import com.github.yracnet.etb.entities.EtbProducto;
import com.github.yracnet.etb.response.Option;

public class OptionMapper {
   public static Option mapperProducto(EtbProducto producto) {
      return Option.builder()
            .key(producto.getId())
            .value(producto.getCodigo())
            .descripcion(producto.getNombre())
            .build();
   }
   public static Option mapperPedido(EtbPedido pedido) {
      return Option.builder()
            .key(pedido.getId())
            .value(pedido.getDescripcion())
            .descripcion(pedido.getDescripcion())
            .build();
   }
}
