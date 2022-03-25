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
package com.github.yracnet.etb.service;

import com.github.yracnet.etb.controller.*;
import com.github.yracnet.etb.entities.*;
import com.github.yracnet.etb.mapper.*;
import com.github.yracnet.etb.request.CREATE;
import com.github.yracnet.etb.request.FILTER;
import com.github.yracnet.etb.request.PING;
import com.github.yracnet.etb.request.PedidoDetalleForm;
import com.github.yracnet.etb.request.REMOVE;
import com.github.yracnet.etb.request.UPDATE;
import com.github.yracnet.etb.response.Message;
import com.github.yracnet.etb.response.Result;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Transactional
@Path("/pedido/detalle")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoDetalleService {
   @Inject
   private EtbPedidoDetalleController controller;
   @Inject
   private EtbProductoController controller2;
   @Inject
   private EtbPedidoController controller1;
   @Inject
   private Jsonb parser;
   @Inject
   private PedidoDetalleMapper mapper;

   @PING
   public Result ping() {
      return Message.builder()
            .title("PING")
            .description("OK")
            .build()
            .asResult();
   }

   @FILTER
   public Result list() {
      List<EtbPedidoDetalle> list = controller.list();
      List<PedidoDetalleForm> data = list.stream()
            .map(mapper::parsePedidoDetalle)
            .collect(Collectors.toList());
      return Message.builder()
            .title("PING")
            .description("OK")
            .build()
            .asResultList(data);
   }

   @CREATE
   public Result create(PedidoDetalleForm detalle) {
      try {
         EtbPedidoDetalle etbPedidoDetalle = mapper.parseEtbPedidoDetalle(detalle);
         
         EtbPedido etbPedido = controller1.find(detalle.getIdPedido());
         EtbProducto etbProducto = controller2.find(detalle.getIdProducto());
         etbPedidoDetalle.setPedido(etbPedido);
         etbPedidoDetalle.setProducto(etbProducto);
         
         
         
         etbPedidoDetalle = controller.create(etbPedidoDetalle);
         
         
         detalle = mapper.parsePedidoDetalle(etbPedidoDetalle);
         
         
         return Message.builder()
               .title("CREATE")
               .description("OK")
               .build()
               .asResultData(detalle);
      } catch (Exception e) {
         return Message.asMessage(e).asResult();
      }
   }

   @UPDATE
   @Path("{id}")
   public Result update(@PathParam("id") UUID id, PedidoDetalleForm detalle) {
      try {
         EtbPedidoDetalle etbPedidoDetalle = controller.find(id);
         etbPedidoDetalle = mapper.parseEtbPedidoDetalle(detalle, etbPedidoDetalle);
         EtbPedido etbPedido = controller1.find(detalle.getIdPedido());
         EtbProducto etbProducto = controller2.find(id);
         etbPedidoDetalle.setPedido(etbPedido);
         etbPedidoDetalle.setProducto(etbProducto);
         
         etbPedidoDetalle = controller.update(etbPedidoDetalle);
         detalle = mapper.parsePedidoDetalle(etbPedidoDetalle);
         return Message.builder()
               .title("UPDATE")
               .description("OK")
               .build()
               .asResultData(detalle);
      } catch (Exception e) {
         return Message.asMessage(e).asResult();
      }
   }

   @REMOVE
   @Path("{id}")
   public Result remove(@PathParam("id") UUID id) {
      try {
         EtbPedidoDetalle etbPedidoDetalle = controller.find(id);
         etbPedidoDetalle = controller.remove(etbPedidoDetalle);
         return Message.builder()
               .title("REMOVE")
               .description("OK")
               .build()
               .asResult();
      } catch (Exception e) {
         return Message.asMessage(e).asResult();
      }
   }
}
