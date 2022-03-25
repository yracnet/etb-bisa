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
public class EtbPedidoController extends AbstractController<EtbPedido, UUID> {
   @Inject
   private EntityManager em;

   public EtbPedidoController() {
      super(EtbPedido.class);
   }

   public void appendProduct(EtbPedido pedido, EtbProducto producto) {
      EtbPedidoDetalle detalle = new EtbPedidoDetalle();
      detalle.setPedido(pedido);
      detalle.setProducto(producto);
      em.persist(detalle);
   }

   public int removeProduct(EtbPedido pedido, EtbProducto producto) {
      return em.createQuery("DELETE FROM EtbPedidoDetalle o WHERE o.pedido = :pedido AND o.producto = :producto")
            .setParameter("pedido", pedido)
            .setParameter("producto", producto)
            .executeUpdate();
   }
}
