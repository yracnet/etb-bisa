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

import com.github.yracnet.etb.entities.EtbPedido;
import com.github.yracnet.etb.entities.EtbPedidoDetalle;
import com.github.yracnet.etb.entities.EtbProducto;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.UUID;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

@Provider
public class EntityConverterProvider implements ParamConverterProvider {
    @Inject
    private EntityManager em;

    @Override
    public <T> ParamConverter<T> getConverter(Class<T> rawType, Type genericType, Annotation[] annotations) {
        if (rawType.equals(EtbProducto.class)) {
            return (ParamConverter<T>) new EntityConverter(rawType);
        } else if (rawType.equals(EtbPedido.class)) {
            return (ParamConverter<T>) new EntityConverter(rawType);
        } else if (rawType.equals(EtbPedidoDetalle.class)) {
            return (ParamConverter<T>) new EntityConverter(rawType);
        }
        return null;
    }

    class EntityConverter<T> implements ParamConverter<T> {
        private final Class<T> entityClass;

        public EntityConverter(Class<T> entityClass) {
            this.entityClass = entityClass;
        }

        @Override
        public T fromString(String param) {
            System.out.println("RawType" + entityClass + ":::: " + param);
            UUID uuid = UUID.fromString(param);
            T entity = em.find(entityClass, uuid, LockModeType.NONE);
            if (entity == null) {
                throw new RuntimeException("Not found " + entityClass.getName() + " by: " + param);
            }
            return entity;
        }

        @Override
        public String toString(T param) {
            return null;
        }
    }

}
