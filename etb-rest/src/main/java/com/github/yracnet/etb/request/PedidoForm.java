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
package com.github.yracnet.etb.request;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PedidoForm implements Serializable {
    private UUID id;
    private String cliente;
    private String descripcion;
    private String fecha;
    private long version;
    
    public Date fechaAsDate(){
        //Parse to date dd/mmm/yyyy
        return new Date();
    }
    
    public void fechaAsDate(Date date){
        //Parse to date dd/mmm/yyyy
    }
}
