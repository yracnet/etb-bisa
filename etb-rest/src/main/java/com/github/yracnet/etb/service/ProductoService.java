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

import com.github.yracnet.etb.controller.EtbProductoController;
import com.github.yracnet.etb.entities.EtbProducto;
import com.github.yracnet.etb.mapper.OptionMapper;
import com.github.yracnet.etb.mapper.ProductMapper;
import com.github.yracnet.etb.request.CREATE;
import com.github.yracnet.etb.request.FILTER;
import com.github.yracnet.etb.request.PING;
import com.github.yracnet.etb.request.ProductoForm;
import com.github.yracnet.etb.request.REMOVE;
import com.github.yracnet.etb.request.UPDATE;
import com.github.yracnet.etb.response.Message;
import com.github.yracnet.etb.response.Option;
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
@Path("/producto")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductoService {
   @Inject
   private EtbProductoController controller;
   @Inject
   private Jsonb parser;
   @Inject
   private ProductMapper mapper;

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
      List<EtbProducto> list = controller.list();
      List<Option> data = list.stream()
            .map(OptionMapper::mapperProducto)
            .collect(Collectors.toList());
      return Message.builder()
            .title("PING")
            .description("OK")
            .build()
            .asResultList(data);
   }

   @CREATE
   public Result create(ProductoForm producto) {
      try {
         EtbProducto etbProducto = mapper.parseEtbProducto(producto);
         etbProducto = controller.create(etbProducto);
         producto = mapper.parseProducto(etbProducto);
         return Message.builder()
               .title("CREATE")
               .description("OK")
               .build()
               .asResultData(producto);
      } catch (Exception e) {
         return Message.asMessage(e).asResult();
      }
   }

   @UPDATE
   @Path("{id}")
   public Result update(@PathParam("id") UUID id, ProductoForm producto) {
      try {
         EtbProducto etbProducto = controller.find(id);
         etbProducto = mapper.parseEtbProducto(producto, etbProducto);
         etbProducto = controller.update(etbProducto);
         producto = mapper.parseProducto(etbProducto);
         return Message.builder()
               .title("UPDATE")
               .description("OK")
               .build()
               .asResultData(producto);
      } catch (Exception e) {
         return Message.asMessage(e).asResult();
      }
   }

   @REMOVE
   @Path("{id}")
   public Result remove(@PathParam("id") UUID id) {
      try {
         EtbProducto etbProducto = controller.find(id);
         etbProducto = controller.remove(etbProducto);
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
