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
package com.github.yracnet.etb.controller;

import com.github.yracnet.etb.entities.EtbPedido;
import com.github.yracnet.etb.entities.EtbPedidoDetalle;
import com.github.yracnet.etb.entities.EtbProducto;
import java.util.UUID;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@RequestScoped
public class EtbPedidoDetalleController extends AbstractController<EtbPedidoDetalle, UUID> {
   @Inject
   private EntityManager em;

   public EtbPedidoDetalleController() {
      super(EtbPedidoDetalle.class);
   }

   @Override
   public EtbPedidoDetalle create(EtbPedidoDetalle entity) {
      EtbPedido pedido = entity.getPedido();
      EtbProducto producto = entity.getProducto();
      if (pedido == null || pedido.getId() == null) {
         throw new RuntimeException("Pedido es requesido");
      }
      if (producto == null || producto.getId() == null) {
         throw new RuntimeException("Producto es requerido");
      }
      int total = producto.getCosto() * entity.getCantidad();
      entity.setTotal(total);
      return super.create(entity);
   }

   @Override
   public EtbPedidoDetalle update(EtbPedidoDetalle entity) {
      EtbPedido pedido = entity.getPedido();
      EtbProducto producto = entity.getProducto();
      if (pedido == null || pedido.getId() == null) {
         throw new RuntimeException("Pedido es requesido");
      }
      if (producto == null || producto.getId() == null) {
         throw new RuntimeException("Producto es requerido");
      }
      int total = producto.getCosto() * entity.getCantidad();
      entity.setTotal(total);
      return super.update(entity);
   }

}
