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

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;

public class AbstractController<T, I> {
   Class<T> aClass;

   public AbstractController(Class<T> aClass) {
      this.aClass = aClass;
   }

   @Inject
   private EntityManager em;

   public List<T> list() {
      return em.createQuery(""
            + "SELECT o "
            + "  FROM " + aClass.getSimpleName() + " o ")
            .getResultList();
   }

   public T find(I id) {
      return em.find(aClass, id, LockModeType.NONE);
   }

   public T create(T entity) {
      em.persist(entity);
      return entity;
   }

   public T update(T entity) {
      return em.merge(entity);
   }

   public T remove(T entity) {
      em.remove(entity);
      return entity;
   }
}
