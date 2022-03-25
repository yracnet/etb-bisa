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
import com.github.yracnet.etb.request.PedidoForm;

public class PedidoMapper {
   public EtbPedido parseEtbPedido(PedidoForm in) {
      EtbPedido out = new EtbPedido();
      out.setId(in.getId());
      out.setVersion(in.getVersion());
      return parseEtbPedido(in, out);
   }

   public EtbPedido parseEtbPedido(PedidoForm in, EtbPedido out) {
      out.setFecha(in.fechaAsDate());
      out.setDescripcion(in.getDescripcion());
      return out;
   }

   public PedidoForm parsePedido(EtbPedido in) {
      PedidoForm out = new PedidoForm();
      out.setId(in.getId());
      out.setVersion(in.getVersion());
      return parsePedido(in, out);
   }

   public PedidoForm parsePedido(EtbPedido in, PedidoForm out) {
      out.fechaAsDate(in.getFecha());
      out.setDescripcion(in.getDescripcion());
      return out;
   }
}
