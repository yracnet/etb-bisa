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
package com.github.yracnet.etb.response;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.Response;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message implements Serializable {
   private String title;
   private String description;

   public static Response asResponse(Exception ex) {
      Message message = Message.builder().title("Error")
            .description(ex.getMessage())
            .build();
      return Response.status(Response.Status.BAD_REQUEST)
            .entity(message)
            .build();
   }

   public static Message asMessage(Exception ex) {
       
      return Message.builder().title("Error")
            .description(ex.getLocalizedMessage())
            .build();
   }

   public Result asResult() {
      Result rd = new Result();
      rd.setMessage(this);
      return rd;
   }

   public <T> ResultList<T> asResultList(List<T> list) {
      ResultList<T> rd = new ResultList();
      rd.setMessage(this);
      rd.setValue(list);
      return rd;
   }

   public <T> ResultList<T> asResultList(T[] array) {
      List<T> list = Arrays.asList(array);
      ResultList<T> rd = new ResultList();
      rd.setMessage(this);
      rd.setValue(list);
      return rd;
   }

   public <T> ResultData<T> asResultData(T data) {
      ResultData<T> rd = new ResultData();
      rd.setMessage(this);
      rd.setValue(data);
      return rd;
   }
}
