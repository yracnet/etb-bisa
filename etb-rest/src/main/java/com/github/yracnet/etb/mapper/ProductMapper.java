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

import com.github.yracnet.etb.entities.EtbProducto;
import com.github.yracnet.etb.request.ProductoForm;

public class ProductMapper {
   public EtbProducto parseEtbProducto(ProductoForm in) {
      EtbProducto out = new EtbProducto();
      out.setId(in.getId());
      out.setVersion(in.getVersion());
      return parseEtbProducto(in, out);
   }

   public EtbProducto parseEtbProducto(ProductoForm in, EtbProducto out) {
      out.setCodigo(in.getCodigo());
      out.setNombre(in.getNombre());
      out.setCosto(in.getCosto());
      return out;
   }

   public ProductoForm parseProducto(EtbProducto in) {
      ProductoForm out = new ProductoForm();
      out.setId(in.getId());
      out.setVersion(in.getVersion());
      return parseProducto(in, out);
   }

   public ProductoForm parseProducto(EtbProducto in, ProductoForm out) {
      out.setCodigo(in.getCodigo());
      out.setNombre(in.getNombre());
      out.setCosto(in.getCosto());
      return out;
   }
}
