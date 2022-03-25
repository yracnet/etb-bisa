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

import com.github.yracnet.etb.entities.EtbPedidoDetalle;
import com.github.yracnet.etb.request.PedidoDetalleForm;

public class PedidoDetalleMapper {
   public EtbPedidoDetalle parseEtbPedidoDetalle(PedidoDetalleForm in) {
      EtbPedidoDetalle out = new EtbPedidoDetalle();
      out.setId(in.getId());
      out.setVersion(in.getVersion());
      return parseEtbPedidoDetalle(in, out);
   }

   public EtbPedidoDetalle parseEtbPedidoDetalle(PedidoDetalleForm in, EtbPedidoDetalle out) {
      
      out.setCantidad(in.getCantidad());
      out.setTotal(in.getTotal());
      return out;
   }

   public PedidoDetalleForm parsePedidoDetalle(EtbPedidoDetalle in) {
      PedidoDetalleForm out = new PedidoDetalleForm();
      out.setId(in.getId());
      out.setVersion(in.getVersion());
      return parsePedidoDetalle(in, out);
   }

   public PedidoDetalleForm parsePedidoDetalle(EtbPedidoDetalle in, PedidoDetalleForm out) {
      
      out.setCantidad(in.getCantidad());
      out.setTotal(in.getTotal());
      
      out.setIdPedido(in.getPedido().getId());
      out.setIdProducto(in.getProducto().getId());
      return out;
   }
}
