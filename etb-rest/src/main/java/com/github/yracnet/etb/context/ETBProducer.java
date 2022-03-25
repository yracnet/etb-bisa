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
package com.github.yracnet.etb.context;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ETBProducer {
   @PersistenceContext(unitName = "etb-store")
   private EntityManager em;

   @Produces
   @RequestScoped
   public EntityManager getEntityManager() {
      return em;
   }

   @Produces
   @ApplicationScoped
   public Jsonb getGsonInstance() {
      Jsonb jsonb = JsonbBuilder.create();
      return jsonb;
   }
}
