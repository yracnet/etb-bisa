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

import com.github.yracnet.etb.entities.EtbProducto;
import java.util.UUID;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@RequestScoped
public class EtbProductoController extends AbstractController<EtbProducto, UUID> {
    @Inject
    private EntityManager em;

    public EtbProductoController() {
        super(EtbProducto.class);
    }

    @Override
    public EtbProducto create(EtbProducto entity) {
        if (entity.getId() != null) {
            throw new EtbException("ID no valido");
        }
        if (entity.getCodigo() == null || entity.getNombre() == null) {
            throw new EtbException("Codig/Nombre es requesido");
        }
        return super.create(entity);
    }

    @Override
    public EtbProducto update(EtbProducto entity) {
        if (entity.getId() == null) {
            throw new EtbException("ID es requerido");
        }
        if (entity.getCodigo() == null || entity.getNombre() == null) {
            throw new EtbException("Codig/Nombre es requesido");
        }
        return super.update(entity);
    }

}
